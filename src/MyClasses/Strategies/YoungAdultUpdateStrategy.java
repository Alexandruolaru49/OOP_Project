package MyClasses.Strategies;

import MyClasses.Children.Child;
import MyClasses.Strategies.UpdateChildrenStrategy;

public class YoungAdultUpdateStrategy implements UpdateChildrenStrategy {
    @Override
    public void calculateAverageScore(Child child) {
        child.setAverageScore(0d);
    }
}
