package pl.pkrysztofiak.measurementsdrawer.view.panel.image.tools;

import io.reactivex.observers.ResourceObserver;
import javafx.scene.input.MouseEvent;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.panel.image.ImagePanelViewModel;

public abstract class ImagePanelTool {

    protected final ImagePanelViewModel imagePanelViewModel;
    
    public ImagePanelTool(ImagePanelViewModel imagePanelViewModel) {
        this.imagePanelViewModel = imagePanelViewModel;
    }
    
    public final OnMousePressedObserver onnMousePressedObserver() {
        return new OnMousePressedObserver();
    }
    
    protected void onMousePressed(MouseEvent event) {
        
    }
    
    private class OnMousePressedObserver extends ResourceObserver<MouseEvent> {

        @Override
        public void onNext(MouseEvent event) {
            ImagePanelTool.this.onMousePressed(event);
        }

        @Override
        public void onError(Throwable e) {
            
        }

        @Override
        public void onComplete() {
            
        }
    }
}
