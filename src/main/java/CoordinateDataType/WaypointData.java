package CoordinateDataType;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;
import java.util.Objects;

/**
 * Allows a a pair of X and Y coordinates as well as what type of waypoint this to be passed to the plugin
 */
public final class WaypointData extends ComplexData<WaypointData> {
    private final double x;
    private final double y;
    private final boolean isCalculated;

    public WaypointData(double x, double y, boolean isCalculated){
        this.x = x;
        this.y = y;
        this.isCalculated = isCalculated;
    }

    /**
     * Create new objects to store changed values
     * @param newY new Y value
     * @return new WaypointObject
     */
    public WaypointData withY(double newY){
        return new WaypointData(this.x, this.y, this.isCalculated);
    }

    /**
     * Create new objects to store changed values
     * @param newX new X value
     * @return new WaypointObject
     */
    public WaypointData withX(double newX){
        return new WaypointData(newX, this.y, this.isCalculated);
    }

    /**
     * Create new objects to store changed values
     * @param newIsCalculated new isCalculated value
     * @return new WaypointObject
     */
    public WaypointData withIsCalculated(boolean newIsCalculated){
        return new WaypointData(this.x, this.y, newIsCalculated);
    }

    /**
     * Getter for X value
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for Y value
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Getter for isCalculated value
     * @return isCalculated
     */
    public boolean isCalculated() {
        return isCalculated;
    }

    @Override
    public Map<String, Object> asMap() {
        return Map.of("x", x, "y", y, "isCalculated", isCalculated);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaypointData that = (WaypointData) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && isCalculated == that.isCalculated;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, isCalculated);
    }
}
