package com.example.parulchopra.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView t1,t2,t3,t4;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.T1);
        t2 = (TextView) findViewById(R.id.T2);
        t3 = (TextView) findViewById(R.id.T3);
        t3 = (TextView) findViewById(R.id.T4);
        b1 = (Button)findViewById(R.id.b1);



        ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(t1, "alpha", 0.2f);
        fadeAnim.start();



        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(t2, "scaleX", 1.0f, 2.0f);
        scaleAnim.setDuration(3000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnim.start();
     b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(b1, View.ALPHA, 0,1);
        fadeAltAnim.setDuration(3000);
        fadeAltAnim.start();
    }
});
        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(t4, "Y", 1000);
        moveAnim.setDuration(2000);
        moveAnim.setInterpolator(new BounceInterpolator());
        moveAnim.setRepeatCount(ValueAnimator.INFINITE);
        moveAnim.start();

    }

}
