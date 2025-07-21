import java.sql.*;

public class DonorDAO {
    public void addDonor(Donor d) {
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO donors VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, d.id);
            pst.setString(2, d.name);
            pst.setString(3, d.donationType);
            pst.setDouble(4, d.amount);
            pst.executeUpdate();
            System.out.println("Donor added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayDonors() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM donors";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Type: " + rs.getString("donationType") +
                        ", Amount: " + rs.getDouble("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
