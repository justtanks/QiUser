package com.qcc.qiuser.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qcc.qiuser.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Intro2Fragment extends Fragment {


    public Intro2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro2, container, false);
    }

}