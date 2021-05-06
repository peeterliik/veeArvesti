import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class PeaklassGraafiline {


    public static void main(String[] args) {

        final String card1text = "Veearvesti";
        final String card2text = "Näidud";
        final String card3text = "Veekulu";
        final String card4text = "Viimane kuu";
        final JPanel cards;
        final String FIRST = "FIRST";
        final String NEXT = "NEXT";
        final String PREVIOUS = "PREVIOUS";
        final String LAST = "LAST";

        JFrame frame = new JFrame("Projekt Veearvesti");

        // Kaart 1
        JPanel card1 = new JPanel();

        JButton b1 = new JButton("Näitude sisestamine");
        b1.setBounds(100, 100, 200, 40);


        JButton b2 = new JButton("Veekulu statistika");
        b2.setBounds(100, 150, 200, 40);

        JButton b3 = new JButton("Vaata viimase kuu arvet");
        b3.setBounds(100, 200, 200, 40);

        JButton b4 = new JButton("Katkesta");
        b4.setBounds(100, 250, 200, 40);

        card1.add(b1);
        card1.add(b2);
        card1.add(b3);
        card1.add(b4);

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Kaart 1 lõpp

        // Kaart 2

        JPanel card2 = new JPanel();
        JLabel tekst1 = new JLabel();
        tekst1.setText("<html><body>Sisesta soojaveenäidu pildi nimi:<br> (Testimiseks \"vesi2.jpg\")</body></html>");
        tekst1.setBounds(100, 50, 300, 80);
        JTextField pilt1 = new JTextField();
        pilt1.setBounds(100, 110, 200, 30);

        JLabel tekst2 = new JLabel();
        tekst2.setText("<html><body>Sisesta külmaveenäidu pildi nimi:<br> (Testimiseks \"vesi1.jpg\")</body></html>");
        tekst2.setBounds(100, 140, 300, 80);
        JTextField pilt2 = new JTextField();
        pilt2.setBounds(100, 200, 200, 30);

        JLabel tekst3 = new JLabel();
        tekst3.setText("<html><body>Sisesta e-mail,<br> kuhu näidud saadetakse:</body></html>");
        tekst3.setBounds(100, 230, 300, 80);
        JTextField aadress = new JTextField();
        aadress.setBounds(100, 290, 200, 30);

        JButton tagasi = new JButton("Tagasi");
        tagasi.setBounds(95, 350, 100, 40);

        JButton saada = new JButton("Saada");
        saada.setBounds(205, 350, 100, 40);

        card2.add(tekst1);
        card2.add(pilt1);
        card2.add(tekst2);
        card2.add(pilt2);
        card2.add(tekst3);
        card2.add(aadress);
        card2.add(tagasi);
        card2.add(saada);

        // Kaart 2 lõpp
         JPanel card3 = new JPanel();
         JLabel tekst4 = new JLabel();
         tekst4.setText("<html><body>Mis aasta veekulu<br>statistikat soovid näha?</body></html>");
         tekst4.setBounds(100, 140, 300, 80);
         String aastad[]={"2019","2020","2021"};
         JComboBox cb=new JComboBox(aastad);
         cb.setBounds(100,200,150,40);
         JButton valitud = new JButton("Näita");
         valitud.setBounds(100,250,100,40);









        Container pane=frame.getContentPane();
        pane.add(cards,BorderLayout.CENTER);
        pane.add(controlButtons,BorderLayout.PAGE_END);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,200);
        frame.setVisible(true);
        }
        }
