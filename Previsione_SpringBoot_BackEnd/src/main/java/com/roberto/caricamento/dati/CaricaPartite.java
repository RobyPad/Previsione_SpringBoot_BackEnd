package com.roberto.caricamento.dati;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Environment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.xdevapi.Statement;
import com.roberto.springboot.rest.controller.PartitaController;
import com.roberto.springboot.rest.dao.PartitaDaoRepository;
import com.roberto.springboot.rest.model.Partita;

public class CaricaPartite 
{	
	@Autowired
	private PartitaDaoRepository repository;
	
	
	
	final String pathDriverChrome = "C:\\Users\\Utente\\Desktop\\workspace\\Previsione_SpringBoot_BackEnd\\risorseEsterne\\chromedriver_win32\\chromedriver.exe";
	
	public CaricaPartite() 
	{
		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver", pathDriverChrome);  
		
	}

	public static void esempioParser()
	{
	
		
		//String url = "https://www.diretta.it/serie-a/risultati/";	
		//String url = "https://www.diretta.it/calcio/francia/ligue-1/risultati/";
		
		String url = "https://www.diretta.it/serie-a-2016-2017/";

		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a300085\\Documents\\Programmi\\chromedriver_win32\\chromedriver.exe");  
		  
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.findElement(By.xpath("//a[@href='/serie-a-2016-2017/risultati/']")).click();
		
	    try 
	    {
			Thread.sleep(3000);	//	3 secondi
		} 
	    catch (InterruptedException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //System.out.println(driver.getPageSource());
	    
	    List<WebElement> lista = driver.findElements(By.partialLinkText("Mostra più incontri"));
	    
	    java.util.Iterator<WebElement> iterator = lista.iterator();
	    while(iterator.hasNext()) 
	    {
	    	WebElement i = iterator.next();
	    	
	    	//System.out.println(i.getText());
	    	//System.out.println(i.getTagName());
	    	//System.out.println(i.getAttribute("onclick"));
	    	//System.out.println(i.getClass());
	    	//System.out.println(i.getCssValue("onclick"));
	    	System.out.println(i.getAttribute("innerHTML"));
	    	System.out.println(i.getAttribute("outerHTML"));
			System.out.println(i.getAttribute("href"));
	        //System.out.println(i.toString());
	        
	     }
	    
	    WebElement a = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
	   
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('href', 'https://www.diretta.it/serie-a-2016-2017/risultati/#')",a);
	    
	    System.out.println(a.getAttribute("outerHTML"));
	   
	    //a.click();
	    
	    //(new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='event__more event__more--static']")).click();

	    
	    //driver.findElement(By.xpath("//a[@class='event__more event__more--static']")).click();
	    
	    //driver.findElement(By.linkText("Mostra più incontri")).click();

	    
	    
	    //WebElement a = driver.findElement(By.xpath("//a[href='https://www.diretta.it/serie-a-2016-2017/risultati/#']"));

	    //System.out.println(a.getAttribute("outerHTML"));

	    //System.out.println(lista.toString());

	    //driver.findElement(By.xpath("//a[@onclick='return cjs.Api.loader.get('cjs').call(function(_cjs){loadMoreGames(_cjs);});']")).click();


        /*
        
		WebElement w = driver.findElement(By.className("event__more--static"));
		
		//WebElement w = driver.findElement(By.partialLinkText("Mostra"));

		//WebElement w1 = driver.findElement(By.id("tournament-page-results-more"));

		System.out.println("----------------------getText----------------------");
		System.out.println(w.getText());
		System.out.println("----------------------toString----------------------");
		System.out.println(w.toString());
		System.out.println("----------------------getAttribute----------------------");
		System.out.println(w.getAttribute("href"));
		
		Point p = w.getLocation();
		
		System.out.println("point " + p.x + " " + p.y);
		Actions actions = new Actions(driver);
		actions.moveToElement(w);
		actions.moveByOffset(10,10).click().build().perform();


		new Actions(driver).moveToElement(w).moveByOffset(p.x,p.y).click().perform();

		
		
		//driver.findElement(By.className("a.event__more.event__more--static")).click();
		
		
		//driver.findElement(By.partialLinkText("Mostra")).getAttribute("href");
		
		System.out.println("--------------------getTagName------------------------");
		System.out.println(w.getTagName());
		System.out.println("--------------------------------------------");

		//driver.findElement(By.className("event__more event__more--static")).click();
		
		//driver.findElement(By.partialLinkText("Mostra più incontri")).click();
		  
		//System.out.println(driver.getPageSource());

		String htmlSource = driver.getPageSource();

		Document doc = Jsoup.parse(htmlSource);
		
		Elements myin = doc.getElementsByClass("event__round event__round--static");

		System.out.println(myin.toString());
		
		// Launch Website  
		//driver.navigate().to(url);
		
		//driver.get(url);
		
		
		//driver.quit();
		
		*/
	    
	}
	
	public static void parser()
	{
		String url = "https://www.diretta.it/serie-a-2016-2017/";

		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a300085\\Documents\\Programmi\\chromedriver_win32\\chromedriver.exe");  
		  
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.findElement(By.xpath("//a[@href='/serie-a-2016-2017/risultati/']")).click();
		
		
		driver.findElement(By.xpath("//a[@class='event__more event__more--static']")).click();;
		
	}

	public void caricaCampionato(String url, String href) 
	{
		WebElement element;
		Actions actions;
		
		
		String annata = "";
		String nazione = "";
		String competizione = "";
		
		/*
		// System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a300085\\Documents\\Programmi\\chromedriver_win32\\chromedriver.exe");  
		  
		*/
		
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
	
		driver.manage().window().maximize();
		driver.get(url);
		element = driver.findElement(By.xpath(href));

		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		/*
		try 
	    {
			Thread.sleep(3000);	//	3 secondi
		} 
	    catch (InterruptedException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		*/
		
		String htmlSource = driver.getPageSource();
		Document doc = Jsoup.parse(htmlSource);
		

		//	NAZIONE
		Element el_nazione = doc.getElementsByClass("tournament").get(0);
		Elements childNazione = el_nazione.children();
		nazione = childNazione.get(4).text();
		
		//	COMPETIZIONE
		Element el_competizione = doc.getElementsByClass("teamHeader__name").get(0);
		competizione = el_competizione.text().trim();
		
		//	ANNATA
		Element el_annata = doc.getElementsByClass("teamHeader__text").get(0);
		annata = el_annata.text();
		
	
		Element el_sportNameSoccer = doc.getElementsByClass("sportName soccer").get(0);
		Elements childSportNameSoccer = el_sportNameSoccer.children();
		
		String squadraCasa= "";
		String squadraTrasferta = "";
		String orario = "";
		String goalSquadraCasa = "";
		String goalSquadraTrasferta = "";
		String turno = "";
		
		int c = 0;
		int g = 0;
		for (Element e : childSportNameSoccer) 
		{
			String nomeClasse = e.className();
			
			//if(nomeClasse.equals("event__header top event__header--no-my-games event__header--noExpand"))
			if(nomeClasse.contains("event__header--noExpand"))
			{
				c = 1;
				System.out.println("");
			}
			else
			{
				if(c == 1 && nomeClasse.equals("event__round event__round--static"))
				{
					g = 1;
					turno = e.text();
					System.out.println("\n" + e.text());
				}
				else
				{

						if(c == 1 && g ==1)
						{
							
							Elements childElement = e.children();
							for (Element e2 : childElement) 
							{
								// ORARIO
								if(e2.className().contains("event__time"))
								{
									orario = e2.text();
								}
								
								// SQUADRA CASA
								if(e2.className().contains("event__participant event__participant--home"))
								{
									squadraCasa = e2.text();
								}
								
								// RISULTATI
								if(e2.className().contains("event__scores"))
								{
									String[] result = e2.text().split(" - ");
									
									goalSquadraCasa = result[0];
									goalSquadraTrasferta = result[1];
									
								}
								
								// SQUADRA TRASFERTA
								if(e2.className().contains("event__participant event__participant--away"))
								{
									squadraTrasferta = e2.text();
								}
							}
							
							/*
							 * Record da scrivere a DB
							 */
							System.out.println(annata + " " + nazione + " " + competizione + " " + turno + " " + orario + " " + squadraCasa + " " + goalSquadraCasa + " " +goalSquadraTrasferta + " " +squadraTrasferta);
						
							//c = 0;
							//g = 0;
							
						}

				}
			}

		}	
	}

	public void caricaCampionato2(String url, String href) 
	{
		WebElement element;
		Actions actions;
		
		
		String annata = "";
		String nazione = "";
		String competizione = "";
		
		
		
		/*
		try 
		{
			String url_DB = "jdbc:mysql://database-previsione.ci87mckdjg2k.us-east-2.rds.amazonaws.com:3306/previsione"; 
	        Connection conn;
			conn = DriverManager.getConnection(url_DB,"","");
			
	        st = conn.createStatement(); 

		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		*/
		
		PartitaController partitaController = new PartitaController();
		
		List<Partita> listaPartite = new ArrayList();

		
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
	
		driver.manage().window().maximize();
		driver.get(url);
		element = driver.findElement(By.xpath(href));

		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		/*
		try 
	    {
			Thread.sleep(3000);	//	3 secondi
		} 
	    catch (InterruptedException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		*/
		
		String htmlSource = driver.getPageSource();
		Document doc = Jsoup.parse(htmlSource);
		

		//	NAZIONE
		Element el_nazione = doc.getElementsByClass("tournament").get(0);
		Elements childNazione = el_nazione.children();
		nazione = childNazione.get(4).text();
		
		//	COMPETIZIONE
		Element el_competizione = doc.getElementsByClass("teamHeader__name").get(0);
		competizione = el_competizione.text().trim();
		
		//	ANNATA
		Element el_annata = doc.getElementsByClass("teamHeader__text").get(0);
		annata = el_annata.text();
		
	
		Element el_sportNameSoccer = doc.getElementsByClass("sportName soccer").get(0);
		Elements childSportNameSoccer = el_sportNameSoccer.children();
		
		String squadraCasa= "";
		String squadraTrasferta = "";
		String orario = "";
		String goalSquadraCasa = "";
		String goalSquadraTrasferta = "";
		String turno = "";
		
		int g = 0;
		for (Element e : childSportNameSoccer) 
		{
			String nomeClasse = e.className();
			
			if(nomeClasse.contains("event__header--noExpand"))
			{
				System.out.println("");
				g = 0;
			}
			else
			{
				if(nomeClasse.equals("event__round event__round--static"))
				{
					g = 1;
					turno = e.text();
					System.out.println("\n" + turno);
				}
				else
				{
							if(g == 0)
							{
								turno = "TurnoNonPresente";
								System.out.println("\n" + turno);
								g=1;
							}
							
							Elements childElement = e.children();
							for (Element e2 : childElement) 
							{
								// ORARIO
								if(e2.className().contains("event__time"))
								{
									orario = e2.text();
								}
								
								// SQUADRA CASA
								if(e2.className().contains("event__participant event__participant--home"))
								{
									squadraCasa = e2.text();
								}
								
								// RISULTATI
								if(e2.className().contains("event__scores"))
								{
									String[] result = e2.text().split(" - ");
									
									goalSquadraCasa = result[0];
									goalSquadraTrasferta = result[1];
									
								}
								
								// SQUADRA TRASFERTA
								if(e2.className().contains("event__participant event__participant--away"))
								{
									squadraTrasferta = e2.text();
								}
							}
							
							/*
							 * Record da scrivere a DB
							 */
							//System.out.println(annata + " " + nazione + " " + competizione + " " + turno + " " + orario + " " + squadraCasa + " " + goalSquadraCasa + " " +goalSquadraTrasferta + " " +squadraTrasferta);
							
							Partita p = new Partita(nazione, competizione, turno, annata, orario, orario, squadraCasa, Integer.parseInt(goalSquadraCasa), squadraTrasferta, Integer.parseInt(goalSquadraTrasferta));

							System.out.println(p);
							

							
							/*listaPartite.add(p);
							partitaController.insertPartite(listaPartite);
							*/
							
							
				}

			}
			
		}	
		


	}
	
	public List<Partita> caricaCampionato3(String url, String href) 
	{
		WebElement element;
		Actions actions;
		
		
		String annata = "";
		String nazione = "";
		String competizione = "";
		
		
		
		/*
		try 
		{
			String url_DB = "jdbc:mysql://database-previsione.ci87mckdjg2k.us-east-2.rds.amazonaws.com:3306/previsione"; 
	        Connection conn;
			conn = DriverManager.getConnection(url_DB,"","");
			
	        st = conn.createStatement(); 

		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		*/
		
		PartitaController partitaController = new PartitaController();
		
		List<Partita> listaPartite = new ArrayList();

		
		// Instantiate a ChromeDriver class.      
		WebDriver driver=new ChromeDriver(); 
		
	
		driver.manage().window().maximize();
		driver.get(url);
		element = driver.findElement(By.xpath(href));

		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		
		/*
		try 
	    {
			Thread.sleep(3000);	//	3 secondi
		} 
	    catch (InterruptedException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		/*
		element = driver.findElement(By.xpath("//a[@class='event__more event__more--static']"));
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
		*/
		
		String htmlSource = driver.getPageSource();
		Document doc = Jsoup.parse(htmlSource);
		

		//	NAZIONE
		Element el_nazione = doc.getElementsByClass("tournament").get(0);
		Elements childNazione = el_nazione.children();
		nazione = childNazione.get(4).text();
		
		//	COMPETIZIONE
		Element el_competizione = doc.getElementsByClass("teamHeader__name").get(0);
		competizione = el_competizione.text().trim();
		
		//	ANNATA
		Element el_annata = doc.getElementsByClass("teamHeader__text").get(0);
		annata = el_annata.text();
		
	
		Element el_sportNameSoccer = doc.getElementsByClass("sportName soccer").get(0);
		Elements childSportNameSoccer = el_sportNameSoccer.children();
		
		String squadraCasa= "";
		String squadraTrasferta = "";
		String orario = "";
		String goalSquadraCasa = "";
		String goalSquadraTrasferta = "";
		String turno = "";
		
		int g = 0;
		for (Element e : childSportNameSoccer) 
		{
			String nomeClasse = e.className();
			
			if(nomeClasse.contains("event__header--noExpand"))
			{
				System.out.println("");
				g = 0;
			}
			else
			{
				if(nomeClasse.equals("event__round event__round--static"))
				{
					g = 1;
					turno = e.text();
					System.out.println("\n" + turno);
				}
				else
				{
							if(g == 0)
							{
								turno = "TurnoNonPresente";
								System.out.println("\n" + turno);
								g=1;
							}
							
							Elements childElement = e.children();
							for (Element e2 : childElement) 
							{
								// ORARIO
								if(e2.className().contains("event__time"))
								{
									orario = e2.text();
								}
								
								// SQUADRA CASA
								if(e2.className().contains("event__participant event__participant--home"))
								{
									squadraCasa = e2.text();
								}
								
								// RISULTATI
								if(e2.className().contains("event__scores"))
								{
									String[] result = e2.text().split(" - ");
									
									goalSquadraCasa = result[0];
									goalSquadraTrasferta = result[1];
									
								}
								
								// SQUADRA TRASFERTA
								if(e2.className().contains("event__participant event__participant--away"))
								{
									squadraTrasferta = e2.text();
								}
							}
							
							/*
							 * Record da scrivere a DB
							 */
							//System.out.println(annata + " " + nazione + " " + competizione + " " + turno + " " + orario + " " + squadraCasa + " " + goalSquadraCasa + " " +goalSquadraTrasferta + " " +squadraTrasferta);
							
							Partita p = new Partita(nazione, competizione, turno, annata, orario, orario, squadraCasa, Integer.parseInt(goalSquadraCasa), squadraTrasferta, Integer.parseInt(goalSquadraTrasferta));

							System.out.println(p);
							

							listaPartite.add(p);

							
							
				}

			}
			
		}
		
		return listaPartite;	

	}

	
}
