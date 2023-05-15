package sg.edu.rp.c346.id22011587.demotimeanddateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    TextView tvDisplay;
    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnDisplayDate = findViewById(R.id.buttonDisplayDate);
        btnDisplayTime = findViewById(R.id.buttonDisplayTime);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReset = findViewById(R.id.resetButton);

        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the current time
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                //Format the time as "hh:mm a"
                SimpleDateFormat format = new SimpleDateFormat("HH:mm", Locale.getDefault());
                String time = format.format(calendar.getTime());

                //Set the time to a TextView
                TextView textView = findViewById(R.id.textViewDisplay);
                String displayText = "Time is " + time;
                textView.setText(displayText);
            }
        });
        //OR
        //btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

                //int getHour = tp.getCurrentHour();
                //int getMin = tp.getCurrentMinute();
                //tvDisplay.setText("Time is " + getHour + getMin);
            //}
        //});

        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get the current date
                Calendar calendar = Calendar.getInstance();
                Date date = calendar.getTime();

                //Format the date as "D/M/Y"
                SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/y", Locale.getDefault());
                String dateString = dateFormat.format(date);

                //Set the date to a textView with "Date is" prefix
                TextView textView = findViewById(R.id.textViewDisplay);
                String displayText = "Date is " + dateString;
                textView.setText(displayText);
            }
        });
        //OR
        //btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //int getDay = dp.getDayOfMonth();
                //int getMonth = dp.getMonth();
                //int getYear = dp.getYear();
                //tvDisplay.setText("Date is " + getDay + getMonth + getYear);
            //}
        //});

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reset the TimePicker to 12AM
                TimePicker timePicker = findViewById(R.id.timePicker);
                timePicker.setHour(0);
                timePicker.setMinute(0);

                //Reset the DatePicker to January 1, 2020
                DatePicker datePicker = findViewById(R.id.datePicker);
                datePicker.updateDate(2020,0,1);

            }
        });
        //OR
        //btnReset.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {

                //dp.updateDate(2020, 01, 01);
                //tp.setCurrentHour(12);
                //tp.setCurrentMinute(00);

            //}
        //});
    }
}