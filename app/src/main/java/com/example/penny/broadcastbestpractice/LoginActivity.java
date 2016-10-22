package com.example.penny.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/**编写等酷界面的Activity,模拟一个简单的登陆功能，首先使用setContentView()方法将login布局加载进来，
 * 并调用findViewById()方法别被获取到账号输入框和密码输入框以及登陆按钮的实例，然后在登陆按钮的点击
 * 事件里面对输入的账号和密码进行判断，否则就提示用户账号和密码错误。
 * Created by penny on 2016/10/22.
 */

public class LoginActivity extends BasicActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                //如果账号是admin切密码是123456，就认为登陆成功
                if (account.equals("admin")&&password.equals("123456")) {
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
