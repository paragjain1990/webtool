package web.web;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
	
	private Document jSoupDoc;

	public Parser(Document jSoupDoc) {
		super();
		this.jSoupDoc = jSoupDoc;
	}
	
	public WebDataStructure filterData() {
		
		WebDataStructure web =new WebDataStructure();
		
		Document filterDoc = this.jSoupDoc;
		
		//SET Url
		String url=  filterDoc.baseUri();
		web.setUrl(url);
		//System.out.println(url);
		
		//SET encoding
		String encoding;
		try {
			encoding = filterDoc.charset().toString();
		} catch (NullPointerException e1) {
			// TODO Auto-generated catch block
			encoding = "encoding not found";
		}
		web.setEncoding(encoding);
		//System.out.println(filterDoc.charset());
		
		
		
		//SET Title 
		String title;
		try {
			title = filterDoc.title();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			title = "Title not found";
		}
		web.setTitle(title);
		
		//SET  keywords
		String keywords;
		
		try {
			keywords=meta_Tag("keywords",filterDoc);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			keywords="keyword not found";
		}
		web.setKeywords(keywords);
		
		//SET description 
		String description;
		try {
			description=meta_Tag("description",filterDoc);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			description="description not found";
		}
		web.setDescription(description);
		

		//SET content //set num_contentLength
		String content;
		int num_contentLength=0;	
		
		
		
		
		try {
			content=filterDoc.text();
			String[] str =content.split("[^0-9a-zA-Z]+");
			num_contentLength=str.length;
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			content="content not found";num_contentLength=0;	
		}
		
		web.setContent(content);
		web.setNum_contentLength(num_contentLength);
		
		//set num_links
		int num_links;
		try {
			num_links=num("link",filterDoc);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			num_links=0;
		}
		web.setNum_links(num_links);
		
		//set num_image
		int num_image;
		try {
			num_image=num("img",filterDoc);
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			num_image=0;
		}
		web.setNum_images(num_image);
		
		//set num_contentLength
		
		
		//SET num_stopWords
		web.setNum_stopWords(0);
		
		return web;
	}
	
	
	
	
	
	//meta data content
	private String meta_Tag(String value,Document filterDoc)
	{	
		Elements metaTags = filterDoc.getElementsByTag("meta");
		String name;
		String content=null;
		
		for (Element metaTag : metaTags)
		{
			name = metaTag.attr("name");
			//System.out.println(name);
			if (value.equals(name))
					content=metaTag.attr("content");
			if(value.equals("all"))
				{if (content==null)
					content=metaTag.attr("content");
				else
					content=content+metaTag.attr("content");
				}	
				
		}
		if (content.equals(null))
		return null;
		else
		return content;
	
	}
	
	private int num(String tag,Document filterDoc)
	{
		Elements Tags = filterDoc.getElementsByTag(tag);
		int n = Tags.size();
		return n;
	}


	
}
	

