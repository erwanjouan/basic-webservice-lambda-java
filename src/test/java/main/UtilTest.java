package main;

import org.junit.jupiter.api.Test;

import static main.LambdaHandler.GREEN;
import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void getRequestBody() {
        String green = Util.getRequestBody(GREEN);
        assertTrue(green.contains(GREEN));
    }
}