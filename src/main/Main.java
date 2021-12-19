package main;

import MyClasses.Children.Child;
import MyClasses.SantaClaus.Santa;
import Reader.Input;
import Reader.InputLoader;
import SimulationFlow.Initialize;
import Writer.Output;
import Writer.WriteOutput;
import checker.Checker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    public void deleteFiles(final File[] directory) {
        if (directory != null) {
            for (File file : directory) {
                if (!file.delete()) {
                    System.out.println("nu s-a sters");
                }
            }
        }
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {

            File directory = new File("tests/");
            Path path = Paths.get("results");
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            File outputDirectory = new File("results");

            Main main = new Main();
            main.deleteFiles(outputDirectory.listFiles());
            int count = 1;
            for (File file : Objects.requireNonNull(directory.listFiles())) {

                String filepath = "results/out_" + file.getName();
                File out = new File(filepath);
                boolean isCreated = out.createNewFile();
                if (isCreated) {
                    System.out.println("Test " + count);
                    count++;
                    action(file.getAbsolutePath(), filepath);
                }
            }

            Checker.calculateScore();
        }


    public static void action(final String inputPath,
                              final String outputPath) {


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
        WriteOutput writeOutput = new WriteOutput();
        //write in output files initial list
        Output output = new Output();
        output.setAnnualChildren(childrenList);
        writeOutput.write(output, outputPath);


//        for(int year = 1; year <= noYears; year++) {
//            ArrayList<Child> newList = initialize.getAnnualList(childrenList, santa, input, year);
//
//            newList.sort(new Comparator<Child>() {
//                @Override
//                public int compare(Child o1, Child o2) {
//                    return Integer.compare(o1.getId(), o2.getId());
//                }
//            });
//
//            output.setAnnualChildren(newList);
//            System.out.println(santa.getSantaBudget());
//            for(Child i : newList) {
//                System.out.println(i.toString());
//                i.displayReceivedGifts();
//            }
//            //write updated list to output files
//
//            writeOutput.write(output, outputPath);
//            childrenList = newList;
//        }

    }
}
