package dev.bank.bankstatement.web.controller;

import dev.bank.bankstatement.web.model.BankProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Spring mvc 구조에서 사용하는 방식
 *
 */

@Controller // @Component 보다 직관적인 annotation 표기(동작은 동일)
public class AccountController {

    private BankProperties bankProperties;

//    @RequestMapping(path = "/api/accounts", method = RequestMethod.GET) // localhost:8080/api/accounts로 요청했을 때 findAll()가 동작
//    public ModelAndView findAll() {
//
//        // model 작성
//        bankProperties = new BankProperties();
//
//        // view(클라이언트에게 보여질 html페이지) 작성
//
//        ModelAndView mav = new ModelAndView();
//
//        // key - values 형태로 작성
//        mav.addObject( "bankProperties", bankProperties);
//
//        mav.setViewName("accounts"); // .html을 제외한 파일명 기술
//
//        return mav;
//    }

    @RequestMapping(path = "/api/accounts", method = RequestMethod.GET)
    public String findAll(Model model) {
        model.addAttribute("bankProperties", new BankProperties());

        return "accounts";
    }
}
