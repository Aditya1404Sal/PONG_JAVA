public class Timer{
    public static double Starting_time = System.nanoTime();
    public static double getTime(){
        return (System.nanoTime() - Starting_time)*1E-9;
    }
}
