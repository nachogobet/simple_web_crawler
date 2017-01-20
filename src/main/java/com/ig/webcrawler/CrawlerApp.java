package com.ig.webcrawler;

import java.io.IOException;

import org.jsoup.HttpStatusException;

public class CrawlerApp {

	public static void main(String[] args) {
		Crawler myCrawler = new Crawler();
		try {
			myCrawler.crawl("http://wiprodigital.com");
		} catch (IOException e) {
			if(e instanceof HttpStatusException)
				System.out.println("That's all the page allows as to request through http");
			else
				e.printStackTrace();
		}
	}

}
