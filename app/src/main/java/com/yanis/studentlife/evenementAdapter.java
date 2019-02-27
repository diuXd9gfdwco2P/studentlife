package com.yanis.studentlife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class evenementAdapter extends RecyclerView.Adapter<evenementAdapter.evenementViewHolder> {
    private Context mCtx;
    private List<evenement> evenementList;

    public evenementAdapter(Context ctx, List<evenement> evenementList) {
        this.mCtx = ctx;
        this.evenementList = evenementList;
    }

    @NonNull
    @Override
    public evenementViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.card,null);
        return new evenementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull evenementViewHolder holder, int i) {
        evenement evenement=evenementList.get(i);

        holder.textViewName.setText(evenement.getName());
        holder.textViewPlace.setText(evenement.getPlace());
        holder.textViewDate.setText(evenement.getDate().substring(0,4)+"/"+evenement.getDate().substring(4,6)+"/"+evenement.getDate().substring(6,8));
        holder.textViewPhone.setText(evenement.getPhone());
        holder.button.setContentDescription(evenement.getUserId());


    }

    @Override
    public int getItemCount() {
        return evenementList.size();
    }

    public class evenementViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName,textViewPlace,textViewDate,textViewPhone;
        Button button;
        public evenementViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.txtNameEvent);
            textViewPlace=itemView.findViewById(R.id.txtPlaceEvent);
            textViewDate=itemView.findViewById(R.id.txtDateEvent);
            textViewPhone=itemView.findViewById(R.id.txtPhoneEvent);
            button =itemView.findViewById(R.id.subscribe);
        }
    }
}
