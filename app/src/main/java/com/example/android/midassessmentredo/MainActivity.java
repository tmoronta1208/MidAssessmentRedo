package com.example.android.midassessmentredo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    Button button1;
    Button button2;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREFS_KEY = "address_shared_preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                String stringInput = editText.getText().toString();
                editor.putString(stringInput, stringInput);
                editor.apply();
                editText.setText("");


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("sharedpref", SHARED_PREFS_KEY);
                startActivity(intent);


            }
        });


    }
}
