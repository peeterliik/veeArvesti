import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.Arrays;

public class PeaklassGraafiline {
// Antud programmil on kaks peaklassi. Graafilise liidese demonstreerimiseks palume kasutada antud peaklassi

    public static void main(String[] args) throws Exception {

        MassiiviStatistika TartuVeevärk = new MassiiviStatistika(4.650,2.0352);

        final String card1text = "Veearvesti";
        final String card2text = "Näidud";
        final String card3text = "Veekulu";
        final String card4text = "Viimane kuu";
        final JPanel cards;
        final String FIRST = "Veearvesti";
        final String SECOND = "Näidud";
        final String THIRD = "Veekulu";
        final String FOURTH = "Viimane kuu";

        JFrame frame = new JFrame("Projekt Veearvesti");

        // Kaart 1
        JPanel card1 = new JPanel();
        JLabel intro = new JLabel();
        intro.setText("<html><body>Teretulemast proovima meie veearvesti projekti.<br> Tee valik all oleva navigatsiooniriba abil.<br>Programmi sulgemiseks vajuta nuppu katkesta.</body></html>");

        card1.add(intro);

        JButton b4 = new JButton("Katkesta");

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
        JTextField pilt1 = new JTextField(20);


        JLabel tekst2 = new JLabel();
        tekst2.setText("<html><body>Sisesta külmaveenäidu pildi nimi:<br> (Testimiseks \"vesi1.jpg\")</body></html>");
        JTextField pilt2 = new JTextField(20);

        JLabel tekst3 = new JLabel();
        tekst3.setText("<html><body>Sisesta e-mail,<br> kuhu näidud saadetakse:</body></html>");
        JTextField aadress = new JTextField(20);

        JLabel näidud = new JLabel("Näidud saadetud!");
        näidud.setVisible(false);


        JButton saada = new JButton("Saada");
        saada.addActionListener(new ActionListener() {
            /*
            Testimiseks on valitud pildid, millest ühe (vesi2.jpg) puhul tuvastus ei toimi ja tulemuseks on vigane näit (-1),
            teise puhul on kasutatud pilti (vesi1.jpg), mille puhul tuvastus töötab
            Näidud lisatakse faili näidud.txt ja saadetakse valitud e-mailile (meili peale saatmine ei pruugi igas arvutis alati
            töötada, kuna Gmail ei taha suvalisi arvuteid usaldada üht ja sama saatja meilikontod kasutama ning võib nõuda
            kaheastmelist autentimist, mille peale meili välja saatmine antud programmiga ei tööta.
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                String soojapilt = pilt1.getText();
                String külmapilt = pilt2.getText();
                String meiliaadress = aadress.getText();
                try {
                    NäidudMassiivi uus = new NäidudMassiivi(Tuvastus.tuvastus(soojapilt),Tuvastus.tuvastus(külmapilt),meiliaadress);
                } catch (Exception err){
                    err.getMessage();
                }
                näidud.setVisible(true);
            }
        });


        card2.add(tekst1);
        card2.add(pilt1);
        card2.add(tekst2);
        card2.add(pilt2);
        card2.add(tekst3);
        card2.add(aadress);
        card2.add(saada);
        card2.add(näidud);

        // Kaart 2 lõpp

        // Kaart 3
         JPanel card3 = new JPanel();
         JLabel tekst4 = new JLabel();
         tekst4.setText("<html><body>Mis aasta veekulu<br>statistikat soovid näha?</body></html>");
         String aastad[]={"2019","2020","2021"};
         JComboBox cb=new JComboBox(aastad);
         JButton naita = new JButton("Näita");
         JLabel soe = new JLabel();
         JLabel külm = new JLabel();

         card3.add(tekst4);
         card3.add(cb);
         card3.add(naita);
         card3.add(soe);
         card3.add(külm);
         naita.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 int aasta = Integer.parseInt(aastad[cb.getSelectedIndex()]);
                 try {
                     soe.setText("Soojakulu " + Arrays.toString(MassiiviStatistika.AastaKuluSoe(aasta)));
                     külm.setText("Külmakulu "+Arrays.toString(MassiiviStatistika.AastaKuluKülm(aasta)));
                 } catch (Exception err) {
                     err.getMessage();
                 }
             }
         });

         // Kaart 3 lõpp

        // Kaart 4
        JPanel card4 = new JPanel();
        int aasta = LocalDate.now().getYear();
        int kuu = LocalDate.now().getMonthValue()-1;
        double arve = TartuVeevärk.KuuArve(aasta,kuu);
        String arveString;
        if (arve <= 0){
            arveString="Viimase kuu näidud ei ole sisestatud";
        }
        else {
            arveString="Aasta " + aasta + " " + kuu + ". kuu arve on " + arve + "€";
        }
        JLabel tekst5=new JLabel(arveString);
        tekst5.setBounds(100,140,300,80);
        card4.add(tekst5);

        // Kaart 4 lõpp

        cards = new JPanel(new CardLayout(10,10));
        cards.add(card1, card1text);
        cards.add(card2, card2text);
        cards.add(card3, card3text);
        cards.add(card4, card4text);

        class ControlActionListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                String cmd = e.getActionCommand();
                if (cmd.equals(FIRST)) {
                    cl.show(cards,"Veearvesti");
                } else if (cmd.equals(SECOND)) {
                    cl.show(cards, "Näidud");
                } else if (cmd.equals(THIRD)) {
                    cl.show(cards, "Veekulu");
                } else if (cmd.equals(FOURTH)) {
                    cl.show(cards, "Viimane kuu");
                }
            }
        }
       ControlActionListener cal=new ControlActionListener();

        JButton btn1 = new JButton("Veearvesti");
        btn1.setActionCommand(FIRST);
        btn1.addActionListener(cal);

        JButton btn2 = new JButton("Sisesta näidud");
        btn2.setActionCommand(SECOND);
        btn2.addActionListener(cal);

        JButton btn3 = new JButton("Näita veekulu");
        btn3.setActionCommand(THIRD);
        btn3.addActionListener(cal);

        JButton btn4 = new JButton("Viimase kuu arve");
        btn4.setActionCommand(FOURTH);
        btn4.addActionListener(cal);

        JPanel controlButtons = new JPanel();
        controlButtons.add(btn1);
        controlButtons.add(btn2);
        controlButtons.add(btn3);
        controlButtons.add(btn4);

        Container pane=frame.getContentPane();
        pane.add(controlButtons,BorderLayout.PAGE_END);
        pane.add(cards, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setVisible(true);
        }
        }
