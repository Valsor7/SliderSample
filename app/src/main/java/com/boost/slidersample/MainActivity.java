package com.boost.slidersample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initClickOnView(R.id.btn_zoom_slider, SliderActivity.class);
        initClickOnView(R.id.btn_3d_slider, Slider3DActivity.class);
    }

    private void initClickOnView(int id, final Class clazz){
        findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, clazz));
            }
        });
    }


}
