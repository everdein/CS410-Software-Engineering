// Radiation sensor adapter getters and setters.
public class RadiationSensorAdapter implements SensorAdapter
{
    private sensor.RadiationSensor RS;

    public RadiationSensorAdapter(sensor.RadiationSensor RS)
    {
            this.RS = RS;
    }

    @Override
    public double getSensorReading()
    {
        return RS.getRadiationValue();
    }

    @Override
    public String getCurrentStatus()
    {
        return RS.getStatusInfo();
    }

    @Override
    public String getSensorType()
    {
        return RS.getName();
    }
}