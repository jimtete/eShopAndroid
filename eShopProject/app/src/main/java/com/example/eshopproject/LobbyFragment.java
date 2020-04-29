package com.example.eshopproject;

import android.annotation.SuppressLint;
import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LobbyFragment extends Fragment {

    Bundle getBundle;
    TextView textViewName,textViewId,textViewQuantity,textViewType;

    public LobbyFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lobby, container, false);

        getBundle = getArguments();
        String username=getBundle.getString("username");

        textViewName=view.findViewById(R.id.textView_product_name);
        textViewId=view.findViewById(R.id.textView_product_id);
        textViewQuantity=view.findViewById(R.id.textView_product_quantity);
        textViewType=view.findViewById(R.id.textView_product_type);

        List<Products> products = MainActivity.eshopDatabase.myDao().getProducts();

        for (Products p: products){
            textViewName.setText(textViewName.getText().toString()+p.getName()+"\n ----------"+"\n");
            textViewId.setText(textViewId.getText().toString()+p.getId()+"\n ----------"+"\n");
            textViewQuantity.setText(textViewQuantity.getText().toString()+p.getQuantity()+"\n ----------"+"\n");
            textViewType.setText(textViewType.getText().toString()+p.getType()+"\n ----------"+"\n");
        }







        return view;
    }
}
