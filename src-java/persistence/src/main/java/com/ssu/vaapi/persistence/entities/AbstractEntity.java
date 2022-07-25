package com.ssu.vaapi.persistence.entities;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class AbstractEntity {
    @Getter
    @CreationTimestamp
    @Column(name = "time_create")
    protected Instant timeCreated;

    @Getter
    @UpdateTimestamp
    @Column(name = "time_modify")
    protected Instant timeModify;
}
