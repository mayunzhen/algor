package com.example.knowledge.spring;

/*
在代码中我们定义一个Wear接口，两个实现了该接口的类Sweater和Shirt，
在Person类的Wear需要调用Wear接口的WearClothe方法，传统的做法是在Person的Wear中创建该接口的实现类，然后通过该对象对调用这个方法。
在Person对象的内部创建了这个对象，既是控制了这个对象，当我们需要调用Shirt的WearClothe方法的时候就需要改动Person类中Wear方法的代码，去创建一个Shirt类对象。



spring的控制反转的意思是，以前用对象是自己是通过new 来获取，现在通过spring容器来进行创建并通过注入的方式来获取。
                        这个创建对象的控制权由调用者自己变成了spring容器，这才是控制反转
 */
public class Test {

    static class Person{

        private Wear clothe;

        public Wear getClothe() {
            return clothe;
        }

        public void setClothe(Wear clothe) {
            this.clothe = clothe;
        }

        public void Wear(){
            clothe  = new Sweater();
            clothe.WearClothe();
        }
    }

    interface Wear{
        void WearClothe();
    }

   static class Sweater implements Wear{

        @Override
        public void WearClothe() {
            // TODO Auto-generated method stub
            System.out.println("穿毛衣");
        }
    }

    class Shirt implements Wear{
        @Override
        public void WearClothe() {
            // TODO Auto-generated method stub
            System.out.println("穿衬衫");
        }
    }


    public static void main(String[] args){
        Person person = new Person();
        person.Wear();
    }
}
