package behaviour.parametrization;


import java.util.List;
import java.util.function.*;

interface IPProvider {
    void p(String s);
}
class StaticMethod {

    public static void p(String s) {
        System.out.println(s);
//        return s;
    }
}

class InstanceMethod implements IPProvider{

    String name;

    InstanceMethod(String name) {
        this.name = name;
    }

    public void p (String s) {

        System.out.println(name + ": " + s);

    }

}

class ClassMethod implements IPProvider{
    public void p(String s) {
        System.out.println(this.getClass().getName() + ": " + s);
    }
}

class ConstructorMethod {

}

public class MethodsReferences {

    static List<String> bimap(List<String> list, BiConsumer<IPProvider, String> biConsumer) {
        return map(list, biConsumer::accept);
    }

    static List<String> map(List<String> list, Consumer<String> f) {

        for (String s : list) {
            f.accept(s);
        }
        
        return list;
    }

    public static void main(String[] args) {

        List<String> list = List.of("1111", "22222", "333", "4");
        
        map(list, StaticMethod::p);

        InstanceMethod instance1 = new InstanceMethod("Instance1");
        InstanceMethod instance2 = new InstanceMethod("Instance2");

        map(list, instance1::p);
        map(list, instance2::p);


        BiConsumer<ClassMethod, String> biConsumer = ClassMethod::p;

        bimap(list, );



//        map(list, ClassMethod::p)

//        String::length;

//        map(list, ClassMethod::p);

//        Function<List<String>, List<String >> s = this::map;


//        Predicate
//        Supplier
//        Consumer
//        Function
//        BinaryOperator
//        UnaryOperator
//        BiFunction
//        ToIntFunction


    }

}
