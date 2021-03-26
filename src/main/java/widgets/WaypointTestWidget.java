package widgets;

import CoordinateDataType.WaypointData;
import edu.wpi.first.shuffleboard.api.widget.Description;
import edu.wpi.first.shuffleboard.api.widget.ParametrizedController;
import edu.wpi.first.shuffleboard.api.widget.SimpleAnnotatedWidget;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;

@Description(name = "Waypoint Test", dataTypes = WaypointData.class)
@ParametrizedController("TestWaypointWidget.fxml")
public class WaypointTestWidget extends SimpleAnnotatedWidget<WaypointData> {

    @FXML
    private Pane root;

    @FXML
    private Slider xSlider;

    @FXML
    private Slider ySlider;

    @FXML
    private void initialize(){
        xSlider.valueProperty().bind(dataOrDefault.map(WaypointData::getX));
        ySlider.valueProperty().bind(dataOrDefault.map(WaypointData::getY));
    }

    @Override
    public Pane getView() {
        return root;
    }
}
