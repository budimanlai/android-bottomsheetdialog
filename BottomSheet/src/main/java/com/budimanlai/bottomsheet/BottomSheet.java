package com.budimanlai.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheet {
    protected BottomSheetDialog dialog;
    protected AppCompatActivity activity;
    protected TextView title;
    protected View mView;
    protected LinearLayout mContent;

    /**
     * Create bottom dialog with default layout
     *
     * @param activity Activity
     */
    public BottomSheet(AppCompatActivity activity) {
        init(activity, R.layout.bs_dialog_container);
    }

    /**
     * Create bottom dialog with custom layout
     *
     * @param activity Activity
     * @param dialog_layout int
     */
    public BottomSheet(AppCompatActivity activity, int dialog_layout) {
        init(activity, dialog_layout);
    }

    public void init(AppCompatActivity a, int dialog_layout) {
        this.activity = a;

        LayoutInflater layoutInflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = layoutInflater.inflate(dialog_layout, null, false);

        dialog = new BottomSheetDialog(this.activity);
        dialog.setContentView(mView);

        title = mView.findViewById(R.id.txtTitle);
        mContent = mView.findViewById(R.id.llContent);
    }

    public void show() { dialog.show(); }
    public void dismiss() { dialog.dismiss(); }
    public void setTitle(String text) { title.setText(text); }
    public View getContentView(int id) {
        LayoutInflater layoutInflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(id, null, false);
        mContent.addView(view);

        return view;
    }
}