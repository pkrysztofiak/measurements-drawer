package pl.pkrysztofiak.measurementsdrawer.viewmodel.panel;

import pl.pkrysztofiak.measurementsdrawer.model.Model;

public class PanelViewModel {

    private final Model model;
    
    public PanelViewModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }
}