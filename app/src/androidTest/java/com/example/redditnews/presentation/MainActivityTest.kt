package com.example.redditnews.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * created by Karim Haggagi Hassan Elsayed on 5/14/25
 **/
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun homeRoute_showsNewsTitleAndList() {
        // The real activity is launched, which should use HomeRoute internally
        composeRule.onNodeWithText("Kotlin News").assertIsDisplayed()
        Thread.sleep(10000)

        composeRule.onNodeWithTag("news_item_2",useUnmergedTree = true).performClick()

        composeRule.onNodeWithTag("details_top_bar").assertIsDisplayed()
        Thread.sleep(5000)

        composeRule.onNodeWithTag("navigation_back",useUnmergedTree = true).performClick()
        composeRule.onNodeWithText("Kotlin News").assertIsDisplayed()
        Thread.sleep(5000)

    }
}

