/**
 * Created by Vinicius Ferreira on 27/11/2016.
 */
public class Methods {

    public int retrieveYear(int time) {
        // Every four-year cycle, starting in 2000, has 1 leap year and 3 regular years.
        // Therefore, it contains a total of 1 * 527.040 plus 3 * 525.600 = 2.103.840 minutes
        int cycles = (time - (time % 2103840)) / 2103840;
        int currentYear = 2000 + (cycles * 4);
        int remainder = time % 2103840;
        if (remainder >= 1578240) {
            // that is, if it is in the last year of a cycle
            currentYear = currentYear + 3;
        } else if (remainder >= 1052640) {
            // and so on, decreasing
            currentYear = currentYear + 2;
        } else if (remainder >= 527040) {
            currentYear = currentYear + 1;
        }
        return currentYear;
    }

    public int retrieveMonth(int time) {
        // Every four-year cycle, starting in 2000, has 1 leap year and 3 regular years.
        // Therefore, it contains a total of 1 * 527.040 plus 3 * 525.600 = 2.103.840 minutes
        boolean isLeapYear = false;
        time = time % 2103840;
        int month = 0;
        if (time >= 1578240) {
            // that is, if it is in the last year of a cycle
            time = time - 1578240;
        } else if (time >= 1052640) {
            // and so on, decreasing
            time = time - 1052640;
        } else if (time >= 527040) {
            time = time - 527040;
        } else {
            isLeapYear = true;
        }
        // At this point, time is the number of minutes in the current year. The month can then be determined.

        // This applies to any date.
        if (time >= 0) {
            month++;
        }

        // This applies only to February and later.
        if (time >= 44640) {
            time = time - 44640;
            month++;
        }

        // This applies only to March and later (considering leap year). The remaining IF statements follow the
        // same formula as before, and will not be commented in details.
        if (isLeapYear) {
            if (time >= 41760) {
                time = time - 41760;
                month++;
            }
        } else {
            if (time >= 40320) {
                time = time - 40320;
                month++;
            }
        }

        // April and later.
        if (time >= 44640) {
            time = time - 44640;
            month++;
        }

        // May and later.
        if (time >= 43200) {
            time = time - 43200;
            month++;
        }

        // June and later.
        if (time >= 44640) {
            time = time - 44640;
            month++;
        }

        // July and later.
        if (time >= 43200) {
            time = time - 43200;
            month++;
        }

        // August and later.
        if (time >= 44640) {
            time = time - 44640;
            month++;
        }

        // September and later.
        if (time >= 44640) {
            time = time - 44640;
            month++;
        }

        // October and later.
        if (time >= 43200) {
            time = time - 43200;
            month++;
        }

        // November and later.
        if (time >= 44640) {
            time = time - 44640;
            month++;
        }

        // December.
        if (time >= 43200) {
            time = time - 43200;
            month++;
        }
        return month;
    }

    public int retrieveDay(int time) {
        // Every four-year cycle, starting in 2000, has 1 leap year and 3 regular years.
        // Therefore, it contains a total of 1 * 527.040 plus 3 * 525.600 = 2.103.840 minutes
        boolean isLeapYear = false;
        time = time % 2103840;
        int month = 0;
        if (time >= 1578240) {
            // that is, if it is in the last year of a cycle
            time = time - 1578240;
        } else if (time >= 1052640) {
            // and so on, decreasing
            time = time - 1052640;
        } else if (time >= 527040) {
            time = time - 527040;
        } else {
            isLeapYear = true;
        }
        // At this point, time is the number of minutes in the current year. The month can then be determined.

        int currentDay = ((time - (time % 1440)) / 1440) + 1;

        // This applies only to February and later.
        if (time >= 44640) {
            time = time - 44640;
            currentDay = currentDay - 31;
        }

        // This applies only to March and later (considering leap year). The remaining IF statements follow the
        // same formula as before, and will not be commented in details.
        if (isLeapYear) {
            if (time >= 41760) {
                time = time - 41760;
                currentDay = currentDay - 29;
            }
        } else {
            if (time >= 40320) {
                time = time - 40320;
                currentDay = currentDay - 28;
            }
        }

        // April and later.
        if (time >= 44640) {
            time = time - 44640;
            currentDay = currentDay - 31;
        }

        // May and later.
        if (time >= 43200) {
            time = time - 43200;
            currentDay = currentDay - 30;
        }

        // June and later.
        if (time >= 44640) {
            time = time - 44640;
            currentDay = currentDay - 31;
        }

        // July and later.
        if (time >= 43200) {
            time = time - 43200;
            currentDay = currentDay - 30;
        }

        // August and later.
        if (time >= 44640) {
            time = time - 44640;
            currentDay = currentDay - 31;
        }

        // September and later.
        if (time >= 44640) {
            time = time - 44640;
            currentDay = currentDay - 31;
        }

        // October and later.
        if (time >= 43200) {
            time = time - 43200;
            currentDay = currentDay - 30;
        }

        // November and later.
        if (time >= 44640) {
            time = time - 44640;
            currentDay = currentDay - 31;
        }

        // December.
        if (time >= 43200) {
            time = time - 43200;
            currentDay = currentDay - 30;
        }

        return currentDay;
    }

    public int retrieveHour(int time) {
        int minutesOfDay = time % 1440;
        int hoursOfDay = (minutesOfDay - (minutesOfDay % 60)) / 60;
        return hoursOfDay;
    }

    public int retrieveMinute(int time) {
        int minutesOfDay = time % 1440;
        int currentMinute = minutesOfDay % 60;
        return currentMinute;
    }

    public String retrieveFullString(int time) {
        int currentMonth = this.retrieveMonth(time);
        String monthString = "";
        switch (currentMonth) {
            case 1:     monthString = "January";
                        break;
            case 2:     monthString = "February";
                         break;
            case 3:     monthString = "March";
                        break;
            case 4:     monthString = "April";
                        break;
            case 5:     monthString = "May";
                        break;
            case 6:     monthString = "June";
                        break;
            case 7:     monthString = "July";
                        break;
            case 8:     monthString = "August";
                        break;
            case 9:     monthString = "September";
                        break;
            case 10:    monthString = "October";
                        break;
            case 11:    monthString = "November";
                        break;
            case 12:    monthString = "December";
                        break;
            default:    monthString = "ERROR - Month is wrong";
        }
        String timeString = this.retrieveDay(time) + " of " + monthString + " of " + this.retrieveYear(time) +
                " at " + this.retrieveHour(time) + " hours and " + this.retrieveMinute(time) + " minutes.";
        return timeString;
    }
}