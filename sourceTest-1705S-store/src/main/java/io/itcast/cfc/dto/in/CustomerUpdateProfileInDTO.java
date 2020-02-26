package io.itcast.cfc.dto.in;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerUpdateProfileInDTO {
    private String realName;
    private String mobile;
    private String email;
}
