/**
 * Created by Vinicius Ferreira on 27/11/2016.
 */

import java.util.*;

public class MainClass {

    public static void main(String[] args) {

        // Declaration of variables that will be used throughout the program
        int yearInt = 0;
        int monthInt = 0;
        int dayInt = 0;
        int hourInt = 0;
        int minuteInt = 0;
        int maxDaysInMonth = 0;
        int absoluteTime = 0;
        int regularYearCount = 0;
        int leapYearCount = 0;
        boolean isLeapYear = false;
        String month = "";

        // This variable controls the recurrence of user inputs, which will repeat until the user enters a valid value
        boolean continueLoop = true;

        // Creating new Scanner object to get user input
        Scanner userInput = new Scanner(System.in);

        // Getting user input with simple verification. Verifications may be reused in main software

        // First validation is year.
        // In actual program, all SCANNER objects will need to be replaced by inputs from the GUI.
        while(continueLoop) {
            System.out.println("Enter Year");
            String year = userInput.next();
            yearInt = Integer.parseInt(year);
            if(yearInt < 2000 | yearInt > 3000) {
                System.out.println("You have entered an invalid year. Please enter a year after 2000 and before 3000.");
            } else {
                continueLoop = false;
            }
        }

        // Determines if this is a leap year
        if(yearInt % 4 == 0) {
            isLeapYear = true;
        }

        // Resets loop control
        continueLoop = true;

        // Second validation is Month. All months between 1 and 12 are valid.
        // Determines the name of the month and the maximum number of days in the month (including leap year).

        while(continueLoop) {
            System.out.println("Enter Month");
            month = userInput.next();
            monthInt = Integer.parseInt(month);
            if(monthInt < 1 | monthInt > 12) {
                System.out.println("You have entered an invalid month. Please enter a year between 1 and 12.");
            } else {
                switch (monthInt) {
                    case 1:     month = "January";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    case 2:     month = "February";
                                if (isLeapYear) {
                                    maxDaysInMonth = 29;
                                } else {
                                    maxDaysInMonth = 28;
                                }
                                continueLoop = false;
                                break;
                    case 3:     month = "March";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    case 4:     month = "April";
                                maxDaysInMonth = 30;
                                continueLoop = false;
                                break;
                    case 5:     month = "May";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    case 6:     month = "June";
                                maxDaysInMonth = 30;
                                continueLoop = false;
                                break;
                    case 7:     month = "July";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    case 8:     month = "August";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    case 9:     month = "September";
                                maxDaysInMonth = 30;
                                continueLoop = false;
                                break;
                    case 10:    month = "October";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    case 11:    month = "November";
                                maxDaysInMonth = 30;
                                continueLoop = false;
                                break;
                    case 12:    month = "December";
                                maxDaysInMonth = 31;
                                continueLoop = false;
                                break;
                    default:    break;
                }
            }
        }

        // Resets loop control
        continueLoop = true;

        // Day verification is made easy by knowing how many days there are in the month.
        while(continueLoop) {
            System.out.println("Enter Day");
            String day = userInput.next();
            dayInt = Integer.parseInt(day);
            if(dayInt < 1 | dayInt > maxDaysInMonth) {
                System.out.println("You have entered an invalid input. Please enter a valid day for " + month);
            } else {
                continueLoop = false;
            }
        }

        // Resets loop control
        continueLoop = true;

        // Hour verification is a rather simple step.
        while(continueLoop) {
            System.out.println("Enter Hour");
            String hour = userInput.next();
            hourInt = Integer.parseInt(hour);
            if(hourInt < 0 | hourInt > 23) {
                System.out.println("You have entered an invalid hour. Please enter an hour between 0 and 23.");
            }   else {
                continueLoop = false;
            }
        }

        // Resets loop control
        continueLoop = true;

        // Minute verification is not complicated at all.
        while(continueLoop) {
            System.out.println("Enter Minute");
            String minute = userInput.next();
            minuteInt = Integer.parseInt(minute);
            if(minuteInt < 0 | minuteInt > 59) {
                System.out.println("You have entered an invalid minute. Please enter a minute between 0 and 59.");
            }   else {
                continueLoop = false;
            }
        }

        // Just a verification step to see if everything is fine. Can be supressed.
        System.out.println("You entered the following date:");
        System.out.println(dayInt + " of " + month + ", " + yearInt + ".");
        System.out.println("You entered the following hour:");
        System.out.println(hourInt + " hours and " + minuteInt + " minutes.");

        // absoluteTime 0 represents the midnight of January 1st, 2000. 1 means 00:01h of the same day. It increases
        // 1 unit per minute.
        // 1 hour has 60 minutes.
        // 1 day has 1,440 minutes.
        // Months 1, 3, 5, 7, 8, 10 and 12 have 44,640 minutes.
        // Months 4, 6, 9 and 11 have 43,200 minutes.
        // February has 40,320 minutes (41,760 on leap years).
        // One year has 525,600 minutes (527.040 on leap years).

        // This process determines the amount of complete years (regular and leap) before the current one since 2000
        final int startOfYearCount = 2000;
        int yearsToDate = yearInt - startOfYearCount;
        if (yearInt == 2000) {
            leapYearCount = 0;
        } else if(isLeapYear) {
            leapYearCount = (yearsToDate - (yearsToDate % 4)) / 4;
        } else {
            leapYearCount = ((yearsToDate - (yearsToDate % 4)) / 4) + 1;
        }
        regularYearCount = yearsToDate - leapYearCount;
        System.out.println("We have " + regularYearCount + " regular years and " + leapYearCount + " leap years " +
                "since 2000.");

        // Adds to absoluteTime the amount of minutes equal to the minutes passed in complete years to date.
        absoluteTime = regularYearCount * 525600 + leapYearCount * 527040;

        // Adds to absoluteTime amount of minutes equal to complete days (not counting today) of the month.
        // This is a series of IF statements. The first one applies to all months.
        if (monthInt >= 1) {
            absoluteTime = absoluteTime + ((dayInt - 1) * 1440);
        }

        // The second IF statement applies to months later than January, and adds 31 days of 1440 minutes to the total
        if (monthInt >= 2) {
            absoluteTime = absoluteTime + (31 * 1440);
        }

        // The third IF statement applies to months later than February, and adds minutes depending
        // if the year is leap or regular
        if (monthInt >= 3) {
            if (isLeapYear) {
                absoluteTime = absoluteTime + (29 * 1440);
            } else {
                absoluteTime = absoluteTime + (28 * 1440);
            }
        }

        // From the fourth IF statement onwards things start getting repetitive and no further comments are placed
        if (monthInt >=4) {
            absoluteTime = absoluteTime + (31 * 1440);
        }

        if (monthInt >=5) {
            absoluteTime = absoluteTime + (30 * 1440);
        }

        if (monthInt >=6) {
            absoluteTime = absoluteTime + (31 * 1440);
        }

        if (monthInt >=7) {
            absoluteTime = absoluteTime + (30 * 1440);
        }

        if (monthInt >=8) {
            absoluteTime = absoluteTime + (31 * 1440);
        }

        if (monthInt >=9) {
            absoluteTime = absoluteTime + (31 * 1440);
        }

        if (monthInt >=10) {
            absoluteTime = absoluteTime + (30 * 1440);
        }

        if (monthInt >=11) {
            absoluteTime = absoluteTime + (31 * 1440);
        }

        if (monthInt == 12) {
            absoluteTime = absoluteTime + (30 * 1440);
        }
        // And at this point, absoluteTime has been added the minutes for all complete years, months and days.
        // Now for the hours and minutes.

        absoluteTime = absoluteTime + (hourInt * 60);
        absoluteTime = absoluteTime + minuteInt;

        // This is just for debugging reasons and may be ommitted.
        System.out.println("Absolute time is: " + absoluteTime);

        Methods calls = new Methods();
        System.out.println("Current year (retrieved by calculation) is " + calls.retrieveYear(absoluteTime));
        System.out.println("Current month (retrieved by calculation) is " + calls.retrieveMonth(absoluteTime));
        System.out.println("Current day (retrieved by calculation) is " + calls.retrieveDay(absoluteTime));
        System.out.println("Current hour (retrieved by calculation) is " + calls.retrieveHour(absoluteTime));
        System.out.println("Current minute (retrieved by calculation) is " + calls.retrieveMinute(absoluteTime));
        System.out.println(calls.retrieveFullString(absoluteTime));

    }

}
