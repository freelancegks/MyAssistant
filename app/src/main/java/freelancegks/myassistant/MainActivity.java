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

    DatabaseHelper Helper = new DatabaseHelper(this);
    private RadioGroup loginSelect;
    private RadioButton LoginSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     }

    public  void register(View V){
        if (V.getId()== R.id.Register){
            Intent registration = new Intent(MainActivity.this,Registration.class);
            startActivity(registration);
        }
    }


    public void onloginclick(View V) {
        if (V.getId() == R.id.login) {
            /* Validate email address & Password. Proceed with login */
            String EmailAddr = ((EditText) findViewById(R.id.EmailAdd)).getText().toString().trim();
            String Pwd = ((EditText) findViewById(R.id.pwd)).getText().toString().trim();
            String EmailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

            String Pass = Helper.searchpass(EmailAddr);

            if (Pwd.equals(Pass)){
                Intent i = new Intent(MainActivity.this, UserLogin.class);
                startActivity(i);
            }else{
                Toast.makeText(MainActivity.this, "Invalid EmailAddress or Password. Try again", Toast.LENGTH_LONG).show();
            }
        }

    }
}
