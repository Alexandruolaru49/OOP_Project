package MyClasses.Children;

import MyClasses.Presents.Gift;
import MyClasses.SantaClaus.Santa;
import enums.Category;
import enums.Cities;

import java.util.ArrayList;
import java.util.Comparator;

public class Child {
    private int id;
    private String lastName;
    private String firstName;
    private Cities city;
    private int age;

    private Double niceScore; //!!

    private ArrayList<Category> giftsPreferences;
    private Double averageScore;
    private ArrayList<Double> niceScoreHistory = new ArrayList<Double>();
    private Double assignedBudget;
    private ArrayList<Gift> receivedGifts = new ArrayList<Gift>();

    public void calculateAssignedBudget(Santa santa, ArrayList<Child> children) {
        Double budgetUnit = (santa.getSantaBudget()) / (santa.getAllScores(children));
        this.setAssignedBudget(this.getAverageScore() * budgetUnit);
    }

    public void calculateReceivedGifts(Santa santa) {
        ArrayList<Gift> gifts = new ArrayList<Gift>();
        for (int i = 0; i < santa.getSantaGiftsList().size(); i++) {
            gifts.add(santa.getSantaGiftsList().get(i));
        }

        gifts.sort(new Comparator<Gift>() {
            @Override
            public int compare(Gift o1, Gift o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });

        Double budget = this.getAssignedBudget();
        ArrayList<Gift> giftsReceived = new ArrayList<Gift>();

        for (Category category : this.getGiftsPreferences()) {
            for (int i = 0; i < gifts.size(); i++) {
                if (gifts.get(i).getCategory().equals(category)) {
                    if (budget > gifts.get(i).getPrice()) {
                        budget = budget - gifts.get(i).getPrice();
                        giftsReceived.add(gifts.get(i));
                        gifts.remove(i);
                        break;
                    }
                }
            }
        }
        this.setReceivedGifts(giftsReceived);
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(final Cities city) {
        this.city = city;
    }

    public Double accessNiceScore() {
        return niceScore;
    }

    public void setNiceScore(final Double niceScore) {
        this.niceScore = niceScore;
    }

    public ArrayList<Category> getGiftsPreferences() {
        return giftsPreferences;
    }

    public void setGiftsPreferences(final ArrayList<Category> giftsPreferences) {
        this.giftsPreferences = giftsPreferences;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    public ArrayList<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    public void setNiceScoreHistory(final ArrayList<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    public Double getAssignedBudget() {
        return assignedBudget;
    }

    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    public ArrayList<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    public void setReceivedGifts(final ArrayList<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", city=" + city +
                ", niceScore=" + niceScore +
                ", giftsPreferences=" + giftsPreferences +
                ", averageScore=" + averageScore +
                ", niceScoreHistory=" + niceScoreHistory +
                ", assignedBudget=" + assignedBudget +"}   ";
    }

    public void displayReceivedGifts() {
        System.out.print("Gifts received: ");
        for(Gift g : getReceivedGifts()) {
            System.out.print(g.getProductName() + " ");
        }
        System.out.println();
    }
}
