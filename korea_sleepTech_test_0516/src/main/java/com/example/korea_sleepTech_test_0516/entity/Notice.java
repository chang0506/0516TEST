package com.example.korea_sleepTech_test_0516.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="adminId", nullable = false)
    private User admin;
}
