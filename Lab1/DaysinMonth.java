import java.util.Scanner;

public class DaysinMonth {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        String[] mLong = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        String[] mAbbre = {"jan.", "feb.", "mar.", "apr.", "may", "june", "july", "aug.", "sept.", "oct.", "nov.", "dec."};
        String[] mShort = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        String[] mNum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month = -1; // from 0 to 11
        int year = -1;

        while (true) {
            System.out.println("Input month: ");
            String inp = keyboard.nextLine().toLowerCase();

            String[] searchIn;
            if (inp.length() == 3) {
                searchIn = mShort;
            } else if (inp.length() == 4 || inp.equals("sept.")) {
                searchIn = mAbbre;
            } else if (inp.length() < 3) {
                searchIn = mNum;
            } else {
                searchIn = mLong;
            }

            for (int i = 0; i<12; i++) {
                if (inp.equals(searchIn[i])) {
                    month = i;
                    break;
                }
            }

            if (month == -1) {
                System.out.println("Invalid input! Please try again.");
            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.println("Input year: ");
                year = keyboard.nextInt();
                if (year < 0) {
                    throw new Exception("Invalid year");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input! Please try again.");
                keyboard.nextLine();
            }
        }
        
        keyboard.close();

        if (month == 1 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) { //febuary in leap year
            System.out.println(29);
        } else {
            System.out.println("Days: "+day[month]);
        }        
    }
}
