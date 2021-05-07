import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;


public class NäidudMassiivi {
    private int aasta;
    private int kuu;
    private double soojanäit;
    private double külmanäit;
    private double[] massiiv;

    // Salvestab automaatselt saadetud näidud massiivi ja tekstifaili, lisades juurde saatmisaja kuu ja aasta
    public NäidudMassiivi(double soojanäit, double külmanäit, String saajasisend) throws Exception {
        this.aasta = LocalDate.now().getYear();
        this.kuu = LocalDate.now().getMonthValue()-1; //lahutan ühe, sest saadetakse eelmise kuu näidud
        this.soojanäit = soojanäit;
        this.külmanäit = külmanäit;
        this.massiiv = new double[]{aasta, kuu, soojanäit, külmanäit};
        this.NäidudFaili(massiiv);
        this.NäidudMeili(saajasisend);
    }

    // Salvestab manuaalselt sisestatud ja juba kuu ja aastaga varustatud näidud massiivi ja tekstifaili
    public NäidudMassiivi(double soojanäit, double külmanäit, int aasta, int kuu) throws Exception {
        this.aasta = aasta;
        this.kuu = kuu;
        this.soojanäit = soojanäit;
        this.külmanäit = külmanäit;
        this.massiiv = new double[]{aasta, kuu, soojanäit, külmanäit};
        this.NäidudFaili(massiiv);
        this.NäidudMeili("");
    }

    // Meetod, mis kirjutab näidu tekstifaili
    public void NäidudFaili(double[] massiiv) throws Exception {
        java.io.File fail = new java.io.File("näidud.txt");
        try (java.io.FileWriter pw = new java.io.FileWriter(fail, true)) {
            pw.write((int) massiiv[0] + " " + (int)massiiv[1] + " " + massiiv[2] + " " + massiiv[3] + "\n");
        }
    }

    public void NäidudMeili(String saajasisend){
        // Kasutasin Gmaili Serveri kaudu Javaga emaili saatmise õpetust lehelt:
        // https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server

        // Kuna kirja sisu on alati analoogne, tegin meetodi parameetriteta ja defineerin saatjad ja saajad meetodi sees ära.
        String saatja = "javaryhmatoo@gmail.com";
        // Kuna selline parooli avaldamine on VÄGA VÄGA halb ja ebaturvaline, peab kasutaja tegema eraldi konto selleks.
        // Lisame saatnusek parooli küsimise rühmatöö teises etapis
        String parool = "JavaJava123";
        String saaja = saajasisend;
        if (saajasisend.equals("")) {saaja ="javaryhmatoo+saaja@gmail.com";}
        String pealkiri = "Krt 12 veenäidud";
        String sisu = this.toString();

        //Panen Properties objekti sätted paika
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");


        //Teen sessiooni
        Session sessioon = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(saatja,parool);
                    }
                });


        //Koostan kirja
        try {
            MimeMessage kiri = new MimeMessage(sessioon);
            kiri.addRecipient(Message.RecipientType.TO,new InternetAddress(saaja));
            kiri.setSubject(pealkiri);
            kiri.setText(sisu);
            //saadan kirja
            Transport.send(kiri);
            System.out.println("Kiri edukalt saadetud aadressile " + saaja);
        } catch (MessagingException e) {throw new RuntimeException(e);}
    }

    @Override
    public String toString() {
        String kuunimi = "";
        switch (kuu) {
            case 1: kuunimi = "jaanuar"; break;
            case 2: kuunimi = "veebruar"; break;
            case 3: kuunimi = "märts"; break;
            case 4: kuunimi = "aprill"; break;
            case 5: kuunimi = "mai"; break;
            case 6: kuunimi = "juuni"; break;
            case 7: kuunimi = "juuli"; break;
            case 8: kuunimi = "august"; break;
            case 9: kuunimi = "september"; break;
            case 10:kuunimi = "oktoober"; break;
            case 11: kuunimi = "november"; break;
            case 12: kuunimi = "detsember"; break;
            default: kuunimi = String.valueOf(kuu);
        }
        return kuunimi + " " + aasta + " soojanäit: " + soojanäit + ", külmanäit: " + külmanäit;
    }
}
