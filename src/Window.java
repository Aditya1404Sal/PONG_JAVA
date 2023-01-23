import javax.swing.JFrame;
import java.awt.*;


public class Window extends JFrame implements Runnable {

    public Graphics2D g2;

    public KL keyListener = new KL();
    public Rectangle Player;
    public Rectangle AI;
    public Rectangle ballRect;
    public PlayerController playerController;
    public Aicontroller aiController;
    public Ball ball;
    public Text leftScoreText,rightScoreText;
    public static boolean isRunning = true;

    public Window() {
        this.setSize(values.SCREEN_WIDTH, values.SCREEN_HEIGHT);
        this.setResizable(true);
        this.setVisible(true);
        this.setTitle(values.SCREEN_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();

        leftScoreText = new Text(0,new Font("Times new Roman",Font.BOLD,values.SCORE_FONT),0,values.Y_POS_SCORE_COUNTER);
        rightScoreText = new Text(0,new Font("Times new Roman",Font.BOLD,values.SCORE_FONT),values.SCREEN_WIDTH-60,values.Y_POS_SCORE_COUNTER);

        Player = new Rectangle(20,100,values.PADDLE_HEIGHT,values.PADDLE_WIDTH,values.PADDLE_COLOR);
        playerController = new PlayerController(Player,keyListener);
        AI = new Rectangle(values.SCREEN_WIDTH-40,100,values.PADDLE_HEIGHT,values.PADDLE_WIDTH,values.PADDLE_COLOR);

        ballRect = new Rectangle(300,200,values.BALL_DIMENSION,values.BALL_DIMENSION,values.PADDLE_COLOR);
        ball = new Ball(ballRect,Player,AI,leftScoreText,rightScoreText);
        aiController = new Aicontroller(new PlayerController(AI),ballRect);


        values.TOOLBAR_HEIGHT_UP = this.getInsets().top;
        values.TOOLBAR_HEIGHT_DOWN = this.getInsets().bottom;
        values.TOOLBAR_HEIGHT_RIGHT = this.getInsets().right;
        values.TOOLBAR_HEIGHT_LEFT = this.getInsets().left;
    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(),getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage,0,0,this);


        playerController.update(dt);
        ball.update(dt);
        aiController.update(dt);

    }

    private void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,values.SCREEN_WIDTH,values.SCREEN_HEIGHT);


        leftScoreText.draw(g2);
        rightScoreText.draw(g2);
        Player.Draw(g2); //paddle1
        AI.Draw(g2); //paddle2
        ballRect.Draw(g2);//ball

    }
    public void stop(){
        isRunning = false;
    }

    public void run() {
        double LastFrameTime = 0.0;
        while(isRunning) {
            double time = Timer.getTime();
            double deltaTime = time - LastFrameTime;
            LastFrameTime = time;
            update(deltaTime);

        }
        this.dispose();
        return;
    }
}