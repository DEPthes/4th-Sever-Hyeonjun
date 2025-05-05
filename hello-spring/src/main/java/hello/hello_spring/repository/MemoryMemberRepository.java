package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static Long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id));//null값일 경우에 미리 처리해주기위해 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().//values() 메서드는 해당 Map의 값(value)들을 반환합니다. 이는 Collection 타입으로 반환되며, Stream 처리를 위해 사용할 수 있습니다.
                stream().//values()로 반환된 Collection을 스트림(Stream)으로 변환합니다.
                filter(member -> member.getName().equals(name)).//스트림 내의 각 요소를 대상으로 조건을 적용합니다.
                findAny();//필터링된 요소들 중에서 하나를 선택합니다.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore()
    {
        store.clear();
    }
}
