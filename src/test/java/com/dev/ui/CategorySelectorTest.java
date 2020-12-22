package com.dev.ui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CategorySelectorTest {

    @Mock
    private MainMenuNB mmnb;

    @InjectMocks
    private CategorySelector cs = new CategorySelector(mmnb);

    @BeforeAll
    static void BeforeAll(){
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void testRenders(){
        assertNotNull(cs);
    }
}
