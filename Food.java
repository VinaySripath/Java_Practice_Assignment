package practiceproblems;

import java.util.Comparator;
import java.util.List;

public class Food implements Comparable<Food>{
	private String foodName;
	private int cost;
	private int serialNo;
	private List<FoodReview> reviewList;
	@Override
	public int compareTo(Food f) {
		int nameCompare = this.getFoodName().compareTo(f.getFoodName());
		int costCompare = this.getCost()-f.getCost();
		return (nameCompare==0)?costCompare:nameCompare;
	}
	
	@Override
	public String toString() {
		return "Food name: "+this.foodName+ " Serial No: "+this.serialNo+" Cost: "+this.cost;
	}
	public Food() {
		
	}
	public Food(String foodName, int cost, int serialNo, List<FoodReview> reviewList) {
		this.foodName = foodName; 
		this.cost=cost;
		this.serialNo=serialNo;
		this.reviewList=reviewList;
	}
	
	public List<FoodReview> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<FoodReview> reviewList) {
		this.reviewList = reviewList;
	}

	public String getFoodName() {
		return this.foodName;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	public int getSerialNo() {
		return this.serialNo;
	}
	
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public void setCost(int cost) {
		this.cost=cost;
	}
	
	public void setSerialNo(int serialNo) {
		this.serialNo=serialNo;
	}
}
