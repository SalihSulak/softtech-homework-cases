package com.salihsulak.service;

import com.salihsulak.model.Residence;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ResidenceService {

    public int totalPriceOfResidences(List<Residence> residenceList){

        return residenceList.stream()
                .map(Residence::getPrice)
                .reduce(0, Integer::sum);
    }

            public double averageSquareMetersOfResidences(List<Residence> residenceList){
                return residenceList.stream()
                        .mapToDouble(Residence::getSquareMeters)
                        .reduce(
                                0,(sum,squareMeters)-> sum + squareMeters / residenceList.size()
                        );
            }

    public void filterByNumberOfRoomAndLivingRoom(List<Residence> residenceList, int numberOfRoom, int numberOfLivingRoom) {

        System.out.println("Arama Sonuçları");
        System.out.println("---------------------------------");

        List<Residence> filterResult = residenceList.stream()
                .filter(
                        residence -> residence.getNumberOfRooms()==numberOfRoom
                                &&residence.getNumberOfLivingRooms()==numberOfLivingRoom
                )
                .collect(Collectors.toList());

                    filterResult.forEach(residence ->
                            System.out.println("ID : " + residence.getId() +
                                    "\t Fiyat : " + residence.getPrice() +
                                    "\t Metrekare : " + residence.getSquareMeters() +
                                    "\t Oda Sayısı : " + residence.getNumberOfRooms() +
                                    "\t Salon Sayısı : " + residence.getNumberOfLivingRooms()
                            )
                    );

        if(filterResult.size()==0)
            System.out.println("Bu özelliklere ait ev bulunamadı");

        System.out.println("------------------------------");
    }

    }
