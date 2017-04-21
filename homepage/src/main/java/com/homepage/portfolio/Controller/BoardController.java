package com.homepage.portfolio.Controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.homepage.portfolio.FileUpUtill;
import com.homepage.portfolio.DTO.BoardDTO;
import com.homepage.portfolio.DTO.CalendarDTO;
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
		
/*		search.getPageCount(boardservice.selectCount(search));
		List<BoardDTO> list =  boardservice.seleteList(search);
		
		System.out.println(search.getSearchKeyword());
		
		request.setAttribute("list", list);
		request.setAttribute("paging", search);
		
*/		
		return "board/List";
	}
	 
	@RequestMapping(value ="board/view/{boardnum}",method= {RequestMethod.POST,RequestMethod.GET})
	public String view(@PathVariable("boardnum") int boardnum , HttpServletRequest req){
		
		BoardDTO dto = boardservice.selectBoard(boardnum);
		List<FileDTO> list = boardservice.findfile(boardnum);
		
List<ReplyDTO> replylist = boardservice.listreply(dto.getBoardnum());
		
		
		req.setAttribute("replylist", replylist);
		
		
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
	
	
	@RequestMapping(value = "test")
	public String test (HttpServletRequest requet){

		
		List<CalendarDTO> testlist = new ArrayList<CalendarDTO>();
		
		CalendarDTO reply = new CalendarDTO();
		JSONObject jsonObject = new JSONObject();
		for(int i = 0 ; i <3 ; i++){
				System.out.println(i);
			reply.setTitle("title1"+i);
			reply.setStart("2017-03-10");
			reply.setEnd("2017-03-13");
			
			testlist.add(reply);
		}
			jsonObject.put("test", testlist);
		
		System.out.println(jsonObject);
		requet.setAttribute("test", jsonObject);
		
		
		return "calendar/test";
	}
	
	@RequestMapping(value = "jsonck")
	public String jsonck (HttpServletRequest requet,HttpServletResponse response) throws Exception{
		



		
		List<CalendarDTO> testlist = new ArrayList<CalendarDTO>();
		
		CalendarDTO reply = new CalendarDTO();
		JSONObject jsonObject = new JSONObject();
		for(int i = 0 ; i <3 ; i++){
				System.out.println(i);
			reply.setTitle("title1"+i);
			reply.setStart("2017-03-10");
			reply.setEnd("2017-03-13");
			
			testlist.add(reply);
		}
			jsonObject.put("test", testlist);
		
		System.out.println(jsonObject);
		requet.setAttribute("test", jsonObject);
		
		
		response.setContentType("text/xml;charset=utf-8");

		PrintWriter printWriter = response.getWriter();

		printWriter.print(jsonObject);

		printWriter.flush();

		printWriter.close();
		
		return null;
		
	}
	
	@RequestMapping(value = "tqwe")
	public String adasd (HttpServletRequest requet,HttpServletResponse response) throws Exception{
		
		return "calendar/calendarCreate";
	}
	
}
