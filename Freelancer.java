package Asignment1;

public class Freelancer extends User {
    private String skill;

    public Freelancer(String name, String skill) {
        super(name);
        this.skill = skill;
    }

    public String getSkill() { return skill; }
    public void setSkill(String skill) { this.skill = skill; }

    public void showFreelancer() {
        System.out.println("Name: " + getName() + ", Skill: " + skill);
    }

    @Override
    public String toString() {
        return "Freelancer{name='" + getName() + "', skill='" + skill + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Freelancer)) return false;
        Freelancer other = (Freelancer) obj;
        return skill.equals(other.skill);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + skill.hashCode();
    }
}
