package optional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

class Person {
    Optional<Car> car;

    Optional<Car> getCar() {
        return car;
    }
}

class Car {

    Optional<Insurance> insurance;

    Optional<Insurance> getInsurance() {
        return insurance;
    }
}

class Insurance {
    String getCompanyName() {
        return companyName;
    }
    String companyName = "The Big optional.Insurance Company";
}



public class TouchOptional {

    static Set<String> getCompanies(List<Person> persons) {

        return persons
                .stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optInsurance -> optInsurance.map(Insurance::getCompanyName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }


    public static void main(String[] args) {

        Optional<String> s = Optional.ofNullable("boooooo");
        s = Optional.empty();

        System.out.println(s.orElseGet(() -> "else"));


        Optional<Person> person = Optional.of(new Person());

        Optional<Car> car = Optional.of(new Car());

        person.get().car = car;

        Optional<Insurance> insurance = Optional.of(new Insurance());

        car.get().insurance = insurance;


        String res = person
//                .map(optional.Person::getCar)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getCompanyName)
                .orElse("Unknown");

        System.out.println(res);
    }
}
