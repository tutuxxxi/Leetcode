package com.linmu.q721;

import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/18 8:29 上午
 * @description：leetcode q721
 * @modified By：
 * @version: 1.0
 */
public class Q721 {

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();


        List<String> list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo1@m.co");
        list.add("Hanzo2@m.co");
        list.add("Hanzo17@m.co");
        list.add("Hanzo18@m.co");
        list.add("Hanzo19@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo34@m.co");
        list.add("Hanzo59@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo7@m.co");
        list.add("Hanzo8@m.co");
        list.add("Hanzo47@m.co");
        list.add("Hanzo48@m.co");
        list.add("Hanzo49@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo0@m.co");
        list.add("Hanzo1@m.co");
        list.add("Hanzo12@m.co");
        list.add("Hanzo13@m.co");
        list.add("Hanzo14@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo3@m.co");
        list.add("Hanzo4@m.co");
        list.add("Hanzo27@m.co");
        list.add("Hanzo28@m.co");
        list.add("Hanzo29@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo9@m.co");
        list.add("Hanzo5@m.co");
        list.add("Hanzo57@m.co");
        list.add("Hanzo58@m.co");
        list.add("Hanzo59@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo5@m.co");
        list.add("Hanzo6@m.co");
        list.add("Hanzo37@m.co");
        list.add("Hanzo38@m.co");
        list.add("Hanzo39@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo2@m.co");
        list.add("Hanzo3@m.co");
        list.add("Hanzo22@m.co");
        list.add("Hanzo23@m.co");
        list.add("Hanzo24@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo8@m.co");
        list.add("Hanzo9@m.co");
        list.add("Hanzo52@m.co");
        list.add("Hanzo53@m.co");
        list.add("Hanzo54@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo4@m.co");
        list.add("Hanzo0@m.co");
        list.add("Hanzo32@m.co");
        list.add("Hanzo33@m.co");
        list.add("Hanzo34@m.co");
        lists.add(list);

        list = new ArrayList<>();
        list.add("Hanzo");
        list.add("Hanzo6@m.co");
        list.add("Hanzo7@m.co");
        list.add("Hanzo42@m.co");
        list.add("Hanzo43@m.co");
        list.add("Hanzo44@m.co");
        lists.add(list);
        new Solution().accountsMerge(lists);
    }
}


class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> resList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        Union union = new Union();
        int index = -1;

        for(List<String> account : accounts){
            //将名称存入，并且暂存名称在list中的位置
            nameList.add(account.get(0));
            index++;

            for(int i = 1; i<account.size(); i++){
                //将当前字符串指定到当前名称下
                union.union(account.get(i), index);
            }
        }

        //此时同一个人的邮箱存在于同一个联通域中
        Map<Integer, List<String>> map = new HashMap<>();
        for(List<String> account : accounts){
            for(int i = 1; i<account.size(); i++){

                String str = account.get(i);
                Object o = union.find(str);
                //如果当前并查集中存在合法的映射
                if(o instanceof Integer){
                    Integer key = (Integer) o;
                    if(!map.containsKey(key)){
                        map.put(key, new ArrayList<String>());
                    }
                    map.get(key).add(str);
                    //移除映射（去重）
                    union.remove(str);
                }
            }
        }

        for(List<String> list : map.values()){
            Collections.sort(list);
        }

        //此时对各个map中的KV输出即可
        for(Integer integer : map.keySet()){
            List<String> list = map.get(integer);
            list.add(0, nameList.get(integer));
            resList.add(list);
        }

        return resList;
    }
}

class Union{
    private Map<String, Integer> emailMap;
    private Map<Integer, Integer> nameMap;

    public Union(){
        emailMap = new HashMap<>();
        nameMap = new HashMap<>();
    }

    public Integer find(String str){
        if(!emailMap.containsKey(str)){
            return null;
        }else{
            Integer integer = emailMap.get(str);
            return find(integer);
        }
    }

    private Integer find(Integer integer){
        if(!nameMap.containsKey(integer)){
            return integer;
        }else{
            Integer temp = find(nameMap.get(integer));
            nameMap.put(integer, temp);
            return temp;
        }
    }

    public void union(String str, Integer integer){
        Integer preInteger = find(integer);

        if(find(str) == null){
            //当前新增
            emailMap.put(str, integer);
        }else{
            //当前存在，改变索引
            Integer strInteger = find(str);

            if(strInteger.equals(preInteger)){
                return;
            }else{
                if(strInteger > preInteger){
                    nameMap.put(strInteger, preInteger);
                }else{
                    nameMap.put(preInteger, strInteger);
                }
            }
        }
    }


    public void remove(String str){
        if(emailMap.containsKey(str)){
            emailMap.remove(str);
        }
    }

}

