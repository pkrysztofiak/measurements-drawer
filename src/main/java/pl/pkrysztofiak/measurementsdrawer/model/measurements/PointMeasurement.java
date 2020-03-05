package pl.pkrysztofiak.measurementsdrawer.model.measurements;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class PointMeasurement extends Measurement {

    private final DoubleProperty xProperty = new SimpleDoubleProperty();
    private final DoubleProperty yProperty = new SimpleDoubleProperty();
    
    public PointMeasurement(double x, double y) {
        xProperty.set(x);
        yProperty.set(y);
    }
}