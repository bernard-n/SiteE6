package com.util;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.*;

public class Email {

	public static void main(String[] args) throws EmailException {
		//SendMail("Jacques","wesh","wesh eklflzlfezlgezppfezllfpez");
    	
    }
	public static void SendMail(String nom, String titre, String message) throws EmailException{
		HtmlEmail email = new HtmlEmail();
	    email.setSmtpPort(587);
	    email.setAuthenticator(new DefaultAuthenticator("bernard-n@saint-louis29.net",
	            "Banksdafuture13"));
	    email.setDebug(false);
	    email.setHostName("smtp.gmail.com");
	    email.setFrom("wesh@bien.koi");
	    email.setSubject("[Provenance : Site Perso] - " + titre);
	    String html;
	    html = "<h1>Message de " + nom + " :</h1>";
	    html += "<p>" + message + "</p>";
	    email.setHtmlMsg(html);
//	    email.setMsg("This is a test mail ... :-)");
	    email.addTo("bernard-n@saint-louis29.net");
	    email.setTLS(true);
	    email.send();		    
	    System.out.println("Mail sent!");
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
