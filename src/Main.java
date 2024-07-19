import java.util.*;

public class Main {
    public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

               run(input);


    }

    public static void run(Scanner input){
        boolean flag1 = true;

        while (flag1) {
            System.out.println(" ");
            System.out.println("===================MAIN MENU=====================");
            System.out.println("PRESS 1 - HOSPITAL ADMINISTRATOR");
            System.out.println("PRESS 2 - PATIENT");
            System.out.println("PRESS 3 - EXIT");
            System.out.println("=================================================");
            System.out.println(" ");
            System.out.println("ENTER YOUR SELECTION :");
            int selection = input.nextInt();

            if (selection == 1) {

                administrationMenu(input);

            } else if (selection == 2) {

                patientMenu(input);

            } else if (selection == 3) {
                System.out.println("exit");
                flag1 = false;
            } else {
                System.out.println("invalid input");
            }
        }
    }

    public static void administrationMenu(Scanner input){

        System.out.println(" ");
        System.out.println("==============HOSPITAL ADMINISTRATOR MENU==============");
        System.out.println("PRESS 1 - ADD A DOCTOR");
        System.out.println("PRESS 2 - ADD A DOCTOR AVAILABILITY");
        System.out.println("PRESS 3 - EXIT");
        System.out.println("=======================================================");
        System.out.println(" ");
        System.out.println("ENTER YOUR SELECTION :");

        boolean flag2 = true;

        while (flag2) {
            int administratorInput = input.nextInt();

            switch (administratorInput) {
                case 1:
                    // get relavant data
                    Controller.addDoctor();
                    System.out.println("DOCTOR WAS ADDED");
                    System.out.println("PRESS 3 FOR EXIT");
                    break;
                case 2:
                    //add Doctor Availability

                    Controller.addAvailabilityForDoctor();
                    System.out.println("PRESS 3 FOR EXIT");

                    break;
                case 3:
                    flag2 = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    System.out.println("PRESS 3 FOR EXIT");
            }

        }
    }

    public static void patientMenu(Scanner input) {
        System.out.println(" ");
        System.out.println("==================PATIENT MENU=====================");
        System.out.println("PRESS 1 -VIEW DOCTORS");
        System.out.println("PRESS 2 - BOOK AN APPOINTMENT");
        System.out.println("PRESS 3 - VIEW SELECTED DOCTORS BOOKING");
        System.out.println("PRESS 4 - REGISTER PATIENT");
        System.out.println("PRESS 5 - EXIT");
        System.out.println("===================================================");
        System.out.println(" ");
        System.out.println("ENTER YOUR SELECTION :");

        boolean flag3 = true;

        while (flag3) {
            int patientInput = input.nextInt();

            switch (patientInput) {
                case 1:
                   Controller.viewAllDoctors();
                    System.out.println("PRESS 3 FOR EXIT");
                    break;
                case 2:
                    Controller.bookAppointment();
                    System.out.println("PRESS 3 FOR EXIT");
                    break;
                case 3:
                    System.out.println("viewDoctorsBooking");
                    System.out.println("PRESS 3 FOR EXIT");
                    break;
                case 4:
                    Controller.addPatient();
                    System.out.println("PRESS 3 FOR EXIT");
                    break;
                case 5:
                    flag3 = false;
                    break;
                default:
                    System.out.println("invalid input");
                    System.out.println("PRESS 3 FOR EXIT");


            }

        }
    }







//            private static void addDoctor() {
//
//            }
//
//            private static void addDoctorAvailability() {
//            }
//
//            private static void viewDoctors() {
//            }
//
//            private static void bookAnAppointment() {
//            }
//
//            private static void viewDoctorsBooking() {
//            }
//
//            private static void registerPatient() {
//            }

//        Scanner input = new Scanner(System.in);
//
//        Doctor newDoctor = new Doctor();
//
//        System.out.println("enter doctor's specialization: ");
//
//        String specialization = input.next();
//
//        boolean s = newDoctor.isPhysician(specialization);
//
//        System.out.println(s);
//
//        Patient newpatient = new Patient();
//
//        System.out.println("enter patient Id: ");
//
//        String patientId = input.next();
//
//        char y = newpatient.getPatientType(patientId);
//
//        System.out.println(y);





    }


