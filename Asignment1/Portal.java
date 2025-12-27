package Asignment1;

import java.util.ArrayList;

public class Portal {
    private String portalName;
    private ArrayList<JobListing> jobs;
    private ArrayList<Freelancer> freelancers;

    public Portal(String portalName) {
        this.portalName = portalName;
        jobs = new ArrayList<>();
        freelancers = new ArrayList<>();
    }

    public void addJob(JobListing job) { jobs.add(job); }
    public void addFreelancer(Freelancer freelancer) { freelancers.add(freelancer); }

    public void showPortal() {
        System.out.println("Portal: " + portalName);
    }

    public void showJobs() {
        System.out.println("Jobs:");
        for (JobListing job : jobs) {
            job.showJob();
        }
    }

    public void showFreelancers() {
        System.out.println("Freelancers:");
        for (Freelancer f : freelancers) {
            f.showFreelancer();
        }
    }

    public void filterFreelancersBySkill(String skill) {
        System.out.println("Freelancers with skill '" + skill + "':");
        for (Freelancer f : freelancers) {
            if (f.getSkill().equalsIgnoreCase(skill)) {
                f.showFreelancer();
            }
        }
    }
}
