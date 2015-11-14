package com.reu.chuchelov.schedule_415;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Chuchelov on 17.09.15.
 */
public class LessonData {

    public static InputStream assetInputStream;
    public static DayData[] lessonsData = new DayData[6];
    public static String[] days = {"Понедельник", "Вторник", "Среда",
            "Четверг", "Пятница", "Суббота"};
    static String group;


    // testing method to see all the written data in @array lessonsData

    public static void readAssets(Context context){
        AssetManager asset = context.getAssets();
        try {
            assetInputStream = asset.open("txts/"+group);
            Log.d(ScheduleActivity.LOGTAG, "ALLRIGHT_FILE_OK");
            Log.d(ScheduleActivity.LOGTAG,"OPENED_"+group);
            readData();
        } catch (IOException e) {
            Log.d(ScheduleActivity.LOGTAG, "FILE NOT FOUND");
        }
    }

    public static void setGroup(String g){
             group = "schedule_"+g+".txt";
    }

    public static String getGroup() {
        return group;
    }

    public static void readData(){
        DateData.setDate();
        Scanner in = new Scanner(assetInputStream);
        for (int i = 0; i < 6; i++) {
            Log.d(ScheduleActivity.LOGTAG, days[i]);
            in.nextLine();
            Lesson lesson;
            String s = "";
            s = in.nextLine();
            lessonsData[i] = new DayData();
            while (!s.equals("endDay")) {
                // creating new object, which will collect data
                // from form.txt and then be added to @lessonsData mas
                lesson = new Lesson();

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

                //reading lesson name
                // @s is read before to evaluate
                // there is still a new lesson in lessons_.txt
                lesson.setLessonName(s);

                s=in.nextLine();
                if(!s.contains("null")){
                    lesson.setLecturer(s);
                } else lesson.setLecturer("null");

                s=in.nextLine();
                lesson.setStartTime(s);

                s=in.nextLine();
                lesson.setEndTime(s);

                s=in.nextLine();
                lesson.setStartWeek(Integer.parseInt(s));

                s=in.nextLine();
                lesson.setEndWeek(Integer.parseInt(s));


                //reading and determinig the type of lesson
                s = in.nextLine();
                if(!s.contains("null")){
                    lesson.setType(s);
                } else lesson.setType("null");

                //setting up number of cabinet
                s = in.nextLine();
                if(!s.contains("null")){
                    if (!s.contains("к"))
                        s = s + " 3к";
                    lesson.setCabinet(s);
                } else lesson.setCabinet("null");


                //adding created @lesson to @lessonsData
                lessonsData[i].addDATA(lesson);

                in.nextLine();
                //reading @s to check if it is !endOfDay
                s = in.nextLine();
            }
        }

    }
}