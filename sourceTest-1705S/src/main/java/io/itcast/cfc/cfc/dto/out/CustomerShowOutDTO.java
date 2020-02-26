package io.itcast.cfc.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CustomerShowOutDTO {

    private Integer customerId;
    private String username;
    private String realName;
    private String avatarUrl;
    private String mobile;
    private String email;
    private Byte status;
    private Long createTimestamp;
    private Boolean newsSubscribed;
    private Integer rewordPoints;
    private Integer defaultAddressId;
}
