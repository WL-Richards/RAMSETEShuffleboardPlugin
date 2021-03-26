import CoordinateDataType.WaypointDataType;
import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;
import widgets.WaypointTestWidget;

import java.util.List;
import java.util.Map;

@Description(group = "com.aembot", name = "RAMSETE Tracker Plugin", version = "0.1.0", summary = "Used to plot the current robot position in relation to the pre-calculated course in real time")
public class RAMSETETracker extends Plugin {

    // Get the supported data
    @Override
    public List<DataType> getDataTypes() {
        return List.of(WaypointDataType.Instance);
    }

    @Override
    public List<ComponentType> getComponents() {
        return List.of(WidgetType.forAnnotatedWidget(WaypointTestWidget.class));
    }

    @Override
    public Map<DataType, ComponentType> getDefaultComponents() {
        return Map.of(WaypointDataType.Instance, WidgetType.forAnnotatedWidget(WaypointTestWidget.class));
    }
}
