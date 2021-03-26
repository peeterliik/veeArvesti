import java.util.Arrays;
import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) throws Exception{

        System.out.println("Teretulemst meie veearvesti programmi kasutama.");
        System.out.println("Veearvesti aitab veenäidud logida, saata ühistu meilile ning kuvada statistikana.");
        System.out.println("Programm on arendusfaasis ning rühmatöö nõuetele vastamiseks tehtud modifikatsioonidega.");
        System.out.println("Tulevikus on programm ühendatud statiivil kaameratega, mis teevad kord kuus pildi kahest veenäidikust");
        System.out.println("Hetkel tuleb programmile need pildid ise viidata (et saaks harjutada ka Scanneri kasutamist!)");
        System.out.println();

        MassiiviStatistika TartuVeevärk = new MassiiviStatistika(4.650,2.0352);

        Scanner scan = new Scanner(System.in);
        System.out.println("Kas tahad sisestada uued näidud (1), vaadata veekulude statistikat (2), vaadata viimase kuu veearvet (3)?");
        int valik = scan.nextInt();

        if (valik==1){
        System.out.println("Sisesta soojaveenäidu pildi nimi: (Testimiseks \"vesi2.jpg\")");
        String soojapilt = scan.nextLine();
        System.out.println("Sisesta külmaveenäidu pildi nimi: (Testimiseks \"vesi1.jpg\")");
        String külmapilt = scan.nextLine();
        System.out.println("Mis meiliaadtessile näidud saadame?");
        String meiliaadress = scan.nextLine();
            NäidudMassiivi uus = new NäidudMassiivi(Tuvastus.tuvastus(soojapilt),Tuvastus.tuvastus(külmapilt),meiliaadress);
        }

        if (valik==2){
            System.out.println("Mis aasta veekulu statistikat soovid näha?");
            int aasta = scan.nextInt();
            System.out.println("Aasta " + aasta + " külmaveekulu:");
            System.out.println(Arrays.toString(MassiiviStatistika.AastaKuluKülm(aasta)));
            System.out.println("Aasta " + aasta + " soojaveekulu:");
            System.out.println(Arrays.toString(MassiiviStatistika.AastaKuluSoe(aasta)));

        }

        if (valik==3){
            // vaatab kuupäeva, võtab eelmise kuu, kui ei ole annab teada, kui on ütleb arve.
            System.out.println(TartuVeevärk.KuuArve(2021,2));

        }


    }

}
