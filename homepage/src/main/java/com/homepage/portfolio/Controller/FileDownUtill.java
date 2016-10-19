package com.homepage.portfolio.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.homepage.portfolio.FileUpUtill;
import com.homepage.portfolio.DTO.FileDTO;

public class FileDownUtill extends AbstractView{
	
	  public FileDownUtill() {
	        setContentType("applicaiton/download;charset=utf-8");
	    }

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		FileInputStream inputStream = null;
		FileChannel fcin = null;
		WritableByteChannel fcout = null;
		
		FileDTO dto = (FileDTO) model.get("file");
		String path = req.getSession().getServletContext().getRealPath("/");
		
		path = FileUpUtill.makePath(path, dto.getFilename());
		
		File f = new File(path + dto.getFilename());
		
		
		
		res.setContentType(getContentType());
		res.setContentLength((int)f.length());
		
		String fileName = URLEncoder.encode(dto.getOriginname(),"UTF-8");
		
		res.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\";");
        res.setHeader("Content-Transfer-Encoding", "binary");
        
        inputStream = new FileInputStream(f);
        fcout = Channels.newChannel(res.getOutputStream());
        fcin = inputStream.getChannel();
        
        try{
        	fcin.transferTo(0, inputStream.available(), fcout);
			
			
		}catch (Exception e) {
			fcin.close();
			fcout.close();
			inputStream.close();
		}
        fcin.close();
		fcout.close();
		inputStream.close();
        
	}
	
	
	
	

}
