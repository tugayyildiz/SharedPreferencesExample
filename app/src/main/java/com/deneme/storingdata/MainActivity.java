package com.deneme.storingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText_age;
    TextView textView;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText_age=findViewById(R.id.editTextNumber);
        textView=findViewById(R.id.textView2);
        textView.setText("Your Age :");

        sharedPreferences=this.getSharedPreferences("com.deneme.storingdata", Context.MODE_PRIVATE);
        int storagedAge=sharedPreferences.getInt("storedAge",0);
        textView.setText("Your Age : " + storagedAge);
    }

    public void save(View view){

        try {

            if(editText_age.getText().toString().matches("")){

                textView.setText("Sayı boş bırakılamaz.!!");

            }
            else{

                int age=Integer.parseInt(editText_age.getText().toString());

                textView.setText("Your Age :" + age);

                sharedPreferences.edit().putInt("storedAge",age).apply();
            }

        } catch (Exception e){

        }

    }

    public void clear(View view){
        try {
            int storedData=sharedPreferences.getInt("storedAge",0);
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age : ");

        }catch(Exception e){

        }

    }
}