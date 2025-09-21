package com.kams.portfolio.post;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTypeAndPublished(String type, boolean published);

    List<Post> findByPublishedTrue();
}
