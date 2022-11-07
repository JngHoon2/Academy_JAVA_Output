package com.javalab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
   
   public String home() {
      log.info("Wlcome home!");
      
      return "redirect:choosePath";
   }
   
   @RequestMapping(value = "/choosePath", method = RequestMethod.GET)
   public String fileUPload() {
      return "fileupload_home";
   }
   
   @RequestMapping(value = "/absolutePathForm", method = RequestMethod.GET)
   public String absolutePathForm() {
      return "absolute_file_upload_form";
   }
   
   @RequestMapping(value = "/relativePathForm", method = RequestMethod.GET)
   public String displayForm() {
      return "relative_file_upload_form";
   }
   
}