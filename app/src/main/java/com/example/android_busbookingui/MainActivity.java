package com.example.android_busbookingui;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner sp_main_start_location;
    private Spinner sp_main_destination_location;

    private TextView txt_main_date;
    private DatePickerDialog.OnDateSetListener datePicker;
    private Calendar calendar = Calendar.getInstance();

    private Button btn_main_search_buses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        datePicker = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "yyyy/MM/dd";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.TAIWAN);
                txt_main_date.setText("" + sdf.format(calendar.getTime()));
            }
        };

        sp_main_start_location = (Spinner)findViewById(R.id.sp_main_start_location);
        sp_main_destination_location = (Spinner)findViewById(R.id.sp_main_destination_location);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this
                ,R.array.location_array,android.R.layout.simple_dropdown_item_1line);
        sp_main_start_location.setAdapter(adapter1);
        sp_main_destination_location.setAdapter(adapter1);


        txt_main_date = (TextView)findViewById(R.id.txt_main_date);
        btn_main_search_buses = findViewById(R.id.btn_main_search_buses);
        btn_main_search_buses.setOnClickListener(onClick);
        txt_main_date.setOnClickListener(onClick);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.btn_main_search_buses){
                Intent intent = new Intent(getApplicationContext(), SearchBusActivity.class);
                startActivity(intent);
            }else if(view.getId() == R.id.txt_main_date){
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        datePicker,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                dialog.show();
            }

        }
    };
}