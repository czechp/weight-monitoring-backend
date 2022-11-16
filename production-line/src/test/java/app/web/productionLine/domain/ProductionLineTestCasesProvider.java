package app.web.productionLine.domain;

public class ProductionLineTestCasesProvider {

    static public ProductionLine getProductionLineToDelete() {
        ProductionLine productionLineToDelete = new ProductionLine("Some line");
        productionLineToDelete.setId(1L);
        return productionLineToDelete;
    }

}
