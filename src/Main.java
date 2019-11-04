import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

JFrame okno = new JFrame();
JPanel menu = new JPanel();
JPanel menuGame = new JPanel();
JButton start = new JButton();
public static Main mama;
JLabel done = new JLabel();
JLabel clientN = new JLabel();
private JButton line = new JButton();
private JButton game1;
private JButton game2;
private JButton game3;
private JButton game4;
public static JButton vubor;
private Image Igame1;
private Image Igame2;
private Image Igame3;
private Image Igame4;
private Image Ivubor;
public static int position;
public static boolean inMenu = true;
public static int H;
public static int W;
public static int IconGameSize;
public static int sizePortH;
public static int sizePortW;
public static int sizeClientCountH;
public static int sizeClientCountW;
public static int PortToLineY;
public static int sizeLineH;
public static int IconGameToIconGameX;
public static int IconGameToIconGameY;
public static int SizeVybor;
public static int LineToIcon;
public static int SideToIcon;


    public static void main(String[] args){
        mama = new Main();
    }

    public Main() {
        okno.setLocation(100, 5);
        okno.setTitle("Консоль. Версия: Очень alpha");
        //okno.setExtendedState(Frame.MAXIMIZED_BOTH);
        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        okno.setUndecorated(true);
        okno.setLocation(0,0);
        okno.setSize(tk.getScreenSize().width,tk.getScreenSize().height);
        System.out.println(okno.getSize()); //TODO:
        H = tk.getScreenSize().height;
        W = tk.getScreenSize().width;
        menu.setLocation(0,0);
        menu.setSize(W,H);
        menu.setBackground(Color.GREEN);
        menu.setLayout(null);
        start.setBounds(100,100,200,50);
        start.setText("Запустить сервер");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Server server = new Server();
                server.main= mama;
            }
        });
        okno.add(menu);
        menu.add(start);
        okno.setVisible(true);

    }

    public void loadImage(int size){
        System.out.println(size);
        ImageIcon foj = new ImageIcon("res/icon/game1.png");
        Igame1 = foj.getImage();
        ImageIcon fod = new ImageIcon("res/icon/game1.png");
        Igame2 = fod.getImage();
        ImageIcon fof = new ImageIcon("res/icon/game1.png");
        Igame3 = fof.getImage();
        ImageIcon foh = new ImageIcon("res/icon/game1.png");
        Igame4 = foh.getImage();
        Igame1 = Igame1.getScaledInstance(size,size,Image.SCALE_SMOOTH);
        Igame2 = Igame2.getScaledInstance(size,size,Image.SCALE_SMOOTH);
        Igame3 = Igame3.getScaledInstance(size,size,Image.SCALE_SMOOTH);
        Igame4 = Igame4.getScaledInstance(size,size,Image.SCALE_SMOOTH);
        game1 = new JButton(new ImageIcon(Igame1));
        game2 = new JButton(new ImageIcon(Igame2));
        game3 = new JButton(new ImageIcon(Igame3));
        game4 = new JButton(new ImageIcon(Igame4));
        game1.setBounds(SideToIcon, LineToIcon+sizeClientCountH+sizeLineH+PortToLineY,size,size);
        game1.setOpaque(false);
        game1.setContentAreaFilled(false);
        game1.setBorderPainted(false);
        game4.setBounds(SideToIcon,LineToIcon+sizeClientCountH+sizeLineH+PortToLineY+IconGameToIconGameY+IconGameSize,size,size);
        game4.setOpaque(false);
        game4.setContentAreaFilled(false);
        game4.setBorderPainted(false);
        game2.setBounds(SideToIcon+IconGameSize+IconGameToIconGameX,LineToIcon+sizeClientCountH+sizeLineH+PortToLineY,size,size);
        game2.setOpaque(false);
        game2.setContentAreaFilled(false);
        game2.setBorderPainted(false);
        game3.setBounds(SideToIcon+IconGameSize*2+IconGameToIconGameX*2,LineToIcon+sizeClientCountH+sizeLineH+PortToLineY,size,size);
        game3.setOpaque(false);
        game3.setContentAreaFilled(false);
        game3.setBorderPainted(false);
        ImageIcon vy = new ImageIcon("res/icon/set.png");
        Ivubor = vy.getImage();
        Ivubor = Ivubor.getScaledInstance(size+10,size+10,Image.SCALE_SMOOTH);
        vubor = new JButton(new ImageIcon(Ivubor));
        vubor.setBounds(SideToIcon-5,LineToIcon+sizeClientCountH+sizeLineH+PortToLineY-5,size+10,size+10);
        position=1;
        vubor.setOpaque(false);
        vubor.setContentAreaFilled(false);
        vubor.setBorderPainted(false);
        menuGame.add(vubor);
        menuGame.add(game2);
        menuGame.add(game3);
        menuGame.add(game4);
        menuGame.add(game1);
        buildMenu();
    }

    public void checkPosition(){
        int sizeGameIcon = (int)(H*40)/100;
        int sizeGameIconh = (int)(W*25)/100;
        IconGameSize = sizeGameIcon>sizeGameIconh? sizeGameIconh : sizeGameIcon;
        SizeVybor = IconGameSize+10;
        System.out.println(sizeGameIcon);
        sizePortH = (int)(H*2.5)/100;
        sizePortW = (int)(W*50)/100;
        sizeClientCountH = sizePortH;
        sizeClientCountW = (int)(W*4.2)/100+50;
        PortToLineY = sizePortH+5;
        sizeLineH =8;
        LineToIcon = (int) (H*0.8)/100;
        SideToIcon = (int) (W*5.8)/100;
        IconGameToIconGameX = (int)(W*4.65)/100;
        IconGameToIconGameY = (int)(H*2.63)/100;
        loadImage(IconGameSize);
    }

    private void buildMenu() {
        menuGame.setBounds(0, 0, W, H);
        menuGame.setBackground(Color.LIGHT_GRAY);
        done.setBounds(10, 0, sizePortW, sizePortH);
        clientN.setBounds(sizePortW+20, 0, sizeClientCountW, sizeClientCountH);
        line.setBounds(-10, PortToLineY, W+100, 5);
        line.setEnabled(false);
        menuGame.add(done);
        menuGame.add(clientN);
        menuGame.add(line);
        menuGame.setLayout(null);
    }

}