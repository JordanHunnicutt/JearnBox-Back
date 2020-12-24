package com.dev.ui;

import com.dev.model.SingleResponseQuestion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class CategorySelectorTest {

    @Mock
    private MainMenuNB mmnb;

    private List<SingleResponseQuestion> allQs = new ArrayList<>();

    @InjectMocks
    private CategorySelector cs = new CategorySelector(mmnb, allQs);

    @BeforeAll
    static void BeforeAll(){
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void testRenders(){
        assertNotNull(cs);
    }
}
