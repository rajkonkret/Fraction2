package com.raj.fraction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        String bOperationText = edTxtOperation.getText().toString();

        if (buttonText.equalsIgnoreCase("-")) {
            edTxtOperation.setText("-");
        }
        if (buttonText.equalsIgnoreCase("+")) {
            edTxtOperation.setText("+");
        }
        if (buttonText.equalsIgnoreCase("*")) {
            edTxtOperation.setText("*");
        }
        if (buttonText.equalsIgnoreCase(":")) {
            edTxtOperation.setText(":");
        }


        //System.out.println(buttonText + " ");
        if (buttonText.equalsIgnoreCase("=")) {

            EditText edTxtFrac1Num = findViewById(R.id.editText);
            EditText edTxtFrac1Den = findViewById(R.id.editText2);
            EditText edTxtFrac2Num = findViewById(R.id.editText4);
            EditText edTxtFrac2Den = findViewById(R.id.editText5);
            EditText edTxtResultNum = findViewById(R.id.editText6);
            EditText edTxtResultDen = findViewById(R.id.editText7);
            EditText edTxtResultNumShort = findViewById(R.id.editText8);
            EditText edTxtResultDenShort = findViewById(R.id.editText9);

            Fraction fraction1 = new Fraction(Integer.valueOf(String.valueOf(edTxtFrac1Num.getText())),
                    Integer.valueOf(String.valueOf(edTxtFrac1Den.getText())));
            Fraction fraction2 = new Fraction(Integer.valueOf(String.valueOf(edTxtFrac2Num.getText())),
                    Integer.valueOf(String.valueOf(edTxtFrac2Den.getText())));

            Calculator calc = new Calculator();
            Fraction fractionR = new Fraction(Integer.valueOf(String.valueOf(edTxtFrac1Num.getText())),
                    Integer.valueOf(String.valueOf(edTxtFrac1Den.getText())));
            switch (bOperationText) {
                case "+":
                    // Fraction fractionResult = calc.addFraction(fraction1, fraction2);
                    fractionR = calc.addFraction(fraction1, fraction2);
                    // edTxtResultNum.setText(String.valueOf(fractionResult.getNumerator()));
                    //   edTxtResultDen.setText(String.valueOf(fractionResult.getDenominator()));
                    break;
                case "-":
                    // Fraction fractionResultMinus = calc.subFraction(fraction1, fraction2);
                    fractionR = calc.subFraction(fraction1, fraction2);
                    //   edTxtResultNum.setText(String.valueOf(fractionResultMinus.getNumerator()));
                    ///   edTxtResultDen.setText(String.valueOf(fractionResultMinus.getDenominator()));
                    break;
                case "*":
                    //  Fraction fractionResultMu = calc.mulFraction(fraction1, fraction2);
                    fractionR = calc.mulFraction(fraction1, fraction2);
                    //  edTxtResultNum.setText(String.valueOf(fractionResultMu.getNumerator()));
                    //   edTxtResultDen.setText(String.valueOf(fractionResultMu.getDenominator()));
                    break;
                case ":":
                    //   Fraction fractionResultD = calc.divFraction(fraction1, fraction2);
                    fractionR = calc.divFraction(fraction1, fraction2);
                    //    edTxtResultNum.setText(String.valueOf(fractionResultD.getNumerator()));
                    //     edTxtResultDen.setText(String.valueOf(fractionResultD.getDenominator()));
                    break;
            }
            edTxtResultNum.setText(String.valueOf(fractionR.getNumerator()));
            edTxtResultDen.setText(String.valueOf(fractionR.getDenominator()));
            fractionR = calc.shorter(fractionR);
            edTxtResultNumShort.setText(String.valueOf(fractionR.getNumerator()));
            edTxtResultDenShort.setText(String.valueOf(fractionR.getDenominator()));

            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            }

        }
    }
}