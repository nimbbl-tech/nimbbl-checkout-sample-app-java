package com.example.nimbbl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nimbbl.Nimbbl;
import com.example.nimbbl.R;
import com.example.nimbbl.data.model.model.CatalogModel;
import com.example.nimbbl.data.model.model.createoder.CreateOrder_Model;
import com.example.nimbbl.data.model.model.postbody.Catlogbody;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.CatalogHolder> {

    private List<CatalogModel> dataList;
    Context context;


    public CatalogAdapter(Context context, List<CatalogModel> dataList) {
        super();
        this.dataList = dataList;
        this.context = context;
    }

    @SuppressWarnings("ConstantConditions")
    @NonNull
    @Override
    public CatalogHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.catalog_item, viewGroup, false);
        return new CatalogAdapter.CatalogHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogHolder holder, int position) {

        CatalogModel catalogModel = dataList.get(position);

        holder.titleTxt.setText(catalogModel.getTitle());
        holder.txtRupees.setText(catalogModel.getPrice());
        holder.txtDesc.setText(catalogModel.getDescription());
        if (catalogModel.getPrice().equals("₹ 2")){
            holder.img.setImageDrawable(context.getResources().getDrawable(R.drawable.img_1));
        }else{
            holder.img.setImageDrawable(context.getResources().getDrawable(R.drawable.img_2));
        }

        holder.buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    SharedPreferences preferences = context.getSharedPreferences("nimmbl_configs_prefs",
                            AppCompatActivity.MODE_PRIVATE
                    );
                    String baseUrl = preferences.getString("shop_base_url", Nimbbl.getInstance().getBaseUrl());

                    ((Nimbbl) ((Activity) context).getApplication()).getApiService()
                            .createOrder(baseUrl + "orders/create", new Catlogbody(catalogModel.getId()))
                            .enqueue(new Callback<CreateOrder_Model>() {
                                @Override
                                public void onResponse(Call<CreateOrder_Model> call, Response<CreateOrder_Model> response) {
                                    if (response.isSuccessful()) {
                                        ((CatalogPage) context).makePayment(response.body().getResult().getItem().getOrder_id());
                                    }
                                }

                                @Override
                                public void onFailure(Call<CreateOrder_Model> call, Throwable t) {

                                }
                            });
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(context,"Unable to create order,",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CatalogHolder extends RecyclerView.ViewHolder {

        TextView titleTxt, txtRupees, txtDesc;
        ImageView img;
        Button buyNowBtn;

        CatalogHolder(View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.txt_title);
            txtRupees = itemView.findViewById(R.id.txt_ruppes);
            txtDesc = itemView.findViewById(R.id.txt_dscription);
            img = itemView.findViewById(R.id.img);
            buyNowBtn = itemView.findViewById(R.id.btn_buynow);
        }
    }
}
