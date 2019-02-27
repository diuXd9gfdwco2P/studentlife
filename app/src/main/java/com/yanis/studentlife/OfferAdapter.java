package com.yanis.studentlife;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {
    private Context ctx;
    private List<offer> OfferList;

    public OfferAdapter(Context ctx, List<offer> OfferList) {
        this.ctx=ctx;
        this.OfferList=OfferList;
    }

    @NonNull
    @Override
    public OfferViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.card_offer_plan,null);
        return new OfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OfferViewHolder offerViewHolder, int i) {
        offer offer=OfferList.get(i);
        offerViewHolder.textViewName.setText(offer.getName());
        offerViewHolder.textViewPlace.setText(offer.getPlace());
        offerViewHolder.textViewDate.setText(offer.getDate().substring(0,4)+"/"+offer.getDate().substring(4,6)+"/"+offer.getDate().substring(6,8));
        offerViewHolder.textViewPhone.setText(offer.getPhone());
    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }

    public class OfferViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName,textViewPlace,textViewDate,textViewPhone;

        public OfferViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.txtNameEvent);
            textViewPlace=itemView.findViewById(R.id.txtPlaceEvent);
            textViewDate=itemView.findViewById(R.id.txtDateEvent);
            textViewPhone=itemView.findViewById(R.id.txtPhoneEvent);
        }
    }
}
