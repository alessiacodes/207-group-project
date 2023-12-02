package use_case.recommend;
import use_case.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecommendViewModel implements ViewModel{
    private RecommendState state = new RecommendState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public RecommendState getState() {
        return state;
    }

    public void setState(RecommendState state) {
        this.state = state;
    }
}
