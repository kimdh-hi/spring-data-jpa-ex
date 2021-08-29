package com.springdatajpa.domain.entity;

import com.springdatajpa.domain.value.Address;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Builder
@ToString(callSuper = true)
public class Publisher extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();

    @Builder(builderMethodName = "createPublisher")
    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
