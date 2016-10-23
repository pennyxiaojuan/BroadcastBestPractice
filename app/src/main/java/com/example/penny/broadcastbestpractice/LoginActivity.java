package com.example.penny.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
/**编写等酷界面的Activity,模拟一个简单的登陆功能，首先使用setContentView()方法将login布局加载进来，
 * 并调用findViewById()方法别被获取到账号输入框和密码输入框以及登陆按钮的实例，然后在登陆按钮的点击
 * 事件里面对输入的账号和密码进行判断，否则就提示用户账号和密码错误。
 * Created by penny on 2016/10/22.
 */

public class LoginActivity extends BasicActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit  = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);
        final boolean isRemember = pref.getBoolean("remember_password",false);
        if (isRemember){
            //将账号和密码都设置到文本框中
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);

        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //如果账号是admin切密码是123456，就认为登陆成功
                if (account.equals("admin")&&password.equals("123456")) {
                    editor = pref.edit();
                    if (rememberPass.isChecked()){
                        //检查复选框是否被选中
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }editor.commit();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this,"account or password is invalid",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
