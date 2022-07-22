package com.bluewater.testapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bluewater.testapp.R;
import com.bluewater.testapp.models.PlantData;

import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder>{

    private Context context;
    private List<PlantData> list;

    public PlantAdapter(Context context, List<PlantData> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.data_list_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PlantData plantData = list.get(position);



        holder.volt.setText(String.valueOf(plantData.getVolts()));
        holder.hpp.setText(String.valueOf(plantData.getHpp()));
        holder.rwp.setText(String.valueOf(plantData.getRwp()));
        holder.tds.setText(String.valueOf(plantData.getTds()));
        holder.pfl.setText(String.valueOf(plantData.getPfl()));
        holder.rfl.setText(String.valueOf(plantData.getRfl()));
        holder.hp.setText(String.valueOf(plantData.getHp()));
        holder.lp.setText(String.valueOf(plantData.getLp()));
        holder.rp.setText(String.valueOf(plantData.getRp()));
        holder.toh.setText(String.valueOf(plantData.getToh()));
        holder.tvolm.setText(String.valueOf(plantData.getTvol()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView user_id,updated,volt,hpp,rwp,tds,pfl,rfl,hp,lp,rp,toh,tvolm;

        public ViewHolder(View itemView) {
            super(itemView);

            user_id = itemView.findViewById(R.id.user_id_text);
            updated = itemView.findViewById(R.id.updated);
            volt = itemView.findViewById(R.id.volt);
            hpp = itemView.findViewById(R.id.hpp);
            rwp = itemView.findViewById(R.id.rwp);
            tds = itemView.findViewById(R.id.tds);
            pfl = itemView.findViewById(R.id.pfl);
            rfl = itemView.findViewById(R.id.rfl);
            hp = itemView.findViewById(R.id.hp);
            lp = itemView.findViewById(R.id.lp);
            rp = itemView.findViewById(R.id.rp);
            toh = itemView.findViewById(R.id.toh);
            tvolm = itemView.findViewById(R.id.tvolm);



        }
    }






}
