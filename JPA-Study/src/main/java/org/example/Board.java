package org.example;

import javax.persistence.*;

@Entity
public class Board {
    @Id
    @Column(name = "BOARD_ID")
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member2 member;

    public Board(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Board() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member2 getMember() {
        return member;
    }

    public void setMember(Member2 member) {
        if(this.member!=null)
        {
            this.member.getBoards().remove(this);
        }
        this.member = member;
        member.getBoards().add(this);
    }
}
