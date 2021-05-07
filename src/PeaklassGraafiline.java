import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

        final String card1text = "Avaleht";
        final String card2text = "Näidud";
        final String card3text = "Veekulu";
        final String card4text = "Viimane kuu";
        final JPanel cards;
        final String FIRST = "Avaleht";
        final String SECOND = "Näidud";
        final String THIRD = "Veekulu";
        final String FOURTH = "Viimane kuu";

        JFrame frame = new JFrame("Projekt Veearvesti");


        // Kaart 1
        JPanel card1 = new JPanel(new BorderLayout(0, 2));
        JPanel sisuc1 = new JPanel(new BorderLayout(0, 2));
        JTextArea intro = new JTextArea();
        intro.setOpaque(false);
        intro.setLineWrap(true);
        intro.setWrapStyleWord(true);
        intro.setBorder(new EmptyBorder(0,8,20,8));
        intro.setText("Teretulemast proovima meie veearvesti projekti. Tee valik vasakul oleva navigatsiooniriba abil. Programmi sulgemiseks vajuta nuppu katkesta.");

        JButton b4 = new JButton("Katkesta");
        JButton b42 = new JButton("Katkesta");

        sisuc1.add(intro, BorderLayout.CENTER);
        sisuc1.add(b4, BorderLayout.PAGE_END);
        card1.add(sisuc1, BorderLayout.PAGE_START);

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        b42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        // Kaart 1 lõpp

        // Kaart 2

        JPanel card2 = new JPanel(new BorderLayout(0, 12));
        JPanel sisuc2 = new JPanel(new BorderLayout(0, 12));


        JPanel rida1c2 = new JPanel(new BorderLayout(0, 2));
        JTextArea tekst1 = new JTextArea();
        tekst1.setText("Sisesta soojaveenäidu pildi nimi: (Testimiseks \"vesi2.jpg\")");
        tekstIlusaks(tekst1);
        JTextField pilt1 = new JTextField(20);
        rida1c2.add(tekst1, BorderLayout.PAGE_START);
        rida1c2.add(pilt1, BorderLayout.PAGE_END);


        JPanel rida2c2 = new JPanel(new BorderLayout(0, 2));
        JTextArea tekst2 = new JTextArea();
        tekst2.setText("Sisesta külmaveenäidu pildi nimi: (Testimiseks \"vesi1.jpg\")");
        tekstIlusaks(tekst2);
        JTextField pilt2 = new JTextField(20);
        rida2c2.add(tekst2, BorderLayout.PAGE_START);
        rida2c2.add(pilt2, BorderLayout.PAGE_END);

        JPanel rida3c2 = new JPanel(new BorderLayout(0, 2));
        JTextArea tekst3 = new JTextArea();
        tekst3.setText("Sisesta e-mail, kuhu näidud saadetakse:");
        tekstIlusaks(tekst3);
        JTextField aadress = new JTextField(20);
        rida3c2.add(tekst3, BorderLayout.PAGE_START);
        rida3c2.add(aadress, BorderLayout.PAGE_END);

        JLabel näidud = new JLabel("Näidud saadetud!");
        näidud.setVisible(false);


        JButton saada = new JButton("Saada");
        saada.addActionListener(new ActionListener() {
            /*
            Testimiseks on valitud pildid, millest ühe (vesi2.jpg) puhul tuvastus ei toimi ja tulemuseks on vigane näit (-1),
            teise puhul on kasutatud pilti (vesi1.jpg), mille puhul tuvastus töötab
            Näidud lisatakse faili näidud.txt ja saadetakse valitud e-mailile (Pikka aega pärast rühmatöö submittimist ei pruugi meil enam töörada,
            kuna Gmail ei taha suvalisi arvuteid usaldada üht ja sama saatja meilikontod kasutama ning võib iseseisvalt uuesti saatmiskontol sisselülitada
            väheturvaliste programmide mitteusaldamise, mille peale meili välja saatmine antud programmiga ei tööta.
             */

            @Override
            public void actionPerformed(ActionEvent e) {
                String soojapilt = pilt1.getText();
                String külmapilt = pilt2.getText();
                String meiliaadress = aadress.getText();


                try {
                    NäidudMassiivi uus = new NäidudMassiivi(Tuvastus.tuvastus(soojapilt),Tuvastus.tuvastus(külmapilt),meiliaadress);
                } catch (Exception err){
                    System.out.println("Viga sisendis või seadmes. Kahjuks kõigi seadmetega (nt Maci arvutitega) tuvstuse osa veel ei tööta. Testime näidissisendiga.");
                    try {
                        NäidudMassiivi uus = new NäidudMassiivi(229,230,meiliaadress);
                    } catch (Exception err2) {
                        System.out.println(err2.getMessage());
                    }
                }
                näidud.setVisible(true);
            }
        });


        sisuc2.add(rida1c2, BorderLayout.PAGE_START);
        sisuc2.add(rida2c2, BorderLayout.CENTER);
        sisuc2.add(rida3c2, BorderLayout.PAGE_END);
        card2.add(sisuc2,BorderLayout.PAGE_START);
        card2.add(näidud, BorderLayout.CENTER);
        card2.add(saada, BorderLayout.PAGE_END);

        // Kaart 2 lõpp

        // Kaart 3
        JPanel card3 = new JPanel(new BorderLayout(0, 12));
        JPanel sisuc3 = new JPanel(new BorderLayout(0, 12));
        JPanel rida1c3 = new JPanel(new BorderLayout(0, 12));
        JPanel rida3c3 = new JPanel(new BorderLayout(0, 12));

        JTextArea tekst4 = new JTextArea();
         tekst4.setText("Mis aasta veekulu statistikat soovid näha?");
         tekstIlusaks(tekst4);
         String aastad[]={"2019","2020","2021"};
         JComboBox cb=new JComboBox(aastad);
         JButton naita = new JButton("Näita");
         JTextArea soe = new JTextArea(); JTextArea külm = new JTextArea();
         tekstIlusaks(soe); tekstIlusaks(külm);
         soe.setBorder(new EmptyBorder(24,6,0,6));

         rida1c3.add(tekst4, BorderLayout.CENTER);
         rida1c3.add(cb, BorderLayout.LINE_END);
         sisuc3.add(rida1c3, BorderLayout.PAGE_START);
         sisuc3.add(naita, BorderLayout.CENTER);
         card3.add(sisuc3, BorderLayout.PAGE_START);
         rida3c3.add(soe, BorderLayout.PAGE_START);
         rida3c3.add(külm, BorderLayout.CENTER);
         card3.add(rida3c3, BorderLayout.CENTER);
         naita.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 int aasta = Integer.parseInt(aastad[cb.getSelectedIndex()]);
                 try {
                     soe.setText("Soojakulu aastal " + aasta +":\n" + Arrays.toString(MassiiviStatistika.AastaKuluSoe(aasta)));
                     külm.setText("Külmakulu aastal " + aasta +":\n"+Arrays.toString(MassiiviStatistika.AastaKuluKülm(aasta)));
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
                    cl.show(cards,"Avaleht");
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

        JButton btn1 = new JButton("Avaleht");
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

        JLabel nav = new JLabel();
        nav.setText("<html><body style = \"\">Navigatsioon: </body></html>");
        nav.setBorder(new EmptyBorder(10,8,10,0));

        JPanel controlButtons = new JPanel(new BorderLayout(0, 2));
        JPanel nupud = new JPanel(new BorderLayout(0, 2));
        JPanel nupud1 = new JPanel(new BorderLayout(0, 2));
        JPanel nupud2 = new JPanel(new BorderLayout(0, 2));
        nupud1.add(btn1,BorderLayout.PAGE_START);
        nupud1.add(btn2,BorderLayout.CENTER);
        nupud2.add(btn3,BorderLayout.PAGE_START);
        nupud2.add(btn4,BorderLayout.CENTER);
        nupud.add(nupud1,BorderLayout.PAGE_START);
        nupud.add(nupud2,BorderLayout.CENTER);
        controlButtons.add(nupud,BorderLayout.PAGE_START);
        controlButtons.add(b42, BorderLayout.PAGE_END);
        controlButtons.setBorder(new EmptyBorder(0,0,10,0));


        Container pane=frame.getContentPane();
        pane.add(nav,BorderLayout.PAGE_START);
        pane.add(controlButtons,BorderLayout.LINE_START);
        pane.add(cards, BorderLayout.CENTER);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
        frame.setVisible(true);
        }

    public static void tekstIlusaks(JTextArea tekst){
        tekst.setOpaque(false);
        tekst.setLineWrap(true);
        tekst.setWrapStyleWord(true);
        tekst.setBorder(new EmptyBorder(0,6,0,6));
    }
        }
