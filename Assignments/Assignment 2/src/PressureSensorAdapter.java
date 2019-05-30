// Pressure sensor adaptor getters and setters.
public class PressureSensorAdapter implements SensorAdapter
{
    private sensor.PressureSensor PS;

    public PressureSensorAdapter(sensor.PressureSensor PS)
    {
        this.PS = PS;
    }

    @Override
    public double getSensorReading()
    {
        return PS.readValue();
    }

    @Override
    public String getCurrentStatus()
    {
        return PS.getReport();
    }

    @Override
    public String getSensorType()
    {
        return PS.getSensorName();
    }
}