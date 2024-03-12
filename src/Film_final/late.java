
package Film_final;

import java.io.BufferedReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class late {
    long d2;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    late(String a) throws ParseException
    {Date b=new Date();
        if(b.after(sdf.parse(a)))
        {
            long d=b.getTime()-sdf.parse(a).getTime();
            TimeUnit time = TimeUnit.DAYS; 
        d2 = time.convert(d, TimeUnit.MILLISECONDS);
            
        }
        
        
                    
    }
}
