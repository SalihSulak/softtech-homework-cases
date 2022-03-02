package com.salihsulak.data;

import com.salihsulak.model.Home;
import com.salihsulak.model.Residence;
import com.salihsulak.model.SummerHouse;
import com.salihsulak.model.Villa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResidenceDataProvider {

    public static List<Residence> getHomeList(){
        Home home1 = new Home(1,10000,  100,  3,  1);
        Home home2 = new Home(2,5000,70,4,1);
        Home home3 = new Home(3,3000,60,3,1);
        return new ArrayList<>(Arrays.asList(home1,home2,home3));
    }

    public static List<Residence> getVillaList(){
        Villa villa1 = new Villa(4,6000000,  1000,  5,  2);
        Villa villa2 = new Villa(5,10000000,  2000,  8,  2);
        Villa villa3 = new Villa(6,2000000,  1200,  11,  3);
        return new ArrayList<>(Arrays.asList(villa1,villa2,villa3));
    }

    public static List<Residence> getSummerHouseList(){
        SummerHouse summerHouse1 = new SummerHouse(7,40000,500,4,1);
        SummerHouse summerHouse2 = new SummerHouse(8,30000,800,5,2);
        SummerHouse summerHouse3 = new SummerHouse(9,60000,600,4,1);
        return new ArrayList<>(Arrays.asList(summerHouse1,summerHouse2,summerHouse3));
    }

    public static List<Residence> getAllResidenceList(){
        return Stream.of(getHomeList(),getVillaList(),getSummerHouseList())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
