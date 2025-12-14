package Asignment1;

public class JobListining {

    private String title;
    private int budget;

    public JobListining(String title, int budget) {
        this.title = title;
        this.budget = budget;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void showJob() {
        System.out.println("Job title: " + title + ", Budget: " + budget);
    }
}
