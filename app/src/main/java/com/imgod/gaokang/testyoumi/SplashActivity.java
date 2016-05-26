package com.imgod.gaokang.testyoumi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import net.youmi.android.AdManager;
import net.youmi.android.spot.SplashView;
import net.youmi.android.spot.SpotDialogListener;
import net.youmi.android.spot.SpotManager;

public class SplashActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    public static final String appid = "80027ed2399f8610";
    public static final String appsecret = "a1fd3415b1bddf6c";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        initSdk();

    }

    private void initSdk() {
        AdManager.getInstance(SplashActivity.this).init(appid, appsecret, true);
        SpotManager.getInstance(SplashActivity.this).loadSpotAds();
        SpotManager.getInstance(SplashActivity.this).showSplashSpotAds(SplashActivity.this, null);

        final SplashView splashView = new SplashView(SplashActivity.this, MainActivity.class);

        SpotManager.getInstance(SplashActivity.this).showSplashSpotAds(SplashActivity.this,
                splashView, new SpotDialogListener() {
                    @Override
                    public void onShowSuccess() {
                        Log.e("splash", "广告显示结果:onShowSuccess");
                    }

                    @Override
                    public void onShowFailed() {
                        Log.e("splash", "广告显示结果:onShowFailed");
//                        setContentView(R.layout.activity_splash);
                        splashView.getSplashView().setVisibility(View.GONE);
                    }

                    @Override
                    public void onSpotClosed() {
                        Log.e("splash", "广告显示结果:onSpotClosed");
                    }

                    @Override
                    public void onSpotClick(boolean b) {
                        Log.e("splash", "广告显示结果:onSpotClick");
                    }
                });

        splashView.hideCloseBtn(false);
        frameLayout.addView(splashView.getSplashView());
    }
}
