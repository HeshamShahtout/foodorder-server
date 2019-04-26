package com.example.eatitserver.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;


import com.example.eatitserver.R;
import com.example.eatitserver.ItemClickListener;

public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener {
    public TextView txtOrderId, txtOrderStatus, txtOrderPhone, txtOrderAddress;

    private ItemClickListener itemClickListner;

    public OrderViewHolder(@NonNull View itemView) {
        super(itemView);

        txtOrderAddress = itemView.findViewById(R.id.order_address);
        txtOrderId = itemView.findViewById(R.id.order_id);
        txtOrderStatus = itemView.findViewById(R.id.order_status);
        txtOrderPhone = itemView.findViewById(R.id.order_phone);

        itemView.setOnClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }

    public void setItemClickListner(ItemClickListener itemClickListner) {
        this.itemClickListner = itemClickListner;
    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v, getAdapterPosition(),false);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Select The Action");

        menu.add(0,0,getAdapterPosition(),"Update");
        menu.add(0,0,getAdapterPosition(),"Update");

    }
}