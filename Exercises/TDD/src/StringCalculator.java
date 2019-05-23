import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public static final int add(final String numbers) { //Change void to int for Req2
        int returnValue=0;  //defined for Re3 "add functionality"
        String[] numbersArray = numbers.split(",|\\n");// Change for Req 4 to include /n in the regex
        List <Integer>negativeNumbers= new ArrayList<Integer>(); // Req 5
        if (numbersArray.length > 2) {
            throw new RuntimeException("Up to 2 numbers separated by comma (,) are allowed");
        } else {
            for (String number : numbersArray)
            {
                if (!number.trim().isEmpty()) { // After refactoring
                    int numberInt = Integer.parseInt(number.trim()); //Req5
                    if (numberInt < 0)    //Req5
                    {
                        negativeNumbers.add(numberInt); //Req5
                    }
                   returnValue += Integer.parseInt(number);
                }
            }
            if (negativeNumbers.size() > 0) {   // Req5
                throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
            }
            return returnValue;
//                if (!numbers.isEmpty()) {
//                    Integer.parseInt(number);// If it is not a number, parseInt will throw an exception
//                }
//            }
        }
       // return 0; // Added return for Req2
    }


}
