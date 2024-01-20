package stream;

import java.util.List;

public class TAnyMatch {
    public static void main(String[] args) {
        List<Integer> li = List.of(1,2,3,4,5,6,5,3,2,1);

        li.stream()
                .findAny(e -> e.equals(2))
                .ifPresent();

//        obsoleteCountries.stream()
//                .findAny(countryNameAndCode -> countryNameAndCode[COUNTRY_CODE_INDEX].equals(countryCode))
//                .ifPresent(this::addToVisibleCountries);

    }
}
