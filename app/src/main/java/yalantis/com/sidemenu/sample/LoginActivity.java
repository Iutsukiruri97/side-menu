package yalantis.com.sidemenu.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextInputLayout userNameLayout=findViewById(R.id.userNameLayout);
        TextInputLayout userPassLayout=findViewById(R.id.userPassLayout);
        userNameLayout.setHint(getResources().getString(R.string.username));
        userPassLayout.setHint(getResources().getString(R.string.password));
    }

    public void LoginClick(View view) {
        Intent in = new Intent();
        in.setClassName( getApplicationContext(), "yalantis.com.sidemenu.sample.MainActivity" );
        in.putExtra("userName",((EditText)findViewById(R.id.userNameText)).getText().toString());
        startActivity( in );
    }
}
