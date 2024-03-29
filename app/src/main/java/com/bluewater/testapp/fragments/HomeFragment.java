package com.bluewater.testapp.fragments;

import static com.bluewater.testapp.fragments.AddFragment.BASE_URL;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bluewater.testapp.R;
import com.bluewater.testapp.adapters.PlantAdapter;
import com.bluewater.testapp.models.PlantData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import com.github.mikephil.charting.charts.LineChart;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<PlantData> plantDataList;
    LinearLayoutManager linearLayoutManager;
    public static final String url ="https://login.nileshsinghdahiya.in/getdata.php";
LineChart lineChart;
    private static final String TAG = "HomeFragment";




    public HomeFragment() {
        // Required empty public constructor
    }



    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);



        //android chart line
lineChart =(LineChart)view.findViewById(R.id.linechart);
        showgraph();




        //showing data from database
        recyclerView = view.findViewById(R.id.plant_data_list);

        plantDataList = new ArrayList<>();
        adapter = new PlantAdapter(getActivity().getApplicationContext(),plantDataList);

        linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        
        getData();






        return view;
    }

    private void showgraph() {

//lineChart.setOnChartGestureListener(getActivity().getApplicationContext());
//TODO: adding linechart using mysql data


    }

    private void getData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject plantdata = array.getJSONObject(i);

                                //adding the product to product list
                                plantDataList.add(new PlantData(
                                        plantdata.getString("volt"),
                                        plantdata.getString("hppapms"),
                                        plantdata.getString("rwpapms"),
                                        plantdata.getString("tds"),
                                        plantdata.getString("pfl"),
                                        plantdata.getString("rfl"),
                                        plantdata.getString("hp"),
                                        plantdata.getString("lp"),
                                        plantdata.getString("rp"),
                                        plantdata.getString("toh"),
                                        plantdata.getString("tvolm")



                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            PlantAdapter adapter = new PlantAdapter(getContext(), plantDataList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(getContext()).add(stringRequest);

    }
}

//    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//        @Override
//        public void onResponse(JSONArray response) {
//            for (int i = 0; i < response.length(); i++) {
//                try {
//                    JSONObject jsonObject = response.getJSONObject(i);
//
//                    PlantData plantData = new PlantData();
//                    plantData.setVolts(jsonObject.getString("volts"));
//                    plantData.setHpp(jsonObject.getString("hppapms"));
//                    plantData.setRwp(jsonObject.getString("rwpapms"));
//                    plantData.setTds(jsonObject.getString("tds"));
//                    plantData.setPfl(jsonObject.getString("pfl"));
//                    plantData.setRfl(jsonObject.getString("rfl"));
//                    plantData.setHp(jsonObject.getString("hp"));
//                    plantData.setLp(jsonObject.getString("lp" ));
//                    plantData.setRp(jsonObject.getString("rp"));
//                    plantData.setToh(jsonObject.getString("toh"));
//                    plantData.setTvol(jsonObject.getString("tvolm"));
//
//
//                    plantDataList.add(plantData);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//
//                }
//            }
//            adapter.notifyDataSetChanged();
//
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            Log.e("Volley", error.toString());
//
//        }
//    });
//    RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//        requestQueue.add(jsonArrayRequest);
//
//                }