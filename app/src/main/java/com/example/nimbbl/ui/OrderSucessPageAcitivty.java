package com.example.nimbbl.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nimbbl.R;

public class OrderSucessPageAcitivty extends AppCompatActivity {

    private String orderId = "", status = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_sucess_page_acitivty);

        if (getIntent().getExtras() != null) {
            orderId = getIntent().getStringExtra("orderid");
            status = getIntent().getStringExtra("status");

            try {
                TextView orderIdTxt = findViewById(R.id.txt_orderid);
                TextView statusTxt = findViewById(R.id.txt_status);

                if (orderId != null)
                    orderIdTxt.setText("Order id:- " + orderId);
                statusTxt.setText("Status:- " + status);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
