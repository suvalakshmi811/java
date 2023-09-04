import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DocxToPdfConverter {
    public static void main(String[] args) {
        try {
          
            FileInputStream docxFile = new FileInputStream("input.docx");
            XWPFDocument document = new XWPFDocument(docxFile);

            PDDocument pdfDocument = new PDDocument();
           
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                PDPage pdfPage = new PDPage(PDRectangle.A4);
                pdfDocument.addPage(pdfPage);

                PDPageContentStream contentStream = new PDPageContentStream(pdfDocument, pdfPage);
                PDFTextStripper pdfTextStripper = new PDFTextStripper();
                pdfTextStripper.setStartPage(0);
                pdfTextStripper.setEndPage(1);

                String text = paragraph.getText();
                pdfTextStripper.processPage(pdfPage);

                contentStream.close();
            }

            
            FileOutputStream pdfFile = new FileOutputStream("output.pdf");
            pdfDocument.save(pdfFile);
            pdfDocument.close();
            docxFile.close();
            pdfFile.close();
            
            System.out.println("Conversion completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
