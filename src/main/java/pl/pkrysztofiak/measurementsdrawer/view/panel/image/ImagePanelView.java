package pl.pkrysztofiak.measurementsdrawer.view.panel.image;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.image.ImagePanelViewModel;

public class ImagePanelView extends Pane {
 
    private final Observable<MouseEvent> mousePressedObservable = JavaFxObservable.eventsOf(this, MouseEvent.MOUSE_PRESSED);
    private final Observable<MouseEvent> mouseDraggedObservable = JavaFxObservable.eventsOf(this, MouseEvent.MOUSE_DRAGGED);
    private final Observable<MouseEvent> mouseReleasedObservable = JavaFxObservable.eventsOf(this, MouseEvent.MOUSE_RELEASED);
    private final Observable<MouseEvent> mouseClickedObservable = JavaFxObservable.eventsOf(this, MouseEvent.MOUSE_CLICKED);
    
    public ImagePanelView(ImagePanelViewModel imagePanelViewModel) {
        
    }
    
    public Observable<MouseEvent> mousePressedObservable() {
        return mousePressedObservable;
    }
    
    public Observable<MouseEvent> mouseDraggedObservable() {
        return mouseDraggedObservable;
    }
    
    public Observable<MouseEvent> mouseReleasedObservable() {
        return mouseReleasedObservable;
    }
    
    public Observable<MouseEvent> mouseClickedObservable() {
        return mouseClickedObservable;
    }
}