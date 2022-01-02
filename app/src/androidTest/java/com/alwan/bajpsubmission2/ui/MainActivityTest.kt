package com.alwan.bajpsubmission2.ui

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.data.DummyCatalogue
import com.alwan.bajpsubmission2.data.model.Catalogue
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DummyCatalogue.getMovie()
    private val dummyTvShow = DummyCatalogue.getTvShow()
    private val emptyData = emptyList<Catalogue>()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun clickChangeLanguage() {
        onView(withId(R.id.menu_language)).perform(click())
    }

    @Test
    fun loadDataMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size - 1
            )
        )
    }

    @Test
    fun loadDataTvShow() {
        onView(withText(R.string.tab_text_2)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size - 1))
        }
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        checkDetail(dummyMovie[0])
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        checkDetail(dummyTvShow[0])
    }

    @Test
    fun emptyDataMovie() {
        assertEquals(emptyData.size, 0)
        onView(withId(R.id.empty_movie)).perform(setVisibility(true))
        onView(withId(R.id.rv_movie)).perform(setVisibility(false))
    }

    @Test
    fun emptyDataTvShow() {
        onView(withText("TV SHOW")).perform(click())
        assertEquals(emptyData.size, 0)
        onView(withId(R.id.empty_tv_show)).perform(setVisibility(true))
        onView(withId(R.id.rv_tv_show)).perform(setVisibility(false))
    }

    private fun checkDetail(catalogue: Catalogue) {
        onView(withId(R.id.tv_title_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogue.title)))
        }
        onView(withId(R.id.tv_score_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogue.score)))
        }
        onView(withId(R.id.tv_genre_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogue.genre)))
        }
        onView(withId(R.id.tv_overview_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogue.overview)))
        }
        onView(withId(R.id.img_poster_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withDrawable(catalogue.poster!!)))
        }
    }

    private fun setVisibility(value: Boolean): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(View::class.java)
            }

            override fun perform(uiController: UiController?, view: View) {
                view.visibility = if (value) View.VISIBLE else View.GONE
            }

            override fun getDescription(): String {
                return "Show / Hide View"
            }
        }
    }

    private fun withDrawable(@DrawableRes id: Int) = object : TypeSafeMatcher<View>() {
        override fun describeTo(description: Description) {
            description.appendText("ImageView with drawable same as drawable with id $id")
        }

        override fun matchesSafely(view: View): Boolean {
            val context = view.context
            val expectedBitmap = context.getDrawable(id)!!.toBitmap()

            return view is ImageView && view.drawable.toBitmap().sameAs(expectedBitmap)
        }
    }
}