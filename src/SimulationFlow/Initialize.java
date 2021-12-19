package SimulationFlow;

import MyClasses.Changes.AnnualChanges;
import MyClasses.Changes.ChildrenUpdate;
import MyClasses.Children.Child;
import MyClasses.Factory.ChildrenFactory;
import MyClasses.Presents.Gift;
import MyClasses.SantaClaus.Santa;
import MyClasses.Strategies.ApplyStrategy;
import MyClasses.Strategies.StrategyFactory;
import MyClasses.Strategies.UpdateChildrenStrategy;
import Reader.Input;
import common.Constants;
import enums.Category;

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



    public ArrayList<Child> makeInitialList(Input input) {

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

    public ArrayList<Child> getFirstYearList(Santa santa, Input input) {
        ArrayList<Child> firstYearList = getUpdatedList(santa, input);
        return firstYearList;
    }

    public ArrayList<Child> getUpdatedList(Santa santa, Input input) {
        ArrayList<Child> initialList = makeInitialList(input);
        ArrayList<Child> updatedList;
        ApplyStrategy objApplyStrategy = new ApplyStrategy();

        //Am aplicat strategia
        updatedList = objApplyStrategy.applyStrategy(initialList);

        for (int i = 0; i < updatedList.size(); i++) {
            Child child = updatedList.get(i);
            child.calculateAssignedBudget(santa, updatedList);
            child.calculateReceivedGifts(santa);
            child.getNiceScoreHistory().add(child.accessNiceScore());
        }
        return updatedList;
    }

//    public void removeOver18(ArrayList<Child> childrenList) {
//        for (int i = 0; i < childrenList.size(); i++) {
//            Child child = childrenList.get(i);
//            if (child.getAge() > Constants.YOUNG_ADULT_AGE) {
//                childrenList.remove(i);
//            }
//        }
//    }

//    public ArrayList<Child> increaseAge(ArrayList<Child> childrenList, Updates updates) {
//        //Eliminam copiii care au varsta > 18 ani
//        for (int i = 0; i < childrenList.size(); i++) {
//            Child child = childrenList.get(i);
//            child.setAge(child.getAge() + 1);
//        }
//        updates.removeOver18(childrenList);
//        return childrenList;
//    }

//    public ArrayList<Child> updateWithNewChildren(ArrayList<Child> childrenList,
//                                                  ArrayList<Child> newChildren) {
//        for (int i = 0; i < newChildren.size(); i++) {
//            Child child = newChildren.get(i);
//            if (child.getAge() <= Constants.YOUNG_ADULT_AGE) {
//                childrenList.add(child);
//            }
//        }
//        return childrenList;
//    }

//    public void addNewGifts(Santa santa, ArrayList<Gift> newGifts) {
//        for(int i = 0; i < newGifts.size(); i++) {
//            Gift gift = newGifts.get(i);
//            santa.getSantaGiftsList().add(gift);
//        }
//    }

//    public void removeDuplicateCategories(ArrayList<Category> initialList,
//                                          ArrayList<Category> updatedList) {
//        for (int i = 0; i < updatedList.size(); i++) {
//            for (int j = 0; j < initialList.size(); j++) {
//                if (initialList.get(j).equals(updatedList.get(i))) {
//                   initialList.remove(j);
//                }
//            }
//        }
//    }

//    public void updateGiftPreferences(ArrayList<Category> initialList,
//                                      ArrayList<Category> updatedList) {
//        for (int i = 0; i < initialList.size(); i++) {
//            updatedList.add(initialList.get(i));
//        }
//    }

//    public void makeUpdates(ArrayList<Child> childrenList,
//                            ArrayList<ChildrenUpdate> childrenUpdates,
//                            Updates updates) {
//
//        for (int i = 0; i < childrenUpdates.size(); i++) {
//            int id = childrenUpdates.get(i).getId();
//            Double niceScore = childrenUpdates.get(i).getNiceScore();
//            ArrayList<Category> giftsPreferences = childrenUpdates.get(i).getGiftsPreferences();
//
//            for (int j = 0; j < childrenList.size(); j++) {
//                if (childrenList.get(j).getId() == id) {
//                    //Adaugam noul niceScore daca nu este null
//                    if (niceScore != null) {
//                        childrenList.get(j).getNiceScoreHistory().add(niceScore);
//                    }
//                    //Adaugam noile preferinte
//                    if (giftsPreferences != null) {
//                        updates.removeDuplicateCategories(childrenList.get(j).getGiftsPreferences(),
//                                giftsPreferences);
//                        updates.updateGiftPreferences(childrenList.get(j).getGiftsPreferences(),
//                                giftsPreferences);
//                        childrenList.get(j).setGiftsPreferences(giftsPreferences);
//                    }
//                }
//            }
//        }
//    }

    public ArrayList<Child> getAnnualList(ArrayList<Child> childrenList, Santa santa,
                                          Input input, int year) {

        Updates updates = Updates.getInstance();
        AnnualChanges changes = input.getAnnualChanges().get(year - 1);
        Double newSantaBudget = changes.getNewSantaBudget();
        ArrayList<Child> newChildren = changes.getNewChildren();
        ArrayList<ChildrenUpdate> childrenUpdates = changes.getChildrenUpdates();
        ArrayList<Gift> newGifts = changes.getNewGifts();

        //Am crescut varsta copiilor si i-am eliminat din lista pe cei cu varsta > 18
        childrenList = updates.increaseAge(childrenList);

        //Am inserat copiii noi in lista(doar cei cu varsta <= 18)
        childrenList = updates.updateWithNewChildren(childrenList, newChildren);

        //Am setat noul buget si am inserat cadourile noi
        santa.setSantaBudget(newSantaBudget);
        updates.addNewGifts(santa, newGifts);

        //Am actualizat niceScore-ul si preferintele copiilor
        updates.makeUpdates(childrenList, childrenUpdates);

        ArrayList<Child> updatedList;
        ApplyStrategy objApplyStrategy = new ApplyStrategy();

        //Am aplicat strategia
        updatedList = objApplyStrategy.applyStrategy(childrenList);
        updates.removeOver18(updatedList);

        for (int i = 0; i < updatedList.size(); i++) {
            Child child = updatedList.get(i);
            child.calculateAssignedBudget(santa, updatedList);
            child.calculateReceivedGifts(santa);
        }

        return updatedList;
    }

}
