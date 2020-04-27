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
public class DeleteProductFragment extends Fragment {

    EditText editText;
    Button deleteButton;

    public DeleteProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_product, container, false);

        editText=view.findViewById(R.id.editText_delete_product);
        deleteButton=view.findViewById(R.id.delete_product_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=0;
                try{
                    id = Integer.parseInt(editText.getText().toString());
                }catch (NumberFormatException e){
                    System.out.println("Could not parse chinga");
                }
                Products temp = new Products();
                temp.setId(id);
                try{
                    MainActivity.eshopDatabase.myDao().deleteProduct(temp);
                    Toast.makeText(getActivity(),"PRODUCT DELETED",Toast.LENGTH_LONG).show();
                    editText.setText("");
                }catch (Exception e){
                    Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
