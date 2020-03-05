package pl.pkrysztofiak.measurementsdrawer.view;

import java.util.stream.IntStream;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import pl.pkrysztofiak.measurementsdrawer.view.panel.PanelView;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.ViewModel;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.PanelViewModel;

public class View extends GridPane {

    private final IntegerProperty columnsProperty = new SimpleIntegerProperty();
    private final Observable<Integer> columnsObservable = JavaFxObservable.valuesOf(columnsProperty).map(Number::intValue);
    
    private final IntegerProperty rowsProperty = new SimpleIntegerProperty();
    private final Observable<Integer> rowsObservable = JavaFxObservable.valuesOf(rowsProperty).map(Number::intValue);
    
    private final ObservableList<PanelView> panels = FXCollections.observableArrayList();
    private final Observable<PanelView> panelAddedObservable = JavaFxObservable.additionsOf(panels).startWith(panels);
    
    {
        columnsObservable.subscribe(this::onColumnsChanged);
        rowsObservable.subscribe(this::onRowsChanged);
        panelAddedObservable.subscribe(this::onPanelAdded);
    }
    
    public View(ViewModel viewModel) {
        columnsProperty.bindBidirectional(viewModel.columnsProperty);
        rowsProperty.bindBidirectional(viewModel.rowsProperty);
        Bindings.bindContentBidirectional(panels, viewModel.panels);
        Bindings.bindContent(getChildren(), panels);
        
        IntStream.range(0, rowsProperty.get()).forEach(rowIndex -> IntStream.range(0, columnsProperty.get()).forEach(columnIndex -> {
            panels.add(new PanelView(columnIndex, rowIndex, new PanelViewModel(viewModel.getModel())));
        }));
    }
    
    private void onColumnsChanged(int columns) {
        getColumnConstraints().clear();
        IntStream.range(0, columns).forEach(columnIndex -> {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setHgrow(Priority.SOMETIMES);
            getColumnConstraints().add(columnConstraints);
        });
    }
    
    private void onRowsChanged(int rows) {
        getRowConstraints().clear();
        IntStream.range(0, rows).forEach(rowIndex -> {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            getRowConstraints().add(rowConstraints);
        });
    }
    
    private void onPanelAdded(PanelView panel) {
        GridPane.setConstraints(panel, panel.getColumnIndex(), panel.getRowIndex());
        GridPane.setMargin(panel, new Insets(8));
    }
}