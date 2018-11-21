package businesslogic;

public class Session {
    private static Session instance;
    private static int sessionID = -1;

    Session() {
    }

    public static Session getInstance() {
        if (instance == null)
            instance = new Session();
        return instance;
    }

    int getSessionID() {
        return sessionID;
    }

    void setSessionID(int sessionID) {
        Session.sessionID = sessionID;
    }
}
