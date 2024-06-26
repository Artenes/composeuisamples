package dev.artenes.uidesigns

import dev.artenes.uidesigns.android.doubles.ValuesRepositoryDouble
import dev.artenes.uidesigns.core.interfaces.DataRepository
import dev.artenes.uidesigns.core.interfaces.ValuesRepository
import dev.artenes.uidesigns.data.AppRepository
import dev.artenes.uidesigns.data.dao.doubles.SampleDaoDouble
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class)
class TestFixtures {

    val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()
    private val valuesRepository: ValuesRepository
    private val repository: DataRepository

    init {
        valuesRepository = ValuesRepositoryDouble()
        repository = AppRepository(
            SampleDaoDouble(),
            testDispatcher
        )
    }

    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    fun tearDown() {
        Dispatchers.resetMain()
    }

}