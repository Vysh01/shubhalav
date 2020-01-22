package com.example.shubhalav.AdaptorShopList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shubhalav.R;

import java.util.List;

public class itemAdaptor extends RecyclerView.Adapter<itemAdaptor.ProgrammingViewHolder> {

private List<modelclass> modelclassList;

    public itemAdaptor(List<modelclass> modelclassList) {

        this.modelclassList = modelclassList;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_layout, parent,false);
        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {

        String no = modelclassList.get(position).getNo();
        String title = modelclassList.get(position).getTitle();
        String body = modelclassList.get(position).getBody();
        holder.setData(no, title, body);



    }

    @Override
    public int getItemCount() {
        return modelclassList.size();
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder  {

          TextView no;
          TextView title;
          TextView body ;
        public ProgrammingViewHolder(@NonNull View itemView) {
            super(itemView);



            no = itemView.findViewById(R.id.no);
            title = itemView.findViewById(R.id.title);
            body = itemView.findViewById(R.id.body);




        }
        private void setData(String noText, String titleText, String bodyText) {
            no.setText(noText);
            title.setText(titleText);
            body.setText(bodyText);
        }

    }
}
