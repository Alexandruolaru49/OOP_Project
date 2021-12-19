package MyClasses.Strategies;

import MyClasses.Children.Child;
import MyClasses.Factory.ChildrenFactory;
import common.Constants;

import java.util.ArrayList;

public class ApplyStrategy {

    public ArrayList<Child> applyStrategy(ArrayList<Child> initialList) {

        ArrayList<Child> updatedList = new ArrayList<Child>();
        for (int i = 0; i < initialList.size(); i++) {
            Child child = initialList.get(i);
            String type = "";
            if (child.getAge() < Constants.BABY_UPPER) {
                type = Constants.BABY;
            }
            if (child.getAge() >= Constants.KID_LOWER && child.getAge() < Constants.KID_UPPER) {
                type = Constants.KID;
            }
            if (child.getAge() >= Constants.TEEN_LOWER && child.getAge() <= Constants.TEEN_UPPER) {
                type = Constants.TEEN;
            }
            if (child.getAge() > Constants.YOUNG_ADULT_AGE) {
                type = Constants.YOUNG_ADULT;
            }

            // Cream copilul cu ChildrenFactory.createChild si aplicam strategia
            Child newChild = ChildrenFactory.createChild(type, child);
            UpdateChildrenStrategy strategy = StrategyFactory.createStrategy(type, newChild);
            strategy.calculateAverageScore(newChild);
            updatedList.add(newChild);
        }
        return updatedList;
    }
}

