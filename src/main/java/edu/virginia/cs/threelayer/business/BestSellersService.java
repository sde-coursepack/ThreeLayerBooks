package edu.virginia.cs.threelayer.business;

import edu.virginia.cs.threelayer.*;
import edu.virginia.cs.threelayer.data.BestSellersManager;

import java.util.Comparator;
import java.util.Date;

public class BestSellersService {
    private final BestSellersManager bestSellersManager;

    public BestSellersService() {
        this(new BestSellersManager());
    }

    public BestSellersService(BestSellersManager bestSellersManager) {
        this.bestSellersManager = bestSellersManager;
    }

    public BestSellersList getCurrentBestSellerList(ListName listName) {
        return bestSellersManager.getCurrentBestSellerList(listName);
    }

    public BestSellersList getHistoricBestSellerList(ListName listName, Date date) {
        return bestSellersManager.getHistoricBestSellerList(listName, date);
    }

    public Book getLongestCurrentBestSeller(ListName listName) {
        var bestSellers = bestSellersManager.getCurrentBestSellerList(listName);
        var longestCurrentBook = bestSellers.getBooks().stream()
                .max(Comparator.comparing(Book::getWeeksOnList));
        if (longestCurrentBook.isEmpty()) {
            throw new EmptyBestSellerListException(bestSellers.toString());
        }
        return longestCurrentBook.get();
    }
}
