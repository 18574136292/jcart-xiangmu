package io.itcast.cfc.mq;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class HotProductDTO implements Serializable {
    private Integer productId;
    private String productCode;
}
