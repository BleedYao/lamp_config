package com.arcticwind.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity1";
    private Button mSeekbar;
    private Button mRcSeekbar;
    private Button mLvSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSeekbar = (Button) findViewById(R.id.btn_seekbar);
        mRcSeekbar = (Button) findViewById(R.id.btn_rcseekbar);
        mLvSeekbar = (Button) findViewById(R.id.btn_lvseekbar);

        mSeekbar.setOnClickListener(this);
        mRcSeekbar.setOnClickListener(this);
        mLvSeekbar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_seekbar:
                intent = new Intent(this, SeekBarActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_lvseekbar:
                intent = new Intent(MainActivity.this, LvSeekBarActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_rcseekbar:
                intent = new Intent(MainActivity.this, RcSeekBarActivity.class);
                startActivity(intent);
                break;
        }
    }
}
