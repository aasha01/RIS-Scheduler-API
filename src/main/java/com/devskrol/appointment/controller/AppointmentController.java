package com.devskrol.appointment.controller;

import com.devskrol.appointment.model.Appointment;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File storageFile = new File("appointments.json");

    // Save appointment
    @PostMapping
    public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment) throws IOException {
        List<Appointment> appointments = new ArrayList<>();

        if (storageFile.exists() && storageFile.length() > 0) {
            appointments = new ArrayList<>(
                    Arrays.asList(objectMapper.readValue(storageFile, Appointment[].class))
            );
        }

        appointment.setId(String.valueOf(100000 + new Random().nextInt(900000)));
        appointments.add(appointment);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, appointments);

        return ResponseEntity.ok("✅ Appointment saved!");
    }

    // Get all appointments
    @GetMapping
    public List<Appointment> getAppointments() throws IOException {
        if (!storageFile.exists() || storageFile.length() == 0) {
            return new ArrayList<>();
        }
        return Arrays.asList(objectMapper.readValue(storageFile, Appointment[].class));
    }

    // Delete appointment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable String id) throws IOException {
        if (!storageFile.exists() || storageFile.length() == 0) {
            return ResponseEntity.notFound().build();
        }

        List<Appointment> appointments = new ArrayList<>(
                Arrays.asList(objectMapper.readValue(storageFile, Appointment[].class))
        );

        boolean removed = appointments.removeIf(appointment -> id.equals(appointment.getId()));
        
        if (!removed) {
            return ResponseEntity.notFound().build();
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(storageFile, appointments);
        return ResponseEntity.ok("✅ Appointment deleted!");
    }
}
