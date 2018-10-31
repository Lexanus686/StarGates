package UI.models;

public class PlanetUI {
    String name; ////название объекта
    boolean isAvailableToVisit; //возможность посещения человеческой расой
    float averageTemperature; //средняя температура
    float gravitationPower; //сила гравитации (в g)
    String starGate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailableToVisit() {
        return isAvailableToVisit;
    }

    public void setAvailableToVisit(boolean availableToVisit) {
        isAvailableToVisit = availableToVisit;
    }

    public float getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(float averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public float getGravitationPower() {
        return gravitationPower;
    }

    public void setGravitationPower(float gravitationPower) {
        this.gravitationPower = gravitationPower;
    }

    public String getStarGate() {
        return starGate;
    }

    public void setStarGate(String starGate) {
        this.starGate = starGate;
    }
}
