import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        double i = 1000;
//        System.out.println((i * 10 / 100) /12);
//        GregorianCalendar gregorianCalendar = new GregorianCalendar();
//        System.out.print("ENTER THE YEAR: ");
//        int yr = scanner.nextInt();
//        for (int i=1;i<=yr;i++){
//            int year = gregorianCalendar.get(Calendar.YEAR);
//            gregorianCalendar.add(Calendar.YEAR,1);
//            System.out.println(year);
//            for (int j=1;j<=(yr+10);j++){
//                System.out.println("Month " + j);
//                System.out.println(i);
//                System.out.println(j);
//            }
//        }
        String yyyy = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(yyyy);

        int year = Integer.parseInt(dateFormat.format(new Date()));
        System.out.println(year);
        year += 1;
        System.out.println(year);
    }
}
