package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ProductShowOutDTO {

    private Integer productId;
    private String productCode;
    private String productName;
    private Double price;
    private Double discount;
    private Integer stockQuantity;
    private String mainPicUrl;
    private Integer rewordPoints;
    private String description;
    private List<String> otherPicUrls;
}
