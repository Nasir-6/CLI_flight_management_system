package main.java;

import util.IdGenerator;
import util.Interface;
import main.java.flight.FlightService;
import main.java.flight.FlightDao;
import main.java.passenger.PassengerDao;
import main.java.passenger.PassengerService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FlightDao flightDao = new FlightDao();
        PassengerDao passengerDao = new PassengerDao();
        FlightService flightService = new FlightService(flightDao);
        IdGenerator idGenerator = new IdGenerator();
        PassengerService passengerService = new PassengerService(passengerDao, flightService, idGenerator);

        ////////////////////////////////////////////////////////

        System.out.println("Welcome to the Flight Management CLI!");

        String[] options = {
                "Add a main.java.flight",
                "Display all flights",
                "Display fully-booked flights",
                "Create a new user",
                "Display main.java.flight or book main.java.flight for a specific user",
                "Cancel main.java.flight",
                "Quit the program"
        };

        while (true) {

            int option = Interface.getOption("Please select your option using the numbers:",
                    options);

            // Switch statements here
            switch (option) {
                case 1:
                    System.out.println("'Add main.java.flight' selected.");
                    flightService.addFlight();
                    break;
                case 2:
                    System.out.println("'Display all flights' selected.");
                    flightService.displayAllFlights();
                    break;
                case 3:
                    System.out.println("'Display fully-booked flights' selected.");
                    flightService.displayFullyBooked();
                    break;
                case 4:
                    System.out.println("'Create a new user' selected.");
                    passengerService.createNewUser();
                    break;
                case 5:
                    System.out.println("'Display main.java.flight or book a main.java.flight for a specific user' selected.");
                    passengerService.chooseIdOrName();
                    break;

                case 6:
                    System.out.println("'Cancel a main.java.flight' selected.");
                    flightService.cancelFlight();

                    break;
                case 7:
                    System.out.println("Thanks for using our management system!");
                    System.exit(0);
            }
            System.out.println("Press enter to continue.");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }
}







