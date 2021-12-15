package MyClasses.Children;

public class Kid extends Child{

    public Kid(Child child) {
        this.setFirstName(child.getFirstName());
        this.setLastName(child.getLastName());
        this.setAge(child.getAge());
        this.setId(child.getId());
        this.setCity(child.getCity());
        this.setNiceScore(child.getNiceScore());
        this.setGiftsPreferences(child.getGiftsPreferences());
        this.setAverageScore(child.getAverageScore());
        this.setNiceScoreHistory(child.getNiceScoreHistory());
        this.setAssignedBudget(child.getAssignedBudget());
        this.setReceivedGifts(child.getReceivedGifts());
    }

}
