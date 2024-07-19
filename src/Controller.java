import java.util.*;

public class Controller {
    public static AbstractList<Doctor> allDoctors = new ArrayList<>();
    public static AbstractList<Patient> allPatients = new ArrayList<>();

    public static int NUMBER_OF_SLOTS = 5;
    public static void addDoctor(){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Your Name: ");
        String name = input.next();
        System.out.println("Enter Your Birthday: ");
        String birthday = input.next();
        System.out.println("Enter Your Specialization: ");
        String specialization = input.next();
        System.out.println("Enter Your Contact Number: ");
        String contact = input.next();

        Random random = new Random();

        Doctor tempDoctor = new Doctor(random.nextInt(),name,birthday,specialization,contact);
        System.out.println("THIS IS YOUR DOCTOR ID: "+ tempDoctor.getDoctorId());
        //System.out.println(random.nextInt());

        allDoctors.add(tempDoctor);



    }

    public static void addAvailabilityForDoctor(){

        Scanner input  = new Scanner(System.in);
        System.out.println("Enter the doctor ID you want add availability: ");
        int docId = input.nextInt();
        Doctor selectedDoctor = null;
        //we need to fetch the doctor from the array list
        for (Doctor doc:Controller.allDoctors){
            if (doc.getDoctorId() == docId){
                selectedDoctor = doc;

            }
        }
        //if the doctor is not existing.we need to say there is no doctor found
        if (selectedDoctor == null){
            System.out.println("Doctor is not founded");
            return;
        }
        //if the doctor is existing take the date
        System.out.println("Enter the day you want to add availability: ");
        int day = input.nextInt();
        System.out.println("Enter the month you want to add availability: ");
        int month = input.nextInt();
        System.out.println("Enter the year you want to add availability: ");
        int year = input.nextInt();

        Date bookingDate = new Date(year,month,day);

        //add the availability for the doctor
        selectedDoctor.setAvailabilities(bookingDate);

    }

    public static void viewAllDoctors(){
        for (Doctor doc: Controller.allDoctors){
            System.out.println(doc.getName() +"has specialization of" + doc.getSpecialization() +" has a ID of: "+doc.getDoctorId() +"and has an availability for "+doc.getAvailabilities().toString());
        }
    }

    public static void addPatient(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter patient name: ");
        String name = input.nextLine();
        System.out.println("Enter patient's ID: ");
        String id = input.nextLine();
        System.out.println("Enter patient's contact information: ");
        String contact = input.nextLine();
        Patient tempPatient = new Patient(id,name,contact);

        allPatients.add(tempPatient);

    }

    public static void bookAppointment(){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the doctor ID you want add availability: ");
        int docId = input.nextInt();
        System.out.println("Enter your patients Id; ");
        String patientId= input.next();

        System.out.println("Enter the Day you want to add Appointment: ");
        String day = input.next();
        System.out.println("Enter the Month you want to add Appointment ");
        String month = input.next();
        System.out.println("Enter the Year you want to add Appointment: ");
        String year = input.next();

        //get patient and doctor
        Patient selectedPatient = getPatientById(patientId);
        Doctor selectedDoc = getDoctorById(docId);

        if(selectedDoc == null || selectedPatient == null){
            System.out.println("invalid doctor or patient id");
            return;
        }

        Date appointmentDate = new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day));

        // check the availability
        boolean isAvailable = checkAvailability(selectedDoc,appointmentDate);

        if (isAvailable){
            String appTime = getTimeForBooking(selectedDoc,appointmentDate);

            if (appTime != null){
                Appointment appointment = new Appointment(selectedDoc,selectedPatient,"no notes",appointmentDate,"");
                selectedDoc.setAppointment(appointment,appointmentDate);
                System.out.println(selectedDoc.getAllAppointments().toString());
            }else {
                System.out.println("All the slots are filled");
            }


            // calculate appointment time
            // make the appointment


        }else {
            System.out.println("Doctor is not available in selected date");
        }


    }

    private static String getTimeForBooking(Doctor selectedDoctor, Date dateOfBooking){
        for(Map.Entry<Date,ArrayList<Appointment>> appointment: selectedDoctor.getAllAppointments().entrySet()){
            if (appointment.getKey().equals(dateOfBooking)){
                int numberOfSlots = appointment.getValue().size();
                if (numberOfSlots > NUMBER_OF_SLOTS -1){
                    return  null;
                }
                System.out.println("you can make a booking");
                int timme = 17 + appointment.getValue().size();
                String strTime = timme +" :00";
                return strTime;
            }
        }
        return "17. 00";
    }

    private static Boolean checkAvailability(Doctor selectedDoctor, Date dateOfBooking){
        for (Date day: selectedDoctor.getAvailabilities()) {
            if(day.equals(dateOfBooking)){
                return true;
            }
        }

        return false;
    }
    public static Patient getPatientById(String patientId){
        for(Patient patient:allPatients){
            if (patient.patientId.equals(patientId)){
                return patient;
            }
        }
        return null;
    }

    public static Doctor getDoctorById(int id){
        for(Doctor doc:allDoctors){
            if (doc.getDoctorId() == id){
                return doc;
            }
        }
        return null;
    }



}
