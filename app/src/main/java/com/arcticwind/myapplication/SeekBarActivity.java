package com.arcticwind.myapplication;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.SeekBar;

/**
 * Created by MyPC on 2017/3/14/0014.
 */
public class SeekBarActivity extends Activity{

    private SeekBar mSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        mSeekBar = (SeekBar) findViewById(R.id.sb);

        mSeekBar.setThumb(new BitmapDrawable(getResources(), ZoomBitmap.zoomImage(BitmapFactory
                        .decodeResource(getResources(), R.drawable.seek_bar_point),50,50)));
    }
}
