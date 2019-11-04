import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tetris extends JPanel implements ActionListener {

    private Timer times;
    public ArrayList<JButton> pole = new ArrayList<JButton>();
    public ArrayList<JButton> line = new ArrayList<JButton>();
    public ArrayList<JButton> side = new ArrayList<JButton>();
    private ArrayList<JButton> pline = new ArrayList<JButton>();
    private ArrayList<JButton> dline = new ArrayList<JButton>();
    private JPanel[] Pole;
    private Image Ifon;
    public static int Playercount;
    private int SizePole;
    private int[] LocationPoleX;
    private int[] LocationPoleY;


    public Tetris(int count){
        Playercount=count;
        LocationPoleX = new int[Playercount];
        LocationPoleY = new int[Playercount];
        Pole = new JPanel[Playercount];
        switch (Playercount){
            case 1:
                SizePole = Main.H;
                break;
            case 2:
                int h = Main.H/2;
                int w= Main.W/2;
                SizePole =(h<w ? h:w);
                break;
            case 3:
                SizePole =(Main.W/3);
                break;
            case 4 :
                SizePole =(Main.H/2);
                break;
            case 5:
                SizePole =(Main.W/4);
                break;
            case 6:
                SizePole =(Main.W/4);
                break;
            case 7:
                SizePole =(Main.W/4);
                break;
            case 8:
                SizePole =(Main.W/4);
                break;
        }
        setPosPoles();
        setLocation(0,0);
        setSize(Main.W,Main.H);
        setLayout(null);
        setBackground(Color.PINK);
        loadImage();
        checkAndSetPos(count);
        times = new Timer(250,this);
        times.start();

    }
    private void setPosPoles(){
        switch (Playercount){
            case 1:
                LocationPoleX[0]=Main.W/2+SizePole/2;
                LocationPoleY[0]=0;
                break;
            case 2:
                LocationPoleX[0]=Main.W/2-SizePole;
                LocationPoleX[1]=Main.W/2+SizePole;
                LocationPoleY[0]=0;
                LocationPoleY[1]=0;
                break;
            case 3:
                LocationPoleX[0]=0;
                LocationPoleX[1]=Main.W/3;
                LocationPoleX[2]=Main.W/3*2;
                LocationPoleY[0]=Main.H/2+SizePole/2;
                LocationPoleY[1]=LocationPoleY[0];
                LocationPoleY[2]=LocationPoleY[0];
                break;
            case 4:
                LocationPoleX[0]=Main.W/2-SizePole;
                LocationPoleX[1]=Main.W/2+SizePole;
                LocationPoleX[2]=LocationPoleX[0];
                LocationPoleX[3]=LocationPoleX[1];
                LocationPoleY[0]=0;
                LocationPoleY[1]=0;
                LocationPoleY[2]=SizePole;
                LocationPoleY[3]=SizePole;
                break;
            case 5:
                LocationPoleX[0]=0;
                LocationPoleX[1]=SizePole;
                LocationPoleX[2]=SizePole*2;
                LocationPoleX[3]=SizePole*3;
                LocationPoleX[4]=Main.W/2-SizePole/2;
                for(int i = 0;i<4;i++){
                    LocationPoleY[i]=0;
                }
                LocationPoleY[4]=SizePole;
                break;
            case 6:
                LocationPoleX[0]=0;
                LocationPoleX[1]=SizePole;
                LocationPoleX[2]=SizePole*2;
                LocationPoleX[3]=SizePole*3;
                LocationPoleX[4]=Main.W/2-SizePole;
                LocationPoleX[5]=Main.W/2+SizePole;
                for(int i = 0;i<4;i++){
                    LocationPoleY[i]=0;
                }
                LocationPoleY[4]=SizePole;
                LocationPoleY[5]=SizePole;
                break;
            case 7:
                LocationPoleX[0]=0;
                LocationPoleX[1]=SizePole;
                LocationPoleX[2]=SizePole*2;
                LocationPoleX[3]=SizePole*3;
                int smalllol=(Main.W-SizePole*3)/2;
                LocationPoleX[4]=smalllol;
                LocationPoleX[5]=LocationPoleX[4]+SizePole;
                LocationPoleX[6]=LocationPoleX[5]+SizePole;
                for(int i = 0;i<4;i++){
                    LocationPoleY[i]=0;
                }for(int i = 4;i<7;i++){
                LocationPoleY[i]=SizePole;
                }
                break;
            case 8:
                LocationPoleX[0]=0;
                LocationPoleX[1]=SizePole;
                LocationPoleX[2]=SizePole*2;
                LocationPoleX[3]=SizePole*3;
                LocationPoleX[4]=0;
                LocationPoleX[5]=SizePole;
                LocationPoleX[6]=SizePole*2;
                LocationPoleX[7]=SizePole*3;
                for(int i = 0;i<4;i++){
                    LocationPoleY[i]=0;
                }for(int i = 4;i<8;i++){
                LocationPoleY[i]=SizePole;
            }

        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    private void loadImage(){
        ImageIcon foh = new ImageIcon("res/icon/game1.png");
        Ifon = foh.getImage();
    }

    private void checkAndSetPos(int count){
        for(int i = 0;i<count;i++) {
            pole.add(new JButton(/*new ImageIcon(Ifon)*/));
            line.add(new JButton());
            side.add(new JButton());
            //pole.get(i).setOpaque(false);
            pole.get(i).setContentAreaFilled(false);
            pole.get(i).setBorderPainted(false);
            pole.get(i).setEnabled(false);
            line.get(i).setOpaque(false);
            line.get(i).setContentAreaFilled(false);
            line.get(i).setBorderPainted(false);
            side.get(i).setOpaque(false);
            side.get(i).setContentAreaFilled(false);
            side.get(i).setBorderPainted(false);
            if (count <= 2) {
                switch (i) {
                    case 0:
                        pole.get(i).setBounds(0, 0, 390, 660);
                        line.get(i).setBounds(240, 0, 5, 660);
                        side.get(i).setBounds(245, 0, 145,660);
                        break;
                    case 1:
                        pole.get(i).setBounds(400, 0, 390, 660);
                        line.get(i).setBounds(640, 0, 5, 660);
                        side.get(i).setBounds(645, 0, 145,660);
                        break;

                }
            }else{

            }
            System.out.println(i);
        }
        switch (count){

        }
        for(int i = 0;i<count;i++) {
            add(pole.get(i));
            add(side.get(i));

        }
        for(int i = 0;i<20;i++){
            pline.add(new JButton());
            pline.get(i).setEnabled(false);
            pline.get(i).setBounds(0,30+30*i,300,1);
            pline.get(i).setBackground(Color.BLACK);
            add(pline.get(i));
        }
        for(int i = 0;i<10;i++){
            dline.add(new JButton());
            dline.get(i).setEnabled(false);
            dline.get(i).setBounds(30+30*i,0,1,600);
            pline.get(i).setBackground(Color.BLACK);
            add(dline.get(i));
        }
        repaint();
    }

}
