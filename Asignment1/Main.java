package Asignment1;

public class Main {
    public static void main(String[] args) {

        Portal portal = new Portal("Simple Freelance Portal");

        Freelancer f1 = new Freelancer("Alex", "Web");
        Freelancer f2 = new Freelancer("Maria", "Design");

        portal.addFreelancer(f1);
        portal.addFreelancer(f2);

        JobListing job1 = new JobListing("Website", 300);
        JobListing job2 = new JobListing("Mobile App", 500);

        job1.assignFreelancer(f1);
        job2.assignFreelancer(f2);

        portal.showPortal();
        portal.showJobs();
        portal.showFreelancers();

        portal.filterFreelancersBySkill("Web");
    }
}
