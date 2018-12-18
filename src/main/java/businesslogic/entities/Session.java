package businesslogic.entities;

public class Session {
    private static Session instance;
    private int sessionID = -1;

    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }
}
