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

    public void updateSkill(String name, String newSkill) {
        String sql = "UPDATE freelancers SET skill = ? WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newSkill);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("Skill updated!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFreelancer(String name) {
        String sql = "DELETE FROM freelancers WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Freelancer deleted!");
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

    public void assignByNames(String fName, String jTitle) {
        String findF = "SELECT id FROM freelancers WHERE name = ?";
        String findJ = "SELECT id FROM job_listings WHERE title = ?";
        String update = "UPDATE job_listings SET freelancer_id = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection()) {
            int fId = -1, jId = -1;
            try (PreparedStatement ps = conn.prepareStatement(findF)) {
                ps.setString(1, fName);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) fId = rs.getInt("id");
            }
            try (PreparedStatement ps = conn.prepareStatement(findJ)) {
                ps.setString(1, jTitle);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) jId = rs.getInt("id");
            }
            if (fId != -1 && jId != -1) {
                try (PreparedStatement ps = conn.prepareStatement(update)) {
                    ps.setInt(1, fId);
                    ps.setInt(2, jId);
                    ps.executeUpdate();
                    System.out.println("Assigned!");
                }
            } else {
                System.out.println("Not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}