package com.kunil.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kunil.security.dto.EmployeeCommonDto;
import com.kunil.security.service.EmployeeService;
import com.kunil.security.vo.Criteria;
import com.kunil.security.vo.CustomUser;
import com.kunil.security.vo.PageDto;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@AllArgsConstructor
public class EmployeeController {

   @Autowired
   private EmployeeService service;

   // 일반사용자
   @RequestMapping(value = { "/emp/employeeList", "/emp" }, method = RequestMethod.GET)
   public String securedHome(Criteria cri, ModelMap model) {
      log.info("/emp/employeeList");

      // 일반 사용자 조회
      List<EmployeeCommonDto> employeesList = service.getEmployeesList(cri);
      model.addAttribute("employeesList", employeesList);

      Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      CustomUser user = null;

      if (principal instanceof CustomUser) {
         user = ((CustomUser) principal);
      }

      log.info("user : " + user);

      String name = user.getUsername();
      model.addAttribute("username", name);
      model.addAttribute("message", "일반 사용자 페이지에 들어오셨습니다.");

      return "/emp/employeesList";

   }

   @RequestMapping(value= {"/admin/employeeList2","/admin"},
                        method=RequestMethod.GET)
   public String securedAdminHome(Criteria cri, ModelMap model) {
      log.info("/admin/employeeList2");
      
      // 부트스트랩 사용자 조회
      List<EmployeeCommonDto> employeesList=service.getEmployeesList(cri);
      model.addAttribute("employeesList",employeesList);
      
      int total=service.getTotalEmployees(cri);
      PageDto dto=new PageDto(cri,total);
      log.info("dto : " + dto.toString());
      model.addAttribute("pageMaker", dto);
      
      Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      
      CustomUser user=null;
      
      if(principal instanceof CustomUser) {
         user=((CustomUser) principal);
      }
      
      log.info("user: "+user);
      
      String name=user.getUsername();
      model.addAttribute("username", name);
      model.addAttribute("message", "관리자 페이지");
      
      return "/admin/employeesList2";
      
   }

}