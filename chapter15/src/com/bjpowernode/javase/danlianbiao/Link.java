package com.bjpowernode.javase.danlianbiao;

public class Link {
    //头节点
    Node header = null;
     private int size = 0;

//获取元素个数
    public int size(){
        return size;
    }

    //向链表中添加元素的方法(向末尾添加)
    public void add(Object data){
        //创建一个新的节点对象
        //让之前单链表末尾的next指向这个对象的内存地址
        //新节点next为null
        //这个元素有可能是第一个，也可能是第二个
        if(header == null){
            //说明还没有节点，new一个新的节点对象作为头节点
            //这时候头节点也是末尾节点！！
            header = new Node(data,null);
        }else{
            //说明头不是空，链表里有节点
            //头节点已经存在
            //找出当前末尾节点，让当前末尾节点的next是新节点
            Node currentLastNode = findLast(header);//当前的最后节点
            currentLastNode.next = new Node(data,null);
        }
        size++;
    }
/*
专门查找末尾节点的方法
 */
    private Node findLast(Node node) {
        if(node.next == null){
            return node;
        }
        return findLast(node.next);//递归，为了找到next==null 的末尾节点！
    }

    //删除某个数据发方法
    public void remove(Object obj){
        //获取被删除节点中保存的next地址
        //将这个地址赋给指向被删除节点的节点的next

    }
    //修改某个数据的方法
    public void modify(Object newObj){

    }
    //查找链表中的某个元素
    public int find(Object obj){
        return 1;
    }
}
