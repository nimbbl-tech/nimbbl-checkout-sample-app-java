package com.example.nimbbl.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.nimbbl.R;
import com.example.nimbbl.data.model.model.CatalogModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tech.nimbbl.checkout.sdk.NimbblCheckoutOptions;
import tech.nimbbl.checkout.sdk.NimbblCheckoutPaymentListener;
import tech.nimbbl.checkout.sdk.NimbblCheckoutSDK;

public class CatalogPage extends AppCompatActivity implements NimbblCheckoutPaymentListener {
    RecyclerView recyclerview_catalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_page);
        recyclerview_catalog = findViewById(R.id.recyclerview_catalog);

        List<CatalogModel> catalogList = new ArrayList<>();
        CatalogModel catalogModel = new CatalogModel();
        catalogModel.setTitle("Colourful Mandalas.");
        catalogModel.setDescription("Convert your dreary device into a bright happy place with this wallpaper by Speedy McVroom");
        catalogModel.setPrice("₹ 2");
        catalogModel.setId(1);
        catalogList.add(catalogModel);

        catalogModel = new CatalogModel();
        catalogModel.setTitle("Designer Triangles.");
        catalogModel.setDescription("Bold blue and deep black triangle designer wallpaper to give your device a hypnotic effect by  chenspec from Pixabay");
        catalogModel.setPrice("₹ 4");
        catalogModel.setId(2);
        catalogList.add(catalogModel);

        this.setUpRecycelrvView(catalogList);
    }

    public final void setUpRecycelrvView(List<CatalogModel> catalogList) {
        recyclerview_catalog.setLayoutManager(new LinearLayoutManager(this));
        recyclerview_catalog.setAdapter(new CatalogAdapter(this, catalogList));
    }


    @Override
    public void onPaymentSuccess(Map<String, Object> map) {
        Log.d("Nimbbl demo", Integer.toString(map.size()));
        Toast.makeText(
                this,
                "OrderId=" + map.get("order_id") + ", Status=" + map.get("status"),
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,OrderSucessPageAcitivty.class);
        intent.putExtra("orderid", map.get("order_id").toString());
        intent.putExtra("status",map.get("status").toString());
        startActivity(intent);
    }

    @Override
    public void onPaymentFailed(String orderId) {
        //to do

    }

    public final void makePayment(@NotNull String orderId) {
        //Intrinsics.checkParameterIsNotNull(orderId, "orderId");
        NimbblCheckoutOptions.Builder b = new NimbblCheckoutOptions.Builder();
        NimbblCheckoutOptions options = b.setKey("access_key_1MwvMkKkweorz0ry").setOrderId(orderId).build();
        NimbblCheckoutSDK.getInstance().init(this);
        NimbblCheckoutSDK.getInstance().checkout(options);
    }
}