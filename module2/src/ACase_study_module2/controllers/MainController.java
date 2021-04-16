package ACase_study_module2.controllers;

import java.util.Scanner;

public class MainController {
    Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        int input;
        do {
            System.out.println("1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n");
            System.out.print("Enter a number: ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    addNewServies();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                   addNewCustomer();
                    break;
                case 4:
                    showInforCustomer();
                    break;
                case 5:
                    addNewBooking();
                    break;

                case 6:
                    showInfoOfEmployee();
                    break;
                case 7:
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("Ron number enter again");
            }
        } while (input != 7);

    }

    public void addNewServies() {
        int input;
        do {

            System.out.println("1. Add new Villa\n" +
                    "2. Add new House\n" +
                    "3. Add new\n" +
                    "4. Back to Menu\n" +
                    "5. Exit");
            System.out.print("Enter a number: ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Ron number enter again");
            }

        } while (input != 5);

    }

    private void addNewVilla() {
        System.out.println("Enter New Villa");
        System.out.println("Enter RoomStandard");
        String roomStandard=scanner.nextLine();
        System.out.println("Enter Comfortable");
        String comfortable=scanner.nextLine();
        System.out.println("Enter Area of Swimming Pool");
        int areaOfSwimmingPool=scanner.nextInt();
        System.out.println("Enter Number Of Floors ");
        int numberOfFloors=scanner.nextInt();

    }

    public void showServices() {
        int input;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            System.out.println("Enter a number: ");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Ron number enter again");
            }
        } while (input != 8);
    }
    private void showInforCustomer() {
    }
    private void showInfoOfEmployee() {
    }

    private void addNewCustomer() {
    }

    private void addNewBooking() {
    }

}
