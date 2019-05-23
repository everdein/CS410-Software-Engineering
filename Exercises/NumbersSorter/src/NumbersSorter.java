// This is our adaptee, a third party implementation of a number
// sorter that deals with Lists, not arrays.

import java.util.Collections;
import java.util.List;

public class NumbersSorter
{
    public List<Integer> sort(List<Integer> numbers)
    {
        // sort and return
        Collections.sort(numbers);
        return numbers;
    }
}
