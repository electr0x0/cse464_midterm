package com.electro.midcalcproject;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    EditText resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputText = findViewById(R.id.display);
        resultText = findViewById(R.id.result);
    }

    public void clearAll(View view) {
        inputText.getText().clear();
        resultText.getText().clear();
    }

    public void appendFirstBracket(View view) {
        inputText.append("(");
    }

    public void appendFirstBracketClose(View view) {
        inputText.append(")");
    }

    public void appendPercent(View view) {
        inputText.append("%");
    }

    public void appendSeven(View view) {
        inputText.append("7");
    }

    public void appendEight(View view) {
        inputText.append("8");
    }

    public void appendNine(View view) {
        inputText.append("9");
    }

    public void appendDivide(View view) {
        inputText.append("/");
    }

    public void appendFour(View view) {
        inputText.append("4");
    }

    public void appendFive(View view) {
        inputText.append("5");
    }

    public void appendSix(View view) {
        inputText.append("6");
    }

    public void appendMultiply(View view) {
        inputText.append("*");
    }

    public void appendOne(View view) {
        inputText.append("1");
    }

    public void appendTwo(View view) {
        inputText.append("2");
    }

    public void appendThree(View view) {
        inputText.append("3");
    }

    public void appendSubtract(View view) {
        inputText.append("-");
    }

    public void appendZero(View view) {
        inputText.append("0");
    }

    public void clearSingle(View view) {
        String currentText = (String) inputText.getText().toString();

        if (!currentText.isEmpty()) {
            String clearedText = currentText.substring(0, currentText.length()-1);

            inputText.setText(clearedText);
        } else {
            Toast.makeText(this, "Please input numbers before trying to clear", Toast.LENGTH_SHORT).show();
        }
    }

    public void calcResult(View view) {
        String currentResult = resultText.getText().toString();

        if (!currentResult.isEmpty()){
            inputText.setText(currentResult);
            resultText.getText().clear();
            return;
        }

        String expression = inputText.getText().toString();

        try {
                Expression e = new ExpressionBuilder(expression).build();
                double result = e.evaluate();

                System.out.println(result);

                resultText.setText(String.valueOf(result));

                inputText.getText().clear();
        } catch (Exception e) {
                String error = e.getMessage();
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
            }
        }

    public void appendAddition(View view) {
        inputText.append("+");
    }
}