public enum Currency {

    PLN("polski złoty", 1.00),
    USD("dolar amerykański", 4.02),
    GBP("funt brytyjski", 5.46),
    EUR("euro", 4.55);

    private final String name;
    private final double exchangeToPLN;

    Currency(String name, double exchangeToPLN) {
        this.name = name;
        this.exchangeToPLN = exchangeToPLN;
    }

    public String getName() {
        return name;
    }

    public double getExchangeToPLN() {
        return exchangeToPLN;
    }


}
