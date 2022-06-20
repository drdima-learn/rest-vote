package com.rubincomputers.restvote.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Restaurant extends AbstractNamedEntity{


    public Restaurant(Integer id, String name, boolean enabled) {
        super(id, name);
        this.enabled = enabled;
    }

    public Restaurant(Integer id, String name) {
        this(id, name, true);
    }

    public Restaurant(Restaurant restaurant){
        this(restaurant.id, restaurant.name, restaurant.enabled);
    }


    @Column(name = "enabled", nullable = false, columnDefinition = "boolean default true", updatable = false)
    private boolean enabled = true;
}
