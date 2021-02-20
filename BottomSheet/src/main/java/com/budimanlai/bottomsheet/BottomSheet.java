package com.budimanlai.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class BottomSheet {
    protected BottomSheetDialog dialog;
    protected Context context;
    protected TextView title;
    protected View mView;
    protected LinearLayout mContent;

    /**
     * Create bottom dialog with default layout
     *
     * @param context Context
     */
    public BottomSheet(Context context) {
        init(context, R.layout.dialog_container);
    }

    /**
     * Create bottom dialog with custom layout
     *
     * @param context Context
     * @param dialog_layout int
     */
    public BottomSheet(Context context, int dialog_layout) {
        init(context, dialog_layout);
    }

    public void init(Context context, int dialog_layout) {
        this.context = context;

        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = layoutInflater.inflate(dialog_layout, null, false);

        dialog = new BottomSheetDialog(this.context);
        dialog.setContentView(mView);

        title = mView.findViewById(R.id.txtTitle);
        mContent = mView.findViewById(R.id.llContent);
    }

    public void show() { dialog.show(); }
    public void dismiss() { dialog.dismiss(); }
    public void setTitle(String text) { title.setText(text); }
    public View getContentView(int id) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(id, null, false);
        mContent.addView(view);

        return view;
    }
}