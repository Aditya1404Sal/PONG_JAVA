import javax.swing.*;
import java.awt.*;


    public class MainMenu extends JFrame implements Runnable {

        public Graphics2D g2;

        public KL keyListener = new KL();
        public Text startGame , exitGame , Title;
        public ML mouseListener = new ML();
        public boolean isRunning = true;


        public MainMenu() {
            this.setSize(values.SCREEN_WIDTH, values.SCREEN_HEIGHT);
            this.setResizable(true);
            this.setVisible(true);
            this.setTitle(values.SCREEN_TITLE);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.addKeyListener(keyListener);
            this.addMouseListener(mouseListener);
            this.addMouseMotionListener(mouseListener);
            this.startGame = new Text("Start game", new Font("Times New Roman",Font.BOLD,33),(float)values.SCREEN_WIDTH/2 -110,(float)values.SCREEN_HEIGHT/2,Color.WHITE);
            this.exitGame = new Text("Exit",new Font("Times New Roman",Font.BOLD,26),(float)values.SCREEN_WIDTH/2 - 40,(float)values.SCREEN_HEIGHT/2 + 60,Color.WHITE);
            this.Title = new Text("Pong",new Font("Times New Roman",Font.PLAIN,200),(float)values.SCREEN_WIDTH/2-270,(float)values.SCREEN_HEIGHT/2 - 100,Color.WHITE);
            g2 = (Graphics2D)this.getGraphics();

        }

        public void update(double dt) {
            Image dbImage = createImage(getWidth(),getHeight());
            Graphics dbg = dbImage.getGraphics();
            this.draw(dbg);
            g2.drawImage(dbImage,0,0,this);
            if(mouseListener.getMouseX() > startGame.x && mouseListener.getMouseX() < startGame.x + startGame.width &&
            mouseListener.getMouseY() > startGame.y - startGame.height / 2 && mouseListener.getMouseY() < startGame.y + startGame.height / 2){
                startGame.color = new Color(212, 224, 114);

                if(mouseListener.isMousePressed()){
                    Main.changeState(1);
                }

            } else {
                startGame.color = Color.WHITE;
            }
            if(mouseListener.getMouseX() > exitGame.x && mouseListener.getMouseX() < exitGame.x + exitGame.width &&
                    mouseListener.getMouseY() > exitGame.y - exitGame.height / 2 && mouseListener.getMouseY() < exitGame.y + exitGame.height / 2){
                exitGame.color = new Color(212, 224, 114);
                if(mouseListener.isMousePressed()){
                    Main.changeState(2);
                }
            } else {
                exitGame.color = Color.WHITE;
            }



        }

        private void draw(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.setColor(Color.BLACK);
            g2.fillRect(0,0,values.SCREEN_WIDTH,values.SCREEN_HEIGHT);

            startGame.draw(g2);
            exitGame.draw(g2);
            Title.draw(g2);

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
        }
    }

