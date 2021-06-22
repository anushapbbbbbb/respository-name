package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Attachments {
	
	public WebDriver driver;

	String name;
	
	String description ;
	
	String author ; 
	
	String dateCreated ;
	
	String size ;
	
	String version;
	
	By addFile;
	
	By deleteFile;
	
	By downloadFile;
	
	public Attachments(){}
	
	public Attachments(WebDriver driver) { 
		this.driver= driver;
	}

	public Attachments(String name, String description, String author, String dateCreated, String size,
			String version) {
		this.name = name;
		this.description = description;
		this.author = author;
		this.dateCreated = dateCreated;
		this.size = size;
		this.version = version;
	}
	
	public void addFile()
	{
		
	}
	
	public void deleteFile()
	{
		
	}
	
	public void downloadFile()
	{
		
	}
	
	

}
