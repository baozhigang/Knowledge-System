enum Color {
    RED, GREEN, BLUE;
    /**
     * 内部转化
     *
     *     public static final Color RED = new Color();
     *     public static final Color GREEN = new Color();
     *     public static final Color BLUE = new Color();
     */

    private Color() {
        System.out.println("constructor for " + this.toString());
    }

    public void colorInfo() {
        System.out.println("color info");
    }
}
