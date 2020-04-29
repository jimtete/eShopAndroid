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
public class UpdaateProductFragment extends Fragment {

    EditText editText1,editText2,editText3;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button updateButton;

    public UpdaateProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_updaate_product, container, false);

        editText1 = view.findViewById(R.id.editText_update_product_id);
        editText2 = view.findViewById(R.id.editText_update_product_name);
        editText3 = view.findViewById(R.id.editText_update_product_quantity);

        radioGroup = view.findViewById(R.id.radio_group_type_update);

        updateButton = view.findViewById(R.id.button_update_product_submit);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pid = 0;
                try{
                    pid = Integer.parseInt(editText1.getText().toString());
                }catch(NumberFormatException e){
                    System.out.println("Could not parse");
                }
                String name = editText2.getText().toString();
                if (name.length()==0){
                    Toast.makeText(getActivity(),"Innapropriate name",Toast.LENGTH_LONG);
                    return;
                }
                int quantity = Integer.parseInt(editText3.getText().toString());
                int type = addListenerOnButton();
                if (type==0)return;
                try {
                    Products products = new Products();
                    products.setId(pid);
                    products.setName(name);
                    products.setQuantity(quantity);
                    products.setType(type);

                    MainActivity.eshopDatabase.myDao().updateProduct(products);
                    Toast.makeText(getActivity(),"Product updated",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
                editText3.setText("");editText2.setText("");editText1.setText("");
            }
        });


        return view;
    }

    private int addListenerOnButton() {
        int selected = radioGroup.getCheckedRadioButtonId();
        if (selected==R.id.radio_movies_update) return 2;
        if (selected==R.id.radio_shows_update)return 1;
        return 0;
    }
}
