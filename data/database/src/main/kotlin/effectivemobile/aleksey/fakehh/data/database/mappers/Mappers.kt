package effectivemobile.aleksey.fakehh.data.database.mappers

import effectivemobile.aleksey.fakehh.data.database.models.AddressDBO
import effectivemobile.aleksey.fakehh.data.database.models.ExperienceDBO
import effectivemobile.aleksey.fakehh.data.database.models.SalaryDBO
import effectivemobile.aleksey.fakehh.data.database.models.VacancyDBO
import effectivemobile.aleksey.fakehh.domain.models.Address
import effectivemobile.aleksey.fakehh.domain.models.Experience
import effectivemobile.aleksey.fakehh.domain.models.Salary
import effectivemobile.aleksey.fakehh.domain.models.Vacancy

internal fun VacancyDBO.mapToOffer() = Vacancy(
    address = address.mapToAddress(),
    appliedNumber = appliedNumber,
    company = company,
    description = description,
    experience = experience.mapToExperience(),
    id = id,
    isFavorite = isFavorite,
    lookingNumber = lookingNumber,
    publishedDate = publishedDate,
    questions = questions,
    responsibilities = responsibilities,
    salary = salary.mapToSalary(),
    schedules = schedules,
    title = title
)


internal fun AddressDBO.mapToAddress() = Address(
    house = house,
    street = street,
    town = town
)

internal fun ExperienceDBO.mapToExperience() = Experience(
    previewText = previewText,
    text = text
)

internal fun SalaryDBO.mapToSalary() = Salary(
    full = full,
    short = short
)

internal fun Vacancy.mapToVacancyDBO() = VacancyDBO(
    address = address.mapToAddressDBO(),
    appliedNumber = appliedNumber,
    company = company,
    description = description,
    experience = experience.mapToExperienceDBO(),
    id = id,
    isFavorite = isFavorite,
    lookingNumber = lookingNumber,
    publishedDate = publishedDate,
    questions = questions,
    responsibilities = responsibilities,
    salary = salary.mapToSalaryDBO(),
    schedules = schedules,
    title = title
)

internal fun Address.mapToAddressDBO() = AddressDBO(
    house = house,
    street = street,
    town = town
)

internal fun Experience.mapToExperienceDBO() = ExperienceDBO(
    previewText = previewText,
    text = text
)

internal fun Salary.mapToSalaryDBO() = SalaryDBO(
    full = full,
    short = short
)