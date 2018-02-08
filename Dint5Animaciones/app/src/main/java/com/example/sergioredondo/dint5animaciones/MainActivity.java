package com.example.sergioredondo.dint5animaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityEvents events;
    Button btn1, btn2;
    TextView textView;
    Animation rotation, translate, alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events= new MainActivityEvents(this);

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(events);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(events);
        textView = findViewById(R.id.textView);

        rotation = AnimationUtils.loadAnimation(this,R.anim.transition1);
       // btn1.setAnimation(rotation);
        translate = AnimationUtils.loadAnimation(this,R.anim.transition2);
        //btn2.setAnimation(translate);
        alpha = AnimationUtils.loadAnimation(this,R.anim.transition3);
        //textView.setAnimation(alpha);
    }

}


class MainActivityEvents implements View.OnClickListener{
    MainActivity mainActivity;

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn1){
            mainActivity.btn1.startAnimation(mainActivity.rotation);
            Log.v("boton","btn1");
        }else if (view.getId() == R.id.btn2){
            Log.v("boton","btn2");

            mainActivity.btn2.startAnimation(mainActivity.translate);
            mainActivity.textView.startAnimation(mainActivity.alpha);
        }
    }
}
