package kata4.view;

import javax.swing.JPanel;
import kata4.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Pablo
 */
public class HistogramDisplay extends ApplicationFrame {

    Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram, String title) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart freeChart = ChartFactory.createBarChart("JFreeChartHistogram...",
                "email domains",
                "nº emails",
                dataSet,
                PlotOrientation.VERTICAL,
                false,
                false,
                rootPaneCheckingEnabled);
        return freeChart;
    }

    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : this.histogram.keySet()) {
            dataSet.addValue(this.histogram.get(key), "", key);
        }
        return dataSet;
    }

    public void execute() {
        this.setVisible(true);
    }

}
