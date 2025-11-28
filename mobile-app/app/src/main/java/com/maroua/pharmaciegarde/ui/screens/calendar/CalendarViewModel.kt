package com.maroua.pharmaciegarde.ui.screens.calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maroua.pharmaciegarde.data.model.CalendarViewMode
import com.maroua.pharmaciegarde.data.model.PharmacySchedule
import com.maroua.pharmaciegarde.data.repository.PharmacyRepository
import com.maroua.pharmaciegarde.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

data class CalendarUiState(
    val viewMode: CalendarViewMode = CalendarViewMode.DAY,
    val selectedDate: Date = Date(),
    val schedules: List<PharmacySchedule> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val repository: PharmacyRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CalendarUiState())
    val uiState: StateFlow<CalendarUiState> = _uiState.asStateFlow()

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    private val displayDateFormat = SimpleDateFormat("EEEE dd MMMM yyyy", Locale("fr", "FR"))
    private val dayNameFormat = SimpleDateFormat("EEEE", Locale("fr", "FR"))

    init {
        loadSchedulesForCurrentDate()
    }

    /**
     * Change le mode d'affichage (jour/semaine/mois)
     */
    fun setViewMode(mode: CalendarViewMode) {
        _uiState.value = _uiState.value.copy(viewMode = mode)
        when (mode) {
            CalendarViewMode.DAY -> loadSchedulesForDay(_uiState.value.selectedDate)
            CalendarViewMode.WEEK -> loadSchedulesForWeek(_uiState.value.selectedDate)
            CalendarViewMode.MONTH -> loadSchedulesForMonth(_uiState.value.selectedDate)
        }
    }

    /**
     * Change la date sélectionnée
     */
    fun selectDate(date: Date) {
        _uiState.value = _uiState.value.copy(selectedDate = date)
        loadSchedulesForCurrentDate()
    }

    /**
     * Navigue au jour précédent/suivant
     */
    fun navigateDay(forward: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.time = _uiState.value.selectedDate
        calendar.add(Calendar.DAY_OF_MONTH, if (forward) 1 else -1)
        selectDate(calendar.time)
    }

    /**
     * Navigue à la semaine précédente/suivante
     */
    fun navigateWeek(forward: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.time = _uiState.value.selectedDate
        calendar.add(Calendar.WEEK_OF_YEAR, if (forward) 1 else -1)
        selectDate(calendar.time)
    }

    /**
     * Navigue au mois précédent/suivant
     */
    fun navigateMonth(forward: Boolean) {
        val calendar = Calendar.getInstance()
        calendar.time = _uiState.value.selectedDate
        calendar.add(Calendar.MONTH, if (forward) 1 else -1)
        selectDate(calendar.time)
    }

    /**
     * Retourne à aujourd'hui
     */
    fun goToToday() {
        selectDate(Date())
    }

    private fun loadSchedulesForCurrentDate() {
        when (_uiState.value.viewMode) {
            CalendarViewMode.DAY -> loadSchedulesForDay(_uiState.value.selectedDate)
            CalendarViewMode.WEEK -> loadSchedulesForWeek(_uiState.value.selectedDate)
            CalendarViewMode.MONTH -> loadSchedulesForMonth(_uiState.value.selectedDate)
        }
    }

    /**
     * Charge les pharmacies de garde pour un jour
     */
    private fun loadSchedulesForDay(date: Date) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            // Pour l'instant, on va chercher les pharmacies de garde du jour
            // TODO: Implémenter l'API pour récupérer les pharmacies de garde par date
            when (val result = repository.getOnDutyPharmacies()) {
                is Result.Success -> {
                    val schedule = PharmacySchedule(
                        date = dateFormat.format(date),
                        pharmacies = result.data,
                        dayOfWeek = dayNameFormat.format(date).capitalize(Locale.getDefault())
                    )
                    _uiState.value = _uiState.value.copy(
                        schedules = listOf(schedule),
                        isLoading = false
                    )
                }
                is Result.Error -> {
                    _uiState.value = _uiState.value.copy(
                        error = result.message,
                        isLoading = false
                    )
                }
                is Result.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
            }
        }
    }

    /**
     * Charge les pharmacies de garde pour une semaine
     */
    private fun loadSchedulesForWeek(date: Date) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            val calendar = Calendar.getInstance()
            calendar.time = date

            // Se positionner au début de la semaine (lundi)
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)

            val schedules = mutableListOf<PharmacySchedule>()

            // Charger les 7 jours de la semaine
            for (i in 0..6) {
                when (val result = repository.getOnDutyPharmacies()) {
                    is Result.Success -> {
                        val schedule = PharmacySchedule(
                            date = dateFormat.format(calendar.time),
                            pharmacies = result.data,
                            dayOfWeek = dayNameFormat.format(calendar.time).capitalize(Locale.getDefault())
                        )
                        schedules.add(schedule)
                    }
                    is Result.Error -> {
                        _uiState.value = _uiState.value.copy(
                            error = result.message,
                            isLoading = false
                        )
                        return@launch
                    }
                    is Result.Loading -> {}
                }
                calendar.add(Calendar.DAY_OF_MONTH, 1)
            }

            _uiState.value = _uiState.value.copy(
                schedules = schedules,
                isLoading = false
            )
        }
    }

    /**
     * Charge les pharmacies de garde pour un mois
     */
    private fun loadSchedulesForMonth(date: Date) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)

            val calendar = Calendar.getInstance()
            calendar.time = date

            // Se positionner au début du mois
            calendar.set(Calendar.DAY_OF_MONTH, 1)

            val schedules = mutableListOf<PharmacySchedule>()
            val maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)

            // Charger tous les jours du mois
            for (day in 1..maxDays) {
                calendar.set(Calendar.DAY_OF_MONTH, day)

                when (val result = repository.getOnDutyPharmacies()) {
                    is Result.Success -> {
                        val schedule = PharmacySchedule(
                            date = dateFormat.format(calendar.time),
                            pharmacies = result.data,
                            dayOfWeek = dayNameFormat.format(calendar.time).capitalize(Locale.getDefault())
                        )
                        schedules.add(schedule)
                    }
                    is Result.Error -> {
                        _uiState.value = _uiState.value.copy(
                            error = result.message,
                            isLoading = false
                        )
                        return@launch
                    }
                    is Result.Loading -> {}
                }
            }

            _uiState.value = _uiState.value.copy(
                schedules = schedules,
                isLoading = false
            )
        }
    }

    fun retry() {
        loadSchedulesForCurrentDate()
    }

    fun getFormattedDate(date: Date): String {
        return displayDateFormat.format(date)
    }
}
