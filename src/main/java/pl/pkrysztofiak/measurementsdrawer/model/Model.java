package pl.pkrysztofiak.measurementsdrawer.model;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.rxjavafx.observables.JavaFxObservable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pl.pkrysztofiak.measurementsdrawer.model.measurements.Measurement;

public class Model {

    public final PublishSubject<Measurement> measurementAddRequest = PublishSubject.create();
    
    private final ObservableList<Measurement> measurements = FXCollections.observableArrayList();
    private final Observable<Measurement> measurementAddedObservable = JavaFxObservable.additionsOf(measurements).startWith(measurements);
    
    {
        measurementAddRequest.delay(0, TimeUnit.SECONDS, Schedulers.single()).subscribe(this::onMeasurementAddRequest);
    }
    
    public Observable<Measurement> measurementAddedObservable() {
        return measurementAddedObservable;
    }
    
    private void onMeasurementAddRequest(Measurement measurement) {
        measurements.add(measurement);
    }
}