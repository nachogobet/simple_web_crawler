package com.ig.webcrawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
	private static Set<String> visited = new HashSet<String>();
	private static String domain = null;

	public void crawl(String seed) throws IOException{
		if(domain == null)
			domain = seed;
		
		if(visited.contains(seed))
			return;

		System.out.println("parsing " + seed + " ...");
		visited.add(seed);
        Connection connection = Jsoup.connect(seed).userAgent(USER_AGENT);
        Document htmlDocument = connection.get();

		Elements links = htmlDocument.select("a[href]");
		
		for(Element link : links)
        {
			String url = link.absUrl("href");
			if(notExternalUrl(url))
				crawl(url);
        }
	}

	private boolean notExternalUrl(String url) {
		return url.contains(domain);
	}
}
