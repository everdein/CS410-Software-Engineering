import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortListAdapter implements Sorter {
    public int[] sort(int[] numbers) {
        List<Integer> numberList = IntStream.of(numbers).boxed().collect(Collectors.toList());
        NumbersSorter numbersSorter = new NumbersSorter();
        List<Integer> sortedList = numbersSorter.sort(numberList);
        return sortedList.stream().mapToInt(i -> i).toArray();
    }
}
