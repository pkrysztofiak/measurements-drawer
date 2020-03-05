package pl.pkrysztofiak.measurementsdrawer;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import pl.pkrysztofiak.measurementsdrawer.model.Model;
import pl.pkrysztofiak.measurementsdrawer.view.View;
import pl.pkrysztofiak.measurementsdrawer.viewmodel.ViewModel;

public class App extends Application {
    
    private final Model model = new Model();
    private final ViewModel viewModel = new ViewModel(model);
    private final View view = new View(viewModel);
    private final Scene scene = new Scene(view);
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        
        stage.setScene(scene);
        stage.show();
    }
}