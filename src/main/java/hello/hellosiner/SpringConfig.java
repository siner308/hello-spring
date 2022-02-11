package hello.hellosiner;

import hello.hellosiner.domain.Member;
import hello.hellosiner.repository.MemberRepository;
import hello.hellosiner.repository.MemoryMemberRepository;
import hello.hellosiner.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
