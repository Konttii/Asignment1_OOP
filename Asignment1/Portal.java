package Asignment1;

public class Portal {

    private String portalName;

    public Portal(String portalName) {
        this.portalName = portalName;
    }

    public String getPortalName() {
        return portalName;
    }

    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    public void showPortal() {
        System.out.println("Portal name: " + portalName);
    }
}

