package Asignment1;

public class JobListing {
    private String title;
    private int budget;
    private Freelancer freelancer; // Кто выполняет работу

    public JobListing(String title, int budget) {
        this.title = title;
        this.budget = budget;
        this.freelancer = null;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getBudget() { return budget; }
    public void setBudget(int budget) { this.budget = budget; }

    public void assignFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public void showJob() {
        System.out.println("Job: " + title + ", Budget: " + budget +
                ", Assigned to: " + (freelancer != null ? freelancer.getName() : "None"));
    }

    @Override
    public String toString() {
        return "Job{" + title + ", Budget=" + budget + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof JobListing)) return false;
        JobListing other = (JobListing) obj;
        return title.equals(other.title) && budget == other.budget;
    }

    @Override
    public int hashCode() {
        return title.hashCode() + budget;
    }
}
