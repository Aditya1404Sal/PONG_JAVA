public class Ball {
    public Rectangle rect;
    public Rectangle leftPaddle, rightPaddle;
    public static double vy = 10;
    public static double vx = -150;
    public Text rightScoreText;
    public Text leftScoreText;

    public Ball(Rectangle rect, Rectangle leftPaddle, Rectangle rightPaddle, Text leftScoreText, Text rightScoreText) {
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;
        this.rect = rect;
        this.leftScoreText = leftScoreText;
        this.rightScoreText = rightScoreText;
    }

    public double calculateNewVelocityAngle(Rectangle paddle){
        double RelativeIntersectY = (paddle.y + (paddle.Height_Rect / 2.0)) - (this.rect.y + (this.rect.Height_Rect / 2.0));
        double normalIntersectY = RelativeIntersectY / (paddle.Height_Rect / 2.0);
        double theta = normalIntersectY * values.Max_Angle;
        return Math.toRadians(theta);
    }

    public void update(double dt) {
        if (vx < 0.0) {
            if (this.rect.x <= this.leftPaddle.x + this.leftPaddle.Width_Rect
                    && this.rect.x + this.rect.Width_Rect >= this.leftPaddle.x
                    && this.rect.y >= this.leftPaddle.y
                    && this.rect.y <= this.leftPaddle.y + this.leftPaddle.Height_Rect) {
                double theta = calculateNewVelocityAngle(leftPaddle);
                double newVx = Math.abs((Math.cos(theta)) * values.BALL_SPEED);
                double newVy = (-Math.sin(theta)) * values.BALL_SPEED;
               double diff = Math.abs(values.SCREEN_WIDTH/2 - this.rect.x);
               double diff2 = Math.abs(values.SCREEN_HEIGHT/2 - this.rect.y);
                double oldSign = Math.signum(vx);
                vx = (newVx * (-1.0 * oldSign))*diff/values.X_axis_Factor;
                vy = newVy*diff/values.Y_axis_Factor;
            }
        } else if (vx > 0.0) {
            if (this.rect.x + this.rect.Width_Rect >= this.rightPaddle.x
                    && this.rect.x <= this.rightPaddle.x + this.rightPaddle.Width_Rect
                    && this.rect.y >= this.rightPaddle.y
                    && this.rect.y <= this.rightPaddle.y + this.rightPaddle.Height_Rect) {
               double theta = calculateNewVelocityAngle(rightPaddle);
               double newVx = Math.abs((Math.cos(theta)) * values.BALL_SPEED);
               double newVy = (-Math.sin(theta)) * values.BALL_SPEED;
                double diff = Math.abs(values.SCREEN_WIDTH/2 - this.rect.x);
                double diff2 = Math.abs(values.SCREEN_HEIGHT/2 - this.rect.y);
                double oldSign = Math.signum(vx);
                vx = (newVx * (-1.0 * oldSign))*diff/values.X_axis_Factor;
                vy = newVy*diff/values.Y_axis_Factor;



           /* } else if (this.rect.x + this.rect.Width_Rect > this.rightPaddle.x + this.rightPaddle.Width_Rect) {
                System.out.println("AI has lost");
            } else if (this.rect.x + this.rect.Width_Rect < this.leftPaddle.x + this.leftPaddle.Width_Rect) {
                System.out.println("You lost");
            */}
        }

        if (vy > 0) {
            if (this.rect.y + this.rect.Height_Rect > values.SCREEN_HEIGHT) {
                vy *= -1;
            }
        } else if (vy < 0) {
            if (this.rect.y < values.TOOLBAR_HEIGHT_UP) {
                vy *= -1;
            }
        }



        this.rect.x +=vx *dt;
        this.rect.y +=vy *dt;
        if(this.rect.x + this.rect.Width_Rect < 0){
            int rightScore = Integer.parseInt(rightScoreText.text);
            rightScore++;
            rightScoreText.text = "" + rightScore;
            this.rect.x = values.SCREEN_WIDTH / 2.0;
            this.rect.y = values.SCREEN_HEIGHT / 2.0;
            vx = -150;
            vy = 10;
            if(rightScore >= values.WINNING_SCORE){
                Main.changeState(2);
            }
        }else if(this.rect.x + this.rect.Width_Rect > values.SCREEN_WIDTH - values.TOOLBAR_HEIGHT_RIGHT){
            int leftScore = Integer.parseInt(leftScoreText.text);
            leftScore++;
            leftScoreText.text = "" + leftScore;
            this.rect.x = values.SCREEN_WIDTH / 2.0;
            this.rect.y = values.SCREEN_HEIGHT / 2.0;
            vx = 150;
            vy = 10;
            if(leftScore >= values.WINNING_SCORE){
                Main.changeState(2);
            }
        }
    }
}

