package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ProductListOutDTO {

    private Integer productId;
    private String productCode;
    private String productName;
    private String productAbstract;
    private Double price;
    private Double discount;
    private String mainPicUrl;
}
