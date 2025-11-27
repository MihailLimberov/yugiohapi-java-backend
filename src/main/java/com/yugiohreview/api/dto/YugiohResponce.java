package com.yugiohreview.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class YugiohResponce {
    private List<YugiohDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}
