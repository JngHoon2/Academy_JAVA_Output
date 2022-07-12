package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import file.vo.NewsClass;

public class MethodClass {
	private ArrayList<NewsClass> newsList = new ArrayList<NewsClass>();
	
	public MethodClass() {}
	
	public void readNewsData() {
		String uri = "/Users/tuan/Documents/works/chap08_naverNewsStand/src/txtData/naver_news_stand.txt";
		FileReader fr = null;
		BufferedReader br = null;
		NewsClass news = null;
		
		try {
			fr = new FileReader(uri);
			br = new BufferedReader(fr);
			
			news =null;
			String one = "";
			String[] tmp = null;
			while((one = br.readLine()) != null) {
				tmp = one.split(",");
				System.out.println(tmp[0] + "\t" + tmp[1] + "\t" +tmp[2] + "\t" +tmp[3]);
				
				news = new NewsClass(tmp[1], tmp[2]);
				newsList.add(news);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void makeHtml() {
		
		int rows = 10;
		int cols = 8;
		
		String tags = "";
		tags += "<!doctype>";
		tags += "<html>";
		tags += "<head><title>News Stand</title></head>";
		tags += "<body>";
		tags += "<table>";
			
		int count = 0;

		for(int ntr = 0; ntr < rows; ntr++) {
			for (int ntd = 0; ntd < cols; ntd++) {
				tags += "<td>";
				tags += "<a href = http://" + newsList.get(count).getUrl() + ">";
				tags += "<img src = /Users/tuan/Documents/works/chap08_naverNewsStand/src/newsImages/" + newsList.get(count).getImg() + ">";
				tags += "</a>";
				tags += "</td>";
				count++;
			}
			tags += "</tr>";
		}
		tags += "</table>";
		tags += "</body>";
		tags += "</html>";

		System.out.println(tags);
		
		String strPath = "/Users/tuan/Documents/works/chap08_naverNewsStand/src/news.html";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(strPath);
			fw.write(tags);
			fw.close();
			System.out.println("html 생성완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
