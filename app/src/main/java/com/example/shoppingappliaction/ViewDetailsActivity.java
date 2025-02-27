package com.example.shoppingappliaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewDetailsActivity extends AppCompatActivity {

    RelativeLayout buyNow_tv;
    TextView coffeeName_tv,money_tv,subText_tv;
    ImageView img1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        buyNow_tv = findViewById(R.id.buyNow_tv);
        coffeeName_tv = findViewById(R.id.coffeeName_tv);
        money_tv = findViewById(R.id.money_tv);
        subText_tv = findViewById(R.id.sub_txt);
        img1 = findViewById(R.id.img1);

        Bundle bundle = getIntent().getExtras();
        String coffeeName = bundle.getString("coffee_name");
        String money = bundle.getString("money");
        String src = bundle.getParcelable("src");
        String extra_details = bundle.getString("extra_details");
        coffeeName_tv.setText(coffeeName);
        money_tv.setText(money);
        coffeeName_tv.setText(coffeeName);
        subText_tv.setText(extra_details);

        buyNow_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  intent = new Intent(ViewDetailsActivity.this,BuyActivity.class);
                startActivity(intent);
            }
        });
    }

}