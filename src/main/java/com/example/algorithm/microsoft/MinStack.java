package com.example.algorithm.microsoft;

import java.util.Stack;

public class MinStack {
    private static Stack<Integer> data = new Stack<>();
    private static Stack<Integer> min = new Stack<>();

    public static void pushStack(int item) {
        data.push(item);
        if(data.size() == 0 ||item < min.peek()){
            min.push(item);
        }else {
            min.push(min.peek());
        }
    }
    //data栈和min栈弹出元素
    public static void stackWithMinPop(){
       if(data.size() > 0 && min.size() > 0){
           min.pop();
           data.pop();
       }
    }
    //data栈的栈顶元素
    public static int stackWithDataTop(){
        int Item = 0;
        if(data.size() > 0){
            Item = data.peek();
        }
        return Item;
    }
    //min栈的栈顶元素，栈顶元素为data栈中现有元素的最小元素
    public static int stackWithMinMin(){
        if(data.size() > 0 && min.size() >0){
            return min.peek();
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
