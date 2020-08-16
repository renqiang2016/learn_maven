package com.ren.hello;

/**
 * @author qiang.ren
 * @version 1.0
 * @since 2020/8/15 11:24
 */
public class HelloWorld {
    public String sayHello() {
        return "Hello Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
    }
}
