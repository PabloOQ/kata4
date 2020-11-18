package kata4;

import kata4.model.Mail;
import kata4.model.Histogram;
import kata4.view.MailHistogramBuilder;
import kata4.view.HistogramDisplay;
import kata4.view.MailListReader;
import java.util.List;

/**
 *
 * @author Pablo
 */
public class Kata4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fileName = new String("email.txt");
        List<Mail> mailList = MailListReader.read(fileName);
        
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
                
        HistogramDisplay histogramDisplay = new HistogramDisplay(histogram, "HISTOGRAM...");
        histogramDisplay.execute();
    }
    
}
