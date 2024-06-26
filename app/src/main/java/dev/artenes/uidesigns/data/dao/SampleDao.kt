package dev.artenes.uidesigns.data.dao

import androidx.room.Dao
import androidx.room.Insert
import dev.artenes.uidesigns.data.SampleEntity

@Dao
interface SampleDao {

    @Insert
    fun save(entity: SampleEntity)

}