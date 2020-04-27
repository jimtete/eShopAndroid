package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertProductFragment extends Fragment {

    EditText editText,editText2;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button submitButton;

    public InsertProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_product, container, false);

        editText = view.findViewById(R.id.editText_insert_name);
        editText2 = view.findViewById(R.id.editText_insert_quantity);

        radioGroup = view.findViewById(R.id.radio_group_type);

        submitButton = view.findViewById(R.id.insert_product_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pid = IDGenerator.sailorId();
                String name = editText.getText().toString();
                if (name.length()==0){
                    Toast.makeText(getActivity(),"Innapropriate name",Toast.LENGTH_LONG);
                    return;
                }
                int quantity = Integer.parseInt(editText2.getText().toString());
                int type = addListenerOnButton();
                if (type==0)return;

                try {
                    Products products = new Products();
                    products.setId(pid);
                    products.setName(name);
                    products.setQuantity(quantity);
                    products.setType(type);

                    MainActivity.eshopDatabase.myDao().insertProduct(products);
                    Toast.makeText(getActivity(),"Product added",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
                editText.setText("");editText2.setText("");
            }
        });

        return view;
    }

    private int addListenerOnButton() {

        int selected = radioGroup.getCheckedRadioButtonId();
        if (selected==R.id.radio_movies) return 2;
        if (selected==R.id.radio_shows)return 1;
        return 0;

    }
}
