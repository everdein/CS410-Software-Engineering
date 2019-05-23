import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ApplicationForm
{
	private JLabel nameLbl = new JLabel("Name:");
	private JLabel surnameLbl = new JLabel("Surname:");
	private JLabel professionLbl = new JLabel("Profession:");
	private JLabel yearLbl = new JLabel("Graduation Year:");
	private JLabel homePhoneLbl = new JLabel("Home Phone:");
	private JLabel workPhoneLbl = new JLabel("Work Phone:");
	private JLabel mobilePhoneLbl = new JLabel("Mobile Phone:");
	private MyTextField nameTxt = new MyTextField(15);
	private MyTextField surnameTxt = new MyTextField(15);
	private MyTextField professionTxt = new MyTextField(15);
	private MyTextField yearTxt = new MyTextField(new YearValidationStrategy(), 15);
	private MyTextField homePhoneTxt = new MyTextField(new PhoneNumberValidationStrategy(), 15);
	private MyTextField workPhoneTxt = new MyTextField(new PhoneNumberValidationStrategy(), 15);
	private MyTextField mobilePhoneTxt = new MyTextField(new PhoneNumberValidationStrategy(), 15);
	private JButton applyBtn = new JButton("Apply");
	private JFrame frm = new JFrame();
	private JPanel centerPnl = new JPanel();
	private JPanel southPnl = new JPanel();
	
	public ApplicationForm()
	{
		centerPnl.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = new Insets(10, 10, 10, 10);
		gc.gridx = 0;
		gc.gridy = 0;
		centerPnl.add(nameLbl, gc);
		gc.gridx = 1;
		gc.gridy = 0;
		centerPnl.add(nameTxt, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		centerPnl.add(surnameLbl, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		centerPnl.add(surnameTxt, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		centerPnl.add(professionLbl, gc);
		gc.gridx = 1;
		gc.gridy = 2;
		centerPnl.add(professionTxt, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		centerPnl.add(yearLbl, gc);
		gc.gridx = 1;
		gc.gridy = 3;
		centerPnl.add(yearTxt, gc);
		gc.gridx = 0;
		gc.gridy = 4;
		centerPnl.add(homePhoneLbl, gc);
		gc.gridx = 1;
		gc.gridy = 4;
		centerPnl.add(homePhoneTxt, gc);
		gc.gridx = 0;
		gc.gridy = 5;
		centerPnl.add(workPhoneLbl, gc);
		gc.gridx = 1;
		gc.gridy = 5;
		centerPnl.add(workPhoneTxt, gc);
		gc.gridx = 0;
		gc.gridy = 6;
		centerPnl.add(mobilePhoneLbl, gc);
		gc.gridx = 1;
		gc.gridy = 6;
		centerPnl.add(mobilePhoneTxt, gc);
		southPnl.add(applyBtn);

		frm.setLayout(new BorderLayout());
		frm.add(centerPnl, BorderLayout.CENTER);
		frm.add(southPnl, BorderLayout.SOUTH);
		frm.setVisible(true);
		frm.pack();
	}
	
	public static void main(String[] args)
	{
		ApplicationForm gui = new ApplicationForm();
	}
}
