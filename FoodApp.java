package practiceproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FoodApp {
	public static void main(String[] args) {
		
		FoodReview fr1 = new FoodReview("vin",5,"good");
		FoodReview fr2 = new FoodReview("bin",3,"okay");
		FoodReview fr3 = new FoodReview("cin",4,"good");
		FoodReview fr4 = new FoodReview("rin",4,"good");
		FoodReview fr5 = new FoodReview("gin",1,"bad");
		FoodReview fr6 = new FoodReview("zin",2,"bad");
		FoodReview fr7 = new FoodReview("din",5,"good!");
		FoodReview fr8 = new FoodReview("win",1,"bad");
		
		List<FoodReview> lst1 = new ArrayList<>();
		lst1.add(fr1);
		lst1.add(fr2);
		lst1.add(fr3);
		
		List<FoodReview> lst2 = new ArrayList<>();
		lst2.add(fr4);
		lst2.add(fr8);
		lst2.add(fr3);
		
		List<FoodReview> lst3 = new ArrayList<>();
		lst3.add(fr5);
		lst3.add(fr6);
		lst3.add(fr7);
		
		List<FoodReview> lst4 = new ArrayList<>();
		lst4.add(fr1);
		lst4.add(fr3);
		
		
		Food f1 = new Food("idly",20,1,lst1);
		Food f9 = new Food("idly",40,7,lst1);
		Food f8 = new Food("idly",50,8,lst1);
		Food f10 = new Food("idly",60,9,lst1);
		Food f2 = new Food("dosa",30,2,lst2);
		Food f3 = new Food("parota",50,5,lst3);
		Food f4 = new Food("north meals",50,4,lst4);
		Food f5 = new Food("south meals",50,3,lst1);
		Food f6 = new Food("chat",40,6,lst3);
		
		Set<Food> foodSet = new TreeSet<Food>();
		foodSet.add(f1);
		foodSet.add(f2);
		foodSet.add(f3);
		foodSet.add(f4);
		foodSet.add(f5);
		foodSet.add(f6);
		foodSet.add(f10);
		foodSet.add(f8);
		foodSet.add(f9);
		
		Map<Food,List<FoodReview>> frMap = new TreeMap<>();
		for(Food f: foodSet) {
			frMap.put(f, f.getReviewList());
		}
		
//		Set<Map.Entry<String, List<FoodReview>>> reviewList = frMap.entrySet();
//		System.out.println(reviewList);
		
		for(Map.Entry<Food, List<FoodReview>>entry: frMap.entrySet()) {
			System.out.println(" ");
			System.out.print("food name: ");
			System.out.println(entry.getKey().getFoodName());
			entry.getValue().stream().forEach((value)->{System.out.print("the rating is: "); 
			System.out.println(value.getPoint());System.out.print(" the review: ");
			System.out.println(value.getComment());});
		}
		
		System.out.println(" ");
		System.out.println("the list of food items are------");
		for(Food f: foodSet) {
			System.out.println(f);
		}
		
		System.out.println(" ");
		System.out.println("the list of food items sorted by cost----------");
		SortByCost sort = new SortByCost();
		Set<Food> foodSortedByCost = new TreeSet<Food>(sort);
		foodSortedByCost.addAll(foodSet);
		
		for(Food f: foodSortedByCost) {
			System.out.println(f);
		}
		
	}
}
