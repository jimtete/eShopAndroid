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
public class UpdateCustomerFragment extends Fragment {

    public UpdateCustomerFragment() {
        // Required empty public constructor
    }

    EditText editText1,editText2,editText3;
    Button updateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_customer, container, false);

        editText1 = view.findViewById(R.id.editText_update_customer_username);
        editText2 = view.findViewById(R.id.editText_update_customer_fullname);
        editText3 = view.findViewById(R.id.editText_update_customer_password);
        updateButton = view.findViewById(R.id.button_update_customer_submit);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText1.getText().toString();
                String fullname = editText2.getText().toString();
                String password = editText3.getText().toString();
                if (fullname.length()<3){
                    Toast.makeText(getActivity(),"Name cannot be less than 3 characters",Toast.LENGTH_LONG).show();
                    return;
                }
                if (username.length()<3){
                    Toast.makeText(getActivity(),"Username cannot be less than 3 characters",Toast.LENGTH_LONG).show();
                    return;
                }

                if (password.length()<8){
                    Toast.makeText(getActivity(),"Password cannot be less than 8 characters",Toast.LENGTH_LONG).show();
                    return;
                }

                try{
                    Customers customers = new Customers();
                    customers.setUsername(username);
                    customers.setPassword(password);
                    customers.setName(fullname);
                    MainActivity.eshopDatabase.myDao().updateCustomer(customers);
                    Toast.makeText(getActivity(),"Customer updated",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
                editText2.setText("");editText1.setText("");editText3.setText("");
            }
        });

        return view;
    }
}
