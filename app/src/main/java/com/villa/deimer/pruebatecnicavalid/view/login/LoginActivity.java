package com.villa.deimer.pruebatecnicavalid.view.login;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.villa.deimer.pruebatecnicavalid.R;
import com.villa.deimer.pruebatecnicavalid.presenter.login.database.LoginDatabasePresenter;
import com.villa.deimer.pruebatecnicavalid.presenter.login.database.LoginDatabasePresenterImpl;
import com.villa.deimer.pruebatecnicavalid.view.timeline.TimelineActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginDatabaseInterface {

    private Context context;
    private LoginDatabasePresenter loginDatabasePresenter;
    @BindView(R.id.lbl_title)
    TextView lblTitle;
    @BindView(R.id.lbl_subtitle)
    TextView lblSubtitle;
    @BindView(R.id.card_credentials)
    CardView cardCredentials;
    @BindView(R.id.txt_email)
    EditText txtEmail;
    @BindView(R.id.txt_password)
    EditText txtPassword;
    @BindView(R.id.fab_login)
    FloatingActionButton fabLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setupActivity();
    }

    private void setupActivity() {
        context = this;
        loginDatabasePresenter = new LoginDatabasePresenterImpl(context, this);
        animateLabels();
    }

    private void animateLabels() {
        YoYo.with(Techniques.FadeInRight)
                .duration(1300)
                .onEnd(new animatorCardviewCallback())
                .playOn(lblTitle);
        lblTitle.setVisibility(View.VISIBLE);
        YoYo.with(Techniques.FadeInRight)
                .duration(1300)
                .playOn(lblSubtitle);
        lblSubtitle.setVisibility(View.VISIBLE);
    }

    private class animatorCardviewCallback implements YoYo.AnimatorCallback {
        @Override
        public void call(Animator animator) {
            YoYo.with(Techniques.FadeInLeft)
                    .duration(1300)
                    .onEnd(new animatorFabCallback())
                    .playOn(cardCredentials);
            cardCredentials.setVisibility(View.VISIBLE);
        }
    }

    private class animatorFabCallback implements YoYo.AnimatorCallback {
        @SuppressLint("RestrictedApi")
        @Override
        public void call(Animator animator) {
            YoYo.with(Techniques.FadeInUp)
                    .duration(1300)
                    .playOn(fabLogin);
            fabLogin.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.fab_login)
    public void clickButLogin() {
        login();
    }

    private void login() {
        String username = txtEmail.getText().toString().trim();
        String password = txtPassword.getText().toString().trim();
        if(username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
            Toast.makeText(context, "Antes de avanzar, debe agregar sus credenciales", Toast.LENGTH_LONG).show();
        } else {
            loginDatabasePresenter.login(username, password);
        }
    }

    @Override
    public void resultLogin(boolean result, String message) {
        if(result) {
            openTimeline();
        } else {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    private void openTimeline() {
        startActivity(new Intent(context, TimelineActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    @Override
    public void resultLogout(boolean result) {}

}
