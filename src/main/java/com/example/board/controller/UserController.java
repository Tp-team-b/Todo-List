package com.example.board.controller;

import com.example.board.dto.UserDto;
import com.example.board.entity.Member;
import com.example.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final MemberRepository memberRepository;

    @GetMapping("/sign-up")
    public String getSignUp() {
        return "sign-up";
    }

    @GetMapping("/sign-in")
    public String getSignIn() {
        return "sign-in";
    }

    @ResponseBody
    @PostMapping("/sign-up")
    public String postSignUp(UserDto userDto) {
        Optional<Member> Member = memberRepository.findByName(userDto.getName());
        if(Member.isPresent()) {
            return "already used name";
        } else {
            Member member = new Member();
            member.setName(userDto.getName());
            member.setPassword(userDto.getPassword());
            memberRepository.save(member);
            return "ok";
        }
    }

    @ResponseBody
    @PostMapping("/sign-in")
    public String postSignIn(UserDto userDto) {
        Optional<Member> Member = memberRepository.findByName(userDto.getName());
        log.info("userDto.getPassword() = {}, Member.get().getPassword() = {}",userDto.getPassword(),Member.get().getPassword());
        if(Member.isPresent() && userDto.getPassword().equals(Member.get().getPassword())) {
            return "success";
        };
        return "fail";
    }


}
