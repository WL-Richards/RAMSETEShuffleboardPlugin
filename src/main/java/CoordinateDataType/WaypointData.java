package CoordinateDataType;

import edu.wpi.first.shuffleboard.api.data.ComplexData;

import java.util.Map;
import java.util.Objects;

/**
 * Allows a a pair of X and Y coordinates as well as what type of waypoint this to be passed to the plugin
 */
public final class WaypointData extends ComplexData<WaypointData> {
    private final double realX, realY, calculatedX, calculatedY;
    private final boolean resetChart;

    public WaypointData(double realX, double realY, double calculatedX, double calculatedY, boolean resetChart) {
        this.realX = realX;
        this.realY = realY;
        this.calculatedX = calculatedX;
        this.calculatedY = calculatedY;
        this.resetChart = resetChart;
    }


    /**
     * Create new objects to store changed values
     * @param newY new Y value
     * @return new WaypointObject
     */
    public WaypointData setRealY(double newY){
        return new WaypointData(this.realX, newY, this.calculatedX, this.calculatedY, this.resetChart);
    }

    /**
     * Create new objects to store changed values
     * @param newX new X value
     * @return new WaypointObject
     */
    public WaypointData setRealX(double newX){
        return new WaypointData(newX, this.realY, this.calculatedX, this.calculatedY, this.resetChart);
    }

    /**
     * Create new objects to store changed values
     * @param newY new Y value
     * @return new WaypointObject
     */
    public WaypointData setCalculatedY(double newY){
        return new WaypointData(this.realX, this.realY, this.calculatedX, newY, this.resetChart);
    }

    /**
     * Create new objects to store changed values
     * @param newX new X value
     * @return new WaypointObject
     */
    public WaypointData setCalculatedX(double newX){
        return new WaypointData(this.realX, this.realY, newX, this.calculatedY, this.resetChart);
    }

    @Override
    public Map<String, Object> asMap() {
        return Map.of("realX", realX, "realY", realY, "calculatedX", calculatedX, "calculatedY", calculatedY, "resetChart", resetChart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaypointData that = (WaypointData) o;
        return Double.compare(that.realX, realX) == 0 && Double.compare(that.realY, realY) == 0 && Double.compare(that.calculatedX, calculatedX) == 0 && Double.compare(that.calculatedY, calculatedY) == 0 && resetChart == that.resetChart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realX, realY, calculatedX, calculatedY, resetChart);
    }

    public double getRealX() {
        return realX;
    }

    public double getRealY() {
        return realY;
    }

    public double getCalculatedX() {
        return calculatedX;
    }

    public double getCalculatedY() {
        return calculatedY;
    }

    public boolean getResetChart() {return resetChart;}
}
