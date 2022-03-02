package com.salihsulak;

import com.salihsulak.model.Residence;
import com.salihsulak.service.ResidenceService;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.salihsulak.data.ResidenceDataProvider.*;

public class Main {
    public static void main(String[] args) {

        ResidenceService service = new ResidenceService();

        System.out.println("Kategorilere Göre Konutların Toplam Fiyatlandırmaları");
        System.out.println("-------------------------------------------------------");

        List<Residence> homeList = getHomeList();
        int totalPriceOfHomes = service.totalPriceOfResidences(homeList);
        System.out.println("Sistemde kayıtlı evlerin toplam fiyatı : " + totalPriceOfHomes);

        List<Residence> villaList = getVillaList();
        int totalPriceOfVillas = service.totalPriceOfResidences(villaList);
        System.out.println("Sistemde kayıtlı villaların toplam fiyatı : " + totalPriceOfVillas);

        List<Residence> summerHouseList = getSummerHouseList();
        int totalPriceOfSummerHouses = service.totalPriceOfResidences(summerHouseList);
        System.out.println("Sistemde kayıtlı yazlıkların toplam fiyatı : " + totalPriceOfSummerHouses);

        List<Residence> allResidenceList = getAllResidenceList();
        int totalPriceOfAllResidances = service.totalPriceOfResidences(allResidenceList);
        System.out.println("Sistemde kayıtlı tüm konutların toplam fiyatı : " + totalPriceOfAllResidances);

        System.out.println("-------------------------------------------------------");
        System.out.println();

        System.out.println("Kategorilere Göre Konutların Ortalama Metrekareleri");
        System.out.println("-------------------------------------------------------");

        double averageSquareMetersOfHomes = service.averageSquareMetersOfResidences(homeList);
        System.out.println("Sistemde kayıtlı evlerin ortalama metrekaresi : " + averageSquareMetersOfHomes);

        double averageSquareMetersOfVillas = service.averageSquareMetersOfResidences(villaList);
        System.out.println("Sistemde kayıtlı villaların ortalama metrekaresi : " + averageSquareMetersOfVillas);

        double averageSquareMetersOfSummerHouses = service.averageSquareMetersOfResidences(summerHouseList);
        System.out.println("Sistemde kayıtlı yazlıkların ortalama metrekaresi : " + averageSquareMetersOfSummerHouses);

        double averageSquareMetersOfAllResidences = service.averageSquareMetersOfResidences(allResidenceList);
        System.out.println("Sistemde kayıtlı evlerin ortalama metrekaresi : " + averageSquareMetersOfAllResidences);

        System.out.println("-------------------------------------------------------");
        System.out.println();

        System.out.println("Filtreme yapmak için lüften oda sayısı ve salon sayısı giriniz ");
        System.out.println("-------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        System.out.print("Oda Sayısı : ");
        int numberOfRoom = input.nextInt();

        System.out.print("Salon Sayısı : ");
        int numberOfLivingRoom = input.nextInt();

        service.filterByNumberOfRoomAndLivingRoom(allResidenceList, numberOfRoom, numberOfLivingRoom);


    }

}
