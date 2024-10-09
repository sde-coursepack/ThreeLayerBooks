package edu.virginia.cs.threelayer.business;

import edu.virginia.cs.threelayer.BestSellersList;
import edu.virginia.cs.threelayer.Book;
import edu.virginia.cs.threelayer.ListName;
import edu.virginia.cs.threelayer.data.BestSellersManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BestSellersServiceTest {
    private BestSellersService bestSellersService;

    @Mock
    private BestSellersManager mockDataManager;

    @Mock
    private BestSellersList mockBestSellersList;

    Book gardensOfTheMoon = new Book("553812173",
            "Gardens Of The Moon", "Steve Erickson", 10);
    Book deadhouseGates = new Book("0553813110",
            "Deadhouse Gates", "Steve Erickson", 5);


    @BeforeEach
    public void setup() {
        bestSellersService = new BestSellersService(mockDataManager);
    }

    @Test
    void getLongestCurrentBestSeller() {
        Book gardensOfTheMoon = new Book("553812173","Gardens Of The Moon","Steve Erickson", 10);
        Book deadhouseGates = new Book("0553813110","Deadhouse Gates","Steve Erickson", 5);

        when(mockDataManager.getCurrentBestSellerList(ListName.COMBINED_FICTION)).thenReturn(mockBestSellersList);
        when(mockBestSellersList.getBooks()).thenReturn(List.of(gardensOfTheMoon, deadhouseGates));
        assertEquals(gardensOfTheMoon, bestSellersService.getLongestCurrentBestSeller(ListName.COMBINED_FICTION));
    }
}