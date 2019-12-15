package com.example.fraction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPlus = findViewById(R.id.button);
        Button btnequals = findViewById(R.id.button2);
        Button btnMinus = findViewById(R.id.button3);
        Button btnMulus = findViewById(R.id.button4);
        Button btnDivide = findViewById(R.id.button5);


        btnPlus.setText("+");
        btnMinus.setText("-");
        btnMulus.setText("*");
        btnDivide.setText(":");

        String btnText = String.valueOf(btnPlus.getText());
        System.out.println(btnText);
        EditText edTxtFrac1Num = findViewById(R.id.editText);
        EditText edTxtFrac1Den = findViewById(R.id.editText2);
        EditText edTxtFrac2Num = findViewById(R.id.editText4);
        EditText edTxtFrac2Den = findViewById(R.id.editText5);
        EditText edTxtOperation = findViewById(R.id.editText3);

        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 2);

        edTxtFrac1Den.setText(String.valueOf(fraction1.getDenominator()));
        edTxtFrac1Num.setText(String.valueOf(fraction1.getNumerator()));
        edTxtFrac2Num.setText(String.valueOf(fraction2.getNumerator()));
        edTxtFrac2Den.setText(String.valueOf(fraction2.getDenominator()));

    }

    public void onClick(View view) {
        Button b = (Button) view;
        EditText edTxtOperation = findViewById(R.id.editText3);
        String buttonText = b.getText().toString();

        System.out.println(buttonText + " ");
        if (buttonText.equalsIgnoreCase("=")) {

            EditText edTxtFrac1Num = findViewById(R.id.editText);
            EditText edTxtFrac1Den = findViewById(R.id.editText2);
            EditText edTxtFrac2Num = findViewById(R.id.editText4);
            EditText edTxtFrac2Den = findViewById(R.id.editText5);
            EditText edTxtResultNum = findViewById(R.id.editText6);
            EditText edTxtResultDen = findViewById(R.id.editText7);

            Fraction fraction1 = new Fraction(Integer.valueOf(String.valueOf(edTxtFrac1Num.getText())),
                    Integer.valueOf(String.valueOf(edTxtFrac1Den.getText())));
            Fraction fraction2 = new Fraction(Integer.valueOf(String.valueOf(edTxtFrac2Num.getText())),
                    Integer.valueOf(String.valueOf(edTxtFrac2Den.getText())));

            Calculator calc = new Calculator();

            switch (edTxtOperation.getText().toString()) {
                case "+":
                    Fraction fractionResult = calc.addFraction(fraction1, fraction2);
                    edTxtResultNum.setText(String.valueOf(fractionResult.getNumerator()));
                    edTxtResultDen.setText(String.valueOf(fractionResult.getDenominator()));
                    break;

            }


        }
    }
}