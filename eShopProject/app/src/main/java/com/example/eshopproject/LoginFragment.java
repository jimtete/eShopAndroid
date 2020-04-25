package com.example.eshopproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText editText1, editText2;
    Button submitButton;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editText1=view.findViewById(R.id.login_username);
        editText2=view.findViewById(R.id.login_password);
        submitButton=view.findViewById(R.id.submit_login);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd=MainActivity.eshopDatabase.myDao().getAuth(editText1.getText().toString());
                if (!pwd.equals(editText2.getText().toString())){
                    Toast.makeText(getActivity(),"Authentication failed",Toast.LENGTH_LONG).show();
                    editText1.setText("");editText2.setText("");
                    return;
                }
                Toast.makeText(getActivity(),"Login successful",Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putString("username",editText1.getText().toString());

                FragmentTransaction fragmentTransaction = MainActivity.fragmentManager.beginTransaction();

                LobbyFragment lobbyFragment = new LobbyFragment();
                lobbyFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.fragment_container,lobbyFragment).commit();

                //MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new LobbyFragment()).addToBackStack(null).commit();



            }
        });

        return view;
    }
}
