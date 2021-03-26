package CoordinateDataType;

import edu.wpi.first.shuffleboard.api.data.ComplexDataType;

import java.util.Map;
import java.util.function.Function;

public final class WaypointDataType extends ComplexDataType<WaypointData> {

    // Set the default name for the data type
    private static final String NAME = "Waypoint";

    // Create a new static instance of the data type to allow the plugin to register the data type as a valid one for use in the plugin
    public  static  final WaypointDataType Instance = new WaypointDataType();

    public WaypointDataType(){
        super(NAME, WaypointData.class);
    }

    @Override
    public Function<Map<String, Object>, WaypointData> fromMap() {
        return map ->{
            return new WaypointData(
                    (double) map.getOrDefault("x", 0.0),
                    (double) map.getOrDefault("y", 0.0),
                    (boolean) map.getOrDefault("isCalculated", false)
            );
        };
    }

    @Override
    public WaypointData getDefaultValue() {
        return new WaypointData(0, 0, false);
    }
}
