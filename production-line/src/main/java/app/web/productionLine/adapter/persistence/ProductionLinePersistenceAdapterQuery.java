package app.web.productionLine.adapter.persistence;

import app.web.exception.NotFoundException;
import app.web.productionLine.application.dto.ProductionLineQueryDto;
import app.web.productionLine.application.port.query.ProductionLinePortExistByName;
import app.web.productionLine.application.query.ProductionLineQuery;
import app.web.productionLine.domain.ProductionLineFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
class ProductionLinePersistenceAdapterQuery implements
        ProductionLineQuery,
        ProductionLinePortExistByName {
    private final ProductionLineRepository productionLineRepository;

    @Override
    public ProductionLineQueryDto findProductionLineById(final long id) {
        return productionLineRepository.findById(id)
                .map(ProductionLineFactory::toDto)
                .orElseThrow(() -> new NotFoundException("Linia z id: " + id + " nie istnieje"));
    }

    @Override
    public List<ProductionLineQueryDto> findAllProductionLines(Pageable pageable) {
        return productionLineRepository.findAll(pageable)
                .stream()
                .map(ProductionLineFactory::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String lineName) {
        return productionLineRepository.existsByLineName(lineName);
    }


}
