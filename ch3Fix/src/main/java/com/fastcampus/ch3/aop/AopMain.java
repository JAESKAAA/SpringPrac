package com.fastcampus.ch3.aop;

import java.lang.reflect.Method;

public class AopMain {

    public static void main(String[] args) throws Exception {

        MyAdvice myAdvice = new MyAdvice();

        Class myClass = Class.forName("com.fastcampus.ch3.aop.MyClass");
        Object obj = myClass.newInstance();

        for (Method m : myClass.getDeclaredMethods()) {
            myAdvice.invoke(m, obj, null);
        }
    }
}

    class MyAdvice {
        void invoke(Method m, Object obj, Object... args) throws Exception {
            System.out.println("[Before]{");


        }

    }

    class MyClass {
        void aaa() {
            System.out.println("aaa() is called");
        }
        void aaa2() {
            System.out.println("aaa2() is called");
        }
        void ccc() {
            System.out.println("ccc() is called");
        }

    }
