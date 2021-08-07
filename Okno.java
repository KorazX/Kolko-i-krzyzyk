import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Okno {

    JFrame ramka;
    JButton nowagra= new JButton("Nowa Gra");
    PanelRysunkowy rysunkowyP;
    int [][] pole=new int[3][3];
    int x,y;
    int ruch;
    // true=1=krzyzyk
    int X,O=0;
    JLabel wygrana=new JLabel("Wygrane X:"+X+" O:"+O);
    public Okno() {
        ramka = new JFrame("Kolko i krzyzyk");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(320,373);
        ramka.setResizable(false);
        rysunkowyP = new PanelRysunkowy();

        nowagra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics gr = rysunkowyP.getGraphics();
                gr.setColor(Color.black);
                gr.clearRect(0,00,300,300);
                gr.drawLine(100, 0, 100, 300);
                gr.drawLine(200, 0, 200, 300);
                gr.drawLine(0, 100, 300, 100);
                gr.drawLine(0, 200, 300, 200);

                for(int i=0;i<3;i++)
                    for(int j=0;j<3;j++)pole[j][i]=0;
                ruch=1;
            }
        });




        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        rysunkowyP = new PanelRysunkowy();
        jp.add("Center", rysunkowyP);
        jp.add("North", nowagra);
        jp.add("South",wygrana);
        //jp.add(wygrana);
        jp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                /*
                         |         |
                  x<100  |  x<200  |
                  y<127  |         |
                         |         |
                 _____________________________
                         |         |
                         |         |
                  y<227  |         |
                         |         |
                ______________________________
                         |         |
                         |         |
                         |         |
                         |         |
                */
                Graphics gr = rysunkowyP.getGraphics();
                gr.setColor(Color.black);
                if(y<127){
                    if(x<100){if(pole[0][0]==0){
                        if(ruch==1){
                        gr.drawLine(20, 20, 60, 60);
                        gr.drawLine(60, 20, 20, 60);
                        pole[0][0]=1;
                        ruch=2;
                            wygrana(1,0,0);}
                        else{gr.drawOval(30,30,40,40);pole[0][0]=2;ruch=1;wygrana(2,0,0);}

                    }}
                    else if(x>100 & x<200){if(pole[0][1]==0){
                        if(ruch==1) {
                        gr.drawLine(120, 20, 160, 60);
                        gr.drawLine(160, 20, 120, 60);
                        pole[0][1] = 1;
                        ruch=2;
                            wygrana(1,0,1);}
                        else {gr.drawOval(130,30,40,40);pole[0][1]=2;ruch=1;wygrana(2,0,1);}

                    }}
                    else if(x>200 & x<300){if(pole[0][2]==0){
                        if(ruch==1) {
                        gr.drawLine(220, 20, 260, 60);
                        gr.drawLine(260, 20, 220, 60);
                        pole[0][2] = 1;
                        ruch=2;
                            wygrana(1,0,2);}
                        else {gr.drawOval(240,30,40,40);pole[0][2]=2;ruch=1;wygrana(2,0,2);}
                    }}}

                else if(y>127 & y<227){
                    if(x<100){if(pole[1][0]==0){
                        if(ruch==1) {
                        gr.drawLine(20, 120, 60, 160);
                        gr.drawLine(60, 120, 20, 160);
                        pole[1][0] = 1;
                        ruch=2;
                        wygrana(1,1,0);}
                        else {gr.drawOval(30,130,40,40);pole[1][0]=2;ruch=1;wygrana(2,1,0);}

                    }}
                    else if(x>100 & x<200){if(pole[1][1]==0){
                        if(ruch==1) {
                            gr.drawLine(120, 120, 160, 160);
                            gr.drawLine(160, 120, 120, 160);
                            pole[1][1] = 1;
                            ruch=2;
                            wygrana(1,1,1);}
                        else {gr.drawOval(130,130,40,40);pole[1][1]=2;ruch=1;wygrana(2,1,1);}

                    }}
                    else if(x>200 & x<300){if(pole[1][2]==0){
                        if(ruch==1) {
                            gr.drawLine(220, 120, 260, 160);
                            gr.drawLine(260, 120, 220, 160);
                            pole[1][2] = 1;
                            ruch=2;
                            wygrana(1,1,2);}
                        else {gr.drawOval(230,130,40,40);pole[1][2]=2;ruch=1;wygrana(2,1,2);}

                    }}
                }
                else if(y>227 & y<327){
                    if(x<100){if(pole[2][0]==0){
                        if(ruch==1) {
                            gr.drawLine(20, 220, 60, 260);
                            gr.drawLine(60, 220, 20, 260);
                            pole[2][0] = 1;
                            ruch=2;
                            wygrana(1,2,0);}
                        else {gr.drawOval(30,230,40,40);pole[2][0]=2;ruch=1;wygrana(2,2,0);}

                    }}
                    else if(x>100 & x<200){if(pole[2][1]==0){
                        if(ruch==1) {
                            gr.drawLine(120, 220, 160, 260);
                            gr.drawLine(160, 220, 120, 260);
                            pole[2][1] = 1;
                            ruch=2;
                            wygrana(1,2,1);}
                        else {gr.drawOval(130,230,40,40);pole[2][1]=2;ruch=1;wygrana(2,1,2);}

                    }}
                    else if(x>200 & x<300){if(pole[2][2]==0){
                        if(ruch==1) {
                            gr.drawLine(220, 220, 260, 260);
                            gr.drawLine(260, 220, 220, 260);
                            pole[2][2] = 1;
                            ruch=2;
                            wygrana(1,2,2);}
                        else {gr.drawOval(230,230,40,40);pole[2][2]=2;ruch=1;wygrana(2,2,2);}

                    }}
                }


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        ramka.add(jp);
        ramka.setVisible(true);


    }

    public void wygrana(int gracz, int wiersz, int kolumna) {

                if(pole[wiersz][0] == gracz         // 3 w wierszu
                && pole[wiersz][1] == gracz
                && pole[wiersz][2] == gracz){
                    Graphics gr = rysunkowyP.getGraphics();
                    gr.setColor(Color.blue);
                    gr.drawLine(20, 50+100*wiersz, 275, 50+100*wiersz);licznikwygranych(gracz);}
                if( pole[0][kolumna] == gracz        // 3 w kolumnie
                && pole[1][kolumna] == gracz
                && pole[2][kolumna] == gracz){
                    Graphics gr = rysunkowyP.getGraphics();
                    gr.setColor(Color.blue);
                    gr.drawLine(50+100*kolumna, 20, 50+100*kolumna, 270);licznikwygranych(gracz);}
                if(wiersz == kolumna                // 3 diagonalnie
                && pole[0][0] == gracz
                && pole[1][1] == gracz
                && pole[2][2] == gracz){
                    Graphics gr = rysunkowyP.getGraphics();
                    gr.setColor(Color.blue);
                    gr.drawLine(50, 50, 260, 260);licznikwygranych(gracz);}
                if(wiersz + kolumna == 2            // 3 przeciwna diagonalna
                && pole[0][2] == gracz
                && pole[1][1] == gracz
                && pole[2][0] == gracz){
                    Graphics gr = rysunkowyP.getGraphics();
                    gr.setColor(Color.blue);
                    gr.drawLine(260, 20, 20, 260);licznikwygranych(gracz);}

    }
    void licznikwygranych(int gracz){
        if(gracz==1)X++;else O++;wygrana.setText("Wygrane X:"+X+" O:"+O);}
}

class PanelRysunkowy extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }
}
