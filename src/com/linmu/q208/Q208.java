package com.linmu.q208;

import com.sun.javafx.sg.prism.NodeEffectInput;
import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xxx_
 * @date ：Created in 2021/4/14 1:22 下午
 * @description：
 * @modified By：
 * @version:
 */
public class Q208 {
    public static void main(String[] args) {
        Trie trie = new Trie();


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println();
        ;   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");
    }
}

class Trie {

    /**
     * 每一个字符节点，拥有一个字符和其后字符的引用
     */
    private class Node{
        char aChar;
        Set<Node> nodes;

        public Node(char aChar, Set<Node> nodes) {
            this.aChar = aChar;
            this.nodes = nodes;
        }
    }

    private Node root;
    private final Node END = new Node('$', null);

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('$', new HashSet<>());
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chars = word.toCharArray();
        Node node = root;

        for(int i = 0; i<chars.length; i++){
            Node temp = getNodeFromSet(node, chars[i]);
            if(temp == null){
                temp = new Node(chars[i], new HashSet<>());
                node.nodes.add(temp);
            }
            node = temp;
        }

        //此时添加结束，在当前位置的子位置添加一个结束标识符
        node.nodes.add(END);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node node = root;

        for(int i = 0; i<chars.length; i++){
            Node temp = getNodeFromSet(node, chars[i]);

            //如果没有找到
            if(temp == null){
                return false;
            }else{
                node = temp;
            }
        }


        //找到了最后一个位置
        return node.nodes.contains(END);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = root;

        for(int i = 0; i<chars.length; i++){
            Node temp = getNodeFromSet(node, chars[i]);

            //如果没有找到
            if(temp == null){
                return false;
            }else{
                node = temp;
            }
        }
        return true;
    }

    private Node getNodeFromSet(Node root, char c){
        for(Node node : root.nodes){
            if(node.aChar == c){
                return node;
            }
        }
        return null;
    }

}
