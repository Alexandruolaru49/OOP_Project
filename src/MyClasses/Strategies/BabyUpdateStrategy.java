package MyClasses.Strategies;

import MyClasses.Children.Child;
import MyClasses.Strategies.UpdateChildrenStrategy;

public class BabyUpdateStrategy implements UpdateChildrenStrategy {

    Child child;

    public BabyUpdateStrategy(Child child) {
        this.child = child;
    }

    @Override
    public void calculateAverageScore(Child child) {
        Double averageScore = 10d;
        child.setAverageScore(averageScore);
    }

}
