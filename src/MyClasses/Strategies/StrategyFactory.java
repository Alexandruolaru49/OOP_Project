package MyClasses.Strategies;

import MyClasses.Children.Child;
import common.Constants;

public class StrategyFactory {
    public static UpdateChildrenStrategy createStrategy(String strategy, Child child) {
        switch (strategy) {
            case Constants.BABY: {
                return new BabyUpdateStrategy(child);
            }
            case Constants.KID: {
                return new KidUpdateStrategy(child);
            }
            case Constants.TEEN: {
                return new TeenUpdateStrategy(child);
            }
            case Constants.YOUNG_ADULT: {
                // nothing happens
            }
        }
        throw new IllegalArgumentException("The strategy type " + strategy + " is not recognized.");
    }
}
