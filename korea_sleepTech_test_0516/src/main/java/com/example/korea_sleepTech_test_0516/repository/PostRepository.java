package com.example.korea_sleepTech_test_0516.repository;

import com.example.korea_sleepTech_test_0516.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
