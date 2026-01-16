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
            System.out.println("Freelancer saved to DB!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showFreelancers() {
        String sql = "SELECT * FROM freelancers";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("--- Freelancers List from DB ---");
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
            System.out.println("Skill updated for: " + name);
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
            System.out.println("Freelancer deleted: " + name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}