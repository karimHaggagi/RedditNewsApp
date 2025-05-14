package com.example.home.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import app.cash.turbine.test
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.presentation.UiText
import com.example.home.MainDispatcherRule
import com.example.home.createFakeNewsDTO
import com.example.home.data.asNewsDomainModel
import com.example.home.domain.usecase.GetNewsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    private lateinit var SUT: HomeViewModel

    @Mock
    private lateinit var getNewsUseCase: GetNewsUseCase


    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainDispatcherRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        SUT = HomeViewModel(getNewsUseCase)
    }

    @Test
    fun `getNews updates uiState with news on success`() = runTest(UnconfinedTestDispatcher())  {
        // Test that when the `getNewsUseCase` emits a successful result,
        successGetNews()
        //the `news` state in `_uiState` is updated with the mapped news items and `isLoading` is set to `false`.
        SUT.uiState.test {
            val result = awaitItem()
            assertEquals(result.isLoading, false)
            assertEquals(
                result.news,
                createFakeNewsDTO().asNewsDomainModel().map { it.asNewsUiModel() })
        }
    }

    @Test
    fun `getNews updates uiState with error on failure`() = runTest(UnconfinedTestDispatcher())  {
        // Test that when the `getNewsUseCase` emits an error result,
        failedGetNews()
        //the `error` state in `_uiState` is updated with the mapped error message and `isLoading` is set to `false`.
        SUT.uiState.test {
            val result = awaitItem()
            assertEquals(result.isLoading, false)
            assert(result.error is UiText)
        }
    }


    @Test
    fun `hideErrorDialog clears the error state`() {
        // Check that calling `hideErrorDialog` sets the `error` state in `_uiState` to `null`.
        SUT.hideErrorDialog()
        assertEquals(SUT.uiState.value.error, null)
    }

    private suspend fun successGetNews() {
        whenever(getNewsUseCase.invoke()).then {
            flow { emit(Result.Success(createFakeNewsDTO().asNewsDomainModel())) }
        }
    }

    private suspend fun failedGetNews() {
        whenever(getNewsUseCase.invoke()).then {
            flow { emit(Result.Error(DataError.Remote.SERVER)) }
        }
    }

}