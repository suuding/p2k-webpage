package com.example.p2k.user;

import jakarta.persistence.*;
import lombok.*;

//@Getter
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="user_tb")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String email; // 중복 체크 필요

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 256, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;    // 학생, 교육자, 관리자

    @Builder
    public User(String email, String name, String password, Role role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
