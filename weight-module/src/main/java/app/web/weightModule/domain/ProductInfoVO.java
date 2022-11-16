package app.web.weightModule.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class ProductInfoVO {
    private final float upRangeWeight;
    private final float downRangeWeight;

    ProductInfoVO() {
        this.upRangeWeight = 0.0f;
        this.downRangeWeight = 0.0f;
    }


    boolean isNotZero() {
        return upRangeWeight != 0.0f && downRangeWeight !=0.0f;
    }

    boolean areDifferent(float productDownRange, float productUpRange) {
        return productDownRange != this.downRangeWeight || productUpRange != this.upRangeWeight;
    }
}
