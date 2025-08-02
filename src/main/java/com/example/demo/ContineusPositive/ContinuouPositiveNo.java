package com.example.demo.ContineusPositive;
import java.util.ArrayList;
        import java.util.Optional;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;




public class ContinuouPositiveNo {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(-1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(0);
        numbers.add(1);

        long count = numbers.stream()
                .reduce(new CountAndMax(),
                        (state, number) -> {
                            if (number > 0) {
                                state.incrementCount();
                            } else {
                                state.resetCount();
                            }
                            return state;
                        },
                        (state1, state2) -> {
                            if (state1.isPositive() && state2.isPositive()) {
                                state1.addToCount(state2.getCount());
                            }
                            return state1;
                        })
                .getCount();

        System.out.println("The number of continuous positive sequences is: " + count);
    }
}


