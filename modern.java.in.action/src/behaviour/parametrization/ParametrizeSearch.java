package behaviour.parametrization;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class ParametrizeSearch {
    @AllArgsConstructor
    @ToString
    static class Apartment {
        int roomCount;
        double totalArea;
    }

    static class Strategy {
        static Predicate<Integer> p = (Integer i) -> i>0;

//        public Strategy() {
//            p = (Integer i) -> i>0;
//        }
    }




    static List<Apartment> filter(List<Apartment> list, Predicate f){
        List<Apartment> res = new ArrayList<>(list.size());
        for (Apartment a : list) {
            if (f.test(a)) {
                res.add(a);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        List<Apartment> list = new ArrayList<>();


        list.add(new Apartment(1, 30.0));
        list.add(new Apartment(1, 40.1));
        list.add(new Apartment(2, 80.0));
        list.add(new Apartment(2, 70.0));
        list.add(new Apartment(2, 80.0));
        list.add(new Apartment(3, 80.0));
        list.add(new Apartment(3, 90.0));

        list.stream()
                .filter(a -> a.roomCount > 2)
                .filter(a -> a.totalArea >= 80)
                .forEach(System.out::println);


        Predicate<? super Apartment> f = (a) -> {
            return a.totalArea < 80 && a.roomCount > 1;
        };

        list.stream()
                .filter((Predicate<? super Apartment>) f)
                .forEach(System.out::println);


        filter(list, f)
                .forEach(System.out::println);


        filter(list, new Predicate() {
            @Override
            public boolean test(Object o) {
                return ((Apartment) o).roomCount < 2;
            }
        })
                .forEach(System.out::println);


    }
}
