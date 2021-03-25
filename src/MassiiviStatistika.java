import java.util.Arrays;

public class MassiiviStatistika {

    public static String AastaKuluSoe(int sisendaasta) throws Exception{
        double[] soojakulu = new double[12];
        double[] soojanäit = new double[13];

        // Loeme failist vastava aasta sisendeid
        java.io.File fail = new java.io.File("näidud.txt");
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                int aasta = Integer.parseInt(tükid[0]);
                int kuu = Integer.parseInt(tükid[1]);

                // Sisestame vastavad näidud kuu indeksi kohale massiivi
                if (aasta == sisendaasta){
                    soojanäit[kuu] = Double.parseDouble(tükid[2]);
                }
                // Arvutuste teostamiseks sisestame eelmise aasta viimase näidu 0-indeksile
                if (aasta == sisendaasta-1 && kuu == 12){
                    soojanäit[0] = Double.parseDouble(tükid[2]);
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            soojakulu[i] = soojanäit[i+1]-soojanäit[i];
        }
        return Arrays.toString(soojakulu);
    }

    public static String AastaKuluKülm(int sisendaasta) throws Exception{
        double[] külmakulu = new double[12];
        double[] külmanäit = new double[13];

        // Loeme failist vastava aasta sisendeid
        java.io.File fail = new java.io.File("näidud.txt");
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                String[] tükid = rida.split(" ");
                int aasta = Integer.parseInt(tükid[0]);
                int kuu = Integer.parseInt(tükid[1]);

                // Sisestame vastavad näidud kuu indeksi kohale massiivi
                if (aasta == sisendaasta){
                    külmanäit[kuu] = Double.parseDouble(tükid[3]);
                }
                // Arvutuste teostamiseks sisestame eelmise aasta viimase näidu 0-indeksile
                if (aasta == sisendaasta-1 && kuu == 12){
                    külmanäit[0] = Double.parseDouble(tükid[3]);
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            külmakulu[i] = külmanäit[i+1]-külmanäit[i];
        }
        return Arrays.toString(külmakulu);
    }

    



    // Arvutused dashboardile
    // Näitudest veekulu tehtud

    // Veehind lisandub nt, peab saama muutuda
    // Igakuine kulu
    // Järjesta sooja vee tarbimise järgi
    // Järjesta külma vee tarbimise järgi
    // Järjesta kogutarbimise järgi
    // Võrdle aastaid kuude lõikes
}
