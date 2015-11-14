package com.reu.chuchelov.schedule_415;

import java.util.ArrayList;

/**
 * Created by Chuchelov on 17.09.15.
 */

//objects of this class contains only one fiels
//@DATA, which is array of lessons per days

public class DayData extends ArrayList {
    public ArrayList<Lesson> DATA = new ArrayList<>();

    public DayData() {
    }

    public void addDATA(Lesson lesson) {
        this.DATA.add(lesson);
    }

    public Lesson getDATA( int n) {
        return DATA.get(n);
    }
}
