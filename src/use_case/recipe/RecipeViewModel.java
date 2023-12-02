package use_case.recipe;

import entity.Recipe;
import use_case.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RecipeViewModel implements ViewModel {
    private RecipeState state = new RecipeState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public RecipeState getState() {
        return state;
    }

    public void setState(RecipeState state) {
        this.state = state;
    }
}