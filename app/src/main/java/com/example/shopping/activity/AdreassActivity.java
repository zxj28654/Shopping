package com.example.shopping.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopping.R;

public class AdreassActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toobar_class;
    private RecyclerView rcy_address;
    private Button but_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adreass);
        initView();
    }

    private void initView() {
        toobar_class = (Toolbar) findViewById(R.id.toobar_class);
        rcy_address = (RecyclerView) findViewById(R.id.rcy_address);
        but_address = (Button) findViewById(R.id.but_address);

        toobar_class.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        but_address.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but_address:

                break;
        }
    }
}
