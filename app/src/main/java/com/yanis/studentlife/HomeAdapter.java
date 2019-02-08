package com.yanis.studentlife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private Context mCtx;
    private List<evenement> evenementList;

    public HomeAdapter(Context mCtx, List<evenement> evenementList) {
        this.mCtx = mCtx;
        this.evenementList = evenementList;
    }

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.card,null);
        return new HomeAdapter.HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder holder, int i) {
        evenement evenement=evenementList.get(i);

        holder.textViewName.setText(evenement.getName());
        holder.textViewPlace.setText(evenement.getPlace());
        holder.textViewDate.setText(evenement.getDate());
        holder.textViewPhone.setText(evenement.getPhone());
    }

    @Override
    public int getItemCount() {
        return evenementList.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName,textViewPlace,textViewDate,textViewPhone;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.txtNameEvent);
            textViewPlace=itemView.findViewById(R.id.txtPlaceEvent);
            textViewDate=itemView.findViewById(R.id.txtDateEvent);
            textViewPhone=itemView.findViewById(R.id.txtPhoneEvent);
        }
    }
}
