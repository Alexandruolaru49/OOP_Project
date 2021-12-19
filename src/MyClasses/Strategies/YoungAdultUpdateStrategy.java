package MyClasses.Strategies;

import MyClasses.Children.Child;
import MyClasses.Children.YoungAdult;
import MyClasses.Strategies.UpdateChildrenStrategy;

public class YoungAdultUpdateStrategy implements UpdateChildrenStrategy {

    Child child;

    public YoungAdultUpdateStrategy(Child child) {
        this.child = child;
    }

    @Override
    public void calculateAverageScore(Child child) {
        child.setAverageScore(0d);
    }
}
