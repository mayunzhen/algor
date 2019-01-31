package com.example.knowledge.java.Thread;

public class ObjectTest implements Cloneable {

    public static void main(String[] args) {

        ObjectTest ot1 = new ObjectTest();

        try {
            ObjectTest ot2 = (ObjectTest) ot1.clone();
            System.out.println("ot2:" + ot2);
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
