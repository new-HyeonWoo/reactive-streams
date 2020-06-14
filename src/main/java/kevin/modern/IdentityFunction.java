package kevin.modern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class IdentityFunction {

    public static void main(String[] args) {

        final List<Integer> list= Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(map(list, i -> i*2));
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for(final T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}
