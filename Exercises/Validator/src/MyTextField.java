
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class MyTextField extends JTextField implements FocusListener
{
	
	private ValidatorStrategy validationStrategy;

	public MyTextField(ValidatorStrategy validationStrategy, int size)
	{
		super(size);
		this.validationStrategy = validationStrategy;
		addFocusListener(this);
	}	
	public MyTextField(int size)
	{
		super(size);
		addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0)
	{
		if (validationStrategy != null)
		{
			validationStrategy.validate(getText());
		}
	}

}
