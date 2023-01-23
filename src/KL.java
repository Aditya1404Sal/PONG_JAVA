import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KL implements KeyListener {
    private final boolean[] keyPressed = new boolean[128];

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent KeyEvent) {
        keyPressed[KeyEvent.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent KeyEvent) {
        keyPressed[KeyEvent.getKeyCode()] = false;
    }
    public boolean IsKeyPressed(int KeyCode){
        return keyPressed[KeyCode];
    }
}
