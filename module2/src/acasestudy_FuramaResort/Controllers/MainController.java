package acasestudy_FuramaResort.Controllers;


import acasestudy_FuramaResort.Commons.FileUtils;
import acasestudy_FuramaResort.Commons.StringUtils;
import acasestudy_FuramaResort.Commons.Validators;
import acasestudy_FuramaResort.Models.*;
import acasestudy_FuramaResort.exceptions.*;

import java.util.*;

public class MainController {

    private static Scanner scanner = new Scanner(System.in);
    private final static String VILLA = "villa";
    private final static String ROOM = "room";
    private final static String HOUSE = "house";
    private final static String CUSTOMER = "customer";
    private final static String BOOING = "booking";

    public static void main(String[] args) {

    }

    public static boolean testregex(String regex, String string) {
        return regex.matches(string);
    }

    public static void displayMainMenu() {
        int choice;
        do {
            System.out.println("1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n");
            System.out.print("Choice the function: ");

            do {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Try again");
                }
            } while (true);


            switch (choice) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                    break;
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInformationOfEmloyee();
                    break;
                case 7:
                    System.out.println("Good Bye!");
                    System.exit(0);
                default:
                    System.out.println("Try again");

            }


        } while (choice != 7);
    }


    private static void addNewCustomer(String fileName) {
        boolean flag;
        String fullname = Validators.checkExceptionInput("Enter fullname", Validators.REGEX_VIETNAMESE_NAME, new NameException());

        String dayOfBirth;
        do {
            flag = true;
            System.out.println("Enter day of birth");
            dayOfBirth = scanner.nextLine();
            try {
                Validators.isValidBirthday(dayOfBirth);
            } catch (BirtdayException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        String gender;
        do {
            flag = true;
            System.out.println("Enter gender");
            gender = scanner.nextLine();

            try {
                Validators.isValidGender(gender);
            } catch (GenderException e) {
                flag = false;
                e.printStackTrace();
            }

        } while (!flag);

        String idCard = Validators.checkExceptionInput("Enter id card", Validators.ID_CARD_REGEX, new IdCardException());


        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();


        String email = Validators.checkExceptionInput("Enter email", Validators.REGEX_EMAIL, new EmailException());


        System.out.println("Enter type of customer");
        String typeOfCustomer = scanner.nextLine();

        System.out.println("Enter address");
        String address = scanner.nextLine();


        FileUtils.setFullPathFile(fileName);
        FileUtils.writerFile(new String[]{fullname, dayOfBirth, gender, idCard, phoneNumber, email, typeOfCustomer, address});


    }

    private static void showInformationOfEmloyee() {
    }

    private static List<Customer> readAllCustomer(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesCustomer = FileUtils.readFile();
        List<Customer> customerList = new ArrayList<>();
        String[] arrayPropertiesCustomer = null;
        Customer customer = null;
        for (String properties : propertiesCustomer) {
            arrayPropertiesCustomer = properties.split(",");
            customer = new Customer();
            customer.setFullName(arrayPropertiesCustomer[0]);
            customer.setDayOfBirth(arrayPropertiesCustomer[1]);
            customer.setGender(arrayPropertiesCustomer[2]);
            customer.setIdCard(arrayPropertiesCustomer[3]);
            customer.setPhoneNumber(arrayPropertiesCustomer[4]);
            customer.setEmail(arrayPropertiesCustomer[5]);
            customer.setTypeOfCustomer(arrayPropertiesCustomer[6]);
            customer.setAddress(arrayPropertiesCustomer[7]);
            customerList.add(customer);
        }
        return customerList;

    }

    public static int checkNumber(int maxNumber) {
        boolean flag;
        int chooseNumber = 0;
        do {
            System.out.print("Nhập số muốn chọn (không được quá " + maxNumber + ")" + " : ");
            try {
                flag = true;
                chooseNumber = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Không được nhập chữ!");
                scanner.nextLine();
                flag = false;
            }
        } while (!flag || chooseNumber < 1 || chooseNumber > maxNumber);
        return chooseNumber;

    }

    private static void addNewBooking() {
        int choice;
        do {
            System.out.println("1. List customer booking\n" +
                    "2. Back to menu\n" +
                    "3. Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Customer> listNameCustomer = readAllCustomer(CUSTOMER);
                    int count = 1;
                    String idBookingCustomer;
                    if (listNameCustomer.size() > 0) {
                        for (int i = 0; i < listNameCustomer.size(); i++) {
                            String name = listNameCustomer.get(i).getFullName();
                            String idCard = listNameCustomer.get(i).getIdCard();
                            System.out.println(count + ". Name Customer: " + name + "\nIdcard: " + idCard);
                            count++;
                        }
                        int chooseCustomerNumber = checkNumber(count - 1);
                        String arrayChooseCustomer = (listNameCustomer.get(chooseCustomerNumber - 1)).getFullName();
                        idBookingCustomer = arrayChooseCustomer.substring(0, 1);
                    } else {
                        System.out.println("------------------------------------------");
                        System.out.println("Can not find customer, please add new customer");
                        System.out.println("------------------------------------------");
                        displayMainMenu();
                    }
                    System.out.println("    1. Booking Villa\n" +
                            "    2. Booking House\n" +
                            "    3. Booking Room");
                    int chooseBooking = checkNumber(3);
                    switch (chooseBooking) {
                        case 1:

                    }
                    break;
                case 2:
                    return;
                case 3:
                    System.exit(0);
            }
        } while (choice != 3);
    }


    private static void showInformationOfCustomer(String fileName) {
        System.out.println("---------------------------");
        System.out.println("List of customer");
        List<Customer> customerList = readAllCustomer(fileName);
        Collections.sort(customerList);
        for (Customer customer : customerList) {
            customer.showInfor();
        }
    }

    private static void addNewServices() {
        int choice;
        do {
            System.out.println("1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            System.out.println("Choice the Service");

            do {
                try {

                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Try again");
                }
            } while (true);

            switch (choice) {
                case 1:
                    addNewService(VILLA);
                    break;
                case 2:
                    addNewService(HOUSE);
                    break;
                case 3:
                    addNewService(ROOM);
                    break;
                case 4:
                    return;
                case 5:
                    System.out.println("Good Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Try again");

            }
        } while (choice != 5);

    }

    private static void addNewService(String fileName) {
        String id;
        do {
            System.out.println("Enter service id");
            id = scanner.nextLine();
        } while (!Validators.isValidRegex(id, Validators.SERVICE_CODE_REGEX));

        String serviceName;
        do {
            System.out.println("Enter  service name");
            serviceName = scanner.nextLine();
        } while (!Validators.isValidRegex(serviceName, Validators.SERVICE_NAME_REGEX));


        double areaUse;
        do {
            System.out.println("Enter area use");
            areaUse = Double.parseDouble(scanner.nextLine());
        } while (!Validators.isMoreThan(areaUse, 30));

        double rentPrice;
        do {
            System.out.println("Enter rent price ");
            rentPrice = Double.parseDouble(scanner.nextLine());
        } while (!Validators.isMoreThan(rentPrice, 0));


        int maxPeople;
        do {
            System.out.println("Enter max people");
            maxPeople = Integer.parseInt(scanner.nextLine());
        } while (!Validators.isMoreThan(maxPeople, 0, 20));

        String rentType;
        do {
            System.out.println("Enter rent type");
            rentType = scanner.nextLine();

        } while (!Validators.isValidRegex(rentType, Validators.SERVICE_NAME_REGEX));


        FileUtils.setFullPathFile(fileName);
        if (fileName.equals(VILLA)) {
            String standardRoom;
            do {
                System.out.println("Enter standard room");
                standardRoom = scanner.nextLine();
            } while (!Validators.isValidRegex(standardRoom, Validators.SERVICE_NAME_REGEX));

            System.out.println("Enter convenient description");
            String otherConvenientDescription = scanner.nextLine();
            double poolArea;
            do {
                System.out.println("Enter pool area");
                poolArea = Double.parseDouble(scanner.nextLine());
            } while (!Validators.isMoreThan(poolArea, 30));

            int numberOfFloor;
            do {
                System.out.println("Enter number of floor");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
            } while (!Validators.isMoreThan(numberOfFloor, 0));


            FileUtils.writerFile(new String[]{
                    id, serviceName, String.valueOf(areaUse), String.valueOf(rentPrice), String.valueOf(maxPeople), rentType,
                    standardRoom, otherConvenientDescription, String.valueOf(poolArea), String.valueOf(numberOfFloor)
            });
        } else if (fileName.equals(HOUSE)) {
            String standardRoom;
            do {
                System.out.println("Enter standard room");
                standardRoom = scanner.nextLine();
            } while (!Validators.isValidRegex(standardRoom, Validators.SERVICE_NAME_REGEX));


            System.out.println("Enter convenient description ");
            String otherConvenientDescription = scanner.nextLine();

            int numberOfFloor;
            do {
                System.out.println("Enter number of floor");
                numberOfFloor = Integer.parseInt(scanner.nextLine());
            } while (!Validators.isMoreThan(numberOfFloor, 0));

            FileUtils.writerFile(new String[]{
                    id, serviceName, String.valueOf(areaUse), String.valueOf(rentPrice), String.valueOf(maxPeople), rentType,
                    standardRoom, otherConvenientDescription, String.valueOf(numberOfFloor)
            });
        } else if (fileName.equals(ROOM)) {
            String extraServiceName;
            do {
                System.out.println("Enter extra service name");
                extraServiceName = scanner.nextLine();
            } while (!Validators.isValiExtraServiceName(extraServiceName));

            System.out.println("Enter unit");
            String unit = scanner.nextLine();
            System.out.println("Enter price");
            double price = Double.parseDouble(scanner.nextLine());
            FileUtils.writerFile(new String[]{
                    id, serviceName, String.valueOf(areaUse), String.valueOf(rentPrice), String.valueOf(maxPeople), rentType,
                    extraServiceName, unit, String.valueOf(price)
            });

        }
        System.out.println("Service added successfully");

    }


    private static void showServices() {
        int choice;
        do {
            System.out.println("1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Room Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAllService(VILLA);
                    break;
                case 2:
                    showAllService(HOUSE);
                    break;
                case 3:
                    showAllService(ROOM);
                    break;
                case 4:
                    showAllServiceNotDup(VILLA);
                    System.out.println("\n");
                    return;
                case 5:
                    showAllServiceNotDup(HOUSE);
                    System.out.println("\n");
                    return;


                case 6:
                    showAllServiceNotDup(ROOM);
                    System.out.println("\n");
                    return;

                case 7:
                    return;
                case 8:
                    System.out.println("Good bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Try again");

            }

        } while (choice != 8);
    }

    private static void showAllServiceNotDup(String fileName) {
        Set<String> setOfServices = new TreeSet<>();
        System.out.println("---------------------------");
        System.out.println("List service not duplicate name : ");
        for (Services services : readAllService(fileName)) {
            setOfServices.add(services.getServiceName());
        }
        for (String name : setOfServices) {
            System.out.println(name);
        }

    }

    private static void showAllService(String fileName) {
        System.out.println("---------------------------");
        System.out.println("List service: ");
        for (Services services : readAllService(fileName)) {
            services.showInfor();
        }

    }

    public static List<Services> readAllService(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesService = FileUtils.readFile();
        List<Services> listOfServices = new ArrayList<>();
        Services services = null;
        String[] propertiesElement = null;
        ExtraService extraService = null;
        for (String properties : propertiesService) {
            propertiesElement = properties.split(StringUtils.COMMA);
            if (fileName.equals(VILLA)) {
                services = new Villa();
                ((Villa) services).setStandardRoom(propertiesElement[6]);
                ((Villa) services).setOtherConvenientDescription(propertiesElement[7]);
                ((Villa) services).setPoolArea(Double.parseDouble(propertiesElement[8]));
                ((Villa) services).setNumberOfFloor(Integer.parseInt(propertiesElement[9]));
            } else if (fileName.equals(HOUSE)) {
                services = new House();
                ((House) services).setStandardRoom(propertiesElement[6]);
                ((House) services).setOtherConvenientDescription(propertiesElement[7]);
                ((House) services).setNumberOfFloor(Integer.parseInt(propertiesElement[8]));
            } else if (fileName.equals(ROOM)) {
                extraService = new ExtraService(propertiesElement[6], propertiesElement[6], Double.parseDouble(propertiesElement[6]));
                services = new Room();
                ((Room) services).setExtraService(extraService);
            }
            services.setId(propertiesElement[0]);
            services.setServiceName(propertiesElement[1]);
            services.setAreaUse(Double.parseDouble(propertiesElement[2]));
            services.setRentPrice(Double.parseDouble(propertiesElement[3]));
            services.setMaxPeople(Integer.parseInt(propertiesElement[4]));
            services.setRentType(propertiesElement[5]);
            listOfServices.add(services);
        }
        return listOfServices;
    }

}
