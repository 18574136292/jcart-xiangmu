package io.itcast.cfc.dto.out;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class PageOutDTO<T> {

    private Integer total;
    private Integer pageSize;
    private Integer pageNum;
    private List<T> list;
}
