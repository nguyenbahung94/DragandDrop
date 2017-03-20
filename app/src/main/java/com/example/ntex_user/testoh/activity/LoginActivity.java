package com.example.ntex_user.testoh.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ntex_user.testoh.R;
import com.example.ntex_user.testoh.model.OneObject;
import com.example.ntex_user.testoh.model.User;
import com.example.ntex_user.testoh.model.Verify;
import com.example.ntex_user.testoh.presenter.PrLoginImp;
import com.example.ntex_user.testoh.view.ViewLogin;

import java.util.List;

public class LoginActivity extends AppCompatActivity implements ViewLogin {
    private PrLoginImp prLoginImp;
    private static String TOKEN = "";
    private EditText edt_verify;
    private Button btn_submit;
    private Button btn_click;
    private Button btn_login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
        prLoginImp = new PrLoginImp(this);
        edt_verify = (EditText) findViewById(R.id.edt_verify);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_login=(Button)findViewById(R.id.btn_login);
        btn_click=(Button)findViewById(R.id.btn_click);
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prLoginImp.getTask(TOKEN);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prLoginImp.checkLogin(new User("mr.hungcity@gmail.com", "81dc9bdb52d04dc20036dbd8313ed055"));
            }
        });
        edt_verify.setVisibility(View.GONE);
        btn_submit.setVisibility(View.GONE);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   prLoginImp.verifyCode(TOKEN,new Verify(edt_verify.getText().toString()));
            }
        });
    }

    @Override
    public void succes(String token) {
        TOKEN=token;
        btn_submit.setVisibility(View.VISIBLE);
        edt_verify.setVisibility(View.VISIBLE);
    }

    @Override
    public void failed() {

    }

    @Override
    public void verifySucces() {
        Toast.makeText(getApplicationContext(),"Verify thanh cong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void succsesTask(List<OneObject> objectList) {
        Intent tam=new Intent(this,AcivityNavigation.class);
        startActivity(tam);
        OneObject object1=objectList.get(0);
        Log.e("LoginActivity-getdata", String.valueOf(object1.getType()));
    }


}
