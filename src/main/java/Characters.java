public class Characters {
    private String name;
    private String symbol;
    String[][] location = new String[8][29];

    public String[][] getLocation() {
        return location;
    }

    public void setLocation(int i, int j, String symbol) {
        this.location = location;
    }

    public Characters(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
