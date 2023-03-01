package com.jsconf.photogram.domain.subscribe;

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
@Table(uniqueConstraints = {@UniqueConstraint(name = "subscribe_uk", columnNames = {"fromUserId", "toUserId"})})
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 증가 전략이 데이터베이스를 따라감
    private int id;

    @JoinColumn(name = "fromUserId") // 이렇게 컬럼명 만들어
    @ManyToOne
    private User fromUser;

    @JoinColumn(name = "toUserId")
    @ManyToOne
    private User toUser;

    private LocalDateTime createDate;

    @PrePersist // DB에 INSERT 되기 직전에 실행
    public void createDate() {
        this.createDate = LocalDateTime.now();
    }
}
