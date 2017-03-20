package com.arcticwind.myapplication;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

public class LvSeekBarActivity extends AppCompatActivity{

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_seek_bar);
        mListView = (ListView) findViewById(R.id.lv_seek_bar);
        mListView.setAdapter(new MyAdapter());
    }

    private class MyAdapter extends BaseAdapter {

        private SeekBar seek;

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = LayoutInflater.from(LvSeekBarActivity.this).inflate(R.layout.item,null);
            }
            seek = (SeekBar) convertView.findViewById(R.id.seek);
            seek.setThumb(new BitmapDrawable(getResources(), ZoomBitmap.zoomImage(BitmapFactory
                    .decodeResource(getResources(), R.drawable.seek_bar_point),50,50)));
            return convertView;
        }
    }
}
