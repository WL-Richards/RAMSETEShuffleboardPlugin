package waypointChart;

import CoordinateDataType.WaypointData;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;

@Description(name = "Waypoint Plotter", dataTypes = WaypointData.class, summary = "Used to display a graph containing RAMSETE points and real Points")
@ParametrizedController("WaypointChartWidget.fxml")
public class WaypointChartWidget extends SimpleAnnotatedWidget<WaypointData> {

    @FXML
    private Pane root;

    @FXML
    private LineChart<Double, Double> positionPlot;

    // Create 2 series to handle both sets of data
    private final XYChart.Series<Double, Double> realCoords = new XYChart.Series<>();
    private final XYChart.Series<Double, Double> ramseteCoords = new XYChart.Series<>();

    private Thread updateThread;

    @FXML
    private void initialize(){

        // Set the X and Y axis labels
        positionPlot.getXAxis().setLabel("X Position (Feet)");
        positionPlot.getYAxis().setLabel("Y Position (Feet)");

        // Disables visual effects that could slow down the Chart proccessing
        positionPlot.setCreateSymbols(false);
        positionPlot.setAnimated(false);

        // Set names for a legend
        realCoords.setName("Real Coordinates");
        ramseteCoords.setName("Calculated Coordinates");

        positionPlot.getData().add(realCoords);
        positionPlot.getData().add(ramseteCoords);

        // Create an update thread to handle additions to the chart to prevent the main UI thread from hanging
        updateThread = new Thread(() -> {

            // Add a listener to the data incoming and whenever new data arrives add the new coordinates to the series
            dataProperty().addListener((observable, oldValue, newValue) -> {
                ramseteCoords.getData().add(new XYChart.Data<>(newValue.getCalculatedX(), newValue.getCalculatedY()));
                realCoords.getData().add(new XYChart.Data<>(newValue.getRealX(), newValue.getRealY()));
            });
        });

        // Start the update thread for the chart
        updateThread.setDaemon(true);
        updateThread.start();
    }

    @Override
    public Pane getView() {
        return root;
    }
}
