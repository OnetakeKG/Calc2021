package net.nov.calc2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mul;
    private Button div;
    private Button sub;
    private Button equal;
    private Button degree;
    private Button percent;
    private Button clear;
    double ans = 0;
    double arg1, arg2; // в будущем - аргументы введенные пользователем в EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button add = findViewById(R.id.key_add);
        mul = findViewById(R.id.key_mul);
        div = findViewById(R.id.key_div);
        sub = findViewById(R.id.key_sub);
        degree = findViewById(R.id.key_degree);
        percent = findViewById(R.id.key_percent);

        equal = findViewById(R.id.key_equal);
        clear = findViewById(R.id.key_clear);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = arg1;
                double b = arg2;
                ans = a + b;
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = arg1;
                double b = arg2;
                ans = a - b;
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = arg1;
                double b = arg2;
                ans = a * b;
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = arg1;
                double b = arg2;
                ans = a / b;
            }
        });

        degree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = arg1;
                double b = arg2;
                double result = 1.0;
                for (int i = 1; i <= arg2; i++) {
                    result = result * arg1;
                    ans = result;
                }
            }
        });

        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = arg1;
                double b = arg2;
                ans = a * b / 100;
            }
        });



        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




    }

}
