package businesslogic;

import businesslogic.entities.Session;
import businesslogic.entities.SpaceObject;
import persistence.PlanetDAO;
import persistence.PlanetDAOInterface;
import persistence.PlanetDTO;

import java.util.ArrayList;

import static persistence.PlanetDAO.convertPlanetDTOToPlanet;
import static persistence.PlanetDAO.convertPlanetToPlanetDTO;

public class PlanetManager implements PlanetManagerInterface {

    private PlanetDAOInterface planetRepository;

    public PlanetManager() {
        planetRepository = new PlanetDAO();
    }

    @Override
    public SpaceObject getPlanet(SpaceObject planet) {
        return convertPlanetDTOToPlanet(planetRepository.getObject(convertPlanetToPlanetDTO(planet), getSessionID()));
    }

    @Override
    public void addPlanet(SpaceObject planet) {
        planetRepository.addObject(convertPlanetToPlanetDTO(planet), getSessionID());
    }

    @Override
    public void updatePlanets(String[] htmlelements) {
        planetRepository.updateHTML(htmlelements, getSessionID());
    }

    @Override
    public ArrayList<SpaceObject> getAllPlanets() {
        ArrayList<SpaceObject> tmp = new ArrayList<SpaceObject>();

        ArrayList<PlanetDTO> allPlanets = planetRepository.getAllPlanets(getSessionID());
        for (PlanetDTO item : allPlanets) {
            tmp.add(convertPlanetDTOToPlanet(item));
        }

        return tmp;
    }

    private int getSessionID() {
        return Session.getInstance().getSessionID();
    }
}
