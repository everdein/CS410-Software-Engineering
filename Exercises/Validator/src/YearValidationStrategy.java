import javax.swing.*;

public class YearValidationStrategy implements ValidatorStrategy
{

    public YearValidationStrategy()
    {

    }

    @Override
    public void validate(String text)
    {
//        JOptionPane.showMessageDialog(null, "Why it taking so long to graduate?");

        // Sara's Example
        int year = Integer.parseInt(text);
        if(year > 2007)
        {
            JOptionPane.showMessageDialog(null, "Can't apply. Graduation year needs to be before 2007.");
        }
    }
}
