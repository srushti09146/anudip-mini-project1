import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DonorDAO donorDAO = new DonorDAO();
        VolunteerDAO volunteerDAO = new VolunteerDAO();

        while (true) {
            System.out.println("\n=== NGO Donation and Volunteer Tracker ===");
            System.out.println("1. Add Donor");
            System.out.println("2. View Donors");
            System.out.println("3. Add Volunteer");
            System.out.println("4. View Volunteers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Donor ID: ");
                    int did = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String dname = sc.nextLine();
                    System.out.print("Enter Donation Type: ");
                    String dtype = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    donorDAO.addDonor(new Donor(did, dname, dtype, amount));
                    break;

                case 2:
                    donorDAO.displayDonors();
                    break;

                case 3:
                    System.out.print("Enter Volunteer ID: ");
                    int vid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String vname = sc.nextLine();
                    System.out.print("Enter Availability: ");
                    String avail = sc.nextLine();
                    volunteerDAO.addVolunteer(new Volunteer(vid, vname, avail));
                    break;

                case 4:
                    volunteerDAO.displayVolunteers();
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
            }
        }
    }
}
