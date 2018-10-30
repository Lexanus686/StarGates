package businesslogic;

public class StarGate {
    private String name;
    private final Long millisecond = 1000L;
    private final Long ModernGalaxyTimeFactor = 8L;
    private final Long OldGalaxyTimeFactor = 64L;
    private final Long AncientGalaxyTimeFactor = 256L;
    private boolean isActivated = false;

    public StarGate(String name) {
        this.name = name;
        this.isActivated = false;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public boolean activate() {
        if (!this.isActivated()) {
            this.isActivated = true;
            return true;
        }
        else return false;
    }

    public void powerLend(Planet planet) throws java.lang.InterruptedException {
        Galaxy galaxyType = planet.getLocation();
        switch (galaxyType) {
            case MODERN:
                Thread.sleep(ModernGalaxyTimeFactor * millisecond);

                break;
            case OLD:
                Thread.sleep(OldGalaxyTimeFactor * millisecond);

                break;
            case ANCIENT:
                Thread.sleep(AncientGalaxyTimeFactor * millisecond);
        }
    }
}
