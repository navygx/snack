package com.yc.snack.user.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.snack.user.bean.MemberInfo;
import com.yc.snack.user.dto.SessionKeysConstant;
import com.yc.snack.user.enums.ResultEnum;
import com.yc.snack.user.service.IMemberInfoService;
import com.yc.snack.user.service.impl.MemberInfoServiceImpl;
import com.yc.snack.user.util.SendMailUtil;
import com.yc.snack.user.vo.ResultVo;

@RestController
@RequestMapping("/member")
public class MemberInfoController {
	@Autowired
	private IMemberInfoService memberInfoService;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@PostMapping("login")
	public ResultVo login(MemberInfo mf,HttpSession session) {
		String vcode=String.valueOf(session.getAttribute("vcode"));
		if(!vcode.equalsIgnoreCase(mf.getRealName())) {
			return new ResultVo(ResultEnum.CODE_ERROR);
		}
		
		MemberInfo memberInfo =memberInfoService.login(mf);
		if(memberInfo==null) {
			return new ResultVo(ResultEnum.LOGIN_ERROR);
		}
		
		session.setAttribute(SessionKeysConstant.CURRENTMEMBERACCOUNT, memberInfo);
		return new ResultVo(ResultEnum.LOGIN_SUCCESS);
	}
	
	@PostMapping("reg")
	public ResultVo reg(MemberInfo mf,HttpSession session) {
		Object obj=session.getAttribute("code");
		if(obj==null) {
			return new ResultVo(ResultEnum.CODE_TIMEOUT);
		}
		
		if(!mf.getRealName().equals(String.valueOf(obj))) {
			return new ResultVo(ResultEnum.CODE_ERROR);
		}
		
		int result=memberInfoService.reg(mf);
		if(result>0) {
			return new ResultVo(ResultEnum.REG_SUCCESS);
		}
		return new ResultVo(ResultEnum.REG_ERROR);
	}
	
	@GetMapping("/check")
	public ResultVo check(HttpSession session) {
		Object obj=session.getAttribute(SessionKeysConstant.CURRENTMEMBERACCOUNT);
		if(obj==null) {
			return new ResultVo(ResultEnum.ERROR);
		}
		return new ResultVo(ResultEnum.SUCCESS,obj);
	}
	
	@PostMapping("/code")
	public ResultVo sendCode(String receive,String nickName,HttpSession session) {
		String code="";
		Random rd=new Random();
		while(code.length()<6) {
			code +=rd.nextInt(10);
		}
		
		if(sendMailUtil.sendHtmlMail(receive, nickName, code)) {
			session.setAttribute("code", code);
			
			TimerTask task=new TimerTask() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					session.removeAttribute("code");
				}
			};
			
			Timer timer=new Timer();
			timer.schedule(task, 180000);
			return new ResultVo(ResultEnum.SUCCESS);
		}
		return new ResultVo(ResultEnum.ERROR);
	}
}
