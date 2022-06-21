package com.rubincomputers.restvote.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "votes",
        indexes = {
                @Index(name = "idx_user_day", columnList = "user_id, day", unique = true)


        }
//        uniqueConstraints = {
//                @UniqueConstraint(columnNames = {
//                        "user_id", "day"},
//                        name = "uk_user_day")
//        }
)

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class Vote extends AbstractBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "day")
    private LocalDate day;


    public Vote(Integer id, Restaurant restaurant, User user, LocalDate day) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
        this.day = day;
    }

    public Vote(Vote vote){
        this(vote.id, vote.restaurant, vote.user, vote.day);
    }
}
