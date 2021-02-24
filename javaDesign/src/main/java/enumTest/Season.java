package enumTest;

public enum Season {
    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");
    String season;
    Season(String season) {
        this.season = season;
    }
    public String getSeason() {
        return season;
    }
}

