import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        int fromYear = 2010;
        int toYear = 2015;
        printBonusDatesBetween(fromYear, toYear);

        /* tests */
        //fromYear = 2020;
        //toYear = 2020;
        //printBonusDatesBetween(fromYear, toYear); //same yers
        //fromYear = -2013;
        //toYear = 2023;
        //printBonusDatesBetween(fromYear, toYear); // negative first
        //fromYear = 2013;
        //toYear = -2023;
        //printBonusDatesBetween(fromYear, toYear);// negative second
        //fromYear = 2020;
        //toYear = 1987;
        //printBonusDatesBetween(fromYear, toYear); //bad years order
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear < 0 || toYear < 0) {
            System.out.println("Please change the data to non-negative data");
            return;
        }
        if (fromYear > toYear) {
            System.out.println("Please change the data in order from smallest to largest");
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat outputDate = new SimpleDateFormat("yyyy-MM-dd");

        for (int year = fromYear; year <= toYear; year++) {
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= 31; day++) {
                    try {
                        String dateStr = String.format("%04d%02d%02d", year, month, day);
                        Date date = simpleDateFormat.parse(dateStr);
                        String checkDate = simpleDateFormat.format(date);
                        String reverseDate = new StringBuilder(checkDate).reverse().toString();
                        if (checkDate.equals(reverseDate)) {
                            String resultDate = outputDate.format(date);
                            System.out.println(resultDate);
                        }
                    } catch (Exception e){
                    }

                }
            }
        }
    }
}

