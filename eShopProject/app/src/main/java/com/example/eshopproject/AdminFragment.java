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
public class AdminFragment extends Fragment implements View.OnClickListener {

    Button updateCustomerButton,updateProductButton,updateSaleButton,deleteProductButton,deleteSaleButton,insertProductButton;

    public AdminFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_admin, container, false);

        updateCustomerButton = view.findViewById(R.id.button_update_customer);
        updateProductButton = view.findViewById(R.id.button_update_product);
        updateSaleButton = view.findViewById(R.id.button_update_sale);
        deleteProductButton = view.findViewById(R.id.button_delete_product);
        deleteSaleButton = view.findViewById(R.id.button_delete_sale);
        insertProductButton = view.findViewById(R.id.button_insert_product);

        updateSaleButton.setOnClickListener(this);
        updateProductButton.setOnClickListener(this);
        updateSaleButton.setOnClickListener(this);
        deleteSaleButton.setOnClickListener(this);
        deleteProductButton.setOnClickListener(this);
        insertProductButton.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_insert_product){
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertProductFragment()).addToBackStack(null).commit();
        }
        if (v.getId()==R.id.button_delete_product){
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteProductFragment()).addToBackStack(null).commit();
        }
        if (v.getId()==R.id.button_delete_sale){
            MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteSaleFragment()).addToBackStack(null).commit();
        }
    }
}
