package com.dev.ui;

import com.dev.model.SingleResponseQuestion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class LobbySettingsNBTest {

    @Mock
    private MainMenuNB mmnb;

    private LobbySettingsNB lsnb = LobbySettingsNB.getLobbySettingsInstance();

    @BeforeAll
    static void BeforeAll(){
        System.setProperty("java.awt.headless", "false");
    }

    @BeforeEach
    void makeInstanceNull(){
        lsnb.killInstance();
    }

    @Test
    void testRenders(){
        lsnb = LobbySettingsNB.getLobbySettingsInstance();
        assertNotNull(lsnb);
    }

    @Test
    void testRendersWithMenuPassedIn(){
        List<SingleResponseQuestion> testQ = new ArrayList<>();
        testQ.add(new SingleResponseQuestion());
        lsnb = LobbySettingsNB.getLobbySettingsInstance(mmnb, testQ);
        assertNotNull(lsnb);
    }

}
