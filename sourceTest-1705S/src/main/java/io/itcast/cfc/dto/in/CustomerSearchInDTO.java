package io.itcast.cfc.dto.in;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerSearchInDTO {

    private String username;
    private String realName;
    private String mobile;
    private String email;
    private Byte status;
}
