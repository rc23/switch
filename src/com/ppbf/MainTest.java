package com.ppbf;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void testMain() throws Exception {
        String[] args = null;
        Main.main(args);

        assertEquals(1, 1);
    }
}
