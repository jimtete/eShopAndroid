package com.example.eshopproject;

import android.annotation.SuppressLint;
import android.os.Bundle;


import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LobbyFragment extends Fragment {

    Bundle getBundle;
    TextView textViewName,textViewId,textViewQuantity,textViewType;

    EditText editText1,editText2;
    Button addToCartButton;

    Button finishShoppingButton,cleanCartButton;



    public LobbyFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lobby, container, false);
        final List<Products> cart=new ArrayList<Products>();

        getBundle = getArguments();
        final String username=getBundle.getString("username");

        textViewName=view.findViewById(R.id.textView_product_name);
        textViewId=view.findViewById(R.id.textView_product_id);
        textViewQuantity=view.findViewById(R.id.textView_product_quantity);
        textViewType=view.findViewById(R.id.textView_product_type);

        List<Products> products = MainActivity.eshopDatabase.myDao().getProducts();

        for (Products p: products){
            textViewName.setText(textViewName.getText().toString()+p.getName()+"\n ----------"+"\n");
            textViewId.setText(textViewId.getText().toString()+p.getId()+"\n ----------"+"\n");
            textViewQuantity.setText(textViewQuantity.getText().toString()+p.getQuantity()+"\n ----------"+"\n");

            if (p.getType()==2)textViewType.setText(textViewType.getText().toString()+"Movie"+"\n ----------"+"\n");
            if (p.getType()==1)textViewType.setText(textViewType.getText().toString()+"Show"+"\n ----------"+"\n");


        }

        editText1=view.findViewById(R.id.editText_add_id);
        editText2=view.findViewById(R.id.editText_add_quantity);

        addToCartButton=view.findViewById(R.id.button_add_to_cart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(editText1.getText().toString());
                int quantity=Integer.parseInt(editText2.getText().toString());

                Products temp = new Products();
                temp = MainActivity.eshopDatabase.myDao().getProduct(id);
                if (temp.getName()==null){
                    Toast.makeText(getActivity(),"Product id does not exist...",Toast.LENGTH_LONG).show();
                    return;
                }
                if (quantity<=0){
                    Toast.makeText(getActivity(),"Invalid quantity...",Toast.LENGTH_LONG).show();
                    return;
                }
                if (quantity>temp.getQuantity()){
                    Toast.makeText(getActivity(),"Invalid quantity...",Toast.LENGTH_LONG).show();
                    return;
                }

                temp.setQuantity(quantity);


                cart.add(temp);
                Toast.makeText(getActivity(),"Added to cart...",Toast.LENGTH_LONG).show();

                editText1.setText("");editText2.setText("");

            }
        });


        cleanCartButton = view.findViewById(R.id.clear_everything);

        finishShoppingButton = view.findViewById(R.id.button_finish_shopping);

        cleanCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.clear();
                Toast.makeText(getActivity(),"Cart cleared",Toast.LENGTH_LONG).show();
            }
        });


        finishShoppingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cart.size()==0){
                    Toast.makeText(getActivity(),"Cart is empty...",Toast.LENGTH_LONG).show();
                    return;
                }

                Bundle bundle = new Bundle();
                bundle.putString("username",username);
                bundle.putSerializable("productList", (Serializable) cart);

                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();

                FinalFragment finalFragment = new FinalFragment();
                finalFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container,finalFragment).commit();
            }
        });


        return view;
    }
}
