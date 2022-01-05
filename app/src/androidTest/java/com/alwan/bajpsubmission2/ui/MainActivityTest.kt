package com.alwan.bajpsubmission2.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.alwan.bajpsubmission2.R
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueDetailEntity
import com.alwan.bajpsubmission2.data.source.local.entity.CatalogueEntity
import com.alwan.bajpsubmission2.utils.DummyCatalogue
import com.alwan.bajpsubmission2.utils.EspressoIdlingResource
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyDetailMovie = DummyCatalogue.getMovieDetails()[0]
    private val dummyDetailTvShow = DummyCatalogue.getTvShowDetails()[0]
    private val emptyData = emptyList<CatalogueEntity>()

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
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
                19
            )
        )
    }

    @Test
    fun loadDataTvShow() {
        onView(withText(R.string.tab_text_2)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
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
        checkDetail(dummyDetailMovie)
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
        checkDetail(dummyDetailTvShow)
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

    private fun checkDetail(catalogueDetailEntity: CatalogueDetailEntity) {
        onView(withId(R.id.tv_title_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogueDetailEntity.name)))
        }
        onView(withId(R.id.tv_score_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogueDetailEntity.voteAverage.toString())))
        }
        onView(withId(R.id.tv_genre_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogueDetailEntity.genres)))
        }
        onView(withId(R.id.tv_overview_detail)).apply {
            check(matches(isDisplayed()))
            check(matches(withText(catalogueDetailEntity.overview)))
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
}