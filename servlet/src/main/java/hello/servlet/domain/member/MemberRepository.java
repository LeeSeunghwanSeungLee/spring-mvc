package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * 동시성 문제가 고려되어있지 않기 때문에, 실무에서는 ConcurrentHashMap, AtomicLong 등을 사용하는 것을 고려하자.
 * 추가로 예외처리를 고려하고 있지 않다. 이유는 단순한 테스트성 보일러플레이트를 개발중이기 때문이다. ID조건등을 고려해서 설계하는 것도 개발자의 몫이다.
 */
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); // 싱글톤

    public  static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
