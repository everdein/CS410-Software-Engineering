//													  //
////				  Matthew Clark					////
////	CS410 Software Engineering - Assignment 2	////
//													  //

// Sensor imports.
import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;

// Awt Import.
import java.awt.*;

// Data structure import.
import java.util.ArrayList;

// Swing Imports.
import javax.swing.*;
import javax.swing.border.TitledBorder;

// Creates sensor application class and extends JFrame.
public class SensorApplication extends JFrame
{
	// Create JFrame.
	public SensorApplication()
	{
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3,1));
		setPreferredSize(new Dimension(600,600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// Creates JPanels for sensors.
	public void createPanelForSensor(double sensorReading, String sensorStatus, String sensorType)
	{
		//Stores color value based on Sensor Condition
		Color color = statusToColor(sensorStatus);

		// Assigns sensor panel and passes color.
		JPanel  sensorPanel = new SensorPanel(color, sensorReading);

		//Creates and prints sensor information to JFrame
		JLabel sensorLabel = new JLabel(sensorStatus +": " + sensorReading);
		sensorPanel.setBorder(new TitledBorder(sensorType));
		sensorPanel.add(sensorLabel);
		add(sensorPanel);
	}

	// Paints color.
	public class SensorPanel extends JPanel
	{
		// Variable declaration.
		private double sensorReading;
		private Color color;

		// Constructor for color and sensor reading.
		public SensorPanel(Color color, double sensorReading)
		{
			this.color = color;
			this.sensorReading = sensorReading;
		}

		//Prints a rectangle in the color based on the return value of statusToColor method.
		@Override
		protected void paintComponent(Graphics g)
		{
			g.setColor(this.color);
			g.fillRect(20, 20, (int) sensorReading * 2, 100);
		}
	}

	// Assigns color to sensor status.
	public Color statusToColor(String sensorStatus)
	{
		// Assigns color green when status is ok.
		if (sensorStatus.equalsIgnoreCase("Ok"))
		{
			return Color.GREEN;
		}
		// Assigns color yellow when status is critical.
		if (sensorStatus.equalsIgnoreCase("Critical"))
		{
			return Color.YELLOW;
		}
		// Assigns color red when status is dangerous.
		if (sensorStatus.equalsIgnoreCase("Danger"))
		{
			return Color.RED;
		}
		return Color.BLACK;
	}

	// Executes main.
	public static void main(String[] args)
	{
		//Creates a list to hold SensorsAdapter interfaces
		ArrayList<SensorAdapter> sensorList = new ArrayList<SensorAdapter>();

		// Creates radiation sensor object.
		RadiationSensor RS = new RadiationSensor();
		SensorAdapter radiationSensorAdapter = new RadiationSensorAdapter(RS);

		// Creates pressure sensor object.
		PressureSensor PS = new PressureSensor();
		SensorAdapter pressureSensorAdapter = new PressureSensorAdapter(PS);

		// Creates temperature sensor object.
		TemperatureSensor TS = new TemperatureSensor();
		SensorAdapter temperatureSensorAdapter = new TemperatureSensorAdapter(TS);

		// Adds sensor to sensor array list.
		sensorList.add(radiationSensorAdapter);
		sensorList.add(pressureSensorAdapter);
		sensorList.add(temperatureSensorAdapter);

		// Creates sensor application object.
		SensorApplication sensorApplication = new SensorApplication();

		// Iterates through sensor list retrieving sensor reading, sensor status and sensor type/name.
		for (int i = 0; i < sensorList.size(); i++)
		{
			// Creates sensor adapter object.
			SensorAdapter sensorAdapter = sensorList.get(i);

			// Creates sensor reading object and store sensor reading..
			double sensorReading = sensorAdapter.getSensorReading();

			// Creates sensor status object and stores current sensor status.
			String sensorStatus = sensorAdapter.getCurrentStatus();

			// Creates sensor type object and stores sensor type.
			String sensorType = sensorAdapter.getSensorType();

			// Creates JPanel and passes sensor reading, sensor status and sensor type.
			sensorApplication.createPanelForSensor(sensorReading, sensorStatus, sensorType);
		}
		// Sizes the frame so all contents are at or above their preferred sizes.
		sensorApplication.pack();
	}
}
