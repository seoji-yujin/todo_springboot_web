package project.maybedo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Todo {
    @Id
    @GeneratedValue
    @Column(name = "todo_id")
    private Long id;
    private String content;
    private LocalDateTime date;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "todo")
    private List<Select> todo_group_list = new ArrayList<>();
}
