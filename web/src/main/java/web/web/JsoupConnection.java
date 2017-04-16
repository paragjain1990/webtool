package web.web;


import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
public class JsoupConnection{
	
	private Document doc = null;
	private String url= null;
	
    
	public JsoupConnection(String url) {
		super();
		this.url = url;
		try {
			this.doc = Jsoup.connect(this.url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		try {
			this.doc = Jsoup.connect(this.url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	} 