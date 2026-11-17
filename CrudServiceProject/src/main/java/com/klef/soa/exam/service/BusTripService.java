package com.klef.soa.exam.service;

import java.util.List;
import com.klef.soa.exam.entity.BusTripEntity;

public interface BusTripService {

    BusTripEntity addbustrip(BusTripEntity trip);

    List<BusTripEntity> displayAllbustrip();

    String deletebustripById(Long id);

    BusTripEntity getBusTripById(Long id);

    BusTripEntity updateBusTrip(Long id, BusTripEntity trip);

    List<BusTripEntity> getTripsByRoute(String routeName);

    List<BusTripEntity> getDelayedTrips();
}