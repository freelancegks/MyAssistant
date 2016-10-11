package freelancegks.myassistant;

import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by SriBhargavi on 11-10-2016.
 */

public class UserLogin extends Activity {
    ListView listView ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userlogin);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Defined Array values to show in ListView
        String[] values = new String[] { "1.My Doctor",
                "2.My Training",
                "3.My Meetings",
                "4.My MailBox",
                "5.My Grocery",
                "6.My Tickets",
                "7.My Reminders",
                "12.My Training",
                "13.My Meetings",
                "14.My MailBox",
                "15.My Grocery",
                "16.My Tickets",
                "17.My Reminders",
                "22.My Training",
                "23.My Meetings",
                "24.My MailBox",
                "25.My Grocery",
                "26.My Tickets",
                "27.My Reminders",
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_SHORT).show();


            }

        });
    }

}
