import net.sourceforge.tess4j.Tesseract;

import java.util.Arrays;

public class Peaklass {
    public static void main(String[] args) throws Exception{
        /* NäidudMassiivi aug20 = new NäidudMassiivi(2.055, 3.515, 2020, 8);
        NäidudMassiivi sep20 = new NäidudMassiivi(4.550, 6.810, 2020, 9);
        NäidudMassiivi oct20 = new NäidudMassiivi(7.434, 10.605, 2020, 10);
        NäidudMassiivi nov20 = new NäidudMassiivi(10.565, 14.466, 2020, 11);
        NäidudMassiivi dec20 = new NäidudMassiivi(12.286, 16.454, 2020, 12);
        NäidudMassiivi jan21 = new NäidudMassiivi(15.483, 19.873, 2021, 1);
        NäidudMassiivi feb21 = new NäidudMassiivi(17.375, 22.297, 2021, 2);
        NäidudMassiivi mar21 = new NäidudMassiivi(20.046,24.848);

        System.out.println(aug20);
        System.out.println(dec20);
        System.out.println(mar21);*/


        MassiiviStatistika TartuVeevärk = new MassiiviStatistika(4.650,2.0352);

        System.out.println(Arrays.toString(MassiiviStatistika.AastaKuluKülm(2020)));
        System.out.println(Arrays.toString(MassiiviStatistika.AastaKuluSoe(2020)));
        System.out.println(TartuVeevärk.KuuArve(2020,3));

        System.out.println(Tuvastus.tuvastus("vesi1.jpg"));
    }

}
