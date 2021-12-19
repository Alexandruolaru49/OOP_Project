package MyClasses.Factory;

import MyClasses.Children.Child;
import MyClasses.Children.Baby;
import MyClasses.Children.Kid;
import MyClasses.Children.Teen;
import MyClasses.Children.YoungAdult;
import common.Constants;

public class ChildrenFactory {


    public static Child createChild(String type, Child child) {
        switch (type) {
            case Constants.BABY: {
                return new Baby(child); //copy-constructor
            }
            case Constants.KID: {
                return new Kid(child);  //copy-constructor
            }
            case Constants.TEEN: {
                return new Teen(child); //copy-constructor
            }
            case Constants.YOUNG_ADULT: {
                return new YoungAdult(child); //copy-constructor
            }
        }
        throw new IllegalArgumentException("The child type " + type + " is not recognized.");
    }
}
