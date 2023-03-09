package com.yuhs.admin.support;

import java.util.Arrays;

public class SearchDto{
	
	private int pageNo = 1;
	private int pageSize = 15;
	private int totalCount = 0;
	private int totalPage = 0;
	private int startPage = 0;
	private int endPage = 15;
	private int blockSize = 10; 
	private int startBlock = 0;
	private int endBlock = 0;
	
	private String searchWord;
	private String searchWord2;
	private String searchWord3;
	private String searchWord4;
	private String searchWord5;

	private String searchOption;
	private String searchOption2;
	private String searchOption3;
	private String searchOption4;
	private String searchOption5;
	private String searchOption6;
	
	
	private String user_role;
	private String ins_id;
	private String searchStartYmd;
	private String searchEndYmd;
	private String type;
	
	private Long[] box;
	private Long[] idBox;
	
	
	public void pageInit(int totalCount) {
		
		this.totalCount = totalCount;
		this.totalPage = ( this.totalCount / this.pageSize ) + 1;
		this.startPage = ( (this.pageNo > 0 ? this.pageNo : 1) - 1 ) * this.pageSize;
		this.endPage =  this.pageSize;
		
		if( this.totalCount % this.pageSize == 0 ){
			this.totalPage--;
		}
		
		int totalBlock = (int)Math.ceil( this.totalCount / (double) this.pageSize );
		this.startBlock = (( this.pageNo - 1) / this.blockSize * this.blockSize ) + 1;
		this.endBlock = (( this.pageNo - 1 ) / this.blockSize * this.blockSize ) + this.blockSize;
		
		if ( this.endBlock > totalBlock ){
			this.endBlock = totalBlock;
		}
	}

	
	public String getSearchOption6() {
		return searchOption6;
	}


	public void setSearchOption6(String searchOption6) {
		this.searchOption6 = searchOption6;
	}


	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public String getSearchWord2() {
		return searchWord2;
	}

	public String getSearchWord3() {
		return searchWord3;
	}

	public String getSearchWord4() {
		return searchWord4;
	}

	public String getSearchWord5() {
		return searchWord5;
	}

	public String getSearchOption() {
		return searchOption;
	}

	public String getSearchOption2() {
		return searchOption2;
	}

	public String getSearchOption3() {
		return searchOption3;
	}

	public String getSearchOption4() {
		return searchOption4;
	}

	public String getSearchOption5() {
		return searchOption5;
	}

	public String getUser_role() {
		return user_role;
	}

	public String getIns_id() {
		return ins_id;
	}

	public String getSearchStartYmd() {
		return searchStartYmd;
	}

	public String getSearchEndYmd() {
		return searchEndYmd;
	}

	public String getType() {
		return type;
	}

	public Long[] getBox() {
		return box;
	}

	public Long[] getIdBox() {
		return idBox;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public void setSearchWord2(String searchWord2) {
		this.searchWord2 = searchWord2;
	}

	public void setSearchWord3(String searchWord3) {
		this.searchWord3 = searchWord3;
	}

	public void setSearchWord4(String searchWord4) {
		this.searchWord4 = searchWord4;
	}

	public void setSearchWord5(String searchWord5) {
		this.searchWord5 = searchWord5;
	}

	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}

	public void setSearchOption2(String searchOption2) {
		this.searchOption2 = searchOption2;
	}

	public void setSearchOption3(String searchOption3) {
		this.searchOption3 = searchOption3;
	}

	public void setSearchOption4(String searchOption4) {
		this.searchOption4 = searchOption4;
	}

	public void setSearchOption5(String searchOption5) {
		this.searchOption5 = searchOption5;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public void setIns_id(String ins_id) {
		this.ins_id = ins_id;
	}

	public void setSearchStartYmd(String searchStartYmd) {
		this.searchStartYmd = searchStartYmd;
	}

	public void setSearchEndYmd(String searchEndYmd) {
		this.searchEndYmd = searchEndYmd;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setBox(Long[] box) {
		this.box = box;
	}

	public void setIdBox(Long[] idBox) {
		this.idBox = idBox;
	}

	@Override
	public String toString() {
		return "SearchDto [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage=" + totalPage + ", startPage=" + startPage + ", endPage=" + endPage + ", blockSize=" + blockSize + ", startBlock=" + startBlock + ", endBlock=" + endBlock + ", searchWord=" + searchWord + ", searchWord2=" + searchWord2 + ", searchWord3=" + searchWord3 + ", searchWord4=" + searchWord4 + ", searchWord5=" + searchWord5 + ", searchOption=" + searchOption + ", searchOption2=" + searchOption2 + ", searchOption3=" + searchOption3 + ", searchOption4=" + searchOption4 + ", searchOption5=" + searchOption5 + ", user_role=" + user_role + ", ins_id=" + ins_id + ", searchStartYmd=" + searchStartYmd + ", searchEndYmd=" + searchEndYmd + ", type=" + type + ", box=" + Arrays.toString(box) + ", idBox=" + Arrays.toString(idBox) + "]";
	}
	
}