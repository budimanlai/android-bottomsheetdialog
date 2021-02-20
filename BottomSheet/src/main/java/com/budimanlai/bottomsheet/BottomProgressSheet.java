package com.budimanlai.bottomsheet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class BottomProgressSheet extends BottomSheet {

    protected View loadingView;
    protected TextView loadingText;

    public BottomProgressSheet(Context context, int dialog_layout) {
        super(context, dialog_layout);
    }

    public static BottomProgressSheet build(Context context) {
        BottomProgressSheet dialog = new BottomProgressSheet(context, R.layout.dialog_progress_container);
        dialog.initLayout();
        return dialog;
    }

    public static BottomProgressSheet build(Context context, int layout) {
        BottomProgressSheet dialog = new BottomProgressSheet(context, layout);
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
