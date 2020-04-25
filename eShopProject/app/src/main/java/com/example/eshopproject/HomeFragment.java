package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    Button button1,button2;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        button1 = view.findViewById(R.id.register_button);
        button2 = view.findViewById(R.id.login_button);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new RegisterFragment()).addToBackStack(null).commit();
                break;
            case R.id.login_button:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new LoginFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
