package com.yugiohreview.api.service;

import com.yugiohreview.api.dto.YugiohDto;
import com.yugiohreview.api.dto.YugiohResponce;

import java.util.List;

public interface YugiohService {
    YugiohDto  createYugioh(YugiohDto yugiohDto);
    YugiohResponce getAllYugioh(int pageNo, int pageSize);
    YugiohDto getYugiohById(int id);
    YugiohDto updateYugioh (YugiohDto yugiohDto, int id);
    void deleteYugiohId (int id);
}
