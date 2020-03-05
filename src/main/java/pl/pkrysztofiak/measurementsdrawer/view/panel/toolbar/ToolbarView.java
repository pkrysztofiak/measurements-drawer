package pl.pkrysztofiak.measurementsdrawer.view.panel.toolbar;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import pl.pkrysztofiak.measurementsdrawer.view.panel.toolbar.tools.Tool;

public class ToolbarView extends FlowPane {

    private final ToggleGroup toggleGroup = new ToggleGroup();
    
    private final ToggleButton pointButton = new ToggleButton("Point");
    private final Observable<Tool> pointSelectedObservable = JavaFxObservable.valuesOf(pointButton.selectedProperty()).filter(Boolean.TRUE::equals).map(selected -> Tool.POINT);
    
    private final ToggleButton lineButton = new ToggleButton("Line");
    private final Observable<Tool> lineSelectedObservable = JavaFxObservable.valuesOf(lineButton.selectedProperty()).filter(Boolean.TRUE::equals).map(selected -> Tool.LINE);
    
    private final ObjectProperty<Tool> selectedToolProperty = new SimpleObjectProperty<>();
    private final Observable<Tool> selectedToolObservable = JavaFxObservable.valuesOf(selectedToolProperty);
    
    {
        toggleGroup.getToggles().setAll(pointButton, lineButton);
        
        pointButton.setMinWidth(96.);
        lineButton.setMinWidth(96.);
        pointButton.setSelected(true);
        
        getChildren().setAll(pointButton, lineButton);
    }
    
    {
        Observable.merge(pointSelectedObservable, lineSelectedObservable).subscribe(selectedToolProperty::set);
    }
    
    public ToolbarView() {
        
    }
    
    public Observable<Tool> selectedToolObservable() {
        return selectedToolObservable;
    }
}