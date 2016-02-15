package com.example.incir.myapplication.backbone;

import com.squareup.otto.Bus;
public class P002EventBus {

    static Bus bus= new Bus();

    public static Bus  getBus(){
        return bus;
    }
}
