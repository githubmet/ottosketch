package com.example.incir.myapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.incir.myapplication.backbone.P001EventBusClass;
import com.example.incir.myapplication.backbone.P001MessageEventClass;
import com.example.incir.myapplication.R;

import com.squareup.otto.Subscribe;

public class P001FragmentTwo extends Fragment implements View.OnClickListener{
    TextView textViewFragmentTwoP001;
    EditText editTextFragmentTwoP001;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.p001fragmenttwo,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewFragmentTwoP001= (TextView) getActivity().findViewById(R.id.textViewFragmentTwoP001);
        editTextFragmentTwoP001= (EditText)getActivity().findViewById(R.id.editTextFragmentTwoP001);
        Button buttonFragmentTwoP001= (Button)getActivity().findViewById(R.id.buttonFragmentTwoP001);
        buttonFragmentTwoP001.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        P001EventBusClass.getBus().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        P001EventBusClass.getBus().unregister(this);

    }
    @Subscribe
    public void getDataFromBus(P001MessageEventClass p001MessageEventClass){  //must be public and void  Event a java class
        String data =p001MessageEventClass.getMessage();
        textViewFragmentTwoP001.setText(data);
    }

    @Override
    public void onClick(View v) {
        P001EventBusClass.getBus().post(new P001MessageEventClass(editTextFragmentTwoP001.getText().toString()));
    }
}
