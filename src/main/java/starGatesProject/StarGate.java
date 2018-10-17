package starGatesProject;

public class StarGate {
    private String name;
    private boolean isActivated;
    //private Stub typeOfStub = null;

    public StarGate(String name) {
        this.name = name;
        this.isActivated = false;
    }

    /*@Override
    public boolean isActivated() {
        return isActivated;
    }

    @Override
    public boolean doAction() {
        if (!this.isActivated()) {
            this.isActivated = true;
            return true;
        }
        else return false;
    }*/

    /*public boolean hasStub() {
        if (typeOfStub == null) return false; else return true;
    }

    public boolean addStub(Stub stub) {
        if (typeOfStub == null){this.typeOfStub = stub; return true;} else return false;
    }*/
}
