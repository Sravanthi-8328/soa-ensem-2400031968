package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.exam.entity.BusTripEntity;
import com.klef.soa.exam.service.BusTripService;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")

@RestController
public class BusTripController {

    private final BusTripService service;

    public BusTripController(BusTripService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String bustrip() {
        return "Bus trip is confirmed successfully";
    }

    @PostMapping("/add")
    public ResponseEntity<BusTripEntity> addbustrip(
            @RequestBody BusTripEntity trip) {
        BusTripEntity saved = service.addbustrip(trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/displayall")
    public ResponseEntity<List<BusTripEntity>> displayAllbustrip() {
        return ResponseEntity.ok(service.displayAllbustrip());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletebustripById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.deletebustripById(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusTripEntity> getBusTripById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getBusTripById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BusTripEntity> updateBusTrip(
            @PathVariable Long id,
            @RequestBody BusTripEntity trip) {
        return ResponseEntity.ok(service.updateBusTrip(id, trip));
    }

    @GetMapping("/route/{routeName}")
    public ResponseEntity<List<BusTripEntity>> getTripsByRoute(
            @PathVariable String routeName) {
        return ResponseEntity.ok(service.getTripsByRoute(routeName));
    }

    @GetMapping("/delayed")
    public ResponseEntity<List<BusTripEntity>> getDelayedTrips() {
        return ResponseEntity.ok(service.getDelayedTrips());
    }
}