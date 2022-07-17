package com.bluewater.testapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluewater.testapp.LoginActivity;
import com.bluewater.testapp.R;
import com.bluewater.testapp.helpers.SharedPrefManager;
import com.bluewater.testapp.helpers.User;


public class AccountFragment extends Fragment {

    TextView textViewUsername,textViewId;


    public AccountFragment() {
        // Required empty public constructor
    }


    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_account, container, false);

        if (!SharedPrefManager.getInstance(getContext()).isLoggedIn()) {
            getActivity().finish();
            startActivity(new Intent(getContext(), LoginActivity.class));
        }


        textViewId = (TextView) view.findViewById(R.id.user_id_text);
        textViewUsername = (TextView) view.findViewById(R.id.user_id_username);




        //getting the current user
        User user = SharedPrefManager.getInstance(getContext()).getUser();

        //setting the values to the textviews
        textViewId.setText(String.valueOf(user.getId()));
        textViewUsername.setText(user.getUsername());


        //when the user presses logout button
        //calling the logout method
//        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//                SharedPrefManager.getInstance(getApplicationContext()).logout();
//            }




        return view;
    }
}