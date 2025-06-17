import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity public class Member {
    @Id @GeneratedValue @Column(name = "MEMBER_ID")
    private Long id;
    private String username;

    @OneToOne(mappedBy = "member")
    private Profile profile;
    ...
}
@Entity public class Profile {
    @Id @GeneratedValue @Column(name = "PROFILE_ID")
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
