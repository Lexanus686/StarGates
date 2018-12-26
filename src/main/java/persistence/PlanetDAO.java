package persistence;

import businesslogic.StarGate;
import businesslogic.entities.Galaxy;
import businesslogic.entities.Planet;
import businesslogic.entities.SpaceObject;

import java.sql.*;
import java.util.ArrayList;

public class PlanetDAO implements PlanetDAOInterface {

    private Connection connection;

    public PlanetDAO() {
        try {
            this.connection = DBHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PlanetDTO getObject(PlanetDTO dto, int sessionID) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Planets WHERE USER_ID=\"%d\"", sessionID));
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addObject(PlanetDTO dto, int sessionID) {
        PreparedStatement statement;

        try {
            statement = this.connection.prepareStatement(
                    "INSERT INTO Planets('NAME', 'VISIT', 'TEMPERATURE', 'GRAVITYPOWER', 'STARGATENAME', 'STARGATESTATUS', 'LOCATION', 'HTMLINFO', 'USER_ID') " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setObject(1, dto.getName());
            statement.setObject(2, dto.isAvailableToVisit());
            statement.setObject(3, dto.getAverageTemperature());
            statement.setObject(4, dto.getGravitationPower());
            statement.setObject(5, dto.getStarGate().getName());
            statement.setObject(6, dto.getStarGate().isActivated());
            statement.setObject(7, dto.getLocation().toString());
            statement.setObject(8, dto.getHtmlInfo());
            statement.setObject(9, sessionID);

            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PlanetDTO getObject(PlanetDTO tmp) {
        return null;
    }

    @Override
    public void addObject(PlanetDTO tmp) {
    }

    @Override
    public void removeObject(PlanetDTO dto) {

    }

    @Override
    public void updateObject(PlanetDTO dto) {

    }

    @Override
    public void updateHTML(String[] htmlelements, int sessionID) {
        PreparedStatement statement;

        ArrayList<Integer> IDs = new ArrayList<Integer>();
        try {
            Statement tmp = this.connection.createStatement();
            ResultSet resultSet = tmp.executeQuery(String.format("SELECT * FROM Planets WHERE USER_ID=\"%d\"", sessionID));
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

                statement = this.connection.prepareStatement(String.format("UPDATE Planets SET HTMLINFO = \"%s\"WHERE USER_ID = \"%d\"AND ID = \"%d\"", htmlelements[htmlelements.length - n], sessionID, item));

                statement.execute();
                n++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PlanetDTO> getAllPlanets(int sessionID) {
        ArrayList<PlanetDTO> planetDTOS = new ArrayList<PlanetDTO>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Planets WHERE USER_ID=\"%d\"", sessionID));
            while (resultSet.next()) {
                planetDTOS.add(new PlanetDTO(resultSet.getString("NAME"),
                        resultSet.getBoolean("VISIT"), resultSet.getFloat("TEMPERATURE"),
                        resultSet.getFloat("GRAVITYPOWER"), new StarGate(resultSet.getString("STARGATENAME"), resultSet.getBoolean("STARGATESTATUS")),
                        Galaxy.valueOf(resultSet.getString("LOCATION")), resultSet.getString("HTMLINFO")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return planetDTOS;
    }

    public static PlanetDTO convertPlanetToPlanetDTO(SpaceObject planet) {
        return new PlanetDTO(planet.getPlanetaryObjectName(), planet.isAvailableToVisit(), planet.getAverageTemperature(),
                planet.getGravitationPower(), planet.getStargate(), planet.getLocation(), planet.getHtmlInfo());
    }

    public static Planet convertPlanetDTOToPlanet(PlanetDTO planetDTO) {
        return new Planet(planetDTO.getName(), planetDTO.isAvailableToVisit(), planetDTO.getAverageTemperature(),
                planetDTO.getGravitationPower(), planetDTO.getStarGate().getName(), planetDTO.getStarGate().isActivated(), planetDTO.getLocation(), planetDTO.getHtmlInfo());
    }
}