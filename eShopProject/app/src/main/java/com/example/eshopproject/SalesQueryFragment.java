package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SalesQueryFragment extends Fragment {

    TextView textView;
    Button submitButton;

    public SalesQueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sales_query, container, false);

        textView=view.findViewById(R.id.txtqueryresult_sales);
        submitButton=view.findViewById(R.id.button_query_all_sales);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result="";
                List<Sales> sales = MainActivity.eshopDatabase.myDao().getSales();
                for (Sales i: sales){
                    String username=i.getUsername();
                    String date=i.getDate();
                    int product = i.getProductId();
                    int saleId = i.getSaleId();

                    result = result +"Username: "+username+" | product: "+product+" | date: "+date+" | saleId " + saleId + "\n ---------";
                }
                textView.setText(result);
            }
        });



        return view;
    }
}
