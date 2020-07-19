package com.noura.anwar.new4shop.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.login.Login;
import com.noura.anwar.new4shop.MainActivity;
import com.noura.anwar.new4shop.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LogAndSignButtum extends AppCompatActivity {
        @BindView(R.id.log_button) Button login;
        @BindView(R.id.sign_button) Button signUp;
        @OnClick(R.id.log_button)void setLogin() {
            startActivity(new Intent(LogAndSignButtum.this, LoginActivity.class));

        }
 @OnClick(R.id.sign_button)void setsign(){
            startActivity(new Intent(LogAndSignButtum.this,SignUpActivity.class));
    }


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_and_sign_buttum);
            ButterKnife.bind(this);

    }
}
