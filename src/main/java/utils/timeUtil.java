package utils;

public class timeUtil {

    public static void timeOut(TimeSeconds seconds){
        try{
            Thread.sleep(seconds.getSeconds()* 1000L);
        }catch (Exception ignored){
        }
    }

    public static boolean isEqual(Object actual1, Object actual2) {
        if (actual1 == null && actual2 == null) {
            return true;
        }
        if (actual1 == null || actual2 == null) {
            return false;
        }
        return actual1.equals(actual2);
    }
}
