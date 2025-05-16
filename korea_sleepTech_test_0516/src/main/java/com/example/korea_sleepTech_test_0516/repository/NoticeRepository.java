package com.example.korea_sleepTech_test_0516.repository;

import com.example.korea_sleepTech_test_0516.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
}
