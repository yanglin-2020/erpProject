package com.xt.util;
/**
 * 分页的工具类
 * @author 杨林
 *
 */
public class PageUtil {
	private int pageSize;//每页显示的条数
	private int nowPage;//当前页
	private int rowCount;//总记录数
	private int pageCount;//总页数
	private int firstPage=1;//首页
	private int lastPage;//尾页
	private int startRow;//起始行
	private int prevPage;//上一页
	private int nextPage;//下一页
	
	public PageUtil(int pageSize,int nowPage,int rowCount){
		this.rowCount = rowCount;
		this.nowPage = nowPage;
		this.pageSize = pageSize;
		//算总页数
		pageCount = rowCount%pageSize==0?rowCount/pageSize:rowCount/pageSize+1;
		//尾页
		lastPage = this.pageCount;
		//当前页
		if(this.nowPage>lastPage){
			this.nowPage = lastPage;
		}
		if(this.nowPage<firstPage){
			this.nowPage = firstPage;
		}
		//上一页
		if(nowPage==1){
			prevPage = 1;
		}else{
			prevPage = nowPage-1;
		}
		//下一页
		if(nowPage==lastPage){
			nextPage = lastPage;
		}else{
			nextPage = nowPage+1;
		}
		//起始行
		startRow = (this.nowPage-1)*pageSize;
	}
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
}
