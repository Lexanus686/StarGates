package businesslogic;

public class Planet extends SpaceObject {

    public Planet(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName, Galaxy location, String htmlInfo) {
        super(name, isAvailableToVisit, averageTemperature, gravitationPower, new StarGate(stargateName), location, htmlInfo);
    }

    public Planet(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, String stargateName, boolean isActivated, Galaxy location, String htmlInfo) {
        super(name, isAvailableToVisit, averageTemperature, gravitationPower, new StarGate(stargateName, isActivated), location, htmlInfo);
    }

    @Override
    public Float getAverageTemperature() {
        return super.averageTemperature;
    }

    @Override
    public Float getGravitationPower() {
        return super.gravitationPower;
    }

    @Override
    public boolean isAvailableToVisit() {
        return super.isAvailableToVisit;
    }

    @Override
    public void setLocation(Galaxy location) {
        super.location = location;
    }

    @Override
    public Galaxy getLocation() {
        return super.location;
    }

    @Override
    public String getPlanetaryObjectName() {
        return super.name;
    }

    @Override
    public StarGate getStargate() {
        return super.starGate;
    }

    @Override
    public void setHtmlInfo(String htmlInfo) {
        super.htmlInfo = htmlInfo;
    }

    @Override
    public String getHtmlInfo() {
        return super.htmlInfo;
    }

    public void info() {
        System.out.println("1: " + getPlanetaryObjectName());
        System.out.println("2: " + isAvailableToVisit());
        System.out.println("3: " + getAverageTemperature());
        System.out.println("4: " + getGravitationPower());
        System.out.println("5: " + getStargate().getName());
        System.out.println("6: " + getLocation());
        System.out.println("7: " + getHtmlInfo());
    }
}