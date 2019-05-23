import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class StringCalculatorTest {

    //Requirement 1: The method can take 0, 1 or 2 numbers separated by comma (,).
    @Test
    public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("1,2,3");
        });
    }

    @Test
    public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
        StringCalculator.add("1,2");
//       assertTrue(true);
    }

    //  @Test(expected = RuntimeException.class) --> Unit Test 4
    @Test
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {

        assertThrows(RuntimeException.class, () -> {
            StringCalculator.add("1,X");
        });
    }
//-----------------------------------//
    //  Requirement 2: For an empty string the method will return 0

    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertEquals(0, StringCalculator.add(""));
    }

    //--------------------------------//
//Requirement 3: Method will return their sum of numbers
    @Test
    public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
        assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        assertEquals(3 + 6, StringCalculator.add("3,6"));
    }

    //Requirements 4: Allow the Add method to handle new lines between numbers
    @Test
    public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
        assertEquals(21, StringCalculator.add("6\n15"));
    }

// Req 5: First one checks whether exception is thrown when there are negative numbers.
    @Test
    public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
       assertThrows(RuntimeException.class, ()->StringCalculator.add("3,-6"));
    }

    //Req5: The second one verifies whether the exception message is correct.

    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("Negatives not allowed: [-6]", exception.getMessage());
    }

}
