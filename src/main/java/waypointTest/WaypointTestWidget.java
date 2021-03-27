package waypointTest;

import CoordinateDataType.WaypointData;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

@Description(name = "Waypoint Test", dataTypes = WaypointData.class, summary = "Displays X and Y sliders Test")
@ParametrizedController("waypointTest/TestWaypointWidget.fxml")
public final class WaypointTestWidget extends SimpleAnnotatedWidget<WaypointData> {

    @FXML
    private Pane root;

    @FXML
    private Slider xSlider;

    @FXML
    private Slider ySlider;

    @FXML
    private void initialize(){
        xSlider.valueProperty().addListener((observable, oldValue, newValue) -> setData(getData().setRealX((double)newValue)));
        ySlider.valueProperty().addListener((observable, oldValue, newValue) -> setData(getData().setRealY((double)newValue)));
    }

    @Override
    public Pane getView() {
        return root;
    }
}
