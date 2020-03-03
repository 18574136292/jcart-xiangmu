package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerLoginOutDTO {
    private String token;
    private Long expireTimestamp;
}
