package com.dev.ui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class InLobbyNBTest {

    private InLobbyNB ilnb = InLobbyNB.getInLobbyInstance();

    @BeforeAll
    static void BeforeAll(){
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void testRenders(){
        assertNotNull(ilnb);
    }

}
