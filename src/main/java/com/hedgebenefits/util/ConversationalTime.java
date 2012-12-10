package com.hedgebenefits.util;


import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.format.DateTimeFormat;

import java.util.HashMap;
import java.util.Map;

public class ConversationalTime {
    private final String JUST_AFTER = "just after ";
    private final String JUST_BEFORE = "just before ";
    private final String ALMOST_QUARTER = "almost quarter ";
    private final String MIDNIGHT = "midnight";
    private final String QUARTER = "quarter ";
    private final String ALMOST_TWENTY = "almost twenty ";
    private final String TWENTY = "twenty ";
    private final String ALMOST_HALF = "almost half ";
    private final String HALF = "half ";
    private final String PAST = "past ";
    private final String ALMOST_TWENTY_FIVE = "almost twenty five ";
    private final String TWENTY_FIVE = "twenty five ";
    private final String ALMOST = "almost ";
    private final String TO = "to ";
    private String TEN = "ten ";
    private static final String FIVE = "five ";

    public String getConversationalTime(String strTime) {

        Map<Integer, String> hourMap = getHourMap();

        String conversationalTime = "";
        String hourInWords = "";
        DateTime time = DateTime.parse(strTime, DateTimeFormat.forPattern("HH:mm"));


        Minutes minutes = getMinutes(time);
        Hours hour = getHour(time);

        if (minutes.isGreaterThan(minutes(32))) {
            conversationalTime = getPrependingTextAfter30Mins(minutes);
            hourInWords = hourMap.get(hour.plus(1).getHours());
        }
        else{
            conversationalTime = getPrependingTextBefore30Mins(minutes);
            hourInWords = hourMap.get(hour.getHours());
        }



        return (conversationalTime + hourInWords).trim();

    }

    private String getPrependingTextAfter30Mins(Minutes minutes) {
        String conversationalTime = "";
        if (minutes.isGreaterThan(minutes(32)) && minutes.isLessThan(minutes(35))) {
            conversationalTime = ALMOST + TWENTY_FIVE + TO ;
        }
        else if(minutes.equals(minutes(35))){
            conversationalTime = TWENTY_FIVE + TO;
        }
        else if ((minutes.isGreaterThan(minutes(35)) && minutes.isLessThan(minutes(38)))){
            conversationalTime = JUST_AFTER + TWENTY_FIVE + TO;
        }
        else if(minutes.isGreaterThan(minutes(37)) && minutes.isLessThan(minutes(40))){
            conversationalTime = ALMOST + TWENTY + TO;
        }
        else if (minutes.equals(minutes(40))){
            conversationalTime = TWENTY + TO;
        }
        else if (minutes.isGreaterThan(minutes(40)) && minutes.isLessThan(minutes(43))){
            conversationalTime = JUST_AFTER + TWENTY + TO;
        }
        else if (minutes.isGreaterThan(minutes(42)) && minutes.isLessThan(minutes(45))){
            conversationalTime = ALMOST + QUARTER + TO;
        }
        else if (minutes.equals(minutes(45))){
            conversationalTime = QUARTER + TO;
        }
        else if (minutes.isGreaterThan(minutes(45)) && minutes.isLessThan(minutes(48))){
            conversationalTime = JUST_AFTER + QUARTER + TO;
        }
        else if (minutes.isGreaterThan(minutes(47)) && minutes.isLessThan(minutes(50))){
            conversationalTime = ALMOST + TEN + TO;
        }
        else if (minutes.equals(minutes(50))){
            conversationalTime = TEN + TO;
        }
        else if (minutes.isGreaterThan(minutes(50)) && minutes.isLessThan(minutes(53))){
            conversationalTime = JUST_AFTER + TEN + TO;
        }
        else if (minutes.isGreaterThan(minutes(52)) && minutes.isLessThan(minutes(55))){
            conversationalTime = ALMOST + FIVE + TO;
        }
        else if (minutes.equals(minutes(55))){
            conversationalTime = FIVE + TO;
        }
        else if (minutes.isGreaterThan(minutes(55)) && minutes.isLessThan(minutes(58))){
            conversationalTime = JUST_AFTER + FIVE + TO;
        }
        else if (minutes.isGreaterThan(minutes(57)) && minutes.isLessThan(minutes(60))){
            conversationalTime = ALMOST;
        }
        return conversationalTime;
    }

