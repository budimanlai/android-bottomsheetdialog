/*
 * Created by Budiman Lai <budiman.lai@gmail.com> on 12/28/20 9:53 AM
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 12/23/20 1:22 PM
 */

package com.budimanlai.bottomsheet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.budimanlai.bottomsheet.BottomListSheet;
import com.budimanlai.bottomsheet.R;

import java.util.ArrayList;

public class BottomListAdapter extends RecyclerView.Adapter<BottomListAdapter.MyViewHolder> {

    private final ArrayList<String> mItems;
    private final BottomListSheet.OnClickListener mListener;

    public BottomListAdapter(ArrayList<String> i, BottomListSheet.OnClickListener l) {
        this.mItems = i;
        this.mListener = l;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.bs_simple_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final String label = this.mItems.get(position);
        holder.txtTitle.setText(label);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.OnClicked(label, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.mItems == null ? 0 : this.mItems.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        public final TextView txtTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.txtTitle = itemView.findViewById(R.id.txtTitle);
        }
    }
}
