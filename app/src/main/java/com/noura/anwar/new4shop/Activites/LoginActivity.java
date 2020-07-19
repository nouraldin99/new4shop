package com.noura.anwar.new4shop.Activites;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.noura.anwar.new4shop.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.Arrays;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

//    private LoginButton loginButton;
//    private ImageButton fbButton;
//    private EditText emailEt, passEt ;


    @BindView(R.id.email_log_button)
    Button emailLogin;
    @BindView(R.id.fb_login_button)
    LoginButton fbLoging;
    @BindView(R.id.fb_img)
    ImageButton faceBook;
    @BindView(R.id.email_et)
    EditText email;
    @BindView(R.id.pass_et)
    EditText password;


    @OnClick(R.id.fb_img)
    void setFbLoging() {
        Log.e("Login:","click");
        fbLoging.performClick();

    }

    private CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        loginButton =
        ButterKnife.bind(this);

        callbackManager = CallbackManager.Factory.create();


        fbLoging.setReadPermissions(Arrays.asList("email", "public_profile"));

        fbLoging.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("login:",loginResult.toString());
                loadUserProfile(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.e("login:","cancel");

            }

            @Override
            public void onError(FacebookException error) {
                Log.e("login:",""+error.getMessage().toString());

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e("login:","onActivityResult");
    }

    AccessTokenTracker TokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

        }
    };

    private void loadUserProfile(AccessToken newAccessToken) {
        GraphRequest graphRequest = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                 String     first_name = object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");
                    String img_url = "https://graph.facebook.com/"+id+"/picture?type=notmal";


                    Log.e("Login: ",first_name);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("field", "first_name,last_name,email,id");
        graphRequest.setParameters(parameters);
        graphRequest.executeAsync();


    }
}
