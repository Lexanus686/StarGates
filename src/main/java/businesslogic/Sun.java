package businesslogic;

public class Sun extends SpaceObject {

    Sun(String name, float averageTemperature, float gravitationPower, Galaxy location, String htmlInfo) {
        super(name, false, averageTemperature, gravitationPower, null, location, htmlInfo);
    }

    @Override
    public void setLocation(Galaxy location) {
        super.location = location;
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
    public Galaxy getLocation() {
        return super.location;
    }

    @Override
    public boolean isAvailableToVisit() {
        return false;
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
}
