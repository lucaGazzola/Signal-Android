package org.thoughtcrime.securesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.thoughtcrime.securesms.test.DelimiterUtilTest;

public class TestingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        TextView textView = findViewById(R.id.textResult);

        String data = execute();

        textView.setText(data);

    }

    private String execute(){

        String results;

        JUnitCore jUnitCore = new JUnitCore();
        Result result = jUnitCore.run(DelimiterUtilTest.class);

        results = "ran: " + result.getRunCount() + " failed: " + result.getFailureCount();

//        List<Failure> failures = result.getFailures();
//
//        if(!failures.isEmpty()) {
//            for(Failure f : failures) {
//                logger.info(f.getTrace());
//            }
//        }

        return results;

    }
}
