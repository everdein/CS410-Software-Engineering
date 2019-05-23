import javax.swing.*;
import java.awt.*;

public class PhoneNumberValidationStrategy implements ValidatorStrategy
{



    public PhoneNumberValidationStrategy()
    {
    }

    @Override
    public void validate(String text)
    {
        JOptionPane.showMessageDialog(null, "Sick phone number dawg!");
    }
}
