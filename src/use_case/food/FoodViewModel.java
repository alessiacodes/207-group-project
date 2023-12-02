package use_case.food;

import use_case.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class FoodViewModel implements ViewModel {

    private FoodState state = new FoodState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public FoodState getState() {
        return state;
    }

    public void setFoodState(FoodState state) {
        this.state = state;
    }

}
