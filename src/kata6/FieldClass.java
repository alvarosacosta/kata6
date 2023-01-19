package kata6;

import com.google.gson.Gson;
import java.lang.reflect.Field;
import kata6.IamTheOneWhoKnocks;

public class FieldClass {
    
    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        Class c = IamTheOneWhoKnocks.class;
        IamTheOneWhoKnocks knocking = new IamTheOneWhoKnocks();
        Field[] fields = c.getDeclaredFields();
        
        int i = 10;
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getType() == String.class) field.set(knocking, String.valueOf(i));
            i+=10;
        }
        System.out.println(new Gson().toJson(knocking));
    }
}
