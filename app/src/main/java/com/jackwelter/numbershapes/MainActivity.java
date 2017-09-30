package com.jackwelter.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkNumber(View view){
        EditText numberEditText = (EditText) findViewById(R.id.numberEditText);
        String numStr = numberEditText.getText().toString();
        long num;
        try {
            num = (long) Long.parseLong(numStr);
        }
        catch (Throwable e){
            Toast.makeText(this, "Please enter a number!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (isPerfectSquare(num) && isPerfectSquare(8*num+1)){
            Toast.makeText(this, numStr + " is both a triangular and square number", Toast.LENGTH_SHORT).show();
        }else if (isPerfectSquare(num)){
            Toast.makeText(this, numStr + " is a square number", Toast.LENGTH_SHORT).show();
        }else if (isPerfectSquare(8*num+1)){
            Toast.makeText(this, numStr + " is a triangular number", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, numStr + " is neither triangular or square", Toast.LENGTH_SHORT).show();
        }
        numberEditText.setText("");
    }

    public boolean isPerfectSquare(long n){
        if(n <= 0){
            return false;
        }
        long tst = (long) Math.sqrt(n);
        return tst*tst == n;
    }
}
