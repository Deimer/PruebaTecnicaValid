package com.villa.deimer.pruebatecnicavalid.view.welcome;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.presenter.welcome.database.WelcomeDatabasePresenter;
import com.villa.deimer.pruebatecnicavalid.presenter.welcome.database.WelcomeDatabasePresenterImpl;
import com.villa.deimer.pruebatecnicavalid.view.login.LoginActivity;
import com.villa.deimer.pruebatecnicavalid.view.timeline.TimelineActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity implements WelcomeDatabaseInterface {

    private Context context;
    private boolean isLogged;
    private WelcomeDatabasePresenter welcomeDatabasePresenter;

    @BindView(R.id.img_logo)
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        welcomeDatabasePresenter = new WelcomeDatabasePresenterImpl(context, this);
        setupValidationLogin();
    }

    private void setupValidationLogin() {
        welcomeDatabasePresenter.isLogged();
    }

    @Override
    public void resultIsLogged(boolean result) {
        isLogged = result;
        setupTimeAnimation();
    }

    private void setupTimeAnimation() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                animateLogo();
            }
        }, 1000);
    }

    private void animateLogo() {
        YoYo.with(Techniques.Pulse)
                .duration(900)
                .repeat(0)
                .onEnd(new animatorCallback())
                .playOn(imgLogo);
    }

    private class animatorCallback implements YoYo.AnimatorCallback {
        @Override
        public void call(Animator animator) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    decideNext();
                }
            }, 1300);
        }
    }

    private void decideNext() {
        if(isLogged) {
            startActivity(new Intent(context, TimelineActivity.class));
        } else {
            startActivity(new Intent(context, LoginActivity.class));
        }
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

}
