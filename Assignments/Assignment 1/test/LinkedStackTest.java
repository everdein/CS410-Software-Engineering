import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedStackTest
{
    @Test
    @DisplayName("isEmpty Method Test")
    public void isEmptyTest()
    {
        LinkedStack linkedStack = new LinkedStack();
        assertTrue(linkedStack.isEmpty());
    }

    @Test
    @DisplayName("size Method Test")
    public void sizeTest()
    {
        LinkedStack linkedStack = new LinkedStack();
        assertEquals(0, linkedStack.size());
    }

    @Test
    @DisplayName("push Method Test")
    public void pushTest()
    {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("ABC");
        assertFalse(linkedStack.isEmpty());
    }

    @Test
    @DisplayName("pop Method Test")
    public void popTest()
    {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("ABC");
        linkedStack.pop();
        assertTrue(linkedStack.isEmpty()); // linked list should be empty
    }

    @Test
    @DisplayName("Tests size of linked stack after pop method.")
    public void popTest2()
    {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("one");
        linkedStack.push("two");
        linkedStack.pop();
        linkedStack.pop();
        assertEquals(0, linkedStack.size());
    }

    @Test
    @DisplayName("peek Method Test")
    public void peekTest()
    {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push("Matt");
        assertEquals(linkedStack.peek(), "Matt");
    }

    @Test
    @DisplayName("Times 10000 objects being pushed into linked stack.")
    public void push10000Test()
    {
        LinkedStack linkedStack = new LinkedStack();
        double startTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++)
        {
            linkedStack.push(i);
        }
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime + " Milliseconds");
        assertTimeout(Duration.ofMillis(5), () -> {
            for(int i = 0; i < 10000; i++)
            {
                linkedStack.push(i);
            }});
    }

    @Test
    @DisplayName("Pop & Peek methods should throw NoSuchElementException if stack is empty.")
    public void popAndPeekIsEmpty()
    {
        LinkedStack linkedStack = new LinkedStack();
        assertThrows(NoSuchElementException.class, () ->
        { linkedStack.pop();});

        assertThrows(NoSuchElementException.class, () ->
        { linkedStack.peek();});
    }
}