import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Doctor extends Person {

    private int doctorId;

    private String doctorBirthDay;
    private String specialization;

    private ArrayList<Date>availabilities;
    public HashMap<Date,ArrayList<Appointment>> allAppointments = new HashMap<>();


    public Doctor(int DoctorId, String name, String DoctorBirthDay, String Specialization,String contactNumber){
        super(name,contactNumber);
        this.doctorId = DoctorId;
        this.doctorBirthDay = DoctorBirthDay;
        this.specialization = Specialization;
        availabilities = new ArrayList<>();

    }


    public boolean isPhysician(String specialization){

        String suffix = "physician";

        if (specialization.length() >= suffix.length()){
            String endSubstring = specialization.substring(specialization.length() - suffix.length());
            return endSubstring.equals(suffix);

        }

        return false;
    }

    public void setAvailabilities(Date availabilities){
        this.availabilities.add(availabilities);
    }

    public void setAppointment(Appointment appointment, Date date){
        ArrayList<Appointment> currentAppointments= this.allAppointments.get(date);
        if(currentAppointments == null){
            ArrayList<Appointment> tempArraylist = new ArrayList<>();
            tempArraylist.add(appointment);
            this.allAppointments.put(date,tempArraylist);
        }
        else{
            currentAppointments.add(appointment);
            this.allAppointments.put(date,currentAppointments);
        }
//        this.allAppointments.put(date,)
    }
    public ArrayList<Date> getAvailabilities() {

        return availabilities;
    }

    public HashMap<Date, ArrayList<Appointment>> getAllAppointments() {

        return allAppointments;
    }

    public int getDoctorId(){

        return doctorId;
    }

    public String getDoctorBirthDay(){
        return doctorBirthDay;
    }

    public void setDoctorBirthDay(String doctorBirthDay){

        this.doctorBirthDay = doctorBirthDay;
    }

    public String getSpecialization(){

        return specialization;
    }

    public void setSpecialization(String specialization){

        this.specialization = specialization;
    }


}
