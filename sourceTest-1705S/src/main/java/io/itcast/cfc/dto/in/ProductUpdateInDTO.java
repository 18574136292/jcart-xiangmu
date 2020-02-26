package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class ProductUpdateInDTO {

    private Integer productId;
    private String productName;
    private Double price;
    private Double discount;
    private Integer stockQuantity;
    private Byte status;
    private String mainPicUrl;
    private Integer rewordPoints;
    private Integer sortOrder;
    private String description;
    private List<String> otherPicUrls;
}
