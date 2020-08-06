package spring.spot.trial.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.Date;

public class VelToPdf {

    public static void velocityToPdf( String html){

        PdfWriter pdfWriter = null;
        Document document = new Document();
        try {

            //Rectangle rect = new Rectangle(700,500);
            Rectangle rect = new Rectangle(700,400);
            document.setPageSize(rect);


            OutputStream file = new FileOutputStream(new File("Test"+new Date().getTime()+".pdf"));


            pdfWriter = PdfWriter.getInstance(document, file);

            // open document
            document.open();

            XMLWorkerHelper xmlWorkerHelper = XMLWorkerHelper.getInstance();
            xmlWorkerHelper.getDefaultCssResolver(true);
            xmlWorkerHelper.parseXHtml(pdfWriter, document, new StringReader(html));


            System.out.println("----------------------####PDF generated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close the document
            document.close();
            // close the writer
            pdfWriter.close();
        }
    }
}

