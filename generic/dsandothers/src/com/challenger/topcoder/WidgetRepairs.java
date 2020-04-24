package com.challenger.topcoder;

public class WidgetRepairs {
 	public static int days(int[] arrivals, int numPerDay) {
        int operationDays = 0;
        int reminder = 0;
        for(int day: arrivals) {
            int i=day+reminder;
            if (i==0) continue;
            int j = i/numPerDay;
            operationDays+=(j==0?1:j);
            reminder=(i<numPerDay)?0:i%numPerDay;
            System.out.println("day="+day+" rem="+reminder+" opdays="
            +operationDays+" i="+i+" j="+j);
        }
        return (reminder==0)?operationDays:operationDays+1;
    }
}
