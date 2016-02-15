package com.example.incir.myapplication;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;

import com.example.incir.myapplication.backbone.P002EventBus;
import com.example.incir.myapplication.communication.P002AnyInstanceOfAnyClass;

public class P002OttoReview extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p002ottoreview);
       Button buttonOttoReviewP002=(Button)findViewById(R.id.buttonOttoReviewP002);
        buttonOttoReviewP002.setOnClickListener(this);

        P002EventBus.getBus().register(this);
    }

    @Override
    public void onClick(View v) {
        P002EventBus.getBus().post(new P002AnyInstanceOfAnyClass("Bucket From P002OttoReview"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        P002EventBus.getBus().unregister(this);
    }
}
