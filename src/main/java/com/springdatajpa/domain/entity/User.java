package com.springdatajpa.domain.entity;

import com.springdatajpa.domain.listener.UserHistoryBackupListener;
import com.springdatajpa.domain.value.Gender;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EntityListeners(value = UserHistoryBackupListener.class)
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private List<UserHistory> userHistories = new ArrayList<>();

    @OneToMany
    @ToString.Exclude
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private List<Review> reviews = new ArrayList<>();

    @Builder(builderMethodName = "createUser")
    public User(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
