public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    private final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double getSurfaceWeight(double mass) {
        return surfaceGravity * mass;
    }
}
