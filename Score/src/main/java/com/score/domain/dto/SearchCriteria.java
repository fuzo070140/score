package com.score.domain.dto;

public class SearchCriteria extends Criteria{
	
	private String searchType;
	private String keyword;
	private String boardGood;
	
	
	public String getBoardGood() {
		return boardGood;
	}
	public void setBoardGood(String boardGood) {
		this.boardGood = boardGood;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return super.toString() + " SearchCriteria "
				+ "[searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}

}
