package com.pigcanfly.leetcoding.s1236;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author tobbyquinn
 * @date 2020/02/03
 */
public class WebCrawler {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        HashSet<String> sets = new HashSet<>();
        sets.add(startUrl);
        String[] domains = startUrl.split("/");
        String prefix=domains[0]+"//"+domains[2];
        crawl(startUrl,htmlParser,sets,prefix);
        return new ArrayList<>(sets);
    }
    public void crawl(String startUrl, HtmlParser htmlParser, HashSet set,String prefix) {
        List<String> urls = htmlParser.getUrls(startUrl);
        urls.stream().filter(url-> url.startsWith(prefix) && !set.contains(url)).forEach(url->{
            set.add(url);
            crawl(url,htmlParser,set,prefix);
        });
    }

    public static void main(String[] args) {
        String url = "http://news.yahoo.com";
        String[] split = url.split("/");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
}
interface HtmlParser {
       List<String> getUrls(String url);
  }
