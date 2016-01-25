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

public class P001FragmentOne extends Fragment implements View.OnClickListener{
    TextView textViewFragmentOneP001;
    EditText editTextFragmentOneP001;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.p001fragmentone,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textViewFragmentOneP001= (TextView)getActivity().findViewById(R.id.textViewFragmentOneP001);
        editTextFragmentOneP001= (EditText)getActivity().findViewById(R.id.editTextFragmentOneP001);
        Button buttonFragmentOneP001= (Button)getActivity().findViewById(R.id.buttonFragmentOneP001);
        buttonFragmentOneP001.setOnClickListener(this);
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
    public void getDataFromBus(P001MessageEventClass p001MessageEventClass){     //must be public and void .  Event a java class
        textViewFragmentOneP001.setText(p001MessageEventClass.getMessage());
    }

    @Override
    public void onClick(View v) {
        P001EventBusClass.getBus().post(new P001MessageEventClass(editTextFragmentOneP001.getText().toString()));
    }
}
