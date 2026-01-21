package Asignment1;

import java.sql.*;

public class Portal {
    private String portalName;

    public Portal(String portalName) {
        this.portalName = portalName;
    }

    public void addFreelancer(Freelancer freelancer) {
        String sql = "INSERT INTO freelancers (name, skill) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, freelancer.getName());
            pstmt.setString(2, freelancer.getSkill());
            pstmt.executeUpdate();
            System.out.println("Freelancer saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFreelancers() {
        String sql = "SELECT * FROM freelancers";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("--- Freelancers List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name") + " | Skill: " + rs.getString("skill"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addJob(JobListing job) {
        String sql = "INSERT INTO job_listings (title, budget) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, job.getTitle());
            pstmt.setInt(2, job.getBudget());
            pstmt.executeUpdate();
            System.out.println("Job saved!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showJobs() {
        String sql = "SELECT * FROM job_listings";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("--- Jobs List ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Title: " + rs.getString("title") + " | Budget: " + rs.getInt("budget") + " | Freelancer ID: " + rs.getInt("freelancer_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void assignByNames(String freelancerName, String jobTitle) {
        String findFreelancer = "SELECT id FROM freelancers WHERE name = ?";
        String findJob = "SELECT id FROM job_listings WHERE title = ?";
        String updateSql = "UPDATE job_listings SET freelancer_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            int fId = -1;
            int jId = -1;

            try (PreparedStatement psF = conn.prepareStatement(findFreelancer)) {
                psF.setString(1, freelancerName);
                ResultSet rsF = psF.executeQuery();
                if (rsF.next()) fId = rsF.getInt("id");
            }

            try (PreparedStatement psJ = conn.prepareStatement(findJob)) {
                psJ.setString(1, jobTitle);
                ResultSet rsJ = psJ.executeQuery();
                if (rsJ.next()) jId = rsJ.getInt("id");
            }

            if (fId != -1 && jId != -1) {
                try (PreparedStatement psU = conn.prepareStatement(updateSql)) {
                    psU.setInt(1, fId);
                    psU.setInt(2, jId);
                    psU.executeUpdate();
                    System.out.println("Success: " + freelancerName + " assigned to " + jobTitle);
                }
            } else {
                System.out.println("Error: Freelancer or Job not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}