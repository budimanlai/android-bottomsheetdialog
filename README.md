# Bottom Sheet Dialog

Example:

![Example](https://budimanlai.com/d/ezgif.com-gif-maker.gif "Example")


------------
### How to use

Example dialog1:
```java
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
```

Example Dialog 2:
```java
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
```

Example Dialog 3:
```java
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
```

Example Dialog 4:
```java
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
```

Example Dialog 5:
```xml
<!-- R.layout.payment_form -->
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="@dimen/dialog_padding">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/dialog_5_text"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/dialog_5_total"
        android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/dialog_5_cc"
        app:drawableStartCompat="@drawable/ic_baseline_credit_card_24"
        android:drawablePadding="10dp"
        app:drawableEndCompat="@drawable/ic_baseline_check_24"
        android:layout_marginBottom="5dp"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="@string/dialog_5_transfer"
        app:drawableStartCompat="@drawable/ic_baseline_attach_money_24"
        android:drawablePadding="10dp"/>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="20dp">

        <Button
            android:id="@+id/btnCancel"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/cancel"
            android:layout_weight="1"
            android:layout_marginEnd="5dp"
            tools:ignore="ButtonStyle" />

        <Button
            android:id="@+id/btnPay"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/pay"
            android:layout_weight="1"
            android:layout_marginStart="5dp"
            tools:ignore="ButtonStyle"/>

    </LinearLayout>
</LinearLayout>
```
```java
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
```
