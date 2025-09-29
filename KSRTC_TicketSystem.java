import java.util.Scanner;

/**
 * KSRTC Ticket Fare Calculator with Discounts
 */
public class KSRTC_TicketSystem {

    private Scanner sc = new Scanner(System.in);
    private String startingPoint;
    private String destination;

    private void calculateFare() {
        System.out.print("Enter the starting point: ");
        startingPoint = sc.nextLine().trim();

        System.out.print("Enter the destination: ");
        destination = sc.nextLine().trim();

        System.out.print("Enter base fare amount: ");
        double baseFare;
        try {
            baseFare = Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount.");
            return;
        }

        System.out.println("Choose ticket type:");
        System.out.println("1. Child (100% discount)");
        System.out.println("2. Half Ticket (50% discount)");
        System.out.println("3. Adult (0% discount)");
        System.out.println("4. Senior Citizen (25% discount)");
        System.out.print("Choice: ");
        String choice = sc.nextLine().trim();

        double discountPercent = 0;
        switch (choice) {
            case "1": discountPercent = 100; break;
            case "2": discountPercent = 50; break;
            case "3": discountPercent = 0; break;
            case "4": discountPercent = 25; break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        double discountAmount = (discountPercent / 100.0) * baseFare;
        double finalFare = baseFare - discountAmount;

        System.out.println("\n=== Ticket Details ===");
        System.out.println("Route: " + startingPoint + " → " + destination);
        System.out.println("Base Fare: Rs " + baseFare);
        System.out.println("Discount: " + discountPercent + "% (Rs " + discountAmount + ")");
        System.out.println("Final Fare: Rs " + finalFare);
    }

    private void run() {
        while (true) {
            System.out.println("\n=== KSRTC Ticket Fare Calculator ===");
            System.out.println("1. Calculate Fare");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": calculateFare(); break;
                case "2": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static void main(String[] args) {
        KSRTC_TicketSystem app = new KSRTC_TicketSystem();
        app.run();
    }
}


