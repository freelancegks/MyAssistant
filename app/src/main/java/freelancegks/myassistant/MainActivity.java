package freelancegks.myassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private RadioGroup loginSelect;
    private RadioButton LoginSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onloginclick(View V) {

        if (V.getId() == R.id.login) {
            EditText EmailAdd = (EditText) findViewById(R.id.EmailAdd);
            EditText Passwordtext = (EditText) findViewById(R.id.pwd);

            /* Validate email address & Password. Proceed with login */
            String EmailAddr = EmailAdd.getText().toString().trim();
            String Pwd = Passwordtext.getText().toString().trim();
            String EmailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

            if (EmailAddr.matches(EmailPattern)) {
                if (Pwd.length() > 8 && Pwd.length() < 12) {
                     /*
                    loginSelect = (RadioGroup) findViewById(R.id.RadioUser);
                    int selectedId = loginSelect.getCheckedRadioButtonId();
                    LoginSelected = (RadioButton) findViewById(selectedId);

                   /* Toast.makeText(MainActivity.this, EmailAddr, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, Pwd, Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, LoginSelected.getText(), Toast.LENGTH_SHORT).show();*/

                    Intent i = new Intent(MainActivity.this, UserLogin.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "Password should be Min 8 & Max 12 characters", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(MainActivity.this, "Please enter valid email address", Toast.LENGTH_LONG).show();
            }
        }
    }
}
