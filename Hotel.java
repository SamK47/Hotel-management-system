import java.util.*;

public class Hotel {
    // Array to track room availability status
    private static int[] roomCount = new int[101];

    // List to store booked rooms, each element is an array [roomNumber, nightsBooked]
    private static List<int[]> bookings = new ArrayList<>();

    public static void main(String[] args) {
        // Scanner for getting the user input
        Scanner scanner = new Scanner(System.in);

        // Main program loop
        while (true) {
            // Display main menu options
            System.out.println("----------- Hotel Reservation System -----------");
            System.out.println("0 - Exit");
            System.out.println("1 - Make a Reservation");
            System.out.println("2 - View Booked Rooms");

            System.out.print("Enter your choice: ");

            // Menu choice
            int choice = scanner.nextInt();

            // Switch for user choice
            switch (choice) {
                case 0:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                case 1:
                    // Call reservation method to handle room booking
                    reservation(scanner);
                    break;
                case 2:
                    // Prompt user for room number to search
                    System.out.print("Enter the room number you want to search: ");
                    int roomNumberToSearch = scanner.nextInt();
                    // Call booked method to view details for a specific room
                    booked(roomNumberToSearch);
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Method for handling room reservation
    public static void reservation(Scanner scanner) {
        // Prompt user for room number
        System.out.print("Enter the room number (1-100) you would like to book: ");
        int roomNumber = scanner.nextInt();

        // Check if the room number is valid
        if (roomNumber >= 1 && roomNumber <= 100) {
            // Check if the room is available
            if (roomCount[roomNumber] == 0) {
                // Mark the room as booked
                roomCount[roomNumber] = roomNumber;

                // Prompt user for the number of nights
                System.out.print("For how many nights would you like to book the room? (Room rate is EUR 100 per night): ");
                int roomNights = scanner.nextInt();

                // Display booking confirmation
                System.out.println("You have chosen to book Room " + roomNumber + " for " + roomNights +
                        " nights. The total bill for this booking will be " + roomNights * 100 + " EUR");

                System.out.println("Room " + roomNumber + " has been successfully booked!");

                // Record the booking in the list
                int[] roomsBooked = { roomNumber, roomNights };
                bookings.add(roomsBooked);

            } else {
                // Room is already booked
                System.out.println("Room " + roomNumber + " is already booked. Choose another one.");
            }
        } else {
            // Invalid room number
            System.out.println("Invalid room number. Enter a number between 1 and 100.");
        }
    }

    // Method for viewing details for a specific room
    public static void booked(int roomNumberToSearch) {
        // Display section heading
        System.out.println("----------- Booked Room Details -----------");

        boolean roomFound = false;

        // Loop through the list of bookings
        for (int[] booking : bookings) {
            // Check if the current booking matches the room number to search
            if (booking[0] == roomNumberToSearch) {
                // Display details for the found room
                System.out.println("Room Number: " + booking[0]);
                System.out.println("Number of nights booked for: " + booking[1]);
                System.out.println("Total Cost: " + booking[1] * 100 + " EUR");
                roomFound = true;
                break;
            }
        }

        // If room not found
        if (!roomFound) {
            System.out.println("Room " + roomNumberToSearch + " not found or not booked yet.");
        }
    }
}
