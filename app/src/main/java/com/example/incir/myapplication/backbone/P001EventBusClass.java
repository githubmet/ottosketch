package com.example.incir.myapplication.backbone;

import com.squareup.otto.Bus;

public class P001EventBusClass {
    private static Bus bus =new Bus();   //simdi neden static oldugunu anladin mi. Her zaman elinin altinda olmali nesne yaratma ile ugrasmamali. :)

    public static Bus getBus() {
        return bus;
    }
}
