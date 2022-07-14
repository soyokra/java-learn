package com.soyokra.learn.note;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

// Variable used in lambda expression should be final or effectively final
public class LambadaScope {
    public void bar() {
        List<String> fooList = new ArrayList<>();


        Integer total1 = 0;
        fooList.stream().forEach(t-> {
            // error
            //total1++;
        });

        AtomicReference<Integer> total2 = new AtomicReference<>(0);
        fooList.stream().forEach(t-> {
            total2.getAndSet(total2.get() + 1);
        });

        List<String> barList = new ArrayList<>();
        fooList.stream().forEach(t-> {
            barList.add(t);
        });
    }
}
