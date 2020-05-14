package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FinalFragment extends Fragment {

    Bundle getBundle;
    TextView textView;

    public FinalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_final, container, false);
        textView = view.findViewById(R.id.final_cart);
        getBundle = getArguments();
        final String username=getBundle.getString("username");
        final List<Products> cart = (List<Products>) getBundle.getSerializable("productList");


//        Date currentTime = Calendar.getInstance().getTime();
//        String date = currentTime.toString();

        String mytime = (DateFormat.format("dd-MM-yyyy hh:mm:ss", new java.util.Date()).toString());
        for (Products p: cart){

            int sid = IDGenerator.saleId();
            int pid = p.getId();

            String myDate=mytime;

            Sales sales = new Sales();
            sales.setSaleId(sid);
            sales.setDate(myDate);
            sales.setProductId(pid);
            sales.setUsername(username);
            MainActivity.eshopDatabase.myDao().insertSale(sales);

        }

        for (Products p: cart){
            textView.setText(textView.getText().toString()+p.getName()+" x " + p.getQuantity()+"\n");
        }

        for (Products p: cart){
            Products temp2 = MainActivity.eshopDatabase.myDao().getProduct(p.getId());

            int quantity=p.getQuantity();
            int pid = p.getId();

            Products temp = new Products();

            temp.setId(pid);
            temp.setQuantity(temp2.getQuantity()-quantity);
            temp.setName(p.getName());
            temp.setType(p.getType());

            MainActivity.eshopDatabase.myDao().updateProduct(temp);

        }
        cart.clear();




        return view;
    }
}
