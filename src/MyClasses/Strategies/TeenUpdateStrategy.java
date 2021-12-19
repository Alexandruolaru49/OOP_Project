package MyClasses.Strategies;

import MyClasses.Children.Child;
import MyClasses.Strategies.UpdateChildrenStrategy;

public class TeenUpdateStrategy implements UpdateChildrenStrategy {

    Child child;

    public TeenUpdateStrategy(Child child) {
        this.child = child;
    }

    @Override
    public void calculateAverageScore(Child child) {
        if (child.getNiceScoreHistory().size() == 0) {
            child.setAverageScore(child.accessNiceScore());
        } else {
            Double sum = 0d;
            for (int i = 0; i < child.getNiceScoreHistory().size(); i++) {
                sum = sum + (child.getNiceScoreHistory().get(i) * (i + 1));
            }
            sum = (2 * sum) / (child.getNiceScoreHistory().size() *
                    (child.getNiceScoreHistory().size() + 1));
            child.setAverageScore(sum);
        }
    }
}
