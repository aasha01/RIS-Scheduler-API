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

@RestController
@RequestMapping("/appointments")
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
}
