package com.linmu.Test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author xxx_
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<String> str = new ArrayList<>();
        str.add("ab");
        str.add("aa");
        str.add("ac");
        str.add("ba");
        Collections.sort(str);
        System.out.println(str);
    }


    private static String firstCharOfEachWord(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            String subStr = String.valueOf(c);
            String first = subStr.substring(0, 1);
            sb.append(first);
        }
        return sb.toString();
    }


    public static int accumulate(int n) {
        return ForkJoinPool.commonPool().invoke(new Adder(1, 10));
    }

    /**
     * 0 < from <= to
     *
     * @param from
     * @param to
     * @return from * (from + 1) * ... * to
     */
    public static int accumulate(int from, int to) {
        int ans = 0;
        for (int i = from; i <= to; i++) {
            ans += i;
        }
        return ans;
    }


    public static void testTalk() {
        String template = "user";
        Random random = new Random();

        int[] ns = new int[]{100, 1000, 10000, 100000};
        int[] ms = new int[]{100, 1000, 10000, 100000, 1000000};

        for (int n : ns) {
            for (int m : ms) {
                long speed1 = 0;
                long speed2 = 0;

                for (int k = 0; k < 5; k++) {
                    List<List<String>> param1 = new ArrayList<>(n);
                    List<List<String>> param2 = new ArrayList<>(m);
                    LinkedHashSet<String> set = new LinkedHashSet<>();
                    for (int i = 0; i < n; i++) {
                        int user1 = random.nextInt(1000000);
                        int user2;
                        do {
                            user2 = random.nextInt(1000000);
                        } while(user2 == user1);

                        param1.add(Arrays.asList(template + user1, template + user2));
                        set.add(template + user1);
                        set.add(template + user2);
                    }

                    int size = set.size();
                    List<String> list = new ArrayList<>(set);

                    for (int i = 0; i < m; i++) {
                        String user1 = list.get(random.nextInt(size));
                        String user2;
                        do {
                            user2 = list.get(random.nextInt(size));
                        } while(user2.equals(user1));

                        param2.add(Arrays.asList(user1, user2));
                    }

                    long i1 = System.currentTimeMillis();
                    canTalk1(param1, param2);
                    speed1 += System.currentTimeMillis()  - i1;
                    i1 = System.currentTimeMillis();
                    canTalk2(param1, param2);
                    speed2 += System.currentTimeMillis()  - i1;
                }
                System.out.printf("n = %-8d\tm = %-9d\tBFS图耗时: %-4dms\t并查集耗时: %-4dms%n", n, m, speed1 / 5, speed2 / 5);
            }
        }
    }

    public static List<Boolean> canTalk1(List<List<String>> linkList, List<List<String>> search) {
        Map<String, Set<String>> linkMap = new HashMap<>(16);

        // 记录为抽象的图
        for (List<String> link : linkList) {
            String user1 = link.get(0);
            String user2 = link.get(1);
            linkMap.computeIfAbsent(user1, str -> new HashSet<>()).add(user2);
            linkMap.computeIfAbsent(user2, str -> new HashSet<>()).add(user1);
        }

        List<Boolean> ans = new ArrayList<>(search.size());
        continuePoint:
        for (List<String> s : search) {
            String userA = s.get(0);
            String userB = s.get(1);

            // 从userA开始, BFS找userB
            Queue<String> queue = new ArrayDeque<>();
            // 记录, 避免因为图的环导致重复走
            Set<String> mark = new HashSet<>();

            queue.offer(userA);
            while(!queue.isEmpty()) {
                String pollItem = queue.poll();

                // 如果找到了userB, 则说明AB在同一个图中, 他们互相能够联通
                if(userB.equals(pollItem)) {
                    ans.add(true);
                    continue continuePoint;
                }

                // 否则记录一下已经找过当前节点了, 并筛选当前结点的后续结点进行继续遍历
                mark.add(pollItem);
                linkMap.get(pollItem).stream().filter(str -> !mark.contains(str)).forEach(queue::offer);
            }
            ans.add(false);
        }
        return ans;
    }

    public static List<Boolean> canTalk2(List<List<String>> linkList, List<List<String>> search) {
        DisjointSetUnion union = new DisjointSetUnion();

        for (List<String> link : linkList) {
            String user1 = link.get(0);
            String user2 = link.get(1);
            union.add(user1);
            union.add(user2);
            union.union(user1, user2);
        }

        return search.stream()
                .map(s -> union.find(s.get(0)).equals(union.find(s.get(1))))
                .collect(Collectors.toList());
    }


}

class DisjointSetUnion {
    /**
     * 记录 子节点 - 父节点, 当key==value时代表当前为根结点
     */
    Map<String, String> treeMap = new HashMap<>();

    /**
     * 记录当前节点其下拥有的结点数量(只维护根结点的数量，其他结点的数据量不一定准确)
     */
    Map<String, Integer> countMap = new HashMap<>();

    public void union(String str1, String str2) {
        String root1 = find(str1);
        String root2 = find(str2);

        if (root1 == null || root2 == null || root1.equals(root2)) {
            return;
        }

        Integer count1 = countMap.get(root1);
        Integer count2 = countMap.get(root2);
        if(count2 < count1) {
            // 总是将结点更少的放在root1
            String temp = root1;
            root1 = root2;
            root2 = temp;
        }
        // 将root1接在root2上
        treeMap.put(root1, root2);
        countMap.put(root2, count1 + count2);
    }

    public String find(String str) {
        String father = treeMap.get(str);
        if(father == null) {
            return null;
        }

        if(!father.equals(str)) {
            String root = find(father);
            if(!father.equals(root)) {
                father = find(father);
                treeMap.put(str, father);
            }
        }
        return father;
    }

    public void add(String str) {
        if(str == null || str.length() == 0 || treeMap.containsKey(str)) {
            return;
        }
        treeMap.put(str, str);
        countMap.put(str, 1);
    }
}

//class DisjointSetUnion {
//    int[] f;
//    int[] rank;
//    int n;
//
//    public DisjointSetUnion(int n) {
//        rank = new int[n + 1];
//        Arrays.fill(rank, 1);
//        f = new int[n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            f[i] = i;
//        }
//    }
//
//    public int find(int x) {
//        return f[x] == x ? x : (f[x] = find(f[x]));
//    }
//
//    public void unionSet(int x, int y) {
//        int fx = find(x), fy = find(y);
//        if (fx == fy) {
//            return;
//        }
//        if (rank[fx] < rank[fy]) {
//            int temp = fx;
//            fx = fy;
//            fy = temp;
//        }
//        //总是将深度低的树合并到深度高的树上
//        rank[fx] += rank[fy];
//        f[fy] = fx;
//    }
//}


class Adder extends RecursiveTask<Integer> {

    private int from;

    private int to;

    Adder(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        if(from == to) {
            return from;
        }else {
            int center = (from + to) / 2;
            Adder adder1 = new Adder(from, center);
            Adder adder2 = new Adder(center + 1, to);
            adder1.fork();
            adder2.fork();
            return adder1.join() + adder2.join();
        }
    }
}
