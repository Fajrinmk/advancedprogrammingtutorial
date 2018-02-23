package id.ac.ui.cs.advprog.tutorial2.exercise1.receiver;

public class Light {

    private static final String OUT_FMT = "%s light is %s";

    private String location;
    private boolean lit;

    public Light(String location) {
        this(location, false);
    }

    public Light(String location, boolean lit) {
        this.location = location;
        this.lit = lit;
    }

    public void on() {
        // TODO Complete me!
        System.out.println(String.format(OUT_FMT, location, "on"));
        this.lit = true;
    }

    public void off() {
        // TODO Complete me!
        System.out.println(String.format(OUT_FMT, location, "off"));
        this.lit = false;
    }

    public boolean isLit() {
        // TODO Complete me!
        return this.lit;
    }

    public String getLocation() {
        // TODO Complete me!
        return this.location;
    }
}
