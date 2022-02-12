package hello.hellosiner;

import hello.hellosiner.domain.Member;
import hello.hellosiner.repository.JdbcMemberRepository;
import hello.hellosiner.repository.JdbcTemplateMemberRepository;
import hello.hellosiner.repository.MemberRepository;
import hello.hellosiner.repository.MemoryMemberRepository;
import hello.hellosiner.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(this.dataSource);
    }
}
