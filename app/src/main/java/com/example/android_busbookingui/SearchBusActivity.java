package com.example.android_busbookingui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchBusActivity extends AppCompatActivity {
    private ImageView btn_searchBus_back;
    private CardView cv_searchBus_item1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_search_bus);
        initView();
    }

    private void initView(){
        btn_searchBus_back = (ImageView) findViewById(R.id.btn_searchBus_back);
        cv_searchBus_item1 = (CardView) findViewById(R.id.cv_searchBus_item1);
        btn_searchBus_back.setOnClickListener(onClick);
        cv_searchBus_item1.setOnClickListener(onClick);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btn_searchBus_back){
                finish();
            }else if(view.getId() == R.id.cv_searchBus_item1){
                Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(intent);
            }

        }
    };
}