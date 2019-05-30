// Temperature sensor adapter getters and setters.
public class TemperatureSensorAdapter implements SensorAdapter
{
    private sensor.TemperatureSensor TS;

    public TemperatureSensorAdapter(sensor.TemperatureSensor TS)
    {
            this.TS = TS;
    }

    @Override
    public double getSensorReading()
    {
        return TS.senseTemperature();
    }

    @Override
    public String getCurrentStatus()
    {
        return TS.getTempReport();
    }

    @Override
    public String getSensorType()
    {
        return TS.getSensorType();
    }
}