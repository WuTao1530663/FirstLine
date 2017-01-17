package com.example.pc.broadcastbestprictice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by pc on 2017/1/12.
 */

public class LoginActivity extends BaseActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPassword;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        sharedPreferences = getPreferences(MODE_PRIVATE);
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        rememberPassword = (CheckBox)findViewById(R.id.remember_password);
        login = (Button)findViewById(R.id.login);
        Boolean isRemember = sharedPreferences.getBoolean("remember_password",false);
        if(isRemember){
            accountEdit.setText(sharedPreferences.getString("account",""));
            passwordEdit.setText(sharedPreferences.getString("password",""));
            rememberPassword.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals("admin") && password.equals("123456")) {
                    editor = sharedPreferences.edit();
                    if(rememberPassword.isChecked()) {
                        editor.putBoolean("remember_password", true);
                        editor.putString("account",account);
                        editor.putString("password",password);

                    }
                    else
                        editor.clear();
                    editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
