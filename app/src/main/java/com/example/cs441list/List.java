package com.example.cs441list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class List extends RecyclerView.Adapter<List.ViewHolder> {
    private String[] localList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(localList[position]);
    }

    @Override
    public int getItemCount() {
        return localList.length;
    }

    public List(String[] list){
        localList = list;
    }
    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        public ViewHolder(View view){
            super(view);
            textView = (TextView) view.findViewById(R.id.clickViewed);
        }
        public TextView getTextView(){
            return textView;
        }
    }



}


