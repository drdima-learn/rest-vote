package com.rubincomputers.restvote.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity {

    // price store in cents
    @Column(name = "price")
    private long price;

    @Column(name = "day", nullable = false)
    @NotNull
    private LocalDate day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

}
