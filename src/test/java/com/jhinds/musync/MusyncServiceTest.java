package com.jhinds.musync;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jonathanhinds on 9/5/15.
 */
public class MusyncServiceTest {
    @Autowired
    PandoraService pandoraSerivce;

    @Test
    public void testPartnerLogin() {
        PandoraService pandoraSerivce = new PandoraService();

        pandoraSerivce.partnerLogin();
    }

    @Test
    public void testUserLogin() {
        PandoraService pandoraSerivce = new PandoraService();

        pandoraSerivce.userLogin("paul@22paul.com", "jh8050541");
    }
}
