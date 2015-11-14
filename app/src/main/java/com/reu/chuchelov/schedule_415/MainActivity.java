package com.reu.chuchelov.schedule_415;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

    static TextView text414;
    static TextView text415;
    SharedPreferences sPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.welcome);


            text414 = (TextView) findViewById(R.id.text414);
            text415 = (TextView) findViewById(R.id.text415);
            text414.setOnClickListener(this);
            text415.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text414 :
                LessonData.setGroup("414");
                Log.d(ScheduleActivity.LOGTAG, "BUTTON_414_CLICKED");
                this.showSchedule();
                break;
            case R.id.text415 :
                LessonData.setGroup("415");
                Log.d(ScheduleActivity.LOGTAG, "BUTTON_415_CLICKED");
                this.showSchedule();
                break;
        }
    }

    public void showSchedule(){
        Intent intent = new Intent(this, ScheduleActivity.class);
        startActivity(intent);
    }

}

