package com.bluewater.testapp.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bluewater.testapp.LoginActivity;
import com.bluewater.testapp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    Button btn;
    public  static final String BASE_URL="https://login.nileshsinghdahiya.in/insertdata.php";
    Button submit;
    TextInputEditText tvolt,thpp,trwp,ttds,tpfl,trfl,thp,trp,tlp,ttoh,ttvol;



    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        View view = inflater.inflate(R.layout.fragment_add, container, false);

        ttvol=(TextInputEditText)view.findViewById(R.id.ted1);
        thpp =(TextInputEditText)view.findViewById(R.id.ted2);
        trwp=(TextInputEditText)view.findViewById(R.id.ted3);
        ttds=(TextInputEditText)view.findViewById(R.id.ted4);
        tpfl=(TextInputEditText)view.findViewById(R.id.ted5);
        trfl=(TextInputEditText)view.findViewById(R.id.ted6);
        thp=(TextInputEditText)view.findViewById(R.id.ted7);
        tlp=(TextInputEditText)view.findViewById(R.id.ted8);
        trp=(TextInputEditText)view.findViewById(R.id.ted9);
        ttoh=(TextInputEditText)view.findViewById(R.id.ted10);
        ttvol=(TextInputEditText)view.findViewById(R.id.ted11);

        btn=(Button)view.findViewById(R.id.btn_submit);
//

btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final String volt=ttvol.getText().toString().trim();
        final String hpp=thpp.getText().toString().trim();
        final String rwp=trwp.getText().toString().trim();
        final String tds=ttds.getText().toString().trim();
        final String pfl=tpfl.getText().toString().trim();
        final String rfl=trfl.getText().toString().trim();
        final String hp=thp.getText().toString().trim();
        final String lp=tlp.getText().toString().trim();
        final String rp=trp.getText().toString().trim();
        final String toh=ttoh.getText().toString().trim();
        final String tvolm=ttvol.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
        @Override
        protected Map<String, String> getParams()  {
            Map<String,String>parms=new HashMap<String, String>();
            parms.put("volt",volt);
            parms.put("hppapms",hpp);
            parms.put("rwpapms",rwp);
            parms.put("tds",tds);
            parms.put("pfl",pfl);
            parms.put("rfl",rfl);
            parms.put("hp",hp);
            parms.put("lp",lp);
            parms.put("rp",rp);
            parms.put("toh",toh);
            parms.put("tvolm",tvolm);
            return parms;
        }
    };
    RequestQueue requestQueue= Volley.newRequestQueue(getActivity().getApplicationContext());
                requestQueue.add(stringRequest);


    }
});


        return view;
    }
}