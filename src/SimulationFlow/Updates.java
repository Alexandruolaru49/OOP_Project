package SimulationFlow;

import MyClasses.Changes.AnnualChanges;
import MyClasses.Changes.ChildrenUpdate;
import MyClasses.Children.Child;
import MyClasses.Presents.Gift;
import MyClasses.SantaClaus.Santa;
import Reader.Input;
import common.Constants;
import enums.Category;

import java.util.ArrayList;

public class Updates {

    private static Updates instance = null;

    private Updates() {

    }

    public static Updates getInstance() {
        if (instance == null) {
            instance = new Updates();
        }
        return instance;
    }

    public void removeOver18(ArrayList<Child> childrenList) {
        for (int i = 0; i < childrenList.size(); i++) {
            Child child = childrenList.get(i);
            if (child.getAge() > Constants.YOUNG_ADULT_AGE) {
                childrenList.remove(i);
            }
        }
    }

    public ArrayList<Child> increaseAge(ArrayList<Child> childrenList) {
        //Eliminam copiii care au varsta > 18 ani
        for (int i = 0; i < childrenList.size(); i++) {
            Child child = childrenList.get(i);
            child.setAge(child.getAge() + 1);
        }
        removeOver18(childrenList);
        return childrenList;
    }

    public ArrayList<Child> updateWithNewChildren(ArrayList<Child> childrenList,
                                                  ArrayList<Child> newChildren) {
        for (int i = 0; i < newChildren.size(); i++) {
            Child child = newChildren.get(i);
            if (child.getAge() <= Constants.YOUNG_ADULT_AGE) {
                childrenList.add(child);
            }
        }
        return childrenList;
    }

    public void addNewGifts(Santa santa, ArrayList<Gift> newGifts) {
        for(int i = 0; i < newGifts.size(); i++) {
            Gift gift = newGifts.get(i);
            santa.getSantaGiftsList().add(gift);
        }
    }

    public void removeDuplicateCategories(ArrayList<Category> initialList,
                                          ArrayList<Category> updatedList) {
        for (int i = 0; i < updatedList.size(); i++) {
            for (int j = 0; j < initialList.size(); j++) {
                if (initialList.get(j).equals(updatedList.get(i))) {
                    initialList.remove(j);
                }
            }
        }
    }

    public void updateGiftPreferences(ArrayList<Category> initialList,
                                      ArrayList<Category> updatedList) {
        for (int i = 0; i < initialList.size(); i++) {
            updatedList.add(initialList.get(i));
        }
    }

    public void makeUpdates(ArrayList<Child> childrenList,
                            ArrayList<ChildrenUpdate> childrenUpdates) {

        for (int i = 0; i < childrenUpdates.size(); i++) {
            int id = childrenUpdates.get(i).getId();
            Double niceScore = childrenUpdates.get(i).getNiceScore();
            ArrayList<Category> giftsPreferences = childrenUpdates.get(i).getGiftsPreferences();

            for (int j = 0; j < childrenList.size(); j++) {
                if (childrenList.get(j).getId() == id) {
                    //Adaugam noul niceScore daca nu este null
                    if (niceScore != null) {
                        childrenList.get(j).getNiceScoreHistory().add(niceScore);
                    }
                    //Adaugam noile preferinte
                    if (giftsPreferences != null) {
                        removeDuplicateCategories(childrenList.get(j).getGiftsPreferences(),
                                giftsPreferences);
                        updateGiftPreferences(childrenList.get(j).getGiftsPreferences(),
                                giftsPreferences);
                        childrenList.get(j).setGiftsPreferences(giftsPreferences);
                    }
                }
            }
        }
    }


}
