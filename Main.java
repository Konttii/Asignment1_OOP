package Asignment1;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal("Simple Freelance Portal");

        Freelancer f1 = new Freelancer("Alex", "Java Developer");

        portal.addFreelancer(f1);
        portal.showFreelancers();
        portal.updateSkill("Alex", "Senior Java");
        // portal.deleteFreelancer("Alex");
    }
}