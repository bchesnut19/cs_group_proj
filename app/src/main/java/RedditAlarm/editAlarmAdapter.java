package RedditAlarm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.PriorityQueue;

public class editAlarmAdapter extends AlarmAdapter {

    public editAlarmAdapter(Context c, PriorityQueue<Alarm> aq) {
        super(c, aq);
    }
    // generates the items in the list view
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.editalarm_listview_detail, null);

        TextView timeTextView = v.findViewById(R.id.timeTextView);
        TextView daysTextView = v.findViewById(R.id.daysTextView);
        Switch alarmSwitch = v.findViewById(R.id.alarmSwitch);
        ImageView removeImageView = v.findViewById(R.id.removeImageView);

        removeImageView.setImageResource(R.drawable.minus);

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

