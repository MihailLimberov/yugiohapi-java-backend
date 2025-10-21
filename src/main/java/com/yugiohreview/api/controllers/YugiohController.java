package com.yugiohreview.api.controllers;

import com.yugiohreview.api.dto.YugiohDto;
import com.yugiohreview.api.models.YuGiOh;
import java.util.ArrayList;

import com.yugiohreview.api.service.YugiohService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class YugiohController {

    private YugiohService yugiohService;

    @Autowired
    public YugiohController(YugiohService yugiohService) {
        this.yugiohService = yugiohService;
    }

    @GetMapping("yugioh")
    public ResponseEntity<List<YuGiOh>> getYugiohs(){
        List<YuGiOh> yugiohs = new ArrayList<>();

        // Later should be removed
        yugiohs.add(new YuGiOh(1,"Blue-Eyes White Dragon","Light"));
        yugiohs.add(new YuGiOh(2,"Dark Magician","Dark"));
        yugiohs.add(new YuGiOh(3,"Red-Eyes Black Dragon","Dark"));
        yugiohs.add(new YuGiOh(4,"Glow-Up Bulb","Earth"));
        yugiohs.add(new YuGiOh(5,"Toadally Awesome","Water"));

        return ResponseEntity.ok(yugiohs);

    }

    @GetMapping("yugioh/{id}")
    public YuGiOh yugiohDetail(@PathVariable int id){
        return new YuGiOh(id,"Dark Magician","Dark");
    }

    @PostMapping("yugioh/create")
    @ResponseStatus(HttpStatus.CREATED)
   public ResponseEntity<YugiohDto> createYuGiOh(@RequestBody YugiohDto yugiohDto){

        return new ResponseEntity<>(yugiohService.createYugioh(yugiohDto),HttpStatus.CREATED);

//        System.out.println(yugioh.getName());
//        System.out.println(yugioh.getType());
//        return new ResponseEntity<>(yugioh,HttpStatus.CREATED);
    }

    @PutMapping("yugioh/{id}/update")
    public ResponseEntity<YuGiOh> updateYuGiOh(@RequestBody YuGiOh yugioh, @PathVariable("id") int yugiohId){
        System.out.println(yugioh.getName());
        System.out.println(yugioh.getType());

        return ResponseEntity.ok(yugioh);
    }

    @DeleteMapping("yugioh/{id}/delete")
    public ResponseEntity<String> deleteYuGiOh(@PathVariable("id") int yugiohId){
        System.out.println(yugiohId);

        return ResponseEntity.ok("YuGiOh card deleted successfully.");
    }
}
