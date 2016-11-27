package com.asus.kejar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class orderActivity extends AppCompatActivity {
    EditText mTextNama;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    TextView mTextHarga, mtextQty;
    // spinner
    Spinner mSpinnerMenu;
    List<String> mListMenu = new ArrayList<>();
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonPlus);
        mtextQty = (TextView) findViewById(R.id.mTextQty);
        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinnerMenu);
        mListMenu.add("---------");
        mListMenu.add("Martabak");
        mListMenu.add("Piscok Bakar");
        mListMenu.add("Ice Cream Sandwich");
        mListMenu.add("Lumpia Basah");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdapter);

//        mButtonOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"Hi, nama saya"+mTextNama.getText(),Toast.LENGTH_LONG).show();
//                mTextHarga.setText(mTextNama.getText());
//            }
//        });
    }

    public void onClickOrder(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "arieridwansyah@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, mTextNama.getText());
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                "Saya Pesan "
        + mSpinnerMenu.getSelectedItem()
        + "sebanyak "
        + mtextQty.getText()
        + "seharga "
        + mTextHarga.getText());

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        }
        catch(android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_LONG).show();
        }
//        Toast.makeText(getApplicationContext(),"Hi, nama saya" +mTextNama.getText(),Toast.LENGTH_LONG).show();
//        mTextHarga.setText(mTextNama.getText());
    }

    public void onClickPlus(View view){
        harga = harga + 5;
        qty = qty + 1;
        mtextQty.setText(qty+"");
        mTextHarga.setText("$"+harga);
    }

    public void onClickMin(View view){
        if(harga != 0) {
            harga = harga - 5;
            qty = qty - 1;
            mtextQty.setText(qty+"");
            mTextHarga.setText("$"+harga);
        }
        else {
            harga = 0;
            qty = 0;
            mtextQty.setText(qty+"");
            mTextHarga.setText("$"+harga);
        }
    }

    public void onClickReset(View v){
        harga = 0;
        qty = 0;
        mTextNama.setText("");
        mTextHarga.setText("$"+harga);
        mtextQty.setText(qty+"");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
