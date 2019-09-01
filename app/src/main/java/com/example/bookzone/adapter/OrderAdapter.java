package com.example.bookzone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bookzone.R;
import com.example.bookzone.model.OrderModel;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private ArrayList<OrderModel> mDataset;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView BookTitle,orderphoneno,orderlocation,orderdeliveryplace;
        public MyViewHolder(View v) {
            super(v);
            BookTitle = v.findViewById(R.id.orderTitle);
            orderphoneno = v.findViewById(R.id.orderphoneno);
            orderlocation = v.findViewById(R.id.orderlocation);
            orderdeliveryplace = v.findViewById(R.id.orderdeliveryplace);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public OrderAdapter(ArrayList<OrderModel> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_row, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.BookTitle.setText(mDataset.get(position).getTitle());
        holder.orderphoneno.setText(mDataset.get(position).getPhonenumber());
        holder.orderlocation.setText(mDataset.get(position).getLocation());
        holder.orderdeliveryplace.setText(mDataset.get(position).getDeliverLocation());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return mDataset.size();
    }
}

