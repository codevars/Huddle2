package com.srmvdp.huddle.Extras;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.srmvdp.huddle.LocalStorage.SessionManagement;
import com.srmvdp.huddle.LoginRegisterTabbed;

public class Splash extends AppCompatActivity {

    private SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        session = new SessionManagement(getApplicationContext());


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!session.phoneIn() & !session.otpIn() & !session.dashboardIn()) {

                    Intent go = new Intent(Splash.this, LoginRegisterTabbed.class);

                    finish();

                    startActivity(go);

                } else {

                    session.phone();

                    session.otp();

                    session.dashboard();

                }
            }
        }, 5 * 1000);

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();


    }
}

