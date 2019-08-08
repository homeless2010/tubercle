package xin.cuichaojiang.tubercle.system.user.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_user")
public class User implements Serializable {
    @Id
    private String id;
    @Column(nullable = false)
    private String loginName;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String loginPassword;
}
