package edu.virginia.cs.threelayer.data;

import edu.virginia.cs.threelayer.BestSellersList;
import edu.virginia.cs.threelayer.ListName;
import org.json.JSONObject;

import java.util.*;

public class BestSellersManager {
    private final BestSellersApi api = new BestSellersApi();

    public BestSellersList getCurrentBestSellerList(ListName listName) {
        JSONObject apiJson = api.getCurrentBestSellers(listName);
        BestSellersJSON bestSellersJSON = new BestSellersJSON();
        return bestSellersJSON.getBestSellerList(apiJson);
    }

    public BestSellersList getHistoricBestSellerList(ListName listName, Date date) {
        BestSellersApi api = new BestSellersApi();
        JSONObject apiJson = api.getHistoricBestSellers(listName, date);
        BestSellersJSON bestSellersJSON = new BestSellersJSON();
        return bestSellersJSON.getBestSellerList(apiJson);
    }
}
