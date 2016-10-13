package freelancegks.myassistant;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by SriBhargavi on 13-10-2016.
 */

public class Registration extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

    }

    public void onsave(View v) {
        if (v.getId() == R.id.save) {

            String Name = ((EditText) findViewById(R.id.name)).getText().toString().trim();
            String UserName = ((EditText) findViewById(R.id.username)).getText().toString().trim();
            String email = ((EditText) findViewById(R.id.emailaddress)).getText().toString().trim();
            String Passwords = ((EditText) findViewById(R.id.passwords)).getText().toString().trim();
            String EmailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

            if (email.matches(EmailPattern)) {
                if (Passwords.length() > 8 && Passwords.length() < 12) {
                    Contacts C = new Contacts();
                    C.setName(Name);
                    C.setUname(UserName);
                    C.setEmail(email);
                    C.setPass(Passwords);
                    helper.insertcontact(C);
                    Toast.makeText(Registration.this, "Thanks for registration.Will move to login page now", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Registration.this, UserLogin.class);
                    startActivity(i);
                }else{

                }
                Toast.makeText(Registration.this, "Password should be Min 8 & Max 12 characters", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(Registration.this, "Invalid Email Address", Toast.LENGTH_LONG).show();
            }
        }
    }
}