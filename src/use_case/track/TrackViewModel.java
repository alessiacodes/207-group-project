package use_case.track;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrackViewModel {

    private TrackState state = new TrackState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private String viewName;

    public TrackViewModel(String viewName) {
        this.viewName = viewName;
    }
    public String getViewName() {
        return this.viewName;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public TrackState getState() {
        return state;
    }
    public void setState(TrackState state) {
        this.state = state;
    }

}
