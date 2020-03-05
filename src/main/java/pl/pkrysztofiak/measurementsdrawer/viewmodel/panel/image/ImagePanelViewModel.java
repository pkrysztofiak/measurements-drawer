package pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.image;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.rxjavafx.schedulers.JavaFxScheduler;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pkrysztofiak.measurementsdrawer.model.Model;
import pl.pkrysztofiak.measurementsdrawer.model.measurements.Measurement;
import pl.pkrysztofiak.measurementsdrawer.view.panel.image.tools.ImagePanelTool;
import pl.pkrysztofiak.measurementsdrawer.view.panel.image.tools.LineTool;
import pl.pkrysztofiak.measurementsdrawer.view.panel.image.tools.PointTool;
import pl.pkrysztofiak.measurementsdrawer.view.panel.toolbar.tools.Tool;

public class ImagePanelViewModel {

    private final ObjectProperty<ImagePanelTool> selectedToolProperty = new SimpleObjectProperty<>();
    private final Observable<ImagePanelTool> selectedToolObservable = JavaFxObservable.valuesOf(selectedToolProperty);
    
    private final ObservableList<Measurement> measurements = FXCollections.observableArrayList(); 
    
    private final List<Measurement> createdMeasurements = new ArrayList<>();
    
    public ImagePanelViewModel(Model model) {
        model.measurementAddedObservable().observeOn(JavaFxScheduler.platform());
    }
    
    public void setSelectedTool(Tool tool) {
        switch (tool) {
        case POINT:
            selectedToolProperty.set(new PointTool(this));
            break;
        case LINE:
            selectedToolProperty.set(new LineTool(this));
            break;
        default:
            break;
        }
    }
    
    public void addCreatedMeasurement(Measurement measurement) {
        createdMeasurements.add(measurement);
    }
}