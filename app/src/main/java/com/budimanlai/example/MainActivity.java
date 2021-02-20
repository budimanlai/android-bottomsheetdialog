package com.budimanlai.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.budimanlai.bottomsheet.BottomListSheet;
import com.budimanlai.bottomsheet.BottomProgressSheet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDialog1();
        initDialog2();
        initDialog3();
        initDialog4();
        initDialog5();
    }

    private void initDialog1() {
        final BottomListSheet bottomDialog = BottomListSheet.build(this);
        bottomDialog.setTitle(getString(R.string.dialog_1_button));
        bottomDialog.setOnClickListener((label, index) -> {
            bottomDialog.dismiss();
            Toast.makeText(MainActivity.this, label, Toast.LENGTH_LONG).show();
        });
        bottomDialog.add("Apple");
        bottomDialog.add("Orange");
        bottomDialog.add("Mango");
        bottomDialog.add("Banana");
        bottomDialog.add("Chocolate");

        final Button btnDialog1 = findViewById(R.id.btnDialog1);
        btnDialog1.setOnClickListener(v -> bottomDialog.show());
    }

    private void initDialog2() {
        final BottomListSheet bottomDialog = BottomListSheet.build(this);
        bottomDialog.setOnClickListener((label, index) -> {
            bottomDialog.dismiss();
            Toast.makeText(MainActivity.this, label, Toast.LENGTH_LONG).show();
        });

        ArrayList<String> socialMedia = new ArrayList<>();
        socialMedia.add("Facebook");
        socialMedia.add("Instagram");
        socialMedia.add("TikTok");
        socialMedia.add("Twitter");
        socialMedia.add("Youtube");
        socialMedia.add("Pinterest");
        socialMedia.add("Snapchat");

        bottomDialog.setTitle(getString(R.string.dialog_2_button));
        bottomDialog.setDescription(getString(R.string.dialog_2_description));
        bottomDialog.addAll(socialMedia);

        final Button btnDialog2 = findViewById(R.id.btnDialog2);
        btnDialog2.setOnClickListener(v -> bottomDialog.show());
    }

    private void initDialog3() {
        final BottomListSheet bottomDialog = BottomListSheet.build(this);
        bottomDialog.setOnClickListener((label, index) -> {
            bottomDialog.dismiss();
            Toast.makeText(MainActivity.this, label, Toast.LENGTH_LONG).show();
        });

        ArrayList<String> socialMedia = new ArrayList<>();
        socialMedia.add("Facebook");
        socialMedia.add("Instagram");
        socialMedia.add("TikTok");
        socialMedia.add("Twitter");
        socialMedia.add("Youtube");
        socialMedia.add("Pinterest");
        socialMedia.add("Snapchat");

        bottomDialog.setTitle(getString(R.string.dialog_3_button));
        bottomDialog.setDescription(getString(R.string.dialog_3_description));
        bottomDialog.addAll(socialMedia);
        bottomDialog.showCancel(true);
        bottomDialog.setOnCancelClickListener(v -> {
            bottomDialog.dismiss();
            Toast.makeText(MainActivity.this, "Cancel triggered", Toast.LENGTH_LONG).show();
        });

        final Button btnDialog2 = findViewById(R.id.btnDialog3);
        btnDialog2.setOnClickListener(v -> bottomDialog.show());
    }

    private void initDialog4() {
        final BottomListSheet bottomDialog = BottomListSheet.build(this, R.layout.dialog_custom);
        bottomDialog.setTitle(getString(R.string.dialog_4_button));
        bottomDialog.setOnClickListener((label, index) -> {
            bottomDialog.dismiss();
            Toast.makeText(MainActivity.this, label, Toast.LENGTH_LONG).show();
        });
        bottomDialog.add("Apple");
        bottomDialog.add("Orange");
        bottomDialog.add("Mango");
        bottomDialog.add("Banana");
        bottomDialog.add("Chocolate");

        final Button btnDialog1 = findViewById(R.id.btnDialog4);
        btnDialog1.setOnClickListener(v -> bottomDialog.show());
    }

    private void initDialog5() {
        final BottomProgressSheet bottomDialog = BottomProgressSheet.build(this);
        bottomDialog.setTitle(getString(R.string.dialog_5_payment));

        View view = bottomDialog.getContentView(R.layout.payment_form);
        final Button btnCancel = view.findViewById(R.id.btnCancel);
        final Button btnPay = view.findViewById(R.id.btnPay);

        btnCancel.setOnClickListener(v -> bottomDialog.dismiss());

        btnPay.setOnClickListener(v -> {
            bottomDialog.showLoading();
            new Handler().postDelayed(() -> {
                bottomDialog.dismiss();
                Toast.makeText(MainActivity.this, "Payment success", Toast.LENGTH_LONG).show();
            }, 3000);
        });

        final Button btnDialog = findViewById(R.id.btnDialog5);
        btnDialog.setOnClickListener(v -> bottomDialog.show());
    }
}