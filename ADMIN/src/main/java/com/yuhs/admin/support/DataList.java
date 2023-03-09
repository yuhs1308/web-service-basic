package com.yuhs.admin.support;

import java.util.ArrayList;


public class DataList extends ArrayList<DataMap> {

	private static final long serialVersionUID = 1L;
	
	private Page page = null;
	
	public void setInitPage(){ /*현재 개수의 페이지 정보를 가져온다*/
		this.page = new Page(this.size());
	}
	
	public Page getPage() {/*현재 개수의 페이지 정보를 가져온다*/
		return page;
	}
	
	public void setPage(int pageNo, int pageSize, int blockSize){ 
		this.page.setPage(this.size(), pageNo, pageSize, blockSize);
	}
	
}