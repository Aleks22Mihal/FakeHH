package effectivemobile.aleksey.fakehh.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_vacancy")
internal data class VacancyDBO(
    @PrimaryKey
    val id: String,
    @Embedded
    val address: AddressDBO,
    @ColumnInfo(name = "appliedNumber")
    val appliedNumber: Int?,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "description")
    val description: String?,
    @Embedded
    val experience: ExperienceDBO,
    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean,
    @ColumnInfo(name = "lookingNumber")
    val lookingNumber: Int?,
    @ColumnInfo(name = "publishedDate")
    val publishedDate: String,
    @ColumnInfo(name = "questions")
    val questions: List<String>,
    @ColumnInfo(name = "responsibilities")
    val responsibilities: String,
    @Embedded()
    val salary: SalaryDBO,
    @ColumnInfo(name = "schedules")
    val schedules: List<String>,
    @ColumnInfo(name = "title")
    val title: String
)