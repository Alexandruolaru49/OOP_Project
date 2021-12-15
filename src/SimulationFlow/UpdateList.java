package SimulationFlow;

import MyClasses.Changes.AnnualChanges;
import MyClasses.Children.Child;
import Reader.Input;

import java.util.ArrayList;

public class UpdateList {

    public ArrayList<Child> updateList(ArrayList<Child> children, Input input, int year) {
        // do changes here
        AnnualChanges changes = input.getAnnualChanges().get(year);


        return children;
    }
}
