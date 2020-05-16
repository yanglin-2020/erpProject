package com.xt.pojo;
/**
 * 发布公告实体类
 * @author yl
 *
 */
public class GongGao {
	private int id;
	private String title;//公告的标题
	private String content;//公告的主体内容
	private String time;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GongGao() {
		super();
	}
	public GongGao(int id, String title, String content, String time, String name) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
		this.name = name;
	}
	public GongGao(String title, String content, String time, String name) {
		super();
		this.title = title;
		this.content = content;
		this.time = time;
		this.name = name;
	}
}
