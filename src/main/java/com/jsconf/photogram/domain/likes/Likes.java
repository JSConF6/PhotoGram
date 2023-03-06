package com.jsconf.photogram.domain.likes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jsconf.photogram.domain.image.Image;
import com.jsconf.photogram.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity // DB에 테이블을 생성
@Table(uniqueConstraints = {@UniqueConstraint(name = "likes_uk", columnNames = {"imageId", "userId"})})
public class Likes { // N
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라감
    private int id;

    @JoinColumn(name = "imageId")
    @ManyToOne
    private Image image; // 1

    // 오류가 터지고 나서 잡아봅시다.
    @JsonIgnoreProperties({"images"})

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user; // 1

    private LocalDateTime createDate;

    @PrePersist // DB에 INSERT 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
