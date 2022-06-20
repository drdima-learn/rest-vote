package com.rubincomputers.restvote.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "dishes")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Dish extends AbstractNamedEntity {



    public Dish(Integer id, String name, long price, LocalDate day, Restaurant restaurant) {
        super(id, name);
        this.price = price;
        this.day = day;
        this.restaurant = restaurant;
    }

    public Dish(Integer id, String name, long price) {
        this(id, name, price, LocalDate.now(), null);
    }

    public Dish(Dish dish) {
        this(dish.id, dish.name, dish.price, dish.day, dish.restaurant);
    }

    // price store in cents
    @Column(name = "price")
    private long price;

    @Column(name = "day", nullable = false)
    @NotNull
    private LocalDate day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

}
