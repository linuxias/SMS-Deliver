package com.linuxias.smsdeliver.ui.addeditfilter

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.linuxias.smsdeliver.repository.FakeFilterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AddEditFilterViewModelTest {
    @get: Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: AddEditFilterViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        viewModel = AddEditFilterViewModel(FakeFilterRepository())
    }
}