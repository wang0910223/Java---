import java.awt.Color;
import java.util.Random;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class bouncingball extends JPanel{
    private ArrayList<Ball> balls;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new bouncingball());
        frame.pack();
        frame.setVisible(true);

        new Thread( ()->{
            while(true){
                frame.repaint();
                try{
                    Thread.sleep(30);
                } catch(Exception e){
                    break;
                }
            }
        }).start();
    }

    public bouncingball() {
        //新增預先存在的20個球
        balls = new ArrayList<Ball>();
        for (int i = 0; i <20 ; i++) {
            int x = (int) Math.floor(Math.random() * 600), y = (int) Math.floor(Math.random() * 600);
            Ball tmp = new Ball(x, y);
            balls.add(tmp);
            repaint();
            Thread gameThread = new Thread(tmp);
            gameThread.start();
        }

        this.setPreferredSize(new Dimension(600,600));
        this.setBackground(Color.WHITE);
        this.addMouseListener(new ClickListener());
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball a : balls) {
            a.draw(g);
        }
    }
    
    //點擊滑鼠增加新的球
    private class ClickListener extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            Ball tmp = new Ball(e.getX(),e.getY());
            balls.add(tmp);
            repaint();
            Thread gameThread = new Thread(tmp);
            gameThread.start();
        }
    }
    
    
}

class Ball extends JComponent implements Runnable{
    private int posX, posY, vx, vy,size;
    private Color color;
    
    public Ball(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.size = (int) Math.floor(Math.random() * 20) + 20;
        this.color = new Color((int) Math.floor((Math.random() * 256)), (int) Math.floor((Math.random() * 256)), (int) Math.floor((Math.random() * 256)));
        this.vx = (int) Math.floor((Math.random() * 15) +1);
        this.vy = (int) Math.floor((Math.random() * 15) +1);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(posX, posY, size, size);
    }

    //處理球的移動路徑，碰到邊緣反彈
    public void move() {
        if (posX < 0) vx = -vx;
        else if(posX > 600) vx = -vx;
        if (posY < 0) vy = -vy;
        else if(posY > 600) vy = -vy;
        posX +=vx;
        posY +=vy;
    }

    @Override
    public void run() {
            while(!Thread.interrupted()) {
            move();
            repaint();
            try {
                Thread.sleep(60);
            } catch (InterruptedException ex) {}
            }
    }
}