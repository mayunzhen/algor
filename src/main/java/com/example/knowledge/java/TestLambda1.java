package com.example.knowledge.java;

@FunctionalInterface
interface StringFunc{
    String func(String str);
}
class MyStringOps{
    //静态方法： 反转字符串
    public static String stringOp(String str){
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}
public class TestLambda1 {
    public static String stringOp(StringFunc stringFunc, String str ){
        return stringFunc.func(str);
    }
    public static void main(String[] args) {
        String inStr = "lambda add power to Java";
        //MyStringOps::strReverse 相当于实现了接口方法func()
        // 并在接口方法func()中作了MyStringOps.strReverse()操作
        String string = TestLambda1.stringOp(MyStringOps::stringOp,inStr);
        System.out.println(string);
    }
}
