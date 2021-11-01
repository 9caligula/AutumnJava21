public enum Season {
    Winter("холодно"),
    Spring("тепло"),
    Summer("жарко"),
    Autumn("дождливо");

    private String decription ;

    Season(String decription) {
        this.decription = decription;
    }

    public String getDecription() {
        return decription;
    }
}
