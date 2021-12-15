package MyClasses.Strategies;

import MyClasses.Children.Child;
import MyClasses.Strategies.UpdateChildrenStrategy;

public class KidUpdateStrategy implements UpdateChildrenStrategy {

    Child child;

    public KidUpdateStrategy(Child child) {
        this.child = child;
    }

    @Override
    public void calculateAverageScore(Child child) {
        if (child.getNiceScoreHistory().size() == 0) {
            child.setAverageScore(child.getNiceScore());
        } else {
            Double sum = 0d;
            for (Double i : child.getNiceScoreHistory()) {
                sum = sum + i;
            }
            sum = sum / (child.getNiceScoreHistory().size());
            child.setAverageScore(sum);
        }
    }

}
