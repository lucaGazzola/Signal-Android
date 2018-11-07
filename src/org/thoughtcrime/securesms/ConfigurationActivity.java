package org.thoughtcrime.securesms;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class ConfigurationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);



        SharedPreferences prefs = getSharedPreferences("preference_category_appearance", MODE_PRIVATE);
        Map<String, ?> allEntries = prefs.getAll();

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue().toString());
            sb.append("\n");
        }

        TextView tv = findViewById(R.id.textView);

        tv.setText(sb.toString());
    }
}
