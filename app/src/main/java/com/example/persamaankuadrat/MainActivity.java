package com.example.persamaankuadrat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText a, b, c;
    Button hitung;
    TextView hasil1, hasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (EditText)findViewById(R.id.a);
        b = (EditText)findViewById(R.id.b);
        c = (EditText)findViewById(R.id.c);

        hitung = (Button)findViewById(R.id.button);
        hasil1 = (TextView)findViewById(R.id.txt_hasil1);
        hasil2 = (TextView)findViewById(R.id.txt_hasil2);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a.length() == 0 && b.length()== 0 && c.length()==0){
                    Toast.makeText(getApplication(), "A B dan C Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(a.length() == 0 && b.length()==0){
                    Toast.makeText(getApplication(), "A dan B Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(b.length() == 0 && c.length() == 0){
                    Toast.makeText(getApplication(), "B dan C Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(a.length() == 0 && c.length() == 0){
                    Toast.makeText(getApplication(), "A dan C Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(a.length() == 0){
                    Toast.makeText(getApplication(), "A Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(b.length() == 0){
                    Toast.makeText(getApplication(), "B Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else if(c.length() == 0){
                    Toast.makeText(getApplication(), "C Tidak Boleh Kosong", Toast.LENGTH_LONG).show();
                }
                else {
                    String isiA = a.getText().toString();
                    String isiB = b.getText().toString();
                    String isiC = c.getText().toString();

                    double a = Double.parseDouble(isiA);
                    double b = Double.parseDouble(isiB);
                    double c = Double.parseDouble(isiC);

                    double result1 = AbcPlus(a, b, c);
                    double result2 = AbcMinus(a, b, c);

                    String output1 = String.valueOf(result1);
                    hasil1.setText(output1.toString());

                    String output2 = String.valueOf(result2);
                    hasil2.setText(output2.toString());
                }
            }
        });
    }
    public double AbcPlus(double a, double b, double c){
        double d = Math.sqrt((b*b)-(4*a*c));

        double rest = -((b+d)/(2*a));

        return rest;
    }

    public double AbcMinus(double a, double b, double c){
        double d = Math.sqrt((b*b) - (4 * a * c));

        double rest = -((b-d)/(2*a));

        return rest;
    }
}