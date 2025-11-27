package com.yugiohreview.api.service.impl;

import com.yugiohreview.api.dto.YugiohDto;
import com.yugiohreview.api.dto.YugiohResponce;
import com.yugiohreview.api.exceptions.YugiohNotFoundException;
import com.yugiohreview.api.models.YuGiOh;
import com.yugiohreview.api.repository.YugiohRepository;
import com.yugiohreview.api.service.YugiohService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public YugiohResponce getAllYugioh(int pageNo, int pageSize) {
        //YuGiOh yugiohTest = yugiohRepository.findById(333333).orElseThrow(() -> new YugiohNotFoundException("Yugioh card could not be found by id"));
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<YuGiOh> yugiohs = yugiohRepository.findAll(pageable);
        List<YuGiOh> listOfYugioh = yugiohs.getContent();
        List<YugiohDto> content = listOfYugioh.stream().map(ygh -> mapToDto(ygh)).collect(Collectors.toList());

        YugiohResponce yugiohResponce = new YugiohResponce();
        yugiohResponce.setContent(content);
        yugiohResponce.setPageNo(yugiohs.getNumber());
        yugiohResponce.setPageSize(yugiohs.getSize());
        yugiohResponce.setTotalElements(yugiohs.getTotalElements());
        yugiohResponce.setTotalPages(yugiohs.getTotalPages());
        yugiohResponce.setLast(yugiohs.isLast());

        return yugiohResponce;
    }

    @Override
    public YugiohDto getYugiohById(int id) {
        YuGiOh yugioh = yugiohRepository.findById(id).orElseThrow(() -> new YugiohNotFoundException("YuGiOh card could not be found!"));
        return mapToDto(yugioh);
    }

    @Override
    public YugiohDto updateYugioh(YugiohDto yugiohDto, int id) {
        YuGiOh yugioh = yugiohRepository.findById(id).orElseThrow(() -> new YugiohNotFoundException("YuGiOh card could not be updated!"));

        yugioh.setName(yugiohDto.getName());
        yugioh.setType(yugiohDto.getType());

        YuGiOh updatedYugioh = yugiohRepository.save(yugioh);
        return mapToDto(updatedYugioh);
    }

    @Override
    public void deleteYugiohId(int id) {
        YuGiOh yugioh = yugiohRepository.findById(id).orElseThrow(() -> new YugiohNotFoundException("YuGiOh card could not be deleted!"));
        yugiohRepository.delete(yugioh);
    }

    private YugiohDto mapToDto(YuGiOh yugioh) {
        YugiohDto yugiohDto = new YugiohDto();
        yugiohDto.setId(yugioh.getId());
        yugiohDto.setName(yugioh.getName());
        yugiohDto.setType(yugioh.getType());

        return yugiohDto;
    }

    private YuGiOh mapToEntity(YugiohDto yugiohDto) {
        YuGiOh yugioh = new YuGiOh();
        yugioh.setName(yugiohDto.getName());
        yugioh.setType(yugiohDto.getType());

        return yugioh;
    }
}
