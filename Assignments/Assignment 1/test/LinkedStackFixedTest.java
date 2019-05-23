import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackFixedTest
{
        @Test
        @DisplayName("isEmpty Method Test")
        public void isEmptyTest()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            assertTrue(linkedStackFixed.isEmpty());
        }

        @Test
        @DisplayName("size Method Test")
        public void sizeTest()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            assertEquals(0, linkedStackFixed.size());
        }

        @Test
        @DisplayName("push Method Test")
        public void pushTest()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            linkedStackFixed.push("ABC");
            assertFalse(linkedStackFixed.isEmpty());
        }

        @Test
        @DisplayName("pop Method Test")
        public void popTest()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            linkedStackFixed.push("ABC");
            linkedStackFixed.pop();
            assertTrue(linkedStackFixed.isEmpty()); // linked list should be empty
        }

        @Test
        @DisplayName("Tests size of linked stack after pop method.")
        public void popTest2()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            linkedStackFixed.push("one");
            linkedStackFixed.push("two");
            linkedStackFixed.pop();
            linkedStackFixed.pop();
            assertEquals(0, linkedStackFixed.size());
        }

        @Test
        @DisplayName("peek Method Test")
        public void peekTest()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            linkedStackFixed.push("Matt");
            assertEquals(linkedStackFixed.peek(), "Matt");
        }

        @Test
        @DisplayName("Times 10000 objects being pushed into linked stack.")
        public void push10000Test()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            double startTime = System.currentTimeMillis();
            for(int i = 0; i < 10000; i++)
            {
                linkedStackFixed.push(i);
            }
            double endTime = System.currentTimeMillis();
            double totalTime = endTime - startTime;
            System.out.println("Total Time: " + totalTime + " Milliseconds");
            assertTimeout(Duration.ofMillis(5), () -> {
                for(int i = 0; i < 10000; i++)
                {
                    linkedStackFixed.push(i);
                }});
        }

        @Test
        @DisplayName("Pop & Peek methods should throw NoSuchElementException if stack is empty.")
        public void popAndPeekIsEmpty()
        {
            LinkedStackFixed linkedStackFixed = new LinkedStackFixed();
            assertThrows(NoSuchElementException.class, () ->
            { linkedStackFixed.pop();});

            assertThrows(NoSuchElementException.class, () ->
            { linkedStackFixed.peek();});
        }
    }