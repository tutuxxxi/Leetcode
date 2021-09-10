package com.linmu.redBlackTree;

import org.w3c.dom.Node;

/**
 * @author ：xxx_
 * @date ：Created in 2021/7/27 3:35 下午
 * @description：
 * @modified By：
 * @version:
 */
public class RedBlackTree {

    private Node root;

    public void add(int value){
        Node node = new Node();
        node.value = value;

        Node target = findPosition(root, value);
        if(target == null){
            root = node;
            node.color = 1;
        }else if(target.value != value){
            // 插入位置为黑色
            if(target.color == 2){
//                target
            }
        }
    }


    private Node findPosition(Node root, int value){
        if(root == null){
            return null;
        }else{
            if(root.value == value){
                return root;
            }else if(root.value > value){
                if(root.left == null){
                    return root;
                }else{
                    return findPosition(root.left, value);
                }
            }else{
                if(root.right == null){
                    return root;
                }else{
                    return findPosition(root.right, value);
                }
            }
        }
    }








    private class Node{
        int value;
        int color;
        Node left;
        Node right;
    }


}