    private String getPrependingTextBefore30Mins(Minutes minutes) {
        String conversationalTime = "";
        if (minutes.isGreaterThan(minutes(0)) && minutes.isLessThan(minutes(3))) {
            conversationalTime = JUST_AFTER;
        }
        else if(minutes.isGreaterThan(minutes(2)) && minutes.isLessThan(minutes(13))){
            conversationalTime = getMinutesMap().get(minutes.getMinutes()) + PAST;
        }
        else if ((minutes.isGreaterThan(minutes(12)) && minutes.isLessThan(minutes(15)))){
            conversationalTime = ALMOST_QUARTER + PAST;
        }
        else if(minutes.isGreaterThan(minutes(15)) && minutes.isLessThan(minutes(18))){
            conversationalTime = JUST_AFTER + QUARTER + PAST;
        }
        else if (minutes.equals(minutes(15))){
            conversationalTime = QUARTER + PAST;
        }
        else if (minutes.isGreaterThan(minutes(17)) && minutes.isLessThan(minutes(20))){
            conversationalTime = ALMOST_TWENTY + PAST;
        }
        else if (minutes.equals(minutes(20))){
            conversationalTime = TWENTY + PAST;
        }
        else if (minutes.isGreaterThan(minutes(20)) && minutes.isLessThan(minutes(23))){
            conversationalTime = JUST_AFTER + TWENTY + PAST;
        }
        else if (minutes.isGreaterThan(minutes(22)) && minutes.isLessThan(minutes(25))){
            conversationalTime = ALMOST_TWENTY_FIVE + PAST;
        }
        else if (minutes.equals(minutes(25))){
            conversationalTime = TWENTY_FIVE + PAST;
        }
        else if (minutes.isGreaterThan(minutes(25)) && minutes.isLessThan(minutes(28))){
            conversationalTime = JUST_AFTER + TWENTY_FIVE + PAST;
        }
        else if (minutes.isGreaterThan(minutes(27)) && minutes.isLessThan(minutes(30))){
            conversationalTime = ALMOST_HALF + PAST;
        }
        else if (minutes.equals(minutes(30))){
            conversationalTime = HALF + PAST;
        }
        else if (minutes.isGreaterThan(minutes(30)) && minutes.isLessThan(minutes(33))){
            conversationalTime = JUST_AFTER + HALF + PAST;
        }
        return conversationalTime;
    }

    private Map<Integer, String> getHourMap() {
        Map<Integer, String> map = new HashMap();
        map.put(0, "midnight ");
        map.put(1, "one ");
        map.put(2, "two ");
        map.put(3, "three ");
        map.put(4, "four ");
        map.put(5, "five ");
        map.put(6, "six ");
        map.put(7, "seven ");
        map.put(8, "eight ");
        map.put(9, "nine ");
        map.put(10, "ten ");
        map.put(11, "eleven ");
        map.put(12, "noon ");
        return map;  //To change body of created methods use File | Settings | File Templates.
    }

    private Map<Integer, String> getMinutesMap() {
        Map<Integer, String> map = new HashMap();
        map.put(1, "one ");
        map.put(2, "two ");
        map.put(3, "three ");
        map.put(4, "four ");
        map.put(5, "five ");
        map.put(6, "six ");
        map.put(7, "seven ");
        map.put(8, "eight ");
        map.put(9, "nine ");
        map.put(10, "ten ");
        map.put(11, "eleven ");
        map.put(12, "twelve ");
        return map;  //To change body of created methods use File | Settings | File Templates.
    }


    private Hours getHour(DateTime time) {
        return Hours.parseHours("P" + 0 + "Y" + 0 + "M" + 0 + "W" + 0 + "DT" + time.getHourOfDay() + "H" + 0 + "M" + 0 + "S");
    }

    private Minutes getMinutes(DateTime time) {
        return Minutes.parseMinutes("P" + 0 + "Y" + 0 + "M" + 0 + "W" + 0 + "DT" + 0 + "H" + time.getMinuteOfHour() + "M" + 0 + "S");
    }

    private Minutes minutes(int min) {
        return Minutes.parseMinutes("P" + 0 + "Y" + 0 + "M" + 0 + "W" + 0 + "DT" + 0 + "H" + min + "M" + 0 + "S");
    }
    private Hours hour(int hr) {
        return Hours.parseHours("P" + 0 + "Y" + 0 + "M" + 0 + "W" + 0 + "DT" + hr + "H" + 0 + "M" + 0 + "S");
    }
}
