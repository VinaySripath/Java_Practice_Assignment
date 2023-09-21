package practiceproblems;

import java.util.Comparator;

public class SortByCost implements Comparator<Food> {
	@Override
	public int compare(Food f1, Food f2) {
		return f1.getCost()<=f2.getCost()?-1:1;
	}
}
