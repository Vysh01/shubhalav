package com.example.shubhalav.AdaptorShopList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shubhalav.R;
import com.example.shubhalav.model.ShopModel;

import java.util.ArrayList;

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ProgrammingViewHolder> {

    private ArrayList<ShopModel> shopModelList;

    public ShopListAdapter(ArrayList<ShopModel> shopModelList) {

        this.shopModelList = shopModelList;
    }



    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_layout, parent, false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {

        String no = shopModelList.get(position).getTme_code();
        String title = shopModelList.get(position).getOutlet_name();
        String body = shopModelList.get(position).getShop_address();
        holder.no.setText(no);
        holder.title.setText(title);
        holder.body.setText(body);
    }

    @Override
    public int getItemCount() {
        return shopModelList.size();
    }


    public class ProgrammingViewHolder extends RecyclerView.ViewHolder {
        TextView no;
        TextView title;
        TextView body;

        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);
            no = itemView.findViewById(R.id.no);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);
        }

    }
}
