package com.soyokra.learn.note;


// 变量逐级作用域
public class VariablesScope {

    // 类作用域
    private String foo = "foo";

    public void foo() {

        // 方法作用域
        String bar = "bar";


        // 块级作用域
        if (true) {
            String foo = "1";
        }

        // 块级作用域
        for (;;) {
            String foo = "1";
        }
    }
}
