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
public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }


    EditText editText1,editText2,editText3;
    Button submitButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        editText1=view.findViewById(R.id.register_full_name);
        editText2=view.findViewById(R.id.register_username);
        editText3=view.findViewById(R.id.register_password);
        submitButton = view.findViewById(R.id.submit_register);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName=editText1.getText().toString();
                if (fullName.length()<3){
                    Toast.makeText(getActivity(),"Name cannot be less than 3 characters",Toast.LENGTH_LONG).show();
                    return;
                }
                String username=editText2.getText().toString();
                if (username.length()<3){
                    Toast.makeText(getActivity(),"Username cannot be less than 3 characters",Toast.LENGTH_LONG).show();
                    return;
                }
                String password=editText3.getText().toString();
                if (password.length()<8){
                    Toast.makeText(getActivity(),"Password cannot be less than 8 characters",Toast.LENGTH_LONG).show();
                    return;
                }

                try{
                    Customers customers = new Customers();
                    customers.setName(fullName);
                    customers.setUsername(username);
                    customers.setPassword(password);

                    MainActivity.eshopDatabase.myDao().insertCustomer(customers);
                    Toast.makeText(getActivity(),"Account registered, please go to login",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });



        return view;
    }
}
