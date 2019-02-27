package com.yanis.studentlife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class planAdapter extends RecyclerView.Adapter<planAdapter.planViewHolder> {
    private Context ctx;
    private List<plan> planList;

    public planAdapter(Context ctx, List<plan> planList) {
        this.ctx = ctx;
        this.planList = planList;
    }

    @NonNull
    @Override
    public planAdapter.planViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.card_offer_plan,null);
        return new planViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull planAdapter.planViewHolder planViewHolder, int i) {
        plan plan=planList.get(i);

        planViewHolder.textViewName.setText(plan.getName());
        planViewHolder.textViewPlace.setText(plan.getPlace());
        planViewHolder.textViewDate.setText(plan.getDate().substring(0,4)+"/"+plan.getDate().substring(4,6)+"/"+plan.getDate().substring(6,8));
        planViewHolder.textViewPhone.setText(plan.getPhone());
    }

    @Override
    public int getItemCount() {
        return planList.size();
    }

    public class planViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName,textViewPlace,textViewDate,textViewPhone;
        public planViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.txtNameEvent);
            textViewPlace=itemView.findViewById(R.id.txtPlaceEvent);
            textViewDate=itemView.findViewById(R.id.txtDateEvent);
            textViewPhone=itemView.findViewById(R.id.txtPhoneEvent);
        }
    }
}
