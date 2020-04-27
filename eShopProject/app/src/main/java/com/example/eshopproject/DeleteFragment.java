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
public class DeleteFragment extends Fragment {

    EditText editText;
    Button deleteButton;

    public DeleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete, container, false);

        editText=view.findViewById(R.id.editText_delete_profile);
        deleteButton=view.findViewById(R.id.delete_profile_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=editText.getText().toString();
                Customers temp = new Customers();
                temp.setUsername(username);
                try{
                    MainActivity.eshopDatabase.myDao().deleteCustomer(temp);
                    Toast.makeText(getActivity(),"CUSTOMER DELETED",Toast.LENGTH_LONG).show();
                    editText.setText("");
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        return  view;
    }
}
