package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    void save() {
        Member member = new Member();
        member.setName("MintRisha");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("MintRisha");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Rylah");
        repository.save(member2);

        Member result1 = repository.findByName("MintRisha").get();
        Member result2 = repository.findByName("Rylah").get();


        assertThat(result1).isEqualTo(member1);
        assertThat(result2).isEqualTo(member2);

    }

    @Test
    void findById() {
        Member member1 = new Member();
        member1.setName("MintRisha");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Rylah");
        repository.save(member2);


        Member result1 = repository.findById(1L).get();
        Member result2 = repository.findById(2L).get();


        assertThat(result1.getName()).isEqualTo(member1.getName());
        assertThat(result2.getName()).isEqualTo(member2.getName());

    }


    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("MintRisha");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Rylah");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}