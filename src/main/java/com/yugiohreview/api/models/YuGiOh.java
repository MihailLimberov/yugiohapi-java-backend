package com.yugiohreview.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class YuGiOh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;

//    public YuGiOh(int id,String name,String type){
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }
//
//    public int getId(){
//        return id;
//    }
//
//    public void setId(int id){
//        this.id = id;
//    }
//
//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public String getType(){
//        return type;
//    }
//
//    public void setType(String type){
//        this.type = type;
//    }

}
