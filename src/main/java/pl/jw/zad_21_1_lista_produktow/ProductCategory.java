package pl.jw.zad_21_1_lista_produktow;

public enum ProductCategory {
    GROCERY("Artykuły spożywcze"),
    AGD("Artykuły gospodarstwa domowego"),
    OTHER("Inne produkty"),
    ALL("Wszystkie produkty");
    private String plName;

    ProductCategory(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }

    public void setPlName(String plName) {
        this.plName = plName;
    }
}
