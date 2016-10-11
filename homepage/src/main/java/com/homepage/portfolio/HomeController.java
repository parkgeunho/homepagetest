package com.homepage.portfolio;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.Service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	BoardService boardservice;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject("제목");
		dto.setContent("내용 네용 sodyd ");
		boardservice.insertBoard(dto);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "board/write" , method = {RequestMethod.GET,RequestMethod.POST})
	public String write(){
		
		return "board/write";
	}
	
	@RequestMapping(value = "board/create" , method = {RequestMethod.GET,RequestMethod.POST})
	public String create(BoardDTO dto){
		
		
		boardservice.insertBoard(dto);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "board/list" , method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model){
		
		
		
		List<BoardDTO> list =  boardservice.seleteList();
		model.addAttribute("list",list);
		return "board/List";
	}
	
	
}
