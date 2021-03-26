public class MassiiviStatistika {
    public double soojahind; // vee soojendamise hind
    public double kanalhind; // vee ja kanalisatsiooni hind

    public MassiiviStatistika(double soojahind, double kanalhind) {
        this.soojahind = soojahind;
        this.kanalhind = kanalhind;
    }

    public static double[] AastaKuluSoe(int sisendaasta) throws Exception{
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
            soojakulu[i] = Math.round((soojanäit[i+1]-soojanäit[i])*1000.0)/1000.0;
        }
        return soojakulu;
    }

    public static double[] AastaKuluKülm(int sisendaasta) throws Exception{
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
            külmakulu[i] = Math.round((külmanäit[i+1]-külmanäit[i])*1000.0)/1000.0;
        }
        return külmakulu;
    }

    public static double[] KuuKulud(int sisendaasta, int sisendkuu) throws Exception{
        double[] kuludkoos = new double[2];
        kuludkoos[0] = MassiiviStatistika.AastaKuluSoe(sisendaasta)[sisendkuu-1];
        kuludkoos[1] = MassiiviStatistika.AastaKuluKülm(sisendaasta)[sisendkuu-1];
        return kuludkoos;
    }

    public double KuuArve(int sisendaasta, int sisendkuu) throws Exception{
        double[] kuludkoos = KuuKulud(sisendaasta, sisendkuu);
        double soojaarve = kuludkoos[0]*soojahind;
        double kanalarve = (kuludkoos[0]+kuludkoos[1])*kanalhind;
        double arve = Math.round((soojaarve + kanalarve)*100.0)/100.0;
        return arve;
    }

}
