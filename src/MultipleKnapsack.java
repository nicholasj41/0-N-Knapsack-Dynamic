import java.util.Scanner;

public class MultipleKnapsack {

	private int[] values = {2, 3, 1, 4, 5};
	private int[] weights = {1, 2, 3, 3, 5};
	private int size = values.length;
	private int maxWeight = 7;
	private int table[];
	
	private MultipleKnapsack() {

		System.out.print("Values: \t");
		for(int x = 0; x < values.length; x++) {
			System.out.print(values[x] + " ");
		}
		System.out.println();
		System.out.print("Weights: \t");
		for(int x = 0; x < weights.length; x++) {
			System.out.print(weights[x] + " ");
		}
		System.out.println();
		System.out.println("Max Weight: \t" + maxWeight);
		
		fillTable();
	}
	
	private void fillTable() {
		table = new int[maxWeight+1];
		
		for(int i = 0; i <= maxWeight; i++) {
			for(int j = 0; j < size; j++) {
				
				int weight = weights[j];
				int value = values[j];
				
				if(weight <= i) {
					table[i] = Math.max(table[i], table[i-weight] + value);
				}
				
			}
		}
		System.out.println("Highest Value that can be achieved: " + table[maxWeight]);
		System.out.println("Complexity: O(size*maxWeight)");
	}
	
	public static void main(String[] arguments) {
		new MultipleKnapsack();
	}
}
