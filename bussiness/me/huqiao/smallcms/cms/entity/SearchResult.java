package me.huqiao.smallcms.cms.entity;

import javax.persistence.Transient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import me.huqiao.smallcms.common.entity.CommonFile;

public class SearchResult {

	private String source;
	private String key;
	private Integer id;
	private String title;
	private WebPage webPage;
	private CommonFile cover;
	private String content;
	
	public SearchResult(
			String source, 
			Integer id, String key,
			String title,
			String content,
			WebPage webPage, CommonFile cover) {
		super();
		this.source = source;
		this.key = key;
		this.id = id;
		this.title = title;
		this.webPage = webPage;
		this.cover = cover;
		this.content = content;
	}
	public SearchResult(
			String source, 
			Integer id, String key,
			String title,
			String content,
		    CommonFile cover) {
		super();
		this.source = source;
		this.key = key;
		this.id = id;
		this.title = title;
		this.cover = cover;
		this.content = content;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public CommonFile getCover() {
		return cover;
	}
	public void setCover(CommonFile cover) {
		this.cover = cover;
	}
	public WebPage getWebPage() {
		return webPage;
	}
	public void setWebPage(WebPage webPage) {
		this.webPage = webPage;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContentText(){
		String c = getContent();
		Document doc = Jsoup.parse(c);
		return doc.text();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchResult other = (SearchResult) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
}
