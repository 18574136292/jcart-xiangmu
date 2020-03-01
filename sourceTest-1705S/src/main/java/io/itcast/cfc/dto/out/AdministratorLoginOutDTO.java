package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdministratorLoginOutDTO {
    private String token;
    private Long expireTimestamp;


}
