package pl.pkrysztofiak.measurementsdrawer.view.panel.image.tools;

import javafx.scene.input.MouseEvent;
import pl.pkrysztofiak.measurementsdrawer.model.measurements.PointMeasurement;
import pl.pkrysztofiak.measurementsdrawer.view.measurements.PointMeasurementView;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.measurements.PointMeasurementViewModel;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.image.ImagePanelViewModel;

public class PointTool extends ImagePanelTool {

    public PointTool(ImagePanelViewModel imagePanelViewModel) {
        super(imagePanelViewModel);
    }

    @Override
    protected void onMousePressed(MouseEvent event) {
        PointMeasurement pointMeasurement = new PointMeasurement(event.getX(), event.getY());
        PointMeasurementView pointMeasurementView = new PointMeasurementView(new PointMeasurementViewModel(pointMeasurement));
        imagePanelViewModel.addCreatedMeasurement(pointMeasurement);
    }
}