package com.dev.ui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MainMenuNBTest {

    private MainMenuNB mmnb;

    @BeforeAll
    static void BeforeAll(){
        System.setProperty("java.awt.headless", "false");
    }

    @BeforeEach
    void makeMenu(){
        mmnb = null;
        mmnb = new MainMenuNB();
    }

    @Test
    void testRenders(){
        assertNotNull(mmnb);
    }

    @Test
    void testNewRender(){
        String[] args = {};
        mmnb.main(args);
        assertNotNull(mmnb);
    }
}
