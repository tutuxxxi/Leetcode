package com.linmu.q855;

import java.util.*;

/**
 * @author by lijun
 * @since 2022/12/30 17:16
 */
public class Q855 {
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
    }
}

class ExamRoom {

    private static final int LEFT_RANGE = -1;

    private static final int RIGHT_RANGE = Integer.MAX_VALUE;

    private final TreeSet<int[]> set;

    private final Map<Integer, List<int[]>> mark;

    private final int size;

    public ExamRoom(int n) {
        set = new TreeSet<>((o1, o2) -> {
            int compare = Integer.compare(o1[1] - o1[0], o2[1] - o2[0]);
            if(compare == 0) {
                return Integer.compare(o1[0], o2[0]);
            }
            return compare;
        });
        mark = new HashMap<>();
        set.add(new int[]{LEFT_RANGE, RIGHT_RANGE});
        size = n;
    }

    public int seat() {
        int position = 0;
        int length = 0;
        int[] arr = null;
        for (int[] ints : set) {
            int newLength = 0;
            int newPosition = 0;

            // 如果为边界记录，则忽略
            if(ints[0] == LEFT_RANGE && ints[1] == RIGHT_RANGE) {
                arr = ints;
                continue;
            } else if(ints[0] == LEFT_RANGE) {
                if(ints[1] == 0) {
                    continue;
                }
                newLength = ints[1];
            } else if(ints[1] == RIGHT_RANGE) {
                if(ints[0] == size - 1) {
                    continue;
                }
                newLength = size - 1 - ints[0];
                newPosition = size - 1;
            } else {
                if(ints[0] == ints[1] - 1) {
                    continue;
                }
                // 左右均为存在的点时，则计算中点
                newPosition = (ints[1] + ints[0]) / 2;
                newLength = newPosition - ints[0];
            }

            // 决策是否要更新
            if(newLength > length) {
                position = newPosition;
                length = newLength;
                arr = ints;
            }else if (newLength == length && newPosition < position) {
                position = newPosition;
                arr = ints;
            }
        }

        // 创建边界
        // 将arr移除
        set.remove(arr);
        int[] leftArr = new int[]{arr[0], position};
        int[] rightArr = new int[]{position, arr[1]};
        set.add(leftArr);
        set.add(rightArr);

        if(leftArr[0] != LEFT_RANGE) {
            set(leftArr[0], 1, leftArr);
        }
        if(leftArr[1] != RIGHT_RANGE) {
            set(leftArr[1], 0, leftArr);
        }
        if(rightArr[0] != LEFT_RANGE) {
            set(rightArr[0], 1, rightArr);
        }
        if(rightArr[1] != RIGHT_RANGE) {
            set(rightArr[1], 0, rightArr);
        }
        return position;
    }

    public void leave(int p) {
        // 移走则左右合并即可
        int[] leftArr =  mark.get(p).get(0);
        int[] rightArr = mark.get(p).get(1);

        int[] mergeArr = new int[]{leftArr[0], rightArr[1]};

        set.remove(leftArr);
        set.remove(rightArr);
        set.add(mergeArr);

        set(p, 0, null);
        set(p, 1, null);
        if(mergeArr[0] != LEFT_RANGE) {
            set(mergeArr[0], 1, mergeArr);
        }
        if(mergeArr[1] != RIGHT_RANGE) {
            set(mergeArr[1], 0, mergeArr);
        }
    }

    private void makeSure(int index) {
        mark.computeIfAbsent(index, i -> {
            List<int[]> list = new ArrayList<>(2);
            list.add(null);
            list.add(null);
            return list;
        });
    }

    private void set(int index, int leftOrRight, int[] value) {
        makeSure(index);
        mark.get(index).set(leftOrRight, value);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//0
//0 9
//0   0
