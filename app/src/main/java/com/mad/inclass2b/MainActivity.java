/*
 Assignment: In Class #2.
 File Name: InClass02_Group03.zip
 Full name: Chinmay Rawool
            Neha Kishor Dalvi
 */

package com.mad.inclass2b;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et;
    private TextView tv;
    private double bmi1,bmi2;
    private double weight1,weight2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
        //final double bmi1,bmi2;
        //final double weight1,weight2;
        final RadioGroup rg =(RadioGroup)findViewById(R.id.RadioGroupRange);
        Button btnCalc = (Button)findViewById(R.id.buttonCalculateWeight);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv = (TextView)findViewById(R.id.textViewResult);
                tv.setText("");
                int id = rg.getCheckedRadioButtonId();
                et = (EditText)findViewById(R.id.editTextFeet);
                String feet = et.getText().toString().trim();
                et = (EditText)findViewById(R.id.editTextInches);
                String inches = et.getText().toString().trim();

                if(feet.equals("") || inches.equals("") || feet.equals(".")||inches.equals(".")){
                    Context context = getApplicationContext();
                    CharSequence text = getResources().getString(R.string.invalid_input).trim();
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }else{
                    int f = Integer.parseInt(feet);
                    int i = Integer.parseInt(inches);
                    int height= f*12+i;
                    tv = (TextView)findViewById(R.id.textViewResult);
                    if(id == R.id.radioButton1){
                        bmi1=18.5;
                        weight1= (double)bmi1*height*height/703;
                        weight1 = Math.round(weight1*100)/100.0;
                        Context context = getApplicationContext();
                        CharSequence text = getResources().getString(R.string.weightCalculated).trim();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        tv.setText(getResources().getString(R.string.resultBelow)+" "+ weight1+" lb ");
                    }else if(id == R.id.radioButton2){
                        bmi1=18.5;
                        bmi2=24.9;
                        weight1= (double)bmi1*height*height/703;
                        weight2= (double)bmi2*height*height/703;
                        weight1 = Math.round(weight1*100)/100.0;
                        weight2 = Math.round(weight2*100)/100.0;
                        Context context = getApplicationContext();
                        CharSequence text = getResources().getString(R.string.weightCalculated).trim();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        tv.setText(getResources().getString(R.string.resultInBetween)+" "+ weight1+" to "+weight2+" lb ");

                    }else if(id == R.id.radioButton3){
                        bmi1=24.9;
                        bmi2=29.9;
                        weight1= (double)bmi1*height*height/703;
                        weight2= (double)bmi2*height*height/703;
                        weight1 = Math.round(weight1*100)/100.0;
                        weight2 = Math.round(weight2*100)/100.0;
                        Context context = getApplicationContext();
                        CharSequence text = getResources().getString(R.string.weightCalculated).trim();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        tv.setText(getResources().getString(R.string.resultInBetween)+" "+weight1+" to "+weight2+" lb");
                    }else if(id == R.id.radioButton4) {
                        bmi1=29.9;
                        weight1= (double)bmi1*height*height/703;
                        weight1 = Math.round(weight1*100)/100.0;
                        Context context = getApplicationContext();
                        CharSequence text = getResources().getString(R.string.weightCalculated).trim();
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        tv.setText(getResources().getString(R.string.resultAbove)+" "+weight1+" lb ");

                    }
                }
            }
        });

    }
}
