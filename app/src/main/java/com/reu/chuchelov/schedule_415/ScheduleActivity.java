package com.reu.chuchelov.schedule_415;

/**
 * Created by Chuchelov on 16.09.15.
 */

import java.io.InputStream;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class ScheduleActivity extends Activity implements OnClickListener{


    int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
    static LinearLayout linearLayout;
    static LinearLayout.LayoutParams lParams;
    static String LOGTAG = "MY_LOG";
    static int WEEK_NUMBER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waybetter);

        //operations with schedule data
        LessonData.readAssets(this.getApplicationContext());

        Log.d(LOGTAG, "Shit piss letsgo");

        linearLayout = (LinearLayout) findViewById(R.id.linLayout);
        lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);

        WEEK_NUMBER = DateData.getWeekNumber();
        int i = DateData.getDayOfWeek();
        if ( i == 6 ) i = 0;
        while(WEEK_NUMBER<=17) {
            createTextView(30, "WEEK #" + WEEK_NUMBER);
            createTextView();
            while ( i < 6){
                createTextView(25, LessonData.days[i]);
                createTextView();
                for (Lesson lesson : LessonData.lessonsData[i].DATA) {
                    /**
                     * Format of lessons_.txt file:
                     *
                     * weekDay(string)
                     * lessonName(string)
                     * lecturer
                     * startTime
                     * endTime
                     * startWeek(int)
                     * endWeek(int)
                     * lesson type("л" or "с")
                     * cabinet(string)
                     * [empty line]
                     * "endDay"
                     *
                     */
                    if (lesson.doesAppear(WEEK_NUMBER)) {
                        createTextView(17,lesson.getLessonName());

                        if(!lesson.getLecturer().equals("null"))
                        createTextView(15,lesson.getLecturer());
                        if(!lesson.getType().equals("null"))
                            createTextView(15,lesson.getType());
                        if (!lesson.getCabinet().equals("null"))
                        createTextView(15,lesson.getCabinet());
                        createTextView(16,lesson.getStartTime() + " - " + lesson.getEndTime());
                        createTextView("....");
                    }
                }
                createTextView("______________\n");
                i++;
            }
            createTextView("\n* * *");
            WEEK_NUMBER++;
            i=0;
        }
        createClickableTextView(13, "\ncreated by chuchelov.");
    }

    public void createTextView(int textSize, String s){
        TextView textView = new TextView(this);
        textView.setText(s);
        textView.setTextSize(textSize);
        textView.setLayoutParams(lParams);
        linearLayout.addView(textView);

    }

    public void createTextView(String s){
        createTextView(18, s);
    }

    public void createTextView(){
        createTextView("");
    }

    public void createClickableTextView(int textSize, String s){
        TextView textView = new TextView(this);
        textView.setText(s);
        textView.setTextSize(textSize);
        textView.setLayoutParams(lParams);
        linearLayout.addView(textView);
        textView.setOnClickListener(chuchelovClicked);

    }

   public static OnClickListener chuchelovClicked = new OnClickListener() {
       @Override
       public void onClick(View v) {

       }
   };

    @Override
    public void onClick(View v) {
    }
}
