import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFParser {

    private String text;

    public PDFParser(File pdf) throws IOException {
        PDDocument doc = PDDocument.load(pdf);
        text = new PDFTextStripper().getText(doc);
        doc.close();
    }


    @Override
    public String toString() {
        return text;
    }

}
