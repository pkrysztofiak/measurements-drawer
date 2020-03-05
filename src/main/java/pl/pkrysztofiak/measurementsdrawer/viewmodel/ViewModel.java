package pl.pkrysztofiak.measurementsdrawer.viewmodel;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pkrysztofiak.measurementsdrawer.model.Model;
import pl.pkrysztofiak.measurementsdrawer.view.panel.PanelView;

public class ViewModel {

    private final Model model;
    
    public final IntegerProperty columnsProperty = new SimpleIntegerProperty(4);
    public final IntegerProperty rowsProperty = new SimpleIntegerProperty(2);
    
    public final ObservableList<PanelView> panels = FXCollections.observableArrayList();
    
    public ViewModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}