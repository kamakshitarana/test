package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

public class Checkbox extends AppCompatActivity {

    CheckBox box1, box2;
    Button button;
    //  RadioButton radi1,radi2;
    Button btnProcced;
    RadioGroup radioGroup;
    Spinner spinner;
    TimePicker timePicker;
    Button buttonb2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        box1 = findViewById(R.id.checkbox1);
        box2 = findViewById(R.id.checkbox2);
        button = findViewById(R.id.btnOrder);
//        radi1 =findViewById(R.id.radio1);
//        radi2 =findViewById(R.id.radio2);
        btnProcced = findViewById(R.id.btnProceedOrder);
        radioGroup = findViewById(R.id.radioGRP);
        spinner = findViewById(R.id.spinner);
//        timePicker =findViewById(R.id.time_picker);


        //CHECKBOX
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (box1.isChecked()) {
                    Toast.makeText(Checkbox.this, "cheese is added", Toast.LENGTH_SHORT).show();
                } else {

                }
                if (box2.isChecked()) {
                    Toast.makeText(Checkbox.this, "Butter is added", Toast.LENGTH_SHORT).show();

                } else {

                }
            }
        });

        //RADIOGROUP & RADIOBUTTON
//        btnProcced.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Checkbox.this,"Without delivery",Toast.LENGTH_SHORT).show();
//
//            }
//        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checked) {
                RadioButton radioButton = findViewById(checked);
                Toast.makeText(Checkbox.this, "selected" + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });


        //sppiner

//        String[] courses = {"c", "c++", "java", "android"};
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemClickListener(new AdapterView.OnItemSelectedListener(){
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String[] i = courses;
//                Toast.makeText(Checkbox.this,"you selected: "+courses[i],
//                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });




        //TimePicker
//        timePicker.setIs24HourView(true) ;
//        btnProcced.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //getting selected time
//                String currentTime ="Time: "+timePicker.getCurrentHour()+" : "+timePicker.getCurrentMinute();
//                Toast.makeText(getApplicationContext(), ""+currentTime, Toast.LENGTH_SHORT).show();
//
//
//            }
//        });





        //time picker fragment

        buttonb2=findViewById(R.id.button2);
        buttonb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display time picker
                DialogFragment timePickerFrag  = new TimePickerFragment();
                timePickerFrag.show(getSupportFragmentManager(),"pick time now: ");

            }
        });

        button3 =findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePickerFrag  = new DatePickerFragment();
                datePickerFrag.show(getSupportFragmentManager(),"pick date now: ");


            }
        });

    }
}