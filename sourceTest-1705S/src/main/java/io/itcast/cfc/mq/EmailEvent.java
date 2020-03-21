package io.itcast.cfc.mq;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailEvent {

    private String toEmail;
    private String title;
    private String content;
}
