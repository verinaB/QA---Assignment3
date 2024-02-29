public class App {
    // Function to calculate the next date from the given date
    public static String getNextDate(int currentDay, int currentMonth, int currentYear) {
        // Number of days in each month
        int[] monthDays = {31, isLeapYear(currentYear) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Validate input date
        if (!isValidDate(currentDay, currentMonth, currentYear)) {
            return "ERROR: Date is not valid.";
        }

        // Handle the special case for the end of time boundary
        if (currentDay == 31 && currentMonth == 12 && currentYear == 2212) {
            return "1/1/2213";
        }

        // Calculate next day
        int nextDay = currentDay;
        int nextMonth = currentMonth;
        int nextYear = currentYear;

        nextDay++; // Move to the next day

        // Check if the new day is beyond the current month's days
        if (nextDay > monthDays[currentMonth - 1]) {
            nextDay = 1; // Reset to the first day
            nextMonth++; // Move to the next month

            if (nextMonth > 12) { // Check if the new month is beyond a year
                nextMonth = 1; // Reset to January
                nextYear++; // Move to the next year
            }
        }

        // Build the next date string
        return nextDay + "/" + nextMonth + "/" + nextYear;
    }

    // Helper function to check for leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    // Helper function to validate the input date
    private static boolean isValidDate(int day, int month, int year) {
        int[] monthDays = {31, isLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return year >= 1812 && year <= 2212 && month >= 1 && month <= 12 && day >= 1 && day <= monthDays[month - 1];
    }
}
/*
public static void main String [args]{
        System.out.println (getNextDate(31, 3, 2024)
        }*/