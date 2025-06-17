package org.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name="USER")
public class Member2 {

    @Id
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    public Member2(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Member2() {

    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
