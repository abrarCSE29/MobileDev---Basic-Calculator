package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Button0 = findViewById(R.id.num0);
        Button Button1 = findViewById(R.id.num1);
        Button Button2 = findViewById(R.id.num2);
        Button Button3 = findViewById(R.id.num3);
        Button Button4 = findViewById(R.id.num4);
        Button Button5 = findViewById(R.id.num5);
        Button Button6 = findViewById(R.id.num6);
        Button Button7 = findViewById(R.id.num7);
        Button Button8 = findViewById(R.id.num8);
        Button Button9 = findViewById(R.id.num9);
        Button ButtonPlus = findViewById(R.id.add);
        Button ButtonMinus = findViewById(R.id.min);
        Button ButtonDiv = findViewById(R.id.div);
        Button ButtonMultiplication = findViewById(R.id.mul);
        Button ButtonEqual = findViewById(R.id.equal);
        Button ButtonOn = findViewById(R.id.on);
        Button ButtonOff = findViewById(R.id.off);
        Button ButtonAc = findViewById(R.id.ac);
        Button ButtonDel = findViewById(R.id.del);
        Button ButtonDot = findViewById(R.id.dot);


        TextView screen = findViewById(R.id.screen);

        ButtonOff.setOnClickListener(view->screen.setVisibility(View.GONE));
        ButtonOn.setOnClickListener(view->{
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        ButtonAc.setOnClickListener(view->{
            screen.setText("0");
            firstNum=0;
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(Button0);
        nums.add(Button1);
        nums.add(Button2);
        nums.add(Button3);
        nums.add(Button4);
        nums.add(Button5);
        nums.add(Button6);
        nums.add(Button7);
        nums.add(Button8);
        nums.add(Button9);

        for (Button b : nums){
            b.setOnClickListener(view-> {
                if(!screen.getText().toString().equals("0")){
                    screen.setText(String.format("%s%s", screen.getText().toString(), b.getText().toString()));
                }else{
                    screen.setText(b.getText().toString());
                }
            });

        }

        ArrayList<Button> opers = new ArrayList<>();

        opers.add(ButtonPlus);
        opers.add(ButtonMinus);
        opers.add(ButtonDiv);
        opers.add(ButtonMultiplication);

        for (Button b : opers){
            b.setOnClickListener(view->{
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        ButtonDel.setOnClickListener(view->{
            String num = screen.getText().toString();

            if(num.length()>1){
                screen.setText(num.substring(0,num.length()-1));

            }else if(num.length()==1){
                screen.setText("0");
            }
        });

        ButtonDot.setOnClickListener(view->{
            if(!screen.getText().toString().contains(".")){
                screen.setText(String.format("%s.", screen.getText().toString()));
            }
        });

        ButtonEqual.setOnClickListener(view->{
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result = 0;
            switch(operation){
                case "/" :
                    result=firstNum/secondNum;
                    break;
                case "*":
                    result=firstNum*secondNum;
                    break;
                case "+":
                    result=firstNum+secondNum;
                    break;
                case "-":
                    result=firstNum-secondNum;
                    break;
                default:
                    break;
            }
            screen.setText(String.valueOf(result));
            firstNum=result;
        });

    }
}