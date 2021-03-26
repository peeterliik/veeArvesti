import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class Tuvastus {


    public static double tuvastus(String failinimi) throws Exception {
        String vesi;
        Tesseract tesseract=new Tesseract();
        tesseract.setDatapath("tessdata-master");
        tesseract.setTessVariable("user_defined_dpi","96");
        vesi = tesseract.doOCR(new File(failinimi));
        try {
            return Double.parseDouble(vesi);
        } catch (Exception e){
            return -1.0;
        }

        /* Janeli testimiseks
        double vesitest = 51.913;
        if(failinimi.equals("vesi1.jpg")){vesitest=64.341;}
        return vesitest;*/
    }


}
