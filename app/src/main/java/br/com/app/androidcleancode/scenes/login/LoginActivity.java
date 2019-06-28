package br.com.app.androidcleancode.scenes.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import br.com.app.androidcleancode.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    LoginInteractorInput output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginConfigurator.INSTANCE.configure(this);
        findViewById(R.id.login_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String user = contentFrom(R.id.login_user);
        String password = contentFrom(R.id.login_password);
        output.validate(new LoginModel.Request(user, password));
    }

    private String contentFrom(@IdRes int fieldId) {
        EditText editText = findViewById(fieldId);
        return editText.getText().toString();
    }
}
