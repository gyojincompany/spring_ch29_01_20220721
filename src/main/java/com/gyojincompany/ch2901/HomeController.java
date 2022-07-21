package com.gyojincompany.ch2901;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.gyojincompany.ch2901.dao.IDao;
import com.gyojincompany.ch2901.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	ContentDao dao;	
	
	@Autowired
	private SqlSession sqlSession;	
	
//	@Autowired
//	public void setDao(ContentDao dao) {
//		this.dao = dao;
//	}

	@RequestMapping(value = "/writeForm")
	public String writeForm() {
		
		return "writeForm";
	}
	
	@RequestMapping(value = "write")
	public String write(HttpServletRequest request) {
		
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		
		IDao idao = sqlSession.getMapper(IDao.class);
		idao.writeDao(mwriter, mcontent);
		
//		dao.writeDao(mwriter, mcontent);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
//		ArrayList<ContentDto> dtos = dao.listDao();
		
		IDao idao = sqlSession.getMapper(IDao.class);
		
		ArrayList<ContentDto> dtos = idao.listDao();
		
		model.addAttribute("list", dtos);
		
		return "list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request) {
				
		IDao idao = sqlSession.getMapper(IDao.class);
		idao.deleteDao(request.getParameter("mid"));
//		dao.deleteDao(request.getParameter("mid"));
		
		return "redirect:list";
	}
	

	
	
	
	
}
