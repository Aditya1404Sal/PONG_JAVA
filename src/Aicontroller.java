public class Aicontroller {
    public PlayerController playerController;
    public Rectangle ball;
    public Aicontroller(PlayerController plrController,Rectangle ball){
        this.playerController = plrController;
        this.ball= ball;
    }
    public void update(double dt){
        playerController.update(dt);
        if(ball.y < playerController.rect.y){
            playerController.MoveUp(dt);
        } else if (ball.y + ball.Height_Rect > playerController.rect.y + playerController.rect.Height_Rect){
            playerController.MoveDown(dt);
        } else if (ball.x + ball.Width_Rect > playerController.rect.x + playerController.rect.Width_Rect) {
            playerController.MoveRight(dt);
        } else if(ball.x - values.PADDLE_SPEED * dt > (values.SCREEN_WIDTH*values.AI_CONSTRAINT)){
            if ((ball.x) < playerController.rect.x) {
                playerController.AIMoveLeft(dt);
        }
        }
    }
}
