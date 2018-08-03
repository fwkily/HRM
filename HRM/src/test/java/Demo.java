import com.gwy.util.DateAndString;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by destiny on 2018/8/2/0002.
 */
public class Demo {
    @Test
    public void test(){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.YEAR;
        int month=calendar.get(calendar.MONTH);
        int day = calendar.get(calendar.DAY_OF_MONTH);
        System.out.println(year+" "+month+" "+day);
    }
    @Test
    public void test1(){
        Date date = new Date();
        System.out.println(DateAndString.dateToStringTime1(date));
    }
}
