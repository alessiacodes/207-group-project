package use_case;

import java.beans.PropertyChangeListener;

public interface ViewModel {
    void firePropertyChanged();
    void addPropertyChangeListener(PropertyChangeListener listener);

}
