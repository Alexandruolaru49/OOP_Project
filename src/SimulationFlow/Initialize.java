package SimulationFlow;

import MyClasses.Children.Child;
import MyClasses.Factory.ChildrenFactory;
import MyClasses.SantaClaus.Santa;
import MyClasses.Strategies.StrategyFactory;
import MyClasses.Strategies.UpdateChildrenStrategy;
import Reader.Input;
import common.Constants;

import java.util.ArrayList;

public class Initialize {

    private static Initialize instance = null;

    private Initialize() {

    }

    public static Initialize getInstance() {
        if (instance == null) {
            instance = new Initialize();
        }
        return instance;
    }



    public ArrayList<Child> makeInitialList(Santa santa, Input input) {

        ArrayList<Child> initialList = new ArrayList<Child>();
        ArrayList<Child> children = input.getChildren();

        for (int i = 0; i < children.size(); i++) {
            Child child = children.get(i);
            if (child.getAge() <= Constants.YOUNG_ADULT_AGE) {
                initialList.add(child);
            }
        }
        return initialList;
    }

    public ArrayList<Child> getUpdatedList(Santa santa, Input input) {
        ArrayList<Child> initialList = makeInitialList(santa,input);
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
            if (child.getAge() >= Constants.TEEN_LOWER && child.getAge() < Constants.TEEN_UPPER) {
                type = Constants.TEEN;
            }
//            if (child.getAge() > Constants.YOUNG_ADULT_AGE) {
//                type = Constants.YOUNG_ADULT;
//            }

            // Cream copilul cu ChildrenFactory.createChild si aplicam strategia
            Child newChild = ChildrenFactory.createChild(type, child);
            UpdateChildrenStrategy strategy = StrategyFactory.createStrategy(type, newChild);
            strategy.calculateAverageScore(newChild);
            updatedList.add(newChild);
        }


        for (int i = 0; i < updatedList.size(); i++) {
            Child child = updatedList.get(i);
            child.calculateAssignedBudget(santa, updatedList);
            child.calculateReceivedGifts(santa);
            child.getNiceScoreHistory().add(child.getNiceScore());
            //newChild.setAge(newChild.getAge() + 1);
        }
        return updatedList;
    }

    public ArrayList<Child> getFirstYearList(Santa santa, Input input) {
        ArrayList<Child> firstYearList = getUpdatedList(santa, input);
        return firstYearList;
    }
}
