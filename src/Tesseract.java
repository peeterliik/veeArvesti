import java.io.File;

public class Tesseract {

    public static void main(String[] args) throws Exception {

        net.sourceforge.tess4j.Tesseract tesseract=new net.sourceforge.tess4j.Tesseract();

        tesseract.setDatapath("tessdata-master");
        tesseract.setTessVariable("user_defined_dpi","96");
        System.out.println(tesseract.doOCR(new File("vesi2.jpg")));
    }


}
