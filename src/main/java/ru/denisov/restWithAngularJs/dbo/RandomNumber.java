package ru.denisov.restWithAngularJs.dbo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "random")
@Getter
@Setter
@NoArgsConstructor
public class RandomNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private Date createDate;
    private int value;
}
