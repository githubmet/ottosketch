package com.example.incir.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.incir.myapplication.backbone.P001EventBusClass;
import com.example.incir.myapplication.backbone.P001MessageEventClass;

import com.squareup.otto.Subscribe;

public class P001OttoFragment extends Activity implements View.OnClickListener {
    EditText editTextOttoFragmentP001;
    TextView textViewOttoFragmentP001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001ottofragment);

        Button buttonOttoFragmentP001=(Button)findViewById(R.id.buttonOttoFragmentP001);
        buttonOttoFragmentP001.setOnClickListener(this);

        editTextOttoFragmentP001= (EditText)findViewById(R.id.editTextOttoFragmentP001);
        textViewOttoFragmentP001= (TextView)findViewById(R.id.textViewOttoFragmentP001);

        P001EventBusClass.getBus().register(this);
    }

    @Override
    public void onClick(View v) {
        //veri yi susbscriber lara iletecegiz.
        String data=editTextOttoFragmentP001.getText().toString();
        P001EventBusClass.getBus().post(new P001MessageEventClass(data));
    }

    @Subscribe
    public void getDataFromEventBus(P001MessageEventClass p001MessageEventClass){
        textViewOttoFragmentP001.setText(p001MessageEventClass.getMessage());
    }

    @Override
    protected void onPause() {
        super.onPause();
        P001EventBusClass.getBus().unregister(this);
    }
}
