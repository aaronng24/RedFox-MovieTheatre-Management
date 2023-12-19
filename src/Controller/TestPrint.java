package Controller;

import com.lowagie.text.Anchor;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Section;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Nguyen Dung
 */
public class TestPrint {

    public static void main(String[] args) throws IOException {
        Document document = new Document(PageSize.A6.rotate(), 10, 10, 0, 10);
        try {
            //Tạo đối tượng PDFWriter
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Nguyen Dung\\OneDrive\\Máy tính\\Nhom3-DuAn1\\TestPRint.pdf"));

            //Mở file để thực hiện ghi
            document.open();

            //Font Chữ
            BaseFont baseFont = BaseFont.createFont("C:\\Users\\Nguyen Dung\\OneDrive\\Máy tính\\Nhom3-DuAn1\\RobotoSlab-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 15, Font.BOLD);
            //Tên công ty
            Paragraph CompName = new Paragraph("REDFOX Cinema",
                    FontFactory.getFont(FontFactory.TIMES_ROMAN, 30, Font.BOLD, new CMYKColor(0, 255, 30, 0)));
            //CompName.setSpacingAfter(14f);
            document.add(CompName);

            //Decor
            Paragraph decor = new Paragraph("___________________________________");
            decor.setSpacingAfter(14f);
            document.add(decor);
            //Tên phim
            Paragraph phimname = new Paragraph("Film:", font);
            document.add(phimname);

            //Tên phim 2
            Paragraph tenphim = new Paragraph("Tôi có một khỏe Tôi có một khỏTôi có một khỏTôi có một khỏTôi có một khỏTôi có một khỏ", font);
            tenphim.setSpacingAfter(8f);
            document.add(tenphim);

            //Giá tiền
            Paragraph giave = new Paragraph("Price: " + "200000" + " Vnđ", font);
            giave.setSpacingAfter(8f);
            document.add(giave);

            //Định dạng + Phòng chiếu
            Paragraph dinhdang = new Paragraph("Format: " + "IMDX ", font);
            dinhdang.add("                   ");
            dinhdang.add("Screen: " + "1");
            dinhdang.setSpacingAfter(8f);
            document.add(dinhdang);
            //Title Ngày, giờ , Ghế
            Paragraph title = new Paragraph("Date", font);
            title.add("                                      ");
            title.add("Time");
            title.add("                                  ");
            title.add("Seat");
            document.add(title);
            //Value Ngày, giờ ,ghế
            Paragraph values = new Paragraph("02-07-2023", font);
            values.add("                          ");
            values.add("18:00" + "-" + "20:00");
            values.add("                       ");
            values.add("A1");
            document.add(values);

            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }
}
