package app.web.productionLine.adapter.persistence;

import app.web.exception.NotFoundException;
import app.web.productionLine.application.port.crud.ProductionLinePortDeleteById;
import app.web.productionLine.application.port.crud.ProductionLinePortFindByIdOrException;
import app.web.productionLine.application.port.crud.ProductionLinePortSave;
import app.web.productionLine.application.port.query.ProductionLinePortFindAll;
import app.web.productionLine.application.port.query.ProductionLinePortFindById;
import app.web.productionLine.domain.ProductionLine;
import app.web.productionLine.domain.ProductionLineFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ProductionLinePersistenceAdapter implements ProductionLinePortSave,
        ProductionLinePortFindByIdOrException,
        ProductionLinePortDeleteById,
        ProductionLinePortFindById,
        ProductionLinePortFindAll
{
    private final ProductionLineRepository productionLineRepository;

    @Override
    public ProductionLine saveProductionLine(ProductionLine productionLine) {
        final var productionLineEntity = ProductionLineFactory.toEntity(productionLine);
        return ProductionLineFactory.toDomain(productionLineRepository.save(productionLineEntity));
    }

    @Override
    public ProductionLine findProductionLineByIdOrException(long lineId) {
        return productionLineRepository.findById(lineId)
                .map(ProductionLineFactory::toDomain)
                .orElseThrow(() -> new NotFoundException("Linia z id: " + lineId + " nie istnieje"));
    }

    @Override
    public void deleteProductionLineById(long id) {
        productionLineRepository.deleteById(id);
    }

    @Override
    public Optional<ProductionLine> findProductionLineById(long id) {
        return productionLineRepository.findById(id)
                .map(ProductionLineFactory::toDomain);
    }

    @Override
    public List<ProductionLine> findAll() {
        return productionLineRepository.findAll()
                .stream()
                .map(ProductionLineFactory::toDomain)
                .collect(Collectors.toList());
    }
}
