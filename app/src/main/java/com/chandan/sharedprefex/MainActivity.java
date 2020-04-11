package com.chandan.sharedprefex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private EditText enterText;
    private Button b1,b2;
    private TextView result;
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME="myprefFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterText = findViewById(R.id.editText2);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        result = findViewById(R.id.tv);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPrefs = getSharedPreferences(PREFS_NAME,0);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("message",enterText.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"Data Saved successfully",Toast.LENGTH_LONG).show();

            }
        });

        //get data back
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cleardata();
                SharedPreferences pref = getSharedPreferences(PREFS_NAME,0);

                if(pref.contains("message")){
                    String msg = pref.getString("message","message not found");
                     result.setText("Message : " +msg);

                }
            }
        });
    }

    private void cleardata() {
        enterText.getText().clear();
    }
}
