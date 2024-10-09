package effectivemobile.aleksey.fakehh.data.network.mappers

import effectivemobile.aleksey.fakehh.data.network.model.AddressDTO
import effectivemobile.aleksey.fakehh.data.network.model.ButtonDTO
import effectivemobile.aleksey.fakehh.data.network.model.ExperienceDTO
import effectivemobile.aleksey.fakehh.data.network.model.InfoScreenDTO
import effectivemobile.aleksey.fakehh.data.network.model.OfferDTO
import effectivemobile.aleksey.fakehh.data.network.model.SalaryDTO
import effectivemobile.aleksey.fakehh.data.network.model.VacancyDTO
import effectivemobile.aleksey.fakehh.domain.models.Address
import effectivemobile.aleksey.fakehh.domain.models.Button
import effectivemobile.aleksey.fakehh.domain.models.Experience
import effectivemobile.aleksey.fakehh.domain.models.InfoScreen
import effectivemobile.aleksey.fakehh.domain.models.Offer
import effectivemobile.aleksey.fakehh.domain.models.Salary
import effectivemobile.aleksey.fakehh.domain.models.Vacancy

internal fun InfoScreenDTO.mapToInfoScreen() = InfoScreen(
    offers = offers.map { offer ->
        offer.mapToOffer()
    },
    vacancies = vacancies.map { vacancy ->
        vacancy.mapToVacancy()
    }
)

internal fun OfferDTO.mapToOffer() = Offer(
    button = button?.mapToButton(),
    id = id,
    link = link,
    title = title
)

internal fun VacancyDTO.mapToVacancy() = Vacancy(
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

internal fun ButtonDTO.mapToButton() = Button(
    text = text
)

internal fun AddressDTO.mapToAddress() = Address(
    house = house,
    street = street,
    town = town
)

internal fun ExperienceDTO.mapToExperience() = Experience(
    previewText = previewText,
    text = text
)

internal fun SalaryDTO.mapToSalary() = Salary(
    full = full,
    short = short
)