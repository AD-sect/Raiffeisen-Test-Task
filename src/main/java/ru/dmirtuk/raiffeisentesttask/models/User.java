package ru.dmirtuk.raiffeisentesttask.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.dmirtuk.raiffeisentesttask.enums.Status;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="users")
public class User {
//добавить юзеру роль
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique=true)
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;//потом сделать энам
//    @OneToMany
//    private List<Statistic> statisticsList;


}
