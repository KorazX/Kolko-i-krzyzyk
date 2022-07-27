import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Okno {
    PanelRysunkowy rysunkowyP;
    int[][] poleGry = new int[3][3];
    int czyjRuch; // 1==krzyzyk  2==kolko
    int liczbaWygranychX, liczbaWygranychO = 0;
    JLabel wygrana = new JLabel("Wygrane X:" + liczbaWygranychX + " O:" + liczbaWygranychO);

    public Okno() {
        JFrame ramka = new JFrame("Kolko i krzyzyk");
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.setSize(320, 373);
        ramka.setResizable(false);

        rysunkowyP = new PanelRysunkowy();

        JButton nowagra = new JButton("Nowa Gra");
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
        jp.add("South", wygrana);

        jp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x, y; //wspolrzedne klikniecia myszka
                x = e.getX();
                y = e.getY();
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

               XY

            00|10|20
            --+--+--
            10|11|12
            --+--+--
            20|21|22
        */
                Graphics gr = rysunkowyP.getGraphics();
                gr.setColor(Color.black);
                if (y < 127) {
                    if (x < 100) {
                        if (poleGry[0][0] == 0) NarysujKolkoLubKrzyzyk(0,0);
                    } else if (x > 100 & x < 200) {
                        if (poleGry[1][0] == 0) NarysujKolkoLubKrzyzyk(1,0);
                    } else if (x > 200 & x < 300) {
                        if (poleGry[2][0] == 0) NarysujKolkoLubKrzyzyk(2,0);
                    }
                } else if (y > 127 & y < 227) {
                    if (x < 100) {
                        if (poleGry[0][1] == 0) NarysujKolkoLubKrzyzyk(0,1);
                    } else if (x > 100 & x < 200) {
                        if (poleGry[1][1] == 0) NarysujKolkoLubKrzyzyk(1,1);
                    } else if (x > 200 & x < 300) {
                        if (poleGry[2][1] == 0) NarysujKolkoLubKrzyzyk(2,1);
                    }
                } else if (y > 227 & y < 327) {
                    if (x < 100) {
                        if (poleGry[0][2] == 0) NarysujKolkoLubKrzyzyk(0,2);
                    } else if (x > 100 & x < 200) {
                        if (poleGry[1][2] == 0) NarysujKolkoLubKrzyzyk(1,2);
                    } else if (x > 200 & x < 300) {
                        if (poleGry[2][2] == 0) NarysujKolkoLubKrzyzyk(2,2);
                    }
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
        gr.clearRect(0, 00, 300, 300);
        gr.drawLine(100, 0, 100, 300);
        gr.drawLine(200, 0, 200, 300);
        gr.drawLine(0, 100, 300, 100);
        gr.drawLine(0, 200, 300, 200);

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) poleGry[j][i] = 0;
        czyjRuch = 1; //Krzyżyk zawsze zaczyna
    }

    void NarysujKolkoLubKrzyzyk(int x,int y){
        Graphics gr = rysunkowyP.getGraphics();
        gr.setColor(Color.black);
        if (czyjRuch == 1) {
            gr.drawLine(100*x+30, 100*y+30, 100*x+70, 100*y+70);
            gr.drawLine(100*x+70, 100*y+30, 100*x+30, 100*y+70);
            poleGry[x][y] = 1;
            SprawdzCzyWygrana(1,x,y);
            czyjRuch = 2;
        } else {
            gr.drawOval(100*x+30, 100*y+30, 45, 45);
            poleGry[x][y] = 2;
            SprawdzCzyWygrana(2, x, y);
            czyjRuch = 1;
        }

    }
    public void SprawdzCzyWygrana(int gracz, int x, int y) {
        int wygrana = 0; // 0 - brak wygranej, 1 - wygrana w kolumnie, 2 - wygrana w wierszu, 3 - wygrana na ukos, 4 - wygrana na ukos (przeciwnie)

        if (poleGry[x][0] == gracz &&
                poleGry[x][1] == gracz &&
                poleGry[x][2] == gracz)
            wygrana = 1; // 3 w kolumnie
        if (poleGry[0][y] == gracz &&
                poleGry[1][y] == gracz &&
                poleGry[2][y] == gracz)
            wygrana = 2; // 3 w wierszu
        if (x == y &&
                poleGry[0][0] == gracz &&
                poleGry[1][1] == gracz &&
                poleGry[2][2] == gracz)
            wygrana = 3; // 3 na ukos
        if (x + y == 2 &&
                poleGry[0][2] == gracz &&
                poleGry[1][1] == gracz &&
                poleGry[2][0] == gracz)
            wygrana = 4; // 3 na ukos przeciwnie

        if (wygrana != 0) {
            Graphics gr = rysunkowyP.getGraphics();
            gr.setColor(Color.blue);
            switch (wygrana) {
                case 1:
                    gr.drawLine(50 + 100 * x, 20, 50 + 100 * x, 270);
                    break;
                case 2:
                    gr.drawLine(20, 50 + 100 * y, 275, 50 + 100 * y);
                    break;
                case 3:
                    gr.drawLine(50, 50, 260, 260);
                    break;
                case 4:
                    gr.drawLine(280, 20, 40, 260);
                    break;
            }
            AktualizujLicznikWygranych(gracz);
        }
    }

    void AktualizujLicznikWygranych(int gracz) {
        if (gracz == 1) liczbaWygranychX++;
        else liczbaWygranychO++;
        wygrana.setText("Wygrane X:" + liczbaWygranychX + " O:" + liczbaWygranychO);
    }


}

class PanelRysunkowy extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
    }
}
