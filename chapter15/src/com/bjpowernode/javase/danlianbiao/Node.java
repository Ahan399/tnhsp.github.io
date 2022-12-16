package com.bjpowernode.javase.danlianbiao;

public class Node {
    //存储的数据
    Object element;
    //下一个节点的内存地址
    Node next;
    public Node(){

    }
    public Node(Object element,Node next){
        this.element = element;
        this.next = next;
    }
}
