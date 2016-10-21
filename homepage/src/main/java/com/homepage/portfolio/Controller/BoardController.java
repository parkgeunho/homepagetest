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
import com.homepage.portfolio.DTO.ReplyDTO;
import com.homepage.portfolio.DTO.SearchDTO;
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
	public String create(BoardDTO dto,HttpServletRequest req) throws Exception{
		
		String path = req.getSession().getServletContext().getRealPath("/");
		FileUpUtill fu = new FileUpUtill();
		List<FileDTO> files = fu.uploadFile(dto.getUploadlists(), path);

		boardservice.save(dto, files);
		return "redirect:list";
	}
	
	
	@RequestMapping(value="board/list" ,method= {RequestMethod.POST,RequestMethod.GET})
	public String list(HttpServletRequest request,SearchDTO search){
		
		search.getPageCount(boardservice.selectCount(search));
		List<BoardDTO> list =  boardservice.seleteList(search);
		
		System.out.println(search.getSearchKeyword());
		
		request.setAttribute("list", list);
		request.setAttribute("paging", search);
		
		
		return "board/List";
	}
	 
	@RequestMapping(value ="board/view/{boardnum}",method= {RequestMethod.POST,RequestMethod.GET})
	public String view(@PathVariable("boardnum") int boardnum , HttpServletRequest req){
		
		BoardDTO dto = boardservice.selectBoard(boardnum);
		List<FileDTO> list = boardservice.findfile(boardnum);
		
		req.setAttribute("dto", dto);
		req.setAttribute("list", list);
		
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
	
	
	@RequestMapping(value = "board/filedown/{filenum}")
	public ModelAndView fileDownload(@PathVariable("filenum") int filenum,HttpServletRequest request){

			
			FileDTO dto = boardservice.downfile(filenum);
			return new ModelAndView("download", "file",dto);
	}
	
	@RequestMapping(value = "board/replysave")
	public String savereply (ReplyDTO reply){
		

		boardservice.insertReply(reply);
		
		
		return "redirect:/board/view/"+ reply.getBoardnum();
	}
	
	
	
}
