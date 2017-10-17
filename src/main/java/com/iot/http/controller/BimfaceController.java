package com.iot.http.controller;

import com.iot.common.util.DataWrapper;
import com.iot.http.service.BimfaceService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/bimface")
public class BimfaceController {
	@Autowired
	BimfaceService bimfaceService;
    @RequestMapping(value = "/getModelViewToken",method = RequestMethod.GET)
    @ResponseBody
    public DataWrapper<String> getUserList(
    		@RequestParam(value="fileId",required=true) Long fileId){
        return bimfaceService.getViewTokenByFileId(fileId);
    }
    
    @RequestMapping(value = "/uploadModelFile",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Long> uploadModelFile(
    		@RequestParam(value="modelFile",required=true) MultipartFile[] modelFile,
    		HttpServletRequest request){
        return bimfaceService.uploadModelFile(modelFile[0],request);
    }
   /* @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<Void> addUser(@ModelAttribute User user){
        return userService.addUser(user);
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public DataWrapper<User> Login(
    		HttpServletRequest request,
    		@RequestParam(value="userName",required=true) String userName,
    		@RequestParam(value="password",required=true) String password
    		) {
		DataWrapper<User> test=userService.login(userName, password);
		return test;
    }*/
}
