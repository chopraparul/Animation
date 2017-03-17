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
TextView t1,t2,t3,t4,t5,t6;

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.T1);
        t2 = (TextView) findViewById(R.id.T2);
        t3 = (TextView) findViewById(R.id.T3);
        t4 = (TextView) findViewById(R.id.T4);
        t5 = (TextView) findViewById(R.id.T5);
        t6 = (TextView) findViewById(R.id.T6);

        b1 = (Button)findViewById(R.id.b1);

        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(t4, "Y", 1000);
        moveAnim.setDuration(2000);
        moveAnim.setRepeatCount(ValueAnimator.INFINITE);
        moveAnim.setRepeatMode(ValueAnimator.REVERSE);
        moveAnim.setInterpolator(new BounceInterpolator());
        moveAnim.start();

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

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(t3, "scaleX", 1.0f, 2.0f)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(t3, "scaleY", 1.0f, 2.0f)
                        .setDuration(2000),
                ObjectAnimator.ofObject(t3, "backgroundColor", new ArgbEvaluator(),
          /*Red*/0xFFFF8080, /*Blue*/0xFF8080FF)
                        .setDuration(2000)
        );
        set.start();

// Define first set of animations
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(t5, "scaleX", 2.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(t5, "scaleY", 2.0f);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(anim1, anim2);
// Define second set of animations
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(t6, "X", 300);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(t6, "Y", 300);
        AnimatorSet set2 = new AnimatorSet();
        set2.playTogether(anim3, anim4);
// Play the animation sets one after another
        AnimatorSet set3 = new AnimatorSet();
        set3.playSequentially(set1, set2);
        set3.start();
    }

}
