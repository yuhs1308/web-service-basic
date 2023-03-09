package com.yuhs.admin.support;

public class Page {

	private int pageNo = 1; /* 현재 페이지 */
	private int pageSize = 20; /* 현재 페이지에 출력되는 ROW 개수*/
	private int totalCount = 0; /* ROW의 총 개수 */
	private int totalPage = 0; /* 페이지의 총 개수 */
	private int startRow = 0; /* 표기되는 리스트의 첫번째 ROW 번호 */ 
	private int endRow = 10; /* 표기되는 리스트의 마지막 ROW 번호 */
	private int blockSize = 10;  /* 표기되는 페이지의 개수 */
	private int startBlock = 0; 
	private int endBlock = 0;	
	

	public Page(int totalCount) {
		
		this.totalCount = totalCount;
		this.totalPage = ( this.totalCount / this.pageSize ) + 1;
		this.startRow = ( (this.pageNo > 0 ? this.pageNo : 1) - 1 ) * this.pageSize;
		this.endRow =  this.pageSize;
		
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
	
	public void setPage(int totalCount, int pageNo, int pageSize, int blockSize) {
		
		this.totalCount = totalCount;
		this.totalPage = ( this.totalCount / this.pageSize ) + 1;
		this.startRow = ( (this.pageNo > 0 ? this.pageNo : 1) - 1 ) * this.pageSize;
		this.endRow =  this.pageSize;
		
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

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + ", startRow=" + startRow + ", endRow=" + endRow + ", blockSize=" + blockSize
				+ ", startBlock=" + startBlock + ", endBlock=" + endBlock + "]";
	}

}