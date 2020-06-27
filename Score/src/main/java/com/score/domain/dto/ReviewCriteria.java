package com.score.domain.dto;

public class ReviewCriteria extends Criteria{
	
	private String GameNumber;
	
	public String getGameNumber() {
		return GameNumber;
	}
	public void setGameNumber(String gameNumber) {
		GameNumber = gameNumber;
	}
	@Override
	public String toString() {
		return super.toString() + " ReviewCriteria "
				+ "[GameNumber=" + GameNumber + "]";
	}

}
