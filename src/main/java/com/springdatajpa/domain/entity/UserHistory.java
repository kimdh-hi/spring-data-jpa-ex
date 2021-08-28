package com.springdatajpa.domain.entity;

import com.springdatajpa.domain.value.Gender;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Builder
public class UserHistory extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder(builderMethodName = "createUserHistory")
    public UserHistory(Long userId, String name, String email, Gender gender) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
