package starGatesProject.planetarysystem.planet_system_object_builder.planetarysystemobject;

import starGatesProject.planetarysystem.planet_system_object_builder.mainclasses.StarGate;
import starGatesProject.planetarysystem.planetary_system_builder.mainclasses.Galaxy;

public abstract class PlanetarySystemObject {

    String name; ////название объекта
    boolean isAvailableToVisit; //возможность посещения человеческой расой
    float averageTemperature; //средняя температура
    float gravitationPower; //сила гравитации (в g)
    StarGate starGate;
    Galaxy location;

    PlanetarySystemObject(String name, boolean isAvailableToVisit, float averageTemperature, float gravitationPower, StarGate starGate) {
        this.name = name;
        this.isAvailableToVisit = isAvailableToVisit;
        this.averageTemperature = averageTemperature;
        this.gravitationPower = gravitationPower;
        this.starGate = starGate;
    }

    public abstract void setLocation(Galaxy galaxyType);

    public abstract boolean isAvailableToVisit();

    public abstract String getPlanetaryObjectName();

    public abstract StarGate getStargate();

    public abstract Galaxy getLocation();
}
