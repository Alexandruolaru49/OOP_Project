package main;

import MyClasses.Children.Child;
import MyClasses.SantaClaus.Santa;
import Reader.Input;
import Reader.InputLoader;
import SimulationFlow.Initialize;

import java.util.ArrayList;
import java.util.Comparator;

public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        String inputPath = "tests/test2.json";
        InputLoader inputLoader = new InputLoader(inputPath);
        Input input = inputLoader.read();

        Santa santa = Santa.getInstance();
        santa.setSantaBudget(input.getSantaBudget());
        santa.setSantaGiftsList(input.getSantaGiftsList());

        Initialize initialize = Initialize.getInstance();
        ArrayList<Child> childrenList;
        childrenList = initialize.getFirstYearList(santa, input);

        childrenList.sort(new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        });
        System.out.println(santa.getSantaBudget());
        for(Child i : childrenList) {
            System.out.println(i.toString());
            i.displayReceivedGifts();
        }

        int noYears = input.getNumberOfYears();
        //write in output files initial list
        for(int year = 1; year <= noYears; year++) {
            ArrayList<Child> newList = initialize.getAnnualList(childrenList, santa, input, year);

            newList.sort(new Comparator<Child>() {
                @Override
                public int compare(Child o1, Child o2) {
                    return Integer.compare(o1.getId(), o2.getId());
                }
            });

            System.out.println(santa.getSantaBudget());
            for(Child i : newList) {
                System.out.println(i.toString());
                i.displayReceivedGifts();
            }
            //write updated list to output files
            childrenList = newList;
        }

//        for(Child i : childrenList) {
//            System.out.println(i.toString());
//            i.displayReceivedGifts();
//        }

        //input.display();
        //Checker.calculateScore();
    }
}
