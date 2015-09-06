package com.jhinds.musync;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jonathanhinds on 9/5/15.
 */
public class MusyncServiceTest {
    @Autowired
    MusyncService musyncService;

    @Test
    public void testPartnerLogin() {
        MusyncService musyncService = new MusyncService();

        musyncService.partnerLogin();
    }
}
