package optional;

import java.util.Optional;

public class TwoOptionals {

    static String performJob(String s, Integer n) {
        return s+String.valueOf(n);
    }

    static Optional<String> performJobSafe(Optional<String> s, Optional<Integer> n) {

        return s.flatMap(s_ ->
                        n.map(n_ ->
                           performJob(s_, n_)
        ));

    }

    public static void main(String[] args) {

         performJobSafe(
                Optional.of("aa"),
                Optional.of(1)
         )
                 .map(System.out::printf);

//                 .map(_s -> {System.out.println(_s); return _s;} );

//                 .stream().map(_s -> {System.out.println(_s); return _s;})
//                 .forEach(_s -> {});


    }
}

