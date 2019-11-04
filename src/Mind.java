public class Mind {

    public static void go(String msg){
        going going = new going();
        going.msgg(msg);
        going.start();
    }


}

class going extends Thread {
    private String msg;
    public void msgg(String g){
        msg=g;
    }
    @Override
    public void run() {
        int whois = 523;
        String comand;
        String [] a = msg.split(":");
        comand = a[1];
        if(Main.inMenu){
            if(a[0].equals("admin")){
                whois =1;
            }else{
                whois=2;
            }
        }
        if(Main.inMenu&&whois==1){
            int count = 242;
            if(comand.equals("Up")){
                count=1;
            }else if(comand.equals("Down")){
                count=2;
            }else if(comand.equals("Rigth")){
                count=3;
            }else if(comand.equals("Left")){
                count=4;
            }else if(comand.equals("Press")){
                count=5;
            }
            switch (count){
                case 1:
                    if(Main.position>3){
                        Main.vubor.setLocation(Main.vubor.getLocation().x,Main.vubor.getLocation().y-Main.IconGameSize-Main.IconGameToIconGameY);
                        Main.position-=3;
                    }
                    break;
                case 2:
                    if(Main.position<4){
                        Main.vubor.setLocation(Main.vubor.getLocation().x,Main.vubor.getLocation().y+Main.IconGameSize+Main.IconGameToIconGameY);
                        Main.position+=3;
                    }
                    break;
                case 3:
                    if(!(Main.position==3||Main.position==6)){
                        Main.vubor.setLocation(Main.vubor.getLocation().x+Main.IconGameSize+Main.IconGameToIconGameX,Main.vubor.getLocation().y);
                        Main.position++;
                    }
                    break;
                case 4:
                    if(!(Main.position==1||Main.position==4)){
                        Main.vubor.setLocation(Main.vubor.getLocation().x-Main.IconGameSize-Main.IconGameToIconGameX,Main.vubor.getLocation().y);
                        Main.position--;
                    }
                    break;
                case 5:
                    Main.inMenu=false;
                    Server.main.okno.remove(Server.main.menuGame);
                    Server.main.okno.add(new Tetris(ClientHandler.clients_count));
                    Server.main.okno.repaint();
                    break;
            }
        }
    }
}