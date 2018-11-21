package persistence;

import businesslogic.Planet;

import java.sql.*;
import java.util.ArrayList;

//TODO не нарушая текущей структуры, понять, как
//TODO a) вытащить попеременно все элементы
//TODO б) если user уже имеет планеты в бд, подгрузить их сразу на начальную страницу
//TODO обновление позиции планет при уходе со страницы
//TODO ПОДУМАТЬ, ГДЕ И КАК МНЕ НУЖЕН МЕТОД getObject(PlanetDTO planetDTO) в моей реализации, если нужен
public class PlanetRepository extends Repository<PlanetDTO> {

    private static final String CON_STR_PLANETS = "jdbc:sqlite:C:\\Users\\User\\.IntelliJIdea2018.2\\StarGates\\src\\main\\java\\DataBase\\Planets.s3db";
    private Connection connection;
    private DBHandler instance;
    private Statement statement;

    private int sessionID;
    private ArrayList<PlanetDTO> planetDTOS;

    public PlanetRepository() {
        try {
            this.instance = new DBHandler(CON_STR_PLANETS);
            this.connection = instance.getConnection();

            planetDTOS = new ArrayList<PlanetDTO>();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getSessionID() {
        return sessionID;
    }

    @Override
    public PlanetDTO getObject(PlanetDTO dto) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PlanetsTable WHERE USER_ID=" + "\"" + sessionID + "\"");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<PlanetDTO> getAllPlanets() {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PlanetsTable WHERE USER_ID=" + "\"" + sessionID + "\"");
            while (resultSet.next()) {
                //TODO Here. Исправить
                /*planetDTOS.add(new PlanetDTO(resultSet.getString("Name"),
                        resultSet.getBoolean("VISIT"), resultSet.getFloat("TEMPERATURE"),
                        resultSet.getFloat("GRAVITYPOWER"), new StarGate(resultSet.getString("STARGATENAME"), resultSet.getBoolean("STARGATESTATUS")),
                        new ArrayList<String>(Arrays.asList(resultSet.getString("HTMLINFO")))));*/
                Thread.sleep(1000);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.planetDTOS;
    }

    @Override
    public void addObject(PlanetDTO tmp) {
        PreparedStatement statement;

        try {
            statement = this.connection.prepareStatement(
                    "INSERT INTO PlanetsTable('NAME', 'VISIT', 'TEMPERATURE', 'GRAVITYPOWER', 'STARGATENAME', 'STARGATESTATUS', 'HTMLINFO', 'USER_ID') " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setObject(1, tmp.getName());
            statement.setObject(2, tmp.isAvailableToVisit());
            statement.setObject(3, tmp.getAverageTemperature());
            statement.setObject(4, tmp.getGravitationPower());
            statement.setObject(5, tmp.getStarGate().getName());
            statement.setObject(6, tmp.getStarGate().isActivated());
            statement.setObject(7, tmp.getHtmlInfo());
            statement.setObject(8, this.sessionID);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeObject(PlanetDTO tmp) {

    }

    @Override
    public void updateObject(PlanetDTO tmp) {

    }

    public void updateHTML(String[] htmlelements, int SessionID) {
        PreparedStatement statement = null;

        ArrayList<Integer> IDs = new ArrayList<Integer>();
        try {
            Statement tmp = this.connection.createStatement();
            ResultSet resultSet = tmp.executeQuery("SELECT * FROM PlanetsTable WHERE USER_ID=" + "\"" + sessionID + "\"");
            while (resultSet.next()) {
                IDs.add(resultSet.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            int n = 1;
            for (Integer item : IDs) {
                htmlelements[htmlelements.length - n] = "[circle, ui-draggable ui-draggable-handle, " + htmlelements[htmlelements.length - n] + "]";
                statement = this.connection.prepareStatement("UPDATE PlanetsTable SET HTMLINFO = " + "\"" + htmlelements[htmlelements.length - n] + "\"" +
                        "WHERE USER_ID = " + "\"" + sessionID + "\"" + "AND ID = " + "\"" + item + "\"");
                statement.execute();
                n++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static PlanetDTO convertPlanetToPlanetDTO(Planet planet) {
        return new PlanetDTO(planet.getPlanetaryObjectName(), planet.isAvailableToVisit(), planet.getAverageTemperature(),
                planet.getGravitationPower(), planet.getStargate(), planet.getLocation(), planet.getHtmlInfo());
    }

    public static Planet convertPlanetDTOToPlanet(PlanetDTO planetDTO) {
        return new Planet(planetDTO.getName(), planetDTO.isAvailableToVisit(), planetDTO.getAverageTemperature(),
                planetDTO.getGravitationPower(), planetDTO.getStarGate().getName(), planetDTO.getStarGate().isActivated(), planetDTO.getLocation(), planetDTO.getHtmlInfo());
    }
}