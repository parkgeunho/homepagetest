package com.homepage.portfolio.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.homepage.portfolio.FileUpUtill;
import com.homepage.portfolio.PagingUtill;
import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.FileDTO;
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
	
	@RequestMapping(value = "board/create")
	public String create(BoardDTO dto,HttpServletRequest requet) throws Exception{
		
		String path = requet.getSession().getServletContext().getRealPath("/");
		FileUpUtill fu = new FileUpUtill();
		List<FileDTO> files = fu.uploadFile(dto.getUploadlists(), path);

		boardservice.save(dto, files);
		return "redirect:list";
	}
	
	
	@RequestMapping(value="board/list" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String list(HttpServletRequest request,PagingUtill paging){
		
		paging.getPageCount(boardservice.selectCount());
		List<BoardDTO> list =  boardservice.seleteList(paging);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		
		
		return "board/List";
	}
	 
	@RequestMapping(value ="board/view/{boardnum}",method= {RequestMethod.POST,RequestMethod.GET})
	public String view(@PathVariable("boardnum") int boardnum , HttpServletRequest req){
		
		BoardDTO dto = boardservice.selectBoard(boardnum);
		
		req.setAttribute("dto", dto);
		
		
		return "board/view";
	}
	
	@RequestMapping(value = "board/update/{boardnum}" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String update(BoardDTO dto,HttpServletRequest requet){
		
		dto = boardservice.selectBoard(dto.getBoardnum());
		
		requet.setAttribute("dto", dto);
		
		
		return "board/update";
	}
	
	@RequestMapping(value = "board/update/update_ok" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String update_ok(BoardDTO dto,HttpServletRequest requet){
		
	
		boardservice.updateBoard(dto);
		
		
		return "redirect:/board/view/"+ dto.getBoardnum();
	}
	
	
	@RequestMapping(value = "board/view/delete" ,method= {RequestMethod.POST})
	public String delete(BoardDTO dto,HttpServletRequest requet){
		
		boardservice.deleteBoard(dto.getBoardnum());
		
		
		return "redirect:/board/list";
	}
	
	
	/*@RequestMapping(value = "board/filedown/{filenum}")
	public ModelAndView fileDownload(@PathVariable("filenum") int filenum){
		
		
		
		}
	*/
	
	
}
