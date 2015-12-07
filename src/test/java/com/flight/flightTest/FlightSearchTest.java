package com.flight.flightTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlightSearchTest {
	WebDriver dr;

	@Test
	public void flightSearch() throws InterruptedException{
		dr = new FirefoxDriver();
		dr.get("http://www.orbitz.com/");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.findElement(By.xpath("//div[@class='headerTabBar']/ul/li[2]/a")).click();
		dr.findElement(By.xpath("//input[@name='ar.rt.leaveSlice.orig.key']")).sendKeys("New York");
		dr.findElement(By.xpath("//input[@name='ar.rt.leaveSlice.dest.key']")).sendKeys("Florida");
		TakesScreenshot ts = (TakesScreenshot)dr;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("C:/Users/Maisha/Pictures/PageObjec/flight.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//dr.findElement(By.xpath("//input[@name='ar.rt.leaveSlice.date']")).click();
		//dr.findElement(By.xpath("//a[@class='arrow arrowNext visible']/img")).click();
		
		//dr.findElement(By.xpath("//a[@title='Return']")).click();
		/*
		String date = "27-Jan 2016";
		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];
		
		
//System.out.println(month_year);
//System.out.println(day);
		selectCurrentMonthDate(month_year,  day);
		Thread.sleep(5000);
		//dr.findElement(By.xpath("//input[@name='ar.rt.returnSlice.date']")).click();
		
		//dr.findElement(By.xpath("div[@class='month-wrapper']/table[2]/tbody/tr[5]/td[6]/a/span[1]")).click();
		
		Thread.sleep(5000);
		date = "29-Jan 2016";
		splitter = date.split("-");
		String month_year1 = splitter[1];
		String day1 = splitter[0];
		//selectCurrentMonthDate(month_year1,  day1);
		Thread.sleep(5000);
		dr.findElement(By.xpath("//div[@class='group dates twoCol']/div[@class='startDate column1']/label[2]/span[2]/div")).click();
		WebElement leave= dr.findElement(By.xpath("//div[@class='group dates twoCol']/div[@class='startDate column1']"));
		String vTime = "6pm-12am";
		leaveTime(vTime, leave);
		
		Thread.sleep(5000);
		dr.findElement(By.xpath("//div[@class='group dates twoCol']/div[@class='endDate column2']/label[2]/span[2]/div")).click();
		WebElement returd= dr.findElement(By.xpath("//div[@class='group dates twoCol']/div[@class='endDate column2']"));
		String RTime = "Midnight";
		leaveTime(RTime, returd);
		
		Thread.sleep(5000);
		dr.findElement(By.xpath("div[@class='group flexSearch']/label/div")).click();
		*/
		WebElement gAdult= dr.findElement((By.xpath("//div[@class='group dates twoCol']/div")));
		String age = "25";

		
		

	}
	@After
	public void end(){
		dr.quit();
	}
	public void selectCurrentMonthDate(String month, String day)throws InterruptedException{
		List<WebElement> datepicker = dr.findElements(By.xpath("//div[@class='calendar twoMonth']/div[@class='calendarBody']/table/thead/tr"));
		for(int i = 0; i<datepicker.size(); i++){
			System.out.println(datepicker.get(i).getText());
			//select a year
			if(datepicker.get(i).getText().equals(month)){
				//select a date
				List<WebElement> days= dr.findElements(By.xpath(".//div[@class='calendar twoMonth']/div[@class='calendarBody']/table["+(i+1)+"]/tbody/tr/td/a"));
				for(WebElement d:days){
					System.out.println(d.getText());
					if(d.getText().equals(day)){
						d.click();
						return;
					}
				}
			}
		}
		dr.findElement(By.xpath("//input[@name='ar.rt.returnSlice.date']")).click();
		Thread.sleep(5000);
		selectCurrentMonthDate(month,  day);
		Thread.sleep(5000);
		
	}
	public void leaveTime(String times, WebElement leave) throws InterruptedException{
		//dr.findElement(By.xpath("//div[@class='group dates twoCol']/div")).click();
		List<WebElement> timecat = dr.findElements((By.xpath("//div[@class='group dates twoCol']/div")));
		for(int k=0; k<timecat.size(); k++){
			System.out.println(timecat.get(k).getText());
			
			if(timecat.get(k).equals(leave)){
				
		List<WebElement> time = dr.findElements(By.xpath(".//div[@class='group dates twoCol']/div["+(k+1)+"]/label/select/option"));
			for(WebElement t:time){
				System.out.println(t.getText());
				if(t.getText().equals(times)){
					t.click();
				return;
			}
		}
		}
		}
		
	}
	public void gender(WebElement gender, String age) throws InterruptedException{
		List<WebElement> genders = dr.findElements(By.xpath("//div[@class='group travelers inlineInputGroup']/label"));
		for (int i=0; i<genders.size(); i++){
			System.out.println("gender"+ genders.get(i).getText());
			if(genders.get(i).equals(gender)){
		List<WebElement> ages = dr.findElements(By.xpath(".//div[@class='group travelers inlineInputGroup']/label["+(i+1)+"]/select/option"));
				for(WebElement a:ages){
					System.out.println(a.getText());
					if(a.getText().equals(age)){
						a.click();
						Thread.sleep(5000);
					}
				}
			}
		}
		
	}
	/*public void selectNextMonthDate(String month, String day) throws InterruptedException{
		dr.findElement(By.xpath("//a[@title='Return']")).click();
		dr.findElement(By.xpath("//span[@class='i i-arrow-right']")).click();
		List<WebElement> datepicker = dr.findElements(By.xpath("//div[@class='calendar']/div[@class='calendar-wrapper']/div/div[@class='month-wrapper']/table[2]/caption/h2[@class='slug']"));
		for(int i = 0; i<datepicker.size(); i++){
			//System.out.println(datepicker.get(i).getText());
			//select a year
			System.out.println("the month and year "+ datepicker.get(i).getText());
			if(datepicker.get(i).getText().equals(month)){
				//select a date
				List<WebElement> days= dr.findElements(By.xpath("//div[@class='calendar']/div[@class='calendar-wrapper']/div/div[@class='month-wrapper']/table[2]/tbody/tr/td/a"));
				for(WebElement d:days){
					System.out.println("the day "+ d.getText());
					if(d.getText().equals(day)){
						d.click();
						return;
					}
				}
			}
		}
		
	}*/
	
}
