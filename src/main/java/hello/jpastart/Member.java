package hello.jpastart;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity //테이블과 매핑한다고 JPA에게 알려주는 것
@Getter
@Setter
@Table(name="MEMBER") //엔티티 클래스에 매핑할 테이블 정보를 알려준다
public class Member {
    @Id //엔티티클래스의 필드를 테이블의 기본키에 매핑한다
    private Long id;
    private String name;
    private int age;

    public Member(){

    }
}