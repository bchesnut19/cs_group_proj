package RedditAlarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;
import java.util.List;
import java.util.PriorityQueue;

public class AlarmAdapter extends BaseAdapter {

    // declares the layout inflater which defines the row layout of the list view
    public LayoutInflater mInflater;

    // declares the priority queue of the alarms
    private List<Alarm> alarmList;

    // constructs the alarm adapter
    public AlarmAdapter(Context c, List<Alarm> al){
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        alarmList = al;
    }

    // gets the number of alarms
    @Override
    public int getCount() {
        return alarmList.size();
    }

    // gets the alarm at the specified position
    @Override
    public Alarm getItem(int position) {
        Alarm[] alarmArray = alarmList.toArray(new Alarm[getCount()]);
        return alarmArray[position];
    }

    // gets the id of the alarm at the specified position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // generates the items in the list view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.alarm_listview_detail, null);

        TextView timeTextView = v.findViewById(R.id.timeTextView);
        TextView daysTextView = v.findViewById(R.id.daysTextView);
        Switch alarmSwitch = v.findViewById(R.id.alarmSwitch);

        Alarm alarmViewed = getItem(position);

        String timeText = alarmViewed.hour + ":" + alarmViewed.minute;
        String daysText = "";

        timeTextView.setText(timeText);

        if (alarmViewed.daysOfWeek[0]) {
            daysText += "SU ";
        }
        if (alarmViewed.daysOfWeek[1]) {
            daysText += "M ";
        }
        if (alarmViewed.daysOfWeek[2]) {
            daysText += "T ";
        }
        if (alarmViewed.daysOfWeek[3]) {
            daysText += "W ";
        }
        if (alarmViewed.daysOfWeek[4]) {
            daysText += "TH ";
        }
        if (alarmViewed.daysOfWeek[5]) {
            daysText += "F ";
        }
        if (alarmViewed.daysOfWeek[6]) {
            daysText += "SA ";
        }

        daysTextView.setText(daysText);

        if (getItem(position).status == 1) {
            alarmSwitch.setChecked(true);
        }
        else {
            alarmSwitch.setChecked(false);
        }

        return v;
    }
}
