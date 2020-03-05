package pl.pkrysztofiak.measurementsdrawer.view.panel;

import javafx.scene.layout.BorderPane;
import pl.pkrysztofiak.measurementsdrawer.view.panel.image.ImagePanelView;
import pl.pkrysztofiak.measurementsdrawer.view.panel.toolbar.ToolbarView;
import pl.pkrysztofiak.measurementsdrawer.view.panel.toolbar.tools.Tool;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.PanelViewModel;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.image.ImagePanelViewModel;

public class PanelView extends BorderPane {

    
    private final int columnIndex;
    private final int rowIndex;

    private final ToolbarView toolbarView = new ToolbarView();
    
    private final ImagePanelViewModel imagePanelViewModel; 
    private final ImagePanelView imagePanelView;
    
    {
        setTop(toolbarView);
        setStyle("-fx-background-color: purple, white; -fx-background-insets: 0, 1;");
    }
    
    public PanelView(int columnIndex, int rowIndex, PanelViewModel panelViewModel) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        
        imagePanelViewModel = new ImagePanelViewModel(panelViewModel.getModel());
        imagePanelView = new ImagePanelView(imagePanelViewModel);
        setCenter(imagePanelView);
                
        toolbarView.selectedToolObservable().subscribe(this::onSelectedToolChanged);
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public int getRowIndex() {
        return rowIndex;
    }
    
    private void onSelectedToolChanged(Tool tool) {
        imagePanelViewModel.setSelectedTool(tool);
    }
}
