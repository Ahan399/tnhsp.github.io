package com.bjpowernode.javase.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
HashMap集合：
    1.HashMap集合底层是哈希表/散列表的数据结构
    2.哈希表是一个怎样的数据结构呢？
        哈希表是一个数组和单向链表的结合体
        数组：在查询方面效率很高，随机增删方面效率很低
        单向链表：在随机增删方面效率很高，在查询方面效率很低
        哈希表在以上的两种数据结构糅合在一起，充分发挥它们各自的优点

    3.HashMap集合底层代码：
        public class HashMap{
            //HashMap底层实际上就是一个数组。（一维数组）
            Node<K,V>[] table;
            //静态内部类HashMap.Node
            static class Node<K,V> implements Map.Entry<K,V>{
                final int hash; //哈希值（哈希值是key的hashCode()方法的执行结果。
                                //hash值通过哈希函数/算法，可以转换存储成元素的下标
                final K key; //存储到MAP集合中的key
                V value; //存储到MAP集合中的那个value
                Node<K,V> next; //下一个节点的内存地址
            }
        }
         哈希表/散列表： 一维数组，这个数组中每一个元素是一个单向链表。（数组和链表的结合体）

     4.主要掌握的原理是：
        map.put(K,V);
            第一步：先将K,V封装到Node对象中
            第二步：底层会调用k的hashCode()方法得出hash值，

                    然后通过哈希算法/函数，将hash值转换为数组的下标 int hash。

                    1.如果下标位置上如何没有任何元素，就把这个NODE添加到这个位置上了
                    2.如果下标对应位置上有链表（有元素），此时会拿着K和链表上的每一个节点的k进行equals
                        如果所有equals方法返回都是false,那么将这个新节点将会被添加到链表的末尾
                        如果有一个equals方法返回了true,那么这个返回true节点的value将会被新的V覆盖！

        map.get(K);
            第一步：先调用k的hashCode()得出hash值
                    通过哈希算法转换为数组下标 int hash，通过数组下标快速定位到某个位置上

                    1.如果这个位置上，什么都没有，返回null
                    2.如果这个位置上有单向链表，那么会拿着参数k和单向链表中的每个节点的k进行equals
                        2.1如果所有equals方法返回false,那么get方法返回null
                        2.2如果其中有一个节点的equals方法返回true,那么这个节点的value就是我们要找的value!

     5.HashMap集合key部分特点：无序不可重复

        为什么无序？
            因为添加元素是有可能加到node数组中的任何一个下标位置，不一定挂在哪个单向链表上。
        不可重复怎么保证？
            equals方法来保证HashMap集合的key不可重复
            如果key值重复了，value值会被覆盖

         放在HashMap集合key部分的元素其实就是放到HashSet集合中了
         所有HashSet也需要重写equals()和hashCode()

       6.HashMap使用不当时无法发挥性能
            假设将所有hashCode()方法返回一个固定值时，那么会导致底层哈希表变成了纯单向链表
            纯单向链表，这种清空我们称为：散列分布不均匀

            什么是散列分布均匀？
                假设有100个元素，10个单向链表，每个单向链表上有10个节点，被称为散列分布均匀

            假设将所有hashCode()方法返回值都设定为不一样的值，可以吗，有什么问题？
            不行，因为这样会导致哈希表变为纯一维数组，也会造成散列分别不均匀

            散列分布均匀需要你重写hashCode()方法时有一定的技巧

        7.重点：放在HashMap集合key部分元素，以及放在HashSet集合中元素，需要同时重写hashCode和equals方法

        8. HashMap集合的默认初始化容量16，默认加载因子是0.75
                这个默认加载因子是当HashMap集合底层数组的容量达到75%的时候，数组开始扩容
                重点： 记住HashMap集合初始化容量必须是2的倍数，这也是官方推荐的
                        可以提供散列均匀，提高效率


 */
public class HashMapTest01 {
    public static void main(String[] args) {
        //测试HashMap集合KEY部分的元素特点
        //Integer是key，它的hashCode和equals都要重写
        Map<Integer,String> map = new HashMap<>();
        map.put(1111,"zhangsan");
        map.put(6666,"lisi");
        map.put(7777,"wangwu");
        map.put(2222,"zhaoliu");
        map.put(2222,"king");//key重复时,value会自动覆盖

        System.out.println(map.size());//4

        //遍历Map集合
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for(Map.Entry<Integer,String> entry : set){
            System.out.println(entry.getKey()+ "=" +entry.getValue());
        }
    }
}
