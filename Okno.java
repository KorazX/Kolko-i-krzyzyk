import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Okno {

    JFrame ramka;
    JButton nowagra= new JButton("Nowa Gra");
    PanelRysunkowy rysunkowyP;
    int [][] poleGry=new int[3][3];
    int x,y; //wspolrzedne klikniecia myszka

    int czyjRuch; // 1==krzyzyk  2==kolko
    int liczbaWygranychX, liczbaWygranychO = 0;
    JLabel wygrana=new JLabel("Wygrane X:"+liczbaWygranychX+" O:"+ liczbaWygranychO);
    public Okno() {
        ramka = new JFrame("Kolko i krzyzyk");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(320,373);
        ramka.setResizable(false);
        rysunkowyP = new PanelRysunkowy();

        nowagra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RysujNowaGre();
            }
        });

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        rysunkowyP = new PanelRysunkowy();
        jp.add("North", nowagra);
        jp.add("Center", rysunkowyP);
        jp.add("South",wygrana);

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
                    if(x<100){if(poleGry[0][0]==0){
                        if(czyjRuch ==1){
                            gr.drawLine(20, 20, 60, 60);
                            gr.drawLine(60, 20, 20, 60);
                            poleGry[0][0]=1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,0,0);}
                        else{
                            gr.drawOval(30,30,40,40);
                            poleGry[0][0]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,0,0);}

                    }}
                    else if(x>100 & x<200){if(poleGry[0][1]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(120, 20, 160, 60);
                            gr.drawLine(160, 20, 120, 60);
                            poleGry[0][1] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,0,1);}
                        else {
                            gr.drawOval(130,30,40,40);
                            poleGry[0][1]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,0,1);}

                    }}
                    else if(x>200 & x<300){if(poleGry[0][2]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(220, 20, 260, 60);
                            gr.drawLine(260, 20, 220, 60);
                            poleGry[0][2] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,0,2);}
                        else {
                            gr.drawOval(240,30,40,40);
                            poleGry[0][2]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,0,2);}
                    }}}

                else if(y>127 & y<227){
                    if(x<100){if(poleGry[1][0]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(20, 120, 60, 160);
                            gr.drawLine(60, 120, 20, 160);
                            poleGry[1][0] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,1,0);}
                        else {
                            gr.drawOval(30,130,40,40);
                            poleGry[1][0]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,1,0);}

                    }}
                    else if(x>100 & x<200){if(poleGry[1][1]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(120, 120, 160, 160);
                            gr.drawLine(160, 120, 120, 160);
                            poleGry[1][1] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,1,1);}
                        else {
                            gr.drawOval(130,130,40,40);
                            poleGry[1][1]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,1,1);
                        }
                    }}
                    else if(x>200 & x<300){if(poleGry[1][2]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(220, 120, 260, 160);
                            gr.drawLine(260, 120, 220, 160);
                            poleGry[1][2] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,1,2);}
                        else {gr.drawOval(230,130,40,40);poleGry[1][2]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,1,2);}

                    }}
                }
                else if(y>227 & y<327){
                    if(x<100){if(poleGry[2][0]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(20, 220, 60, 260);
                            gr.drawLine(60, 220, 20, 260);
                            poleGry[2][0] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,2,0);}
                        else {gr.drawOval(30,230,40,40);poleGry[2][0]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,2,0);}

                    }}
                    else if(x>100 & x<200){if(poleGry[2][1]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(120, 220, 160, 260);
                            gr.drawLine(160, 220, 120, 260);
                            poleGry[2][1] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,2,1);}
                        else {gr.drawOval(130,230,40,40);poleGry[2][1]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,1,2);}

                    }}
                    else if(x>200 & x<300){if(poleGry[2][2]==0){
                        if(czyjRuch ==1) {
                            gr.drawLine(220, 220, 260, 260);
                            gr.drawLine(260, 220, 220, 260);
                            poleGry[2][2] = 1;
                            czyjRuch =2;
                            SprawdzCzyWygrana(1,2,2);}
                        else {gr.drawOval(230,230,40,40);poleGry[2][2]=2;
                            czyjRuch =1;
                            SprawdzCzyWygrana(2,2,2);}
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

    private void RysujNowaGre() {
        Graphics gr = rysunkowyP.getGraphics();
        gr.setColor(Color.black);
        gr.clearRect(0,00,300,300);
        gr.drawLine(100, 0, 100, 300);
        gr.drawLine(200, 0, 200, 300);
        gr.drawLine(0, 100, 300, 100);
        gr.drawLine(0, 200, 300, 200);

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)poleGry[j][i]=0;
        czyjRuch =1;
    }

    public void SprawdzCzyWygrana(int gracz, int wiersz, int kolumna) {
        int wygrana = 0; // 0 - brak wygranej, 1 - wygrana w wierszu, 2 - wygrana w kolumnie, 3 - wygrana na ukos, 4 - wygrana na ukos (przeciwnie)

        if(poleGry[wiersz][0] == gracz
           && poleGry[wiersz][1] == gracz
           && poleGry[wiersz][2] == gracz)
            wygrana=1;// 3 w wierszu
        if( poleGry[0][kolumna] == gracz
           && poleGry[1][kolumna] == gracz
           && poleGry[2][kolumna] == gracz)
            wygrana=2;// 3 w kolumnie
        if(wiersz == kolumna
           && poleGry[0][0] == gracz
           && poleGry[1][1] == gracz
           && poleGry[2][2] == gracz)
            wygrana=3;// 3 na ukos
        if(wiersz + kolumna == 2
           && poleGry[0][2] == gracz
           && poleGry[1][1] == gracz
           && poleGry[2][0] == gracz)
            wygrana=4;// 3 na ukos przeciwnie

        if(wygrana!=0){
            Graphics gr = rysunkowyP.getGraphics();
            gr.setColor(Color.blue);
            switch(wygrana){
                case 1:
                    gr.drawLine(20, 50+100*wiersz, 275, 50+100*wiersz);
                    break;
                case 2:
                    gr.drawLine(50+100*kolumna, 20, 50+100*kolumna, 270);
                    break;
                case 3:
                    gr.drawLine(50, 50, 260, 260);
                    break;
                case 4:
                    gr.drawLine(260, 20, 20, 260);
                    break;
            }
            AktualizujLicznikWygranych(gracz);
        }
    }
    void AktualizujLicznikWygranych(int gracz){
        if(gracz==1)liczbaWygranychX++;
            else liczbaWygranychO++;
        wygrana.setText("Wygrane X:"+liczbaWygranychX+" O:"+ liczbaWygranychO);}
}

class PanelRysunkowy extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }
}
