package dev.artenes.uidesigns.data

import dev.artenes.uidesigns.data.dao.SampleDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class AppRepository @Inject constructor(
    private val sampleDao: SampleDao,
    private val dispatcher: CoroutineContext = Dispatchers.IO
) {

    fun seedForTests() {
        //seed database for tests
    }

    fun wipeData() {
        //wipe all data
    }

    suspend fun save(entity: SampleEntity) {
        withContext(dispatcher) {

        }
    }

}