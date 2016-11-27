package com.asus.kejar;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMe(View view) {
        Intent i = new Intent(MainActivity.this, orderActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                //TODO pindah ke halaman profile activity
                Intent about = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(about);
                break;
            case R.id.order:
                //TODO pindah ke halaman order
                Intent order = new Intent(MainActivity.this, orderActivity.class);
                startActivity(order);
                break;
            case R.id.quit:
                //TODO keluar aplikasi
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda yakin ingin keluar ?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();

                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
