package dev.m.obj.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "time_of_day")
public class Time0fDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Morning
    //Noon
    //Afternoon
    //Evening
    private String period;
}