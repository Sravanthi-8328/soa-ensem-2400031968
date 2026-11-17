package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.klef.soa.exam.entity.BusTripEntity;
import com.klef.soa.exam.repository.BusTripRepository;
import com.klef.soa.exam.service.BusTripService;

@Service
public class BusTripServiceImpl implements BusTripService {

    private final BusTripRepository repository;

    public BusTripServiceImpl(BusTripRepository repository) {
        this.repository = repository;
    }

    @Override
    public BusTripEntity addbustrip(BusTripEntity trip) {
        return repository.save(trip);
    }

    @Override
    public List<BusTripEntity> displayAllbustrip() {
        return repository.findAll();
    }

    @Override
    public String deletebustripById(Long id) {
        BusTripEntity trip = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Bus trip not found"));

        repository.delete(trip);
        return "Bus trip deleted successfully";
    }

    @Override
    public BusTripEntity getBusTripById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Bus trip not found"));
    }

    @Override
    public BusTripEntity updateBusTrip(Long id, BusTripEntity trip) {
        BusTripEntity existing = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Bus trip not found"));

        existing.setRouteName(trip.getRouteName());
        existing.setTravelDate(trip.getTravelDate());
        existing.setPassengerCount(trip.getPassengerCount());
        existing.setDelayed(trip.isDelayed());

        return repository.save(existing);
    }

    @Override
    public List<BusTripEntity> getTripsByRoute(String routeName) {
        return repository.findByRouteNameIgnoreCase(routeName);
    }

    @Override
    public List<BusTripEntity> getDelayedTrips() {
        return repository.findByDelayedTrue();
    }
}