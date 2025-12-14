package Asignment1;

public class Freelancer {

    private String name;
    private String skill;

    public Freelancer(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void showFreelancer() {
        System.out.println("Name: " + name + ", Skill: " + skill);
    }
}

