package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateSaleFragment extends Fragment {

    EditText editText1,editText2,editText3,editText4;
    Button updateButton;

    public UpdateSaleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_sale, container, false);

        editText1 = view.findViewById(R.id.editText_update_sale_sid);
        editText2 = view.findViewById(R.id.editText_update_sale_pid);
        editText3 = view.findViewById(R.id.editText_update_sale_username);
        editText4 = view.findViewById(R.id.editText_update_sale_date);

        updateButton = view.findViewById(R.id.button_update_sale_submit);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sid = Integer.parseInt(editText1.getText().toString());
                int pid = Integer.parseInt(editText2.getText().toString());
                String username = editText3.getText().toString();
                String date = editText4.getText().toString();

                Sales sales = new Sales();
                sales.setUsername(username);
                sales.setProductId(pid);
                sales.setDate(date);
                sales.setSaleId(sid);

                MainActivity.eshopDatabase.myDao().updateSale(sales);
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                Toast.makeText(getActivity(),"Sale updated...",Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
