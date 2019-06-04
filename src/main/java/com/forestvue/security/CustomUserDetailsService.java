package com.forestvue.security;


import com.forestvue.domain.MemberVO;
import com.forestvue.mapper.MemberMapper;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Setter(onMethod_ = {@Autowired})
    private MemberMapper memberMapper;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        MemberVO vo = memberMapper.read(userName);
        if(vo==null)  throw new UsernameNotFoundException("no user found");
        return new CustomUser(vo);
    }
}
