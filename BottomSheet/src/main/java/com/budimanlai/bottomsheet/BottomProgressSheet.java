package com.budimanlai.bottomsheet;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BottomProgressSheet extends BottomSheet {

    protected View loadingView;
    protected TextView loadingText;

    public BottomProgressSheet(AppCompatActivity activity, int dialog_layout) {
        super(activity, dialog_layout);
    }

    public static BottomProgressSheet build(AppCompatActivity activity) {
        BottomProgressSheet dialog = new BottomProgressSheet(activity, R.layout.bs_dialog_progress_container);
        dialog.initLayout();
        return dialog;
    }

    public static BottomProgressSheet build(AppCompatActivity activity, int layout) {
        BottomProgressSheet dialog = new BottomProgressSheet(activity, layout);
        dialog.initLayout();
        return dialog;
    }

    public void initLayout() {
        loadingView = mView.findViewById(R.id.llLoading);
        loadingText = mView.findViewById(R.id.txtLoadingTitle);
    }

    @Override
    public void show() {
        super.show();
        hideLoading();
    }

    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
        mContent.setVisibility(View.GONE);
        dialog.setCancelable(false);
    }

    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
        mContent.setVisibility(View.VISIBLE);
        dialog.setCancelable(true);
    }
}
