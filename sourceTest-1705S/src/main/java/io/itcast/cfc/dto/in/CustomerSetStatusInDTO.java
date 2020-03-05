package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerSetStatusInDTO {

    private Integer customerId;
    private Byte status;
}
