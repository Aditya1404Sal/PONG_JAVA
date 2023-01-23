import java.awt.event.KeyEvent;

public class PlayerController {
    public Rectangle rect;
    public KL Keylistener;
    public PlayerController(Rectangle rect,KL Keylistener){
        this.rect = rect;
        this.Keylistener = Keylistener;
    }
    public PlayerController(Rectangle rect){
        this.rect =  rect;
        this.Keylistener = null;
    }
    public void update(double dt){
        if(Keylistener != null) {
            if (Keylistener.IsKeyPressed(KeyEvent.VK_UP)) {
                MoveUp(dt);
            } else if (Keylistener.IsKeyPressed(KeyEvent.VK_DOWN)) {
                MoveDown(dt);
            } else if (Keylistener.IsKeyPressed(KeyEvent.VK_RIGHT)) {
                MoveRight(dt);
            } else if (Keylistener.IsKeyPressed(KeyEvent.VK_LEFT)) {
                MoveLeft(dt);
            }
        }
    }



    public void MoveUp(double dt){
        if (this.rect.y - values.PADDLE_SPEED * dt > values.TOOLBAR_HEIGHT_UP) {
            this.rect.y = (this.rect.y - values.PADDLE_SPEED * dt);
        }
    }
    public void MoveDown(double dt) {
                if ((this.rect.y + values.PADDLE_SPEED * dt) + rect.Height_Rect  < values.SCREEN_HEIGHT - values.TOOLBAR_HEIGHT_DOWN) {
                this.rect.y = (this.rect.y + values.PADDLE_SPEED * dt);
            }
        }

    public void MoveLeft(double dt){
        if(this.rect.x - values.PADDLE_SPEED * dt > values.TOOLBAR_HEIGHT_LEFT){
            this.rect.x = (this.rect.x - values.PADDLE_SPEED * dt);
        }
    }
    public void MoveRight(double dt) {
        if((this.rect.x + values.PADDLE_SPEED * dt) +rect.Width_Rect < (values.SCREEN_WIDTH + values.TOOLBAR_HEIGHT_RIGHT)/4) {
            this.rect.x = (this.rect.x + values.PADDLE_SPEED * dt);
        }
    }
    public void AIMoveLeft(double dt){
        this.rect.x = (this.rect.x - values.PADDLE_SPEED * dt);
    }

}
