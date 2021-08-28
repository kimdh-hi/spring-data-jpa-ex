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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Builder(builderMethodName = "createUserHistory")
    public UserHistory(User user, String name, String email, Gender gender) {
        this.user = user;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
}
