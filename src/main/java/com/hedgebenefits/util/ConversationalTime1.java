package com.hedgebenefits.util;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.HashMap;
import java.util.Map;

public class ConversationalTime1 {
    private final String JUST_AFTER = "just after ";
    private final String PAST = "past ";
    private final String ALMOST = "almost ";
    private final String TO = "to ";

    public String getNewConversationalTime(String strTime) {
        String conversationalTime = "";
        DateTime time = DateTime.parse(strTime, DateTimeFormat.forPattern("HH:mm"));

        String prefixText = "";
        String nearestDial = "";

        int minutes = time.getMinuteOfHour();
        int hour = getHour(time);

        if (minutes > 32){
            minutes = 60 - minutes;
            prefixText = getPrefixingText(minutes, JUST_AFTER, ALMOST);
            nearestDial = getNearestDial(minutes);
            if (!"".equals(nearestDial)){
                nearestDial = nearestDial + TO;
            }
            conversationalTime = prefixText + nearestDial + getHourMap().get(hour+1);

        }
        else {
            prefixText = getPrefixingText(minutes, ALMOST, JUST_AFTER);
            nearestDial = getNearestDial(minutes);
            if (!"".equals(nearestDial)){
                nearestDial = nearestDial + PAST;
            }
            return prefixText + nearestDial + getHourMap().get(hour);
        }

        return conversationalTime.trim();

    }

    private int getHour(DateTime time) {
        int hour = time.getHourOfDay();
        if (hour > 12) {
            hour = hour - 12;
        }
        return hour;
    }

    private String getNearestDial(int minutes) {
        String nearestDial = "";

        int i = minutes % 5;
        if (i == 0){
            nearestDial = getMinDialMap().get(minutes+0.0);
        }
        else if (i > 0 && i <= 2){
            double dial = Math.floor(minutes / 5.0) * 5;
            nearestDial = getMinDialMap().get(dial);
        }
        else if (i > 2 &&  i < 5){
            double dial = Math.ceil(minutes/5.0)*5;
            nearestDial =  getMinDialMap().get(dial);
        }
        return nearestDial;
    }

    private String getPrefixingText(int minutes, String almostText, String justAfterText) {

        String prefixText = "";

        int i = minutes % 5;

        if (i > 0 && i <= 2){
           prefixText =  justAfterText;
        }
        else if (i >= 3 &&  i < 5){
            prefixText =  almostText;
        }
        return prefixText;
    }

    private Map<Integer, String> getHourMap() {
        Map<Integer, String> map = new HashMap();
        map.put(0, "midnight");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four ");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "noon");
        return map;  //To change body of created methods use File | Settings | File Templates.
    }

    private Map<Double, String> getMinDialMap() {
        Map<Double, String> map = new HashMap();
        map.put(0.0, "");
        map.put(5.0, "five ");
        map.put(10.0, "ten ");
        map.put(15.0, "quarter ");
        map.put(20.0, "twenty ");
        map.put(25.0, "twenty five ");
        map.put(30.0, "half ");
        return map;
    }

    public static void main(String... args) {
        String time = "00:28";
        String conversationalTime = new ConversationalTime1().getNewConversationalTime(time);
        System.out.println(conversationalTime);
    }
}
