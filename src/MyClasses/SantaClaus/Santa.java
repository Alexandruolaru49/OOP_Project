package MyClasses.SantaClaus;

import MyClasses.Children.Child;
import MyClasses.Presents.Gift;

import java.util.ArrayList;

public class Santa {

    private static Santa instance = null;

    private Santa() {

    }

    public static Santa getInstance() {
        if(instance == null) {
            instance = new Santa();
        }
        return instance;
    }

    private Double santaBudget;
    private ArrayList<Gift> santaGiftsList;

    public Double getAllScores(ArrayList<Child> children) {
        Double sum = 0d;
        for (Child i : children) {
            sum = sum + i.getAverageScore();
        }
        return sum;
    }

    public Double getSantaBudget() {
        return santaBudget;
    }

    public void setSantaBudget(final Double santaBudget) {
        this.santaBudget = santaBudget;
    }

    public ArrayList<Gift> getSantaGiftsList() {
        return santaGiftsList;
    }

    public void setSantaGiftsList(final ArrayList<Gift> santaGiftsList) {
        this.santaGiftsList = santaGiftsList;
    }
}
