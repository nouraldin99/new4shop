package com.noura.anwar.new4shop.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;

import com.noura.anwar.new4shop.MainActivity;
import com.noura.anwar.new4shop.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Timer;

public class Splah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);



        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    startActivity(new Intent(Splah.this, MainActivity.class));
                    finish();
                } catch (Exception e) {
                    Log.d("DDDD", "Ex " + e.getLocalizedMessage());
                }
            }
        }).start();







    }

    public static void getHash(Activity mActivity) {
        PackageInfo info;
        try {
            info = mActivity.getPackageManager().getPackageInfo("com.noura.anwar.new4shop", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.d("hashKey", something);
             //   Log.e("packageName", .getInstance().getPackageName());
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }
}
