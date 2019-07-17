package com.forestvue.mapper;

import com.forestvue.config.RootConfig;
import com.forestvue.config.SecurityConfig;
import com.forestvue.domain.AuthVO;
import com.forestvue.domain.MemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
@Log4j
public class MemberMapperTests {
    @Setter(onMethod_ = @Autowired)
    private MemberMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private PasswordEncoder pwencoder;
    @Before
    public void delete(){
        mapper.deleteUserAuthAll();
        mapper.deleteUserAll();
    }

    @Test
    public void insert(){
        MemberVO member = new MemberVO();
        member.setUserName("spring");
        member.setUserpw(pwencoder.encode("mayflower123!"));
        mapper.write(member);
        AuthVO auth = new AuthVO();
        auth.setAuth("ROLE_ADMIN");
        auth.setUserid(member.getUserid());
        mapper.grant(auth);
    }
    @Test
    public void grant(){

    }
}
