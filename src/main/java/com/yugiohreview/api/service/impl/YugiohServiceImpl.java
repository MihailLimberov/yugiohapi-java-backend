package com.yugiohreview.api.service.impl;

import com.yugiohreview.api.dto.YugiohDto;
import com.yugiohreview.api.models.YuGiOh;
import com.yugiohreview.api.repository.YugiohRepository;
import com.yugiohreview.api.service.YugiohService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YugiohServiceImpl implements YugiohService {
    private YugiohRepository yugiohRepository;

    @Autowired
    public YugiohServiceImpl(YugiohRepository yugiohRepository) {
        this.yugiohRepository = yugiohRepository;
    }

    @Override
    public YugiohDto createYugioh(YugiohDto yugiohDto) {
        YuGiOh yugioh = new YuGiOh();
        yugioh.setName(yugiohDto.getName());
        yugioh.setType(yugiohDto.getType());

        YuGiOh newYugioh = yugiohRepository.save(yugioh);

        YugiohDto yugiohResponse = new YugiohDto();
        yugiohResponse.setId(newYugioh.getId());
        yugiohResponse.setName(newYugioh.getName());
        yugiohResponse.setType(newYugioh.getType());

        return yugiohResponse;
    }
}
