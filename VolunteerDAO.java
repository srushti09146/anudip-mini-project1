import java.sql.*;

public class VolunteerDAO {
    public void addVolunteer(Volunteer v) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO volunteers VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, v.id);
            pst.setString(2, v.name);
            pst.setString(3, v.availability);
            pst.executeUpdate();
            System.out.println("Volunteer added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayVolunteers() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM volunteers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Availability: " + rs.getString("availability"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
