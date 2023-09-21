package practiceproblems;

public class FoodReview implements Comparable<FoodReview> {
	private String userName;
	private int point;
	private String comment;
	
	public FoodReview(String userName, int point, String comment) {
		this.userName = userName;
		this.point = point;
		this.comment = comment;
	}
	
	public FoodReview() {
		
	}
	
	public String getUserName() {
		return this.userName;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "User name: "+this.userName+" point: "+this.point+" comment: "+this.comment;
	}
	
	@Override
	public int compareTo(FoodReview fr) {
		return this.point-fr.point;
	}
}
