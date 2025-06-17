package shoping.study.spring.MyShopingMall.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity public class Category {
    @Id
    @GeneratedValue @Column(name = "CATEGORY_ID")
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    private List<Item> items = new ArrayList<Item>();
    //	`@JoinTable`: 연결 테이블 설정
    //	•	`name`: 연결 테이블 이름 (`CATEGORY_ITEM`)
    //	•	`joinColumns`: 현재 엔티티(Category)의 FK 컬럼 (`CATEGORY_ID`)
    //	•	`inverseJoinColumns`: 반대쪽 엔티티(Item)의 FK 컬럼 (`ITEM_ID`)
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "PARENT_ID")
    private Category parent;
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<Category>();
    //= =연관관계 메소드= =//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getChild() {
        return child;
    }

    public void setChild(List<Category> child) {
        this.child = child;
    }
}