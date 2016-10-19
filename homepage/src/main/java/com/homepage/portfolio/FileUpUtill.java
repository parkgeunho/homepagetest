package com.homepage.portfolio;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.homepage.portfolio.DTO.FileDTO;

public class FileUpUtill {
	
	
	// 파일 저장
	public List<FileDTO> uploadFile(List<MultipartFile> uploadList ,String path){
		List<FileDTO> filelist = new ArrayList<FileDTO>();
		
		for(MultipartFile uploadfile : uploadList){
			
			if(uploadfile.getSize()==0){
				
				continue;
				
			}
			
			String savename =  saveName();
			String savepath = makePath(path, savename);
			
			save(uploadfile, savepath, savename);
			
			FileDTO filedto = new  FileDTO();
			filedto.setOriginname(uploadfile.getOriginalFilename());
			filedto.setFilename(savename);
			filedto.setFilesize(uploadfile.getSize());
			filelist.add(filedto);
			
			
			
		}
		
		
		return filelist;
		
	}
	
	
	// 실제로 파일 저장 되는 메소드
	
	public static String save(MultipartFile file,String path, String filename){
		
		  if (file  ==  null || file.getName().equals("") || file.getSize() < 1) {
	            return null;
	        }
		  
		  makefolder(path);
		  String savapath = path + filename;
		  
		  File saveFile = new File(savapath);
		  try{
			  file.transferTo(saveFile);
		  }catch (IOException e) {
			System.out.println(e);
		}
		  
		return savapath;
	}
	
	
	// 저장 이름 생성
	public String saveName(){
		long time = System.currentTimeMillis(); 
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		String strDT = dayTime.format(new Date(time)); 
		System.out.println(strDT); 

		return strDT;		
	}
	
	// 저장 폴더 생성
	public static void makefolder(String path){
		
		File folder = new File(path);
		
		if(!folder.exists()){
			
			folder.mkdirs();
		
		}
		
	}
	
	//경로 생성
	public static String makePath(String path,String filename){
		
		return path + filename.substring(0, 4)+"/";
	}
	

}
