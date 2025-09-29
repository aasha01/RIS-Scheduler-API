package com.devskrol.appointment.model;

public class Appointment { private Patient patient; private String physician; private String provider; private String exam; private String appointmentDate;
    private String slotDateTime;
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public String getPhysician() { return physician; }
    public void setPhysician(String physician) { this.physician = physician; }
    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }
    public String getExam() { return exam; }
    public void setExam(String exam) { this.exam = exam; }
    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate)
    { this.appointmentDate = appointmentDate; }
    public String getSlotDateTime() { return slotDateTime; }
    public void setSlotDateTime(String slotDateTime)
    { this.slotDateTime = slotDateTime; }
}