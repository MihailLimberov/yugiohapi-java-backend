package com.yugiohreview.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "yugioh", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<Review>();

}
