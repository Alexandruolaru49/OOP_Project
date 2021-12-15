package MyClasses.Changes;

import MyClasses.Presents.Gift;
import enums.Category;

import java.util.ArrayList;

public class ChildrenUpdate {
    private int id;
    private Double niceScore;
    private ArrayList<Category> giftsPreferences;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public Double getNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }
}

