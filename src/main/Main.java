package main;

import MyClasses.Children.Child;
import MyClasses.SantaClaus.Santa;
import Reader.Input;
import Reader.InputLoader;
import SimulationFlow.Initialize;

import java.util.ArrayList;

/**
 * Class used to run the code
 */
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
        String inputPath = "tests/test25.json";
        InputLoader inputLoader = new InputLoader(inputPath);
        Input input = inputLoader.read();

        Santa santa = Santa.getInstance();
        santa.setSantaBudget(input.getSantaBudget());
        santa.setSantaGiftsList(input.getSantaGiftsList());

        Initialize initialize = Initialize.getInstance();
        ArrayList<Child> childrenList;
        childrenList = initialize.getFirstYearList(santa, input);

        for(Child i : childrenList) {
            System.out.println(i.toString());
            i.displayReceivedGifts();
        }

        //input.display();
        //Checker.calculateScore();
    }
}
