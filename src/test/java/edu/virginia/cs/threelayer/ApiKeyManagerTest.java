package edu.virginia.cs.threelayer;

import edu.virginia.cs.threelayer.data.ApiKeyManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ApiKeyManagerTest {
    @Test
    public void getBestSellersAPI() {
        ApiKeyManager factory = new ApiKeyManager();
        assertNotNull(factory.getBestSellersAPIKey());
    }
}
