package RedditAlarm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.List;


public class UIClass extends AppCompatActivity implements AlarmFragment.passAlarm {

    List<Alarm> listOfAlarms = new ArrayList<>();
    LogicHandler logicReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);

        logicReference = new LogicHandler(this);
        listOfAlarms = logicReference.alarmList;

        // temporary call for Notifications testing
        //Notification.Builder tempNotification = Notifications.newNotification(this);
        MainMenuFragment mainMenuFrag = new MainMenuFragment();
        mainMenuFrag.ui = this;
        mainMenuFrag.logicReference = logicReference;
        mainMenuFrag.alarmList = (ArrayList<Alarm>) logicReference.alarmList;
        //the next two expressions are used to call and populate a frame layout with
        //a fragment (AlarmFragment)
        //fragment1 is the name of the FrameLayout under base_layout.xml
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment1,mainMenuFrag);

        //commits the fragment to the layout?
        fragmentTransaction.commit();

    }

    public AlarmFragment addAlarmFrag(MainMenuFragment menuIn) {
        AlarmFragment alarmFrag = new AlarmFragment();
        alarmFrag.ui = this;
        alarmFrag.logic = this.logicReference;
        alarmFrag.mainRef = menuIn;

        // changes the interface to the add alarm fragment

        return inflateAlarmFrag(alarmFrag);
    }
    public AlarmFragment inflateAlarmFrag(AlarmFragment alarmFrag) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment1, alarmFrag)
                .addToBackStack("add")
                .commit();
        return alarmFrag;
    }

    public void killAlarmEdit(AlarmFragment fragIn) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .remove(fragIn);
        getSupportFragmentManager().popBackStack();
        fragmentTransaction.commit();

    }

    @Override
    public void addAlarmFromFragment(Alarm alarm) {
        //MainMenuFragment mainMenu = getSupportFragmentManager().findFragmentById(R.id.);
    }

}