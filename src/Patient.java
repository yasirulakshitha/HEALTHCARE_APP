public class Patient extends Person{
    public String patientId;

    public Patient(String name, String PatientId,String contactNumber){
        super(name,contactNumber);
        this.patientId = PatientId;
    }

    public char getPatientType( String PatientId){
        char firstLetter = this.patientId.charAt(0);
        return firstLetter;
    }

    public String getPatientId(){
        return patientId;
    }



}
