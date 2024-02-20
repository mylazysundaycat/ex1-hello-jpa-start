package hello.jpastart;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity //테이블과 매핑한다고 JPA에게 알려주는 것
@Getter
@Setter
@Table(name="MEMBER") //엔티티 클래스에 매핑할 테이블 정보를 알려준다
public class Member {
    @Id //엔티티클래스의 필드를 테이블의 기본키에 매핑한다
    private Long id;
    private String name;
    private int age;

    //추가
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;

    public Member(){

    }
}