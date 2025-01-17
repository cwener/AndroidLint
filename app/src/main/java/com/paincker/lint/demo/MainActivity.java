package com.paincker.lint.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_origin);

        Toast.makeText(this, "toast", Toast.LENGTH_SHORT);

        callNewApi();

        Log.d("tag", "msg");
        String.format("{\"code\":%d, \"lat\":%f, \"lon\":%f}", 200, 1.0f, 1.0f);
        String.format(getString(R.string.app_name), 20);
        "tmp1".equals("tmp2");
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).run();
    }

    private void callNewApi() {
        new View(this).setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

            }
        });
    }
}
