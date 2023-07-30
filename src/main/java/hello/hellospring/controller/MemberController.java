package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
//    /**
//     * 필드 주입
//     */
//    @Autowired private final MemberService memberService;
//
////    @Autowired
////    public MemberController(MemberService memberService) {
////        this.memberService = memberService;
////    }
//    /**
//     * 세터 주입
//     */
//    private MemberService memberService;
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }


}
