package web.web;

public class WebDataStructure {

	private String url          ;
	private String encoding     ;
	private String title        ;
	private String keywords     ;
	private String description  ;
	private String content		;
	private int num_links        ;
	private int num_images       ;
	private int num_stopWords    ;
	private int num_contentLength;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNum_links() {
		return num_links;
	}
	public void setNum_links(int num_links) {
		this.num_links = num_links;
	}
	public int getNum_images() {
		return num_images;
	}
	public void setNum_images(int num_images) {
		this.num_images = num_images;
	}
	public int getNum_stopWords() {
		return num_stopWords;
	}
	public void setNum_stopWords(int num_stopWords) {
		this.num_stopWords = num_stopWords;
	}
	public int getNum_contentLength() {
		return num_contentLength;
	}
	public void setNum_contentLength(int num_contentLength) {
		this.num_contentLength = num_contentLength;
	}
	
	
}

