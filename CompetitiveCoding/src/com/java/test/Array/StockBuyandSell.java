package com.java.test.Array;

import java.util.ArrayList;

class Interval {
	int buy, sell;
}

class StockBuyandSell {

	void stockBuySell(int price[], int n) {

		if (n == 1)
			return;

		int count = 0;

		ArrayList<Interval> sol = new ArrayList<Interval>();

		int i = 0;
		while (i < n - 1) {

			while ((i < n - 1) && (price[i + 1] <= price[i]))
				i++;

			if (i == n - 1)
				break;

			Interval e = new Interval();
			e.buy = i++;

			while ((i < n) && (price[i] >= price[i - 1]))
				i++;

			e.sell = i - 1;
			sol.add(e);

			count++;
		}

		if (count == 0)
			System.out.println("There is no day when buying the stock " + "will make profit");
		else
			for (int j = 0; j < count; j++)
				System.out.println("Buy on day: " + sol.get(j).buy + "	 " + "Sell on day : " + sol.get(j).sell);

		return;
	}

	public static void main(String args[]) {
		StockBuyandSell stock = new StockBuyandSell();

		int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int n = price.length;

		stock.stockBuySell(price, n);
	}
}
