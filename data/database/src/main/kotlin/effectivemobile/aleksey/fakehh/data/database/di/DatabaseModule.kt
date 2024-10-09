package effectivemobile.aleksey.fakehh.data.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import effectivemobile.aleksey.fakehh.data.database.AppDatabase
import effectivemobile.aleksey.fakehh.data.database.AppDatabaseDao
import effectivemobile.aleksey.fakehh.data.database.repository.DatabaseRepositoryImpl
import effectivemobile.aleksey.fakehh.domain.repository.DatabaseRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "AppDataBase"
    ).build()

    @Singleton
    @Provides
    fun provideAppDao(database: AppDatabase) = database.databaseDao()

    @Singleton
    @Provides
    fun provideDataBaseRepository(databaseDao: AppDatabaseDao): DatabaseRepository {
        return DatabaseRepositoryImpl(databaseDao)
    }
}