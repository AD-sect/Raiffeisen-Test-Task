package ru.dmirtuk.raiffeisentesttask.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dmirtuk.raiffeisentesttask.enums.Type;
import ru.dmirtuk.raiffeisentesttask.enums.Move;
import ru.dmirtuk.raiffeisentesttask.enums.Result;

import javax.persistence.*;

// TODO: 25.08.2022 сделать enum в gametype
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Result result;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column
    @Enumerated(EnumType.STRING)
    private Move userMove;

    @Column
    @Enumerated(EnumType.STRING)
    private Move compMove;

    @ManyToOne
    private User user;

}
