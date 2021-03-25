import java.io.File;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Tuvastus {

    public static String tuvastus(String failinimi) throws Exception {

        String vesi;
        Tesseract tesseract=new Tesseract();
        tesseract.setDatapath("tessdata-master");
        tesseract.setTessVariable("user_defined_dpi","96");
        vesi=tesseract.doOCR(new File(failinimi));
        return vesi;
    }


}
