package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ReturnUpdateActionInDTO {

    private Integer returnId;
    private Byte action;
}
