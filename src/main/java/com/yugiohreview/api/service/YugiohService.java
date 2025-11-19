package com.yugiohreview.api.service;

import com.yugiohreview.api.dto.YugiohDto;

import java.util.List;

public interface YugiohService {
    YugiohDto  createYugioh(YugiohDto yugiohDto);
    List<YugiohDto> getAllYugioh();
    YugiohDto getYugiohById(int id);
    YugiohDto updateYugioh (YugiohDto yugiohDto, int id);
    void deleteYugiohId (int id);
}
