package com.freeoda.franktirkey.smfes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.icu.util.VersionInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reg,login;
    TextView verDetail,appTitle;
    EditText usrnm,pass;

    String version;

    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appTitle = findViewById(R.id.appTitle);

        usrnm = findViewById(R.id.usrnm);
        pass = findViewById(R.id.pass);

        reg = findViewById(R.id.reg);
        login = findViewById(R.id.login);
        verDetail = findViewById(R.id.verDetail);

        version = BuildConfig.VERSION_NAME;
        verDetail.setText("Version: "+version+" ");

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        usrnm.startAnimation(animation);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        animation2.setDuration(1500);
        pass.startAnimation(animation2);

//        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
//        reg.startAnimation(animation);
//        login.startAnimation(animation);

        reg.animate().translationY(0).alphaBy(1).setDuration(1800);
        login.animate().translationY(0).alphaBy(1).setDuration(1500);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sample_animation);
        verDetail.startAnimation(animation);

        //AppTitle Animation

//            appTitle.animate()
//                    .alpha(5)
//                    .setDuration(5000)
//                    .scaleXBy(1)
//                    .scaleYBy(1)
//                    .translationX(5)
//                    .setListener(new Animator.AnimatorListener() {
//                        @Override
//                        public void onAnimationStart(Animator animator) {
//                            Toast.makeText(MainActivity.this,"Here animation starts",Toast.LENGTH_SHORT);
//                        }
//
//                        @Override
//                        public void onAnimationEnd(Animator animator) {
//
//                            usrnm.animate()
//                                    .alpha(1)
//                                    .setDuration(500)
//                                    .setListener(new Animator.AnimatorListener() {
//                                        @Override
//                                        public void onAnimationStart(Animator animator) {
//
//                                        }
//
//                                        @Override
//                                        public void onAnimationEnd(Animator animator) {
//                                            pass.animate()
//                                                    .alpha(1)
//                                                    .setDuration(500)
//                                                    .setListener(new Animator.AnimatorListener() {
//                                                        @Override
//                                                        public void onAnimationStart(Animator animator) {
//
//                                                        }
//
//                                                        @Override
//                                                        public void onAnimationEnd(Animator animator) {
//
//                                                            verDetail.animate()
//                                                                    .alpha(1)
//                                                                    .setDuration(500)
//                                                                    .setListener(new Animator.AnimatorListener() {
//                                                                        @Override
//                                                                        public void onAnimationStart(Animator animator) {
//                                                                            reg.animate()
//                                                                                    .alpha(1)
//                                                                                    .setDuration(500)
//                                                                                    .setListener(new Animator.AnimatorListener() {
//                                                                                        @Override
//                                                                                        public void onAnimationStart(Animator animator) {
//                                                                                            login.animate()
//                                                                                                    .alpha(1)
//                                                                                                    .setDuration(500);
//                                                                                        }
//
//                                                                                        @Override
//                                                                                        public void onAnimationEnd(Animator animator) {
//
//                                                                                        }
//
//                                                                                        @Override
//                                                                                        public void onAnimationCancel(Animator animator) {
//
//                                                                                        }
//
//                                                                                        @Override
//                                                                                        public void onAnimationRepeat(Animator animator) {
//
//                                                                                        }
//                                                                                    });
//                                                                        }
//
//                                                                        @Override
//                                                                        public void onAnimationEnd(Animator animator) {
//
//                                                                        }
//
//                                                                        @Override
//                                                                        public void onAnimationCancel(Animator animator) {
//
//                                                                        }
//
//                                                                        @Override
//                                                                        public void onAnimationRepeat(Animator animator) {
//
//                                                                        }
//                                                                    });
//                                                        }
//
//                                                        @Override
//                                                        public void onAnimationCancel(Animator animator) {
//
//                                                        }
//
//                                                        @Override
//                                                        public void onAnimationRepeat(Animator animator) {
//
//                                                        }
//                                                    });
//                                        }
//
//                                        @Override
//                                        public void onAnimationCancel(Animator animator) {
//
//                                        }
//
//                                        @Override
//                                        public void onAnimationRepeat(Animator animator) {
//
//                                        }
//                                    });
//                        }
//
//                        @Override
//                        public void onAnimationCancel(Animator animator) {
//
//                        }
//
//                        @Override
//                        public void onAnimationRepeat(Animator animator) {
//
//                        }
//                    });

        //Animation Ends here

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                R.color.colorMainActivity));

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Registration.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.loading);
                verDetail.startAnimation(animation);
                verDetail.setText("loading...");

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}
