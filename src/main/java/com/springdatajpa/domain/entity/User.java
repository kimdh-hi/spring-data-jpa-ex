package com.springdatajpa.domain.entity;

import com.springdatajpa.domain.listener.UserHistoryBackupListener;
import com.springdatajpa.domain.value.Gender;
import lombok.*;

import javax.persistence.*;

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

    @Builder(builderMethodName = "createUser")
    public User(String name, String email, Gender gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
