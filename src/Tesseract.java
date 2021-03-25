import java.io.File;

public class Tesseract {

    public static int tuvastus(int failinimi) throws Exception {

        int vesi;
        net.sourceforge.tess4j.Tesseract tesseract=new net.sourceforge.tess4j.Tesseract();
        tesseract.setDatapath("tessdata-master");
        tesseract.setTessVariable("user_defined_dpi","96");
        vesi=Integer.parseInt(tesseract.doOCR(new File("vesi2.jpg")));
        return vesi;
    }


}
