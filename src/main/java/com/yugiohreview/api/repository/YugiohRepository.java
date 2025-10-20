package com.yugiohreview.api.repository;

import com.yugiohreview.api.models.YuGiOh;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YugiohRepository extends JpaRepository<YuGiOh,Integer> {

}
