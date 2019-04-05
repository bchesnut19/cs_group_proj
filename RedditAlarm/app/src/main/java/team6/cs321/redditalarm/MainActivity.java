package team6.cs321.redditalarm;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declares and initializes the button to edit the alarms
        Button editBtn = findViewById(R.id.editBtn);

        // declares and initializes the image view to add a new alarm
        ImageView addImgView = findViewById(R.id.addImgView);

        // declares and initializes the list view that will show the list of alarms
        final ListView alarmListView = findViewById(R.id.alarmListView);

        // when the edit button is clicked, the user will able to edit the alarms
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // when the image view is clicked, the screen changes to the alarm add activity
        addImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creates a new activity where the user will be able to add an alarm
                //Intent addAlarmIntent = new Intent(getApplicationContext(), AlarmAdd.class);
                //startActivity(addAlarmIntent);

                // uses the alarm adapter class to modify the alarm list view
                AlarmAdapter alarmAdapter = new AlarmAdapter(getApplicationContext());
                alarmListView.setAdapter(alarmAdapter);
            }
        });

    }
}
