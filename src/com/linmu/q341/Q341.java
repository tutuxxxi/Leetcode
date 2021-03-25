package com.linmu.q341;

import java.lang.reflect.Member;
import java.net.NetworkInterface;
import java.util.*;

/**
 * @author ：xxx_
 * @date ：Created in 2021/3/23 11:24 上午
 * @description：
 * @modified By：
 * @version:
 */
public class Q341 {
    public static void main(String[] args) {
        List<NestedInteger> list = new ArrayList<>(2);
        list.add(new NestedInteger(1));

        List<NestedInteger> list2 = new ArrayList<>(2);
        list2.add(new NestedInteger(4));

        List<NestedInteger> list3 = new ArrayList<>(1);
        list3.add(new NestedInteger(6));


        list2.add(new NestedInteger(list3));
        list.add(new NestedInteger(list2));

        NestedIterator nestedIterator = new NestedIterator(list);
        nestedIterator.next();
        nestedIterator.next();
        nestedIterator.next();
    }
}



class NestedInteger {

    private Object obj;

    NestedInteger(Object o){
        obj = o;
    }

    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    public boolean isInteger(){
        return obj instanceof Integer;
    }

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    public Integer getInteger(){
        if(isInteger()){
            return (Integer) obj;
        }
        return null;
    }

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer
     */
    public List<NestedInteger> getList(){
        if(!isInteger()){
            return (List<NestedInteger>) obj;
        }
        return null;
    }
}


class NestedIterator implements Iterator<Integer> {

    private Queue<Integer> queue;


    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        split(nestedList);
    }

    private void split(List<NestedInteger> nestedList){
        for(NestedInteger nestedInteger : nestedList){
            if(nestedInteger.isInteger()){
                queue.offer(nestedInteger.getInteger());
            }else{
                split(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
