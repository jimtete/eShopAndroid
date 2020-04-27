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
public class DeleteSaleFragment extends Fragment {

    EditText editText;
    Button deleteButton;

    public DeleteSaleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_sale, container, false);

        editText=view.findViewById(R.id.editText_delete_sale);
        deleteButton=view.findViewById(R.id.delete_sale_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=0;
                try{
                    id = Integer.parseInt(editText.getText().toString());
                }catch (NumberFormatException e){
                    System.out.println("Could not parse chinga");
                }
                Sales temp = new Sales();
                temp.setSaleId(id);
                try{
                    MainActivity.eshopDatabase.myDao().deleteSale(temp);
                    Toast.makeText(getActivity(),"SALE DELETED",Toast.LENGTH_LONG).show();
                    editText.setText("");
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }
}
