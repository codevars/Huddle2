package com.srmvdp.huddle.Extras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.srmvdp.huddle.LocalStorage.SessionManagement;
import com.srmvdp.huddle.Authentication.LoginRegisterTabbed;

public class Splash extends AppCompatActivity {

    private SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        session = new SessionManagement(getApplicationContext());

        super.onCreate(savedInstanceState);

        if (!session.forgotIn() & !session.changeIn() & !session.phoneIn() & !session.otpIn() & !session.dashboardIn()) {

            Intent go = new Intent(Splash.this, LoginRegisterTabbed.class);

            startActivity(go);

            finish();

        }

        else {

            session.changepassword();

            session.forgotpassword();

            session.phone();

            session.otp();

            session.dashboard();


        }

    }

}

