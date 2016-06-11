
import java.util.*;

import org.springframework.dao.support.DataAccessUtils;

import com.online.util.DateUtil;
class Test 
{
    public static void main(String[] args)
    {
        String test = "2016-6-10";
        System.out.println(DateUtil.getWeek(test, "-"));
    }   
}