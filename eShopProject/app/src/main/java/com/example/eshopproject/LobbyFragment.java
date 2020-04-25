package com.example.eshopproject;

import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LobbyFragment extends Fragment {

    Bundle getBundle;


    public LobbyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lobby, container, false);

        getBundle = getArguments();
        String username=getBundle.getString("username");
        ((TextView)view.findViewById(R.id.textView2)).setText(username);





        return view;
    }
}
