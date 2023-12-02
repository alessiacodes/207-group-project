package use_case.track;

import use_case.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrackViewModel implements ViewModel {

    public static final String TRACK_BUTTON_LABEL = "Track Food";
    private TrackState state;
    private final PropertyChangeSupport propertyChangeSupport;

    public TrackViewModel(TrackState state) {
        this.state = state;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void firePropertyChanged() {
        // Notify listeners that a property has changed
        propertyChangeSupport.firePropertyChange("propertyName", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public TrackState getState() {
        return state;
    }

    public void setState(TrackState state){
        this.state = state;
    }
}
