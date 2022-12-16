package com.bjpowernode.javase.string;

public class StringTest05 {
    public static void main(String[] args) {
        //String类当中的常用方法
        //1 .charAt(int index)   返回指定索引处的char值
        char c = "中国人".charAt(1);
        System.out.println(c);//输出了‘国’

        //2 .compareTo(String anotherString)    按照字典顺序比较两个字符串大小
        int result = "abc".compareTo("abc");
        System.out.println(result);//0 两个相等
        int result1 = "abcd".compareTo("abce");
        System.out.println(result1);//-1 前小后大
        int result2 = "abce".compareTo("abcd");
        System.out.println(result2);//1 前大后小

        //3 .contains(charSequence s)   判断前面的字符串是否包含后面的子字符串,返回布尔值
        System.out.println("HelloWorld.java".contains(".java"));//ture
        System.out.println("http://baidu.com".contains("https://"));//false

        //4 .endsWith(String suffix)    判断当前字符串是否以某个字符串结尾
        System.out.println("test.txt".endsWith(".java"));//false
        System.out.println("test.txt".endsWith(".txt"));//ture

        //5 .equals() 比较字符串必须使用.equals,不能使用==
        // equals有没有调用compareTo方法？老版本有

        //6 .equalsIgnoreCase(String anotherString) 判断两个字符串是否相等，同时忽略大小写
        System.out.println("ABc".equalsIgnoreCase("abc"));//ture

        //7 .getByte()  将字符串转换为字节数组
        byte[] bytes = "abcdef".getBytes();
        for(int i=0;i< bytes.length;i++){
            System.out.println(bytes[i]);
        }

        //8 .indexOf(String str)    判断某个子字符串在当前字符串中第一次出现处的索引
        System.out.println("oraclejavac++.javaxxx".indexOf("java"));

        //9 .isEmpty()  判断某个字符串是否为空
        String s ="";
        System.out.println(s.isEmpty());//ture

        //10 .length()  获得字符串的长度
        System.out.println("abc".length());//3

        //11 .lastIndexOf(String str) 判断某个子字符串在当前字符串中最后一次出现的索引
        System.out.println("oraclejavac++java#".lastIndexOf("java"));

        //12 .replace(CharSequence target,CharSequence replacement)
        //将当前字符串内的老字符串替换成新字符串
        String newString = "http://www.baidu.com".replace("http://","https://");
        System.out.println(newString);
        String newString2 = "name=zhangsan&password=123&age=20".replace("=",":");
        System.out.println(newString2);

        //13 .split(String regex) 以regex为标识拆分字符串，返回一个字符串数组
        String[] ymd = "2000-05-05".split("-");
        for(int i=0;i< ymd.length;i++){
            System.out.println(ymd[i]);
        }

        //14 .startWith(String prefix) 判断当前字符串是否以某个字符串开始
        System.out.println("http://www.baidu.com".startsWith("http"));

        //15 .substring(int beginIndex) 输入字符串起始下标截取字符串
        System.out.println("http://www.baidu.com".substring(7));

        //16 .substring(int beginIndex,int endIndex) 输入字符串起始和结束下标，截取字符串
        //重载的方法，区间左闭右开

        //17 .toCharArray() 将字符串转换为char数组
        char[] chars = "我是中国人".toCharArray();
        for(int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
        }

        //18 .toLowerCase() 将字符串全部转换为小写
        System.out.println("CASEandThen".toLowerCase());

        //19 .toUpperCase() 将字符串全部转换为大写
        System.out.println("abcDEfg".toUpperCase());

        //20 .trim() 去除字符串的前后空白，字符串元素中的空白不能去除
        System.out.println("     Hello world!     ".trim());

        //21 .String中只有一个方法是静态的，不需要new对象
        //这个方法叫 valueOf()
        //作用：将“非字符串”转换为“字符串”
        String s1= String.valueOf(new Customer());//自动调用对象toString,将其返回值转换为字符串
        System.out.println(s1);
        //研究一下println方法源码
        //println在输出任何数据时都是转换成字符串再输出，内部()
        System.out.println(100);//其实只有经由println输出后的东西都是字符串！

    }

}
class Customer{
    //重写toString

    @Override
    public String toString() {
        return "我是一个客户";
    }
}
