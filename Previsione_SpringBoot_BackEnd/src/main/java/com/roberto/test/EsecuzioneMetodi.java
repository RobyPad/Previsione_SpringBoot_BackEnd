package com.roberto.test;

import com.roberto.caricamento.dati.CaricaPartite;

public class EsecuzioneMetodi
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		/*
		 * Italia serie A 2016/2017
		 */
		String url_italia = "https://www.diretta.it/serie-a-2016-2017/";
		String href_italia = "//a[@href='/serie-a-2016-2017/risultati/']";
		
		/*
		 * Francia ligue 1 2016/2017
		 */
		String url_francia = "https://www.diretta.it/calcio/francia/ligue-1-2016-2017/";
		String href_francia = "//a[@href='/calcio/francia/ligue-1-2016-2017/risultati/']";
		
		/*
		 * Champions_League 2016/2017
		 */
		String url_Champions_League = "https://www.diretta.it/calcio/europa/champions-league-2016-2017/risultati/";
		String href_Champions_League = "//a[@href='/calcio/europa/champions-league-2016-2017/risultati/']";
		
		/*
		 * Albania_Super_League 2016/2017
		 */
		String url_Albania_Super_League = "https://www.diretta.it/calcio/albania/super-league-2016-2017/risultati/";
		String href_Albania_Super_League = "//a[@href='/calcio/albania/super-league-2016-2017/risultati/']";
		
		/*
		 * Campionati Europei U17
		 */
		String url_Campionati_Europei_U17 = "https://www.diretta.it/calcio/europa/campionati-europei-u17-2016/risultati/";
		String href_Campionati_Europei_U17 = "//a[@href='/calcio/europa/campionati-europei-u17-2016/risultati/']";

		
		CaricaPartite o = new CaricaPartite();
				
		//o.caricaCampionato(url_francia,href_francia);
		
		o.caricaCampionato2(url_italia, href_italia);
		
		//o.caricaCampionato(url_Champions_League,href_Champions_League);
		
		//o.caricaCampionato2(url_Albania_Super_League,href_Albania_Super_League);
		
		//o.caricaCampionato2(url_Campionati_Europei_U17,href_Campionati_Europei_U17);
		
	}
	
	
}
