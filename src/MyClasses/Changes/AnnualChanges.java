package MyClasses.Changes;

import MyClasses.Children.Child;
import MyClasses.Presents.Gift;

import java.util.ArrayList;

public class AnnualChanges {
    private Double newSantaBudget;
    private ArrayList<Gift> newGifts;
    private ArrayList<Child> newChildren;
    private ArrayList<Child> childrenUpdates;

    public Double getNewSantaBudget() {
        return newSantaBudget;
    }

    public void setNewSantaBudget(final Double newSantaBudget) {
        this.newSantaBudget = newSantaBudget;
    }

    public ArrayList<Gift> getNewGifts() {
        return newGifts;
    }

    public void setNewGifts(final ArrayList<Gift> newGifts) {
        this.newGifts = newGifts;
    }

    public ArrayList<Child> getNewChildren() {
        return newChildren;
    }

    public void setNewChildren(final ArrayList<Child> newChildren) {
        this.newChildren = newChildren;
    }

    public ArrayList<Child> getChildrenUpdates() {
        return childrenUpdates;
    }

    public void setChildrenUpdates(final ArrayList<Child> childrenUpdates) {
        this.childrenUpdates = childrenUpdates;
    }
}
