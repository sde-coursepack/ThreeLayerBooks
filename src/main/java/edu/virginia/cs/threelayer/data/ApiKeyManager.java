package edu.virginia.cs.threelayer.data;

import java.io.*;

public class ApiKeyManager {
    private static final String BESTSELLERS_KEY_FILENAME = "nytimes.key";

    public String getBestSellersAPIKey() {
        ClassLoader classLoader = getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(BESTSELLERS_KEY_FILENAME)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readLine().strip();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
