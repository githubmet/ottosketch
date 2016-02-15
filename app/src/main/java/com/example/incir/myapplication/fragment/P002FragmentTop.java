package com.example.incir.myapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.incir.myapplication.P002OttoReview;
import com.example.incir.myapplication.R;
import android.widget.TextView;

import com.example.incir.myapplication.backbone.P002EventBus;
import com.example.incir.myapplication.communication.P002AnyInstanceOfAnyClass;
import com.squareup.otto.Bus;  //hey, android. Please we are not apart
import com.squareup.otto.Subscribe;

public class P002FragmentTop extends Fragment {
    TextView textViewFragmentTopP002;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.p002fragmenttop,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textViewFragmentTopP002= (TextView)getActivity().findViewById(R.id.textViewFragmentTopP002);
    }
    @Override
    public void onResume() {
        super.onResume();
        P002EventBus.getBus().register(this);
    }

    @Subscribe
    public void getDataFromEventBus(P002AnyInstanceOfAnyClass p002AnyInstanceOfAnyClass){
        String water=p002AnyInstanceOfAnyClass.getBucket();
        textViewFragmentTopP002.setText(water);
    }

    @Override
    public void onStop() {
        super.onStop();
        P002EventBus.getBus().unregister(this);
    }
}
