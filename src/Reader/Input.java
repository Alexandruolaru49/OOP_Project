package Reader;

import MyClasses.Changes.AnnualChanges;
import MyClasses.Children.Child;
import MyClasses.Presents.Gift;

import java.util.ArrayList;

public class Input {

    private final int numberOfYears;
    private final Double santaBudget;
    private final ArrayList<Child> children;
    private final ArrayList<Gift> santaGiftsList;
    private final ArrayList<AnnualChanges> annualChanges;


    public Input(final int numberOfYears, final Double santaBudget,
                     final ArrayList<Child> children, final ArrayList<Gift> santaGiftsList,
                     final ArrayList<AnnualChanges> annualChanges) {
        this.numberOfYears = numberOfYears;
        this.santaBudget = santaBudget;
        this.children = children;
        this.santaGiftsList = santaGiftsList;
        this.annualChanges = annualChanges;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public ArrayList<Child> getChildren() {
        return children;
    }

    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public ArrayList<AnnualChanges> getAnnualChanges() {
        return annualChanges;
    }


    @Override
    public String toString() {
        return "Input{" +
                "numberOfYears=" + numberOfYears +
                ", santaBudget=" + santaBudget +
                ", children=" + children.toString() +
                ", santaGiftsList=" + santaGiftsList.toString() +
                ", annualChanges=" + annualChanges.toString() +
                '}';
    }

    public void display() {
        System.out.print(numberOfYears + " ");
        System.out.print(santaBudget + " ");
        for(int i = 0; i < children.size(); i++) {
            System.out.print(children.get(i).getFirstName() + " ");
        }
        for(int i = 0; i < santaGiftsList.size(); i++) {
            System.out.print(santaGiftsList.get(i).getProductName() + " ");
        }
        for(int i = 0; i < annualChanges.size(); i++) {
            System.out.print(annualChanges.get(i).getNewSantaBudget() + " ");
        }
        System.out.println();
    }
}
