package com.bjpowernode.javase.array;

public class MyStack {
    //向栈中存储元素，我们这里使用一维数组模拟。存到栈中，就表示存储到数组中
    //选用object类型数组方便存储所有类型数据
    private  Object[] elements;//私有属性，习惯性提供set get方法

    //栈帧，永远指向栈顶部元素
    //那么这个默认初始值是多少？ 注意：最初的栈是空的，一个元素都没有
   // private int index = -1;//如果index采用了-1，代表栈帧指向顶部元素(0)
    // private int index = 0;//如果index采用了0，代表栈帧指向顶部元素(0)的上方
    //换言之，栈内有东西才能指向a[0],下标为0，栈帧为0.栈为空自然指向-1
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public MyStack() {
        this.elements = new Object[10];//默认初始化容量是10,数组内无值
        this.index = -1;
    }
    //压栈方法
    public void push(Object obj){
        if(this.index >= this.elements.length-1){
            System.out.println("栈已满，压栈失败");
            return;
        }
        this.index++;//先自增，才能代表栈帧所指向的那个元素的下标，并且向上移动栈帧
        this.elements[index] = obj;//将压栈的元素赋值给空位
        System.out.println("压栈"+obj+"成功，栈帧指向"+index);
    }
    //弹栈方法
    public Object pop(){
        if(this.index < 0){
            System.out.println("栈已空，弹栈失败！");
            return null;
        }
       Object obj = this.elements[index];
        this.elements[index] =null;//清空栈位置
        this.index--;
        System.out.println("弹栈成功！栈帧指向"+index);
        return obj;
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }
}
