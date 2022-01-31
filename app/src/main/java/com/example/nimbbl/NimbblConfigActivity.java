package com.example.nimbbl;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tech.nimbbl.checkout.sdk.NimbblCheckoutSDK;

public class NimbblConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nimbbl_config);
        SharedPreferences preferences = getSharedPreferences("nimmbl_configs_prefs", MODE_PRIVATE);

        String base_url = preferences.getString("shop_base_url", Nimbbl.getInstance().getBaseUrl());
        String accessKey = "access_key_1MwvMkKkweorz0ry";
        RadioGroup radio_sandbox_group = findViewById(R.id.radio_sandbox_group);
        RadioGroup radio_sampleapp_group = findViewById(R.id.radio_sampleapp_group);
        TextView tv_title_accesskey = findViewById(R.id.tv_title_accesskey);
        EditText edt_access_key = findViewById(R.id.edt_access_key);
        Button btn_done = findViewById(R.id.btn_done);

        switch (base_url) {
            case "https://devshop.nimbbl.tech/api/":
                radio_sandbox_group.check(R.id.radio_dev);
                tv_title_accesskey.setText(" Update a dev environment access key");
                accessKey = preferences.getString("access_key_dev", "access_key_1MwvMkKkweorz0ry");
                break;
            case "https://uatshop.nimbbl.tech/api/":
                radio_sandbox_group.check(R.id.radio_uat);
                tv_title_accesskey.setText(" Update a uat environment access key");
                accessKey = preferences.getString("access_key_uat", "access_key_1MwvMkKkweorz0ry");
                break;
            case "https://shoppp.nimbbl.tech/api/":
                radio_sandbox_group.check(R.id.radio_preprod);
                tv_title_accesskey.setText(" Update a preprod environment access key");
                accessKey = preferences.getString("access_key_preprod", "access_key_1MwvMkKkweorz0ry");
                break;
            case "https://shop.nimbbl.tech/api/":
                radio_sandbox_group.check(R.id.radio_prod);
                tv_title_accesskey.setText(" Update a prod environment access key");
                accessKey = preferences.getString("access_key_prod", "access_key_1MwvMkKkweorz0ry");
                break;
        }
        edt_access_key.setText(accessKey);

        String sampleApp = preferences.getString("sample_app_mode", "browser");
        if (sampleApp.equals("browser")) {
            radio_sampleapp_group.check(R.id.radio_custom_browser);
        } else {
            radio_sampleapp_group.check(R.id.radio_native);
        }
        radio_sandbox_group.setOnCheckedChangeListener((group, checkedId) -> {
            // This will get the radiobutton that has changed in its check state
            RadioButton checkedRadioButton = group.findViewById(checkedId);
            // This puts the value (true/false) into the variable
            boolean isChecked = checkedRadioButton.isChecked();
            // If the radiobutton that has changed in check state is now checked...
            if (isChecked) {
                // Changes the textview's text to "Checked: example radiobutton text"
                if (checkedRadioButton.getId() == R.id.radio_dev) {
                    tv_title_accesskey.setText(" Update a dev environment access key");
                    edt_access_key.setText(
                            preferences.getString(
                                    "access_key_dev",
                                    "access_key_1MwvMkKkweorz0ry"
                            )
                    );
                } else if (checkedRadioButton.getId() == R.id.radio_uat) {
                    tv_title_accesskey.setText(" Update a uat environment access key");
                    edt_access_key.setText(preferences.getString("access_key_uat", "access_key_1MwvMkKkweorz0ry"));
                } else if (checkedRadioButton.getId() == R.id.radio_preprod) {
                    tv_title_accesskey.setText(" Update a preprod environment access key");
                    edt_access_key.setText(preferences.getString("access_key_preprod", "access_key_1MwvMkKkweorz0ry"));
                } else if (checkedRadioButton.getId() == R.id.radio_prod) {
                    tv_title_accesskey.setText(" Update a prod environment access key");
                    edt_access_key.setText(preferences.getString("access_key_prod", "access_key_1MwvMkKkweorz0ry"));
                }
            }
        });

        btn_done.setOnClickListener(view -> {
            String baseUrl = "https://devshop.nimbbl.tech/api/";
            SharedPreferences.Editor editor = preferences.edit();
            switch (radio_sandbox_group.getCheckedRadioButtonId()) {
                case R.id.radio_dev:
                    baseUrl = "https://devshop.nimbbl.tech/api/";
                    editor.putString("access_key_dev", edt_access_key.getText().toString().trim());
                    break;
                case R.id.radio_uat:
                    baseUrl = "https://uatshop.nimbbl.tech/api/";
                    editor.putString("access_key_uat", edt_access_key.getText().toString().trim());
                    break;
                case R.id.radio_preprod:
                    baseUrl = "https://shoppp.nimbbl.tech/api/";
                    editor.putString("access_key_preprod", edt_access_key.getText().toString().trim());
                    break;
                case R.id.radio_prod:
                    baseUrl = "https://shop.nimbbl.tech/api/";
                    editor.putString("access_key_prod", edt_access_key.getText().toString().trim());
                    break;
            }

            switch (radio_sampleapp_group.getCheckedRadioButtonId()) {
                case R.id.radio_native:
                    editor.putString("sample_app_mode", "native");
                    break;
                case R.id.radio_custom_browser:
                    editor.putString("sample_app_mode", "browser");
                    break;
            }


            Nimbbl.getInstance().setBaseUrl(baseUrl);
            String apiUrl = "";
            String webViewUrl = "";
            String webViewRespUrl = "";
            switch (baseUrl) {

                case "https://devshop.nimbbl.tech/api/":
                    apiUrl = "https://devapi.nimbbl.tech/api/v2/";
                    webViewUrl = "https://devcheckout.nimbbl.tech/?modal=false&order_id=";
                    webViewRespUrl = "https://devcheckout.nimbbl.tech/mobile/redirect";
                    break;
                case "https://uatshop.nimbbl.tech/api/":
                    apiUrl = "https://uatapi.nimbbl.tech/api/v2/";
                    webViewUrl = "https://uatcheckout.nimbbl.tech/?modal=false&order_id=";
                    webViewRespUrl = "https://uatcheckout.nimbbl.tech/mobile/redirect";
                    break;
                case "https://shoppp.nimbbl.tech/api/":
                    apiUrl = "https://apipp.nimbbl.tech/api/v2/";
                    webViewUrl = "https://checkoutpp.nimbbl.tech/?modal=false&order_id=";
                    webViewRespUrl = "https://checkoutpp.nimbbl.tech/mobile/redirect";
                    break;
                case "https://shop.nimbbl.tech/api/":
                    apiUrl = "https://api.nimbbl.tech/api/v2/";
                    webViewUrl = "https://checkout.nimbbl.tech/?modal=false&order_id=";
                    webViewRespUrl = "https://checkout.nimbbl.tech/mobile/redirect";
                    break;
            }
            NimbblCheckoutSDK.Companion.getInstance().setEnvironmentUrls(apiUrl, webViewUrl, webViewRespUrl);

            editor.putString("shop_base_url", baseUrl);
            boolean isSuccess = editor.commit();

            if (isSuccess) {

                Toast.makeText(this, "Environment selected successfully !", Toast.LENGTH_SHORT)
                        .show();
                onBackPressed();
            }
        });
    }

}