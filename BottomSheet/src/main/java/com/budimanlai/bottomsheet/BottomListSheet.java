package com.budimanlai.bottomsheet;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.budimanlai.bottomsheet.adapter.BottomListAdapter;

import java.util.ArrayList;

public class BottomListSheet extends BottomSheet {

    private BottomListAdapter mAdapter;
    private ArrayList<String> mItems;
    private BottomListSheet.OnClickListener mListener;
    private TextView txtDescription;
    private Button btnCancel;

    public BottomListSheet(Context context) {
        super(context);
    }
    public BottomListSheet(Context context, int layout) {
        super(context, layout);
    }

    public static BottomListSheet build(Context context) {
        BottomListSheet dialog = new BottomListSheet(context);
        dialog.initLayout();
        return dialog;
    }

    public static BottomListSheet build(Context context, int layout) {
        BottomListSheet dialog = new BottomListSheet(context, layout);
        dialog.initLayout();
        return dialog;
    }

    public void setOnClickListener(BottomListSheet.OnClickListener listener) {
        mListener = listener;
    }

    public void initLayout() {
        View view = getContentView(R.layout.dialog_list);
        txtDescription = view.findViewById(R.id.txtDescription);
        btnCancel = view.findViewById(R.id.btnCancel);

        mItems = new ArrayList<>();
        mAdapter = new BottomListAdapter(mItems, (label, index) -> {
            if (mListener != null) {
                mListener.OnClicked(label, index);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void show() {
        super.show();
        mAdapter.notifyDataSetChanged();
    }

    public void setDescription(String text) {
        txtDescription.setText(text);
        txtDescription.setVisibility(View.VISIBLE);
    }

    public void setOnCancelClickListener(View.OnClickListener listener) {
        btnCancel.setOnClickListener(listener);
    }

    /**
     * Show or hide cancel button
     *
     * @param b boolean
     */
    public void showCancel(boolean b) {
        btnCancel.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    public void add(String text) { mItems.add(text); }
    public void addAll(ArrayList<String> all) { mItems.addAll(all); }
    public void clear() { mItems.clear(); }

    public interface OnClickListener {
        void OnClicked(String label, int index);
    }
}