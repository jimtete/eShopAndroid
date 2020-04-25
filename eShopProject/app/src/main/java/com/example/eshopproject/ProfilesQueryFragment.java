package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfilesQueryFragment extends Fragment {

    TextView textView;
    Button submitButton;

    public ProfilesQueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profiles_query, container, false);

        submitButton = view.findViewById(R.id.button_query_all_customers);
        textView = view.findViewById(R.id.txtqueryresult);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                List<Customers> customers = MainActivity.eshopDatabase.myDao().getCustomers();
                for (Customers i: customers){
                    String name=i.getName();
                    String username=i.getUsername();
                    String pass="";
                    for (int j=0;j<i.getPassword().length();j++){
                        pass+="*";
                    }
                    result = result +"Name: "+name+" | username: "+username+" | password: "+pass+"\n ---------";
                }
                textView.setText(result);
            }
        });


        return view;
    }
}
