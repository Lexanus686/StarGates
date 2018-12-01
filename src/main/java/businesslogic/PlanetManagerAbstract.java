package businesslogic;

import persistence.PlanetDTO;
import persistence.PlanetRepository;

import java.util.ArrayList;

import static persistence.PlanetRepository.convertPlanetDTOToPlanet;
import static persistence.PlanetRepository.convertPlanetToPlanetDTO;

public class PlanetManagerAbstract extends Session {

    private PlanetRepository planetRepository = null;

    public PlanetManagerAbstract() {
        getInstance();
        planetRepository = new PlanetRepository(this);
    }

    public Planet getPlanet(Planet planet) {
        return convertPlanetDTOToPlanet(planetRepository.getObject(convertPlanetToPlanetDTO(planet)));
    }

    public void addPlanet(Planet planet) {
        planetRepository.addObject(convertPlanetToPlanetDTO(planet));
    }

    public void updatePlanets(String[] htmlelements) {
        planetRepository.updateHTML(htmlelements);
    }

    public ArrayList<Planet> getAllPlanets() {
        ArrayList<Planet> tmp = new ArrayList<Planet>();

        ArrayList<PlanetDTO> allPlanets = planetRepository.getAllPlanets();
        for (PlanetDTO item : allPlanets) {
            tmp.add(convertPlanetDTOToPlanet(item));
        }

        return tmp;
    }

    public int getSessionID() {
        return super.getSessionID();
    }
}
