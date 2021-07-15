package com.example.android.cowinapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        initComponents();
        Button button_pin = findViewById(R.id.button_search_pin);
        Button button_scan=findViewById(R.id.buttonScanBarcode);
        button_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                showToastMessage("button pressed", 500);
                Intent searchPin = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(searchPin);
            }
        }
        );
        button_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanQr=new Intent(getApplicationContext(),ScannerBarcodeActivity.class);
                startActivity(scanQr);

            }
        });

    }

    public void showToastMessage(String text, int duration) {
        final Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duration);
    }
}





