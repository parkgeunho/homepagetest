package com.homepage.portfolio.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MailController {
		
	@RequestMapping(value="sendmail",method = RequestMethod.GET)
	public String mail(){
		return "mail";
	}
	
	 @RequestMapping(value ="/sendmail" ,method =RequestMethod.POST)
	 public  @ResponseBody HashMap<String, String> sendMail(String q_name,String q_subject,String q_gmail,String q_content,HttpServletResponse res) throws IOException{
			
	    		
	    		/*using hashMap*/
		 
	    		HashMap<String, String> map = new HashMap<String, String>();
	    		map.put("rtncode", "500");
	    		map.put("msg", "System error. Contact admiinistrator");
	    	
	    		
	    		try{

	    			//check mail and content
	    			if(!isEmail(q_gmail)|| q_content.length()==0){
	    				return map;
	    			}
	    			
				
				q_content = q_content.replaceAll("\n", "<br/>");
				q_gmail = " < " + q_gmail + " >";	
	    			
				String form = 
							"<div style='width: 770px;margin:auto; '><div style='margin-left: 20px;'><Br>작성자 : "+q_name + q_gmail + "</div>"+
							"<div style='height: 20px;border-bottom: 1px solid #D9E5FF;'></div>" + 
							"<div style='margin-left: 20px; margin-top: 20px;'>" + q_content + "</div></div>";
				
	    			
	    			
	    					
	    			Properties p = System.getProperties();
	    	        p.put("mail.smtp.starttls.enable", "true");     
	    	        p.put("mail.smtp.host", "smtp.gmail.com");     
	    	        p.put("mail.smtp.auth","true");                 
	    	        p.put("mail.smtp.port", "587");                 
	    	           
	    	        Authenticator auth = new MyAuthentication();
	    	         
	    	        //make session and MimeMessage
	    	        Session session = Session.getDefaultInstance(p, auth);
	    	        MimeMessage msg = new MimeMessage(session);
	    	         
	    	        session.setDebug(true);
	                //send mail time
	                msg.setSentDate(new Date());
	                 
	                InternetAddress from = new InternetAddress() ;
	                
	                 
	                from = new InternetAddress(q_gmail);
	                 
	                // From
	                msg.setFrom(from);
	                 
	                 
	                // to 
	                
	                InternetAddress to = new InternetAddress("nobody@digiwork.co.kr");
	                msg.setRecipient(Message.RecipientType.TO, to);
	                 
	                // subject
	                msg.setSubject(q_subject, "UTF-8");
	                 
	                // content
	                msg.setText(form, "UTF-8");
	                 
	                // email header 
	                msg.setHeader("content-Type", "text/html");
	                 
	                //send mail
	                javax.mail.Transport.send(msg);
	                 
	            }catch (AddressException addr_e) {
	            	return map;
	            }catch (MessagingException msg_e) {
	            	return map;
	            }catch (NullPointerException e) {
	            	return map;
	    		}
	    		
	    	
	    		/*using hashMap 	*/
	    		map.put("rtncode", "200");
	    		map.put("msg", "Contact has been received successfully.");
	    
	    		
	    		return map;
	    	}
	    	
	    	
    	class MyAuthentication extends Authenticator {
    	      
    	    PasswordAuthentication pa;
    	    
    	 
    	    public MyAuthentication(){
    	        

    	        String id = "kioho80@gmail.com";       
    	        String pw = "1q2w3e123";          
    	 
    	        
    	        pa = new PasswordAuthentication(id, pw);
    	      
    	    }
    	 
    	    
    	    public PasswordAuthentication getPasswordAuthentication() {
    	        return pa;
    	    }
    	
    	
    	}
    	
    	
    	public static boolean isEmail(String email) {
            if (email==null) return false;
            boolean b = Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+",email.trim());
            return b;
        }

}
