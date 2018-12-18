package persistence;

import java.util.ArrayList;

public interface PlanetDAOInterface extends Repository<PlanetDTO> {
    void updateHTML(String[] htmlelements, int sessionID);

    PlanetDTO getObject(PlanetDTO dto, int sessionID);

    void addObject(PlanetDTO dto, int sessionID);

    ArrayList<PlanetDTO> getAllPlanets(int sessionID);

}
