package Asignment1;

public class Main {
    public static void main(String[] args) {

        Portal portal = new Portal("Simple Freelance Portal");
        portal.showPortal();

        JobListining job1 = new JobListining("Website", 300);
        JobListining job2 = new JobListining("Mobile App", 500);

        job1.showJob();
        job2.showJob();

        Freelancer f1 = new Freelancer("Alex", "Web");
        Freelancer f2 = new Freelancer("Maria", "Design");

        f1.showFreelancer();
        f2.showFreelancer();

        if (job1.getBudget() > job2.getBudget()) {
            System.out.println("First job is more expensive");
        } else {
            System.out.println("Second job is more expensive");
        }
    }
}
