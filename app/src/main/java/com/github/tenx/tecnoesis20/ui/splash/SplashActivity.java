package com.github.tenx.tecnoesis20.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import com.github.tenx.tecnoesis20.R;
import com.github.tenx.tecnoesis20.ui.main.MainActivity;
import com.google.android.material.button.MaterialButton;
import com.victor.loading.newton.NewtonCradleLoading;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.act_splash_mbtn_next)
    MaterialButton mbtnNext;

    @BindView(R.id.act_splash_progress)
    NewtonCradleLoading progress;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        mbtnNext.setOnClickListener(v -> {
//            go to next screen
            showProgress();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    hideProgress();
                    startActivity(i);
                    finish();
                }
            }, 1500);
        });
    }

    public void showProgress(){
        progress.start();
        progress.setVisibility(View.VISIBLE);
        mbtnNext.setEnabled(false);
    }

    public void hideProgress()
    {   mbtnNext.setEnabled(true);
        progress.stop();
        progress.setVisibility(View.INVISIBLE);
    }
}
