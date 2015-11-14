package com.reu.chuchelov.schedule_415;

/**
 * Created by Chuchelov on 17.09.15.
 */
// This class runs new @Lesson object types
// all getters and setters included


public class Lesson{

        public Lesson(){}

        private String lessonName;
        private String cabinet;
        private String type;
        private int startWeek;
        private int endWeek;
        private String startTime;
        private String endTime;
        private String lecturer;

        public String getLecturer() {
                return lecturer;
        }

        public void setLecturer(String lecturer) {
                this.lecturer = lecturer;
        }

        public String getStartTime() {
                return startTime;
        }

        public void setStartTime(String startTime) {
                this.startTime = startTime;
        }

        public String getEndTime() {
                return endTime;
        }

        public void setEndTime(String endTime) {
                this.endTime = endTime;
        }

        public String getType() {
                return type;
        }

        public void setType(String type) {
                if (type.equals("л")){
                        this.type = "Лекция";
                }else this.type = "Семинар";
        }

        public int getStartWeek() {
                return startWeek;
        }

        public void setStartWeek(int startWeek) {
                this.startWeek = startWeek;
        }

        public int getEndWeek() {
                return endWeek;
        }

        public void setEndWeek(int endWeek) {
                this.endWeek = endWeek;
        }

        public String getLessonName() {
                return lessonName;
        }

        public void setLessonName(String lessonName) {
                this.lessonName = lessonName;
        }

        public String getCabinet() {
                return cabinet;
        }

        public void setCabinet(String cabinet) {
                this.cabinet = cabinet;
        }

        public boolean doesAppear(int weekNumber){
                if ((this.getStartWeek() <= weekNumber) &&
                        (this.getEndWeek() >= weekNumber))
                        return true;
                else return false;
        }
}