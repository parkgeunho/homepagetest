package com.homepage.portfolio.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.Service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	BoardService boardservice;
	
	/*
	 * 글쓰기 이동
	*/
	
	@RequestMapping(value = "board/write" , method = {RequestMethod.GET,RequestMethod.POST})
	public String write(){
		
		return "board/write";
	}
	
	
	/* 글 저장  */	
	@RequestMapping(value = "board/create" , method = {RequestMethod.POST})
	public String create(BoardDTO dto,HttpServletRequest request){
		System.out.println(request.getAttribute("method"));
		if(request.getAttribute("method")!=null){
			boardservice.updateBoard(dto);			
		}else
		boardservice.insertBoard(dto);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "board/update" , method = {RequestMethod.POST})
	public String update(BoardDTO dto, Model model,HttpServletRequest request){
		
		dto = boardservice.selectBoard(dto.getBoardnum());
		request.setAttribute("dto", dto);
		model.addAttribute("method", "update");
		return "board/update_ok";
	}
	
	/* 게시판 화면으로 */
	@RequestMapping(value = "board/list" , method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model){
		
		
		
		List<BoardDTO> list =  boardservice.seleteList();
		model.addAttribute("list",list);
		return "board/List";
	}
	
	@RequestMapping(value= "board/view/{boardnum} ", method = {RequestMethod.GET})
	public String view (@PathVariable int boardnum,Model model){
		
		
		BoardDTO dto=boardservice.selectBoard(boardnum);
		
		model.addAttribute("dto", dto);
		return "board/view";
	}
	
}
