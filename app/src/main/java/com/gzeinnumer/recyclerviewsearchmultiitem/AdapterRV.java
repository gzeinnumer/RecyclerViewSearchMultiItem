package com.gzeinnumer.recyclerviewsearchmultiitem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.MyHolder> implements Filterable {

    private Context context;
    private ArrayList<DataItem> list;
    private ArrayList<DataItem> listFilter;
    private View view;

    public AdapterRV(Context context, ArrayList<DataItem> list) {
        this.context = context;
        this.list = list;
        listFilter = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

        myHolder.tv1.setText(list.get(i).getStrTv1());
        myHolder.tv2.setText(list.get(i).getStrTv2());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(ArrayList<DataItem> list) {
        this.list = list;
        listFilter = new ArrayList<>(list);
        notifyDataSetChanged();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }


    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<DataItem> fildteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                fildteredList.addAll(listFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (DataItem item : listFilter){
                    if( item.getStrTv2().toLowerCase().contains(filterPattern)){
                        fildteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = fildteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };



}
