public class Main {
    public static int state = 0;
    public static Thread MAINTHREAD;
    public static MainMenu menu;
    public static Window window;
    public static void main(String[] args) {
         menu = new MainMenu();
         MAINTHREAD = new Thread(menu);
        MAINTHREAD.start();
    }
    public static void changeState(int newState){
        if(newState == 1 && state == 0){
            menu.stop();
            window = new Window();
            MAINTHREAD = new Thread(window);
            MAINTHREAD.start();
        } else if( newState == 2){
            if(window != null)
                window.stop();
            if(menu != null){
                menu.stop();
            }
        }
    }
}