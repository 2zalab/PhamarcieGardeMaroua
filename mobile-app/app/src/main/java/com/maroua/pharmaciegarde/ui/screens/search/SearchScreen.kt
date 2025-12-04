package com.maroua.pharmaciegarde.ui.screens.search

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maroua.pharmaciegarde.R
import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.ui.components.PharmacyCard
import com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel
import com.maroua.pharmaciegarde.util.SubscriptionChecker

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class,
    ExperimentalFoundationApi::class
)
@Composable
fun SearchScreen(
    onPharmacyClick: (Pharmacy) -> Unit,
    onBackClick: () -> Unit,
    viewModel: PharmacyViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val currentUser by authViewModel.currentUser.collectAsStateWithLifecycle()
    val keyboardController = LocalSoftwareKeyboardController.current
    var searchQuery by remember { mutableStateOf("") }
    var sortBy by remember { mutableStateOf("default") }

    val isPremium = SubscriptionChecker.isPremium(currentUser)

    // Actualiser les données au chargement
    LaunchedEffect(Unit) {
        viewModel.refreshPharmacies()
    }

    // Filtrage et tri des pharmacies
    val filteredAndSortedPharmacies = remember(uiState.pharmacies, searchQuery, sortBy) {
        val filtered = if (searchQuery.isBlank()) {
            uiState.pharmacies
        } else {
            uiState.pharmacies.filter { pharmacy ->
                pharmacy.name.contains(searchQuery, ignoreCase = true) ||
                pharmacy.address.contains(searchQuery, ignoreCase = true) ||
                (pharmacy.district?.contains(searchQuery, ignoreCase = true) == true)
            }
        }

        when (sortBy) {
            "name" -> filtered.sortedBy { it.name }
            "district" -> filtered.sortedBy { it.district }
            else -> filtered
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.search_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = {
                    keyboardController?.hide()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            when {
                uiState.isLoading && uiState.pharmacies.isEmpty() -> {
                    LoadingState()
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text(
                                text = stringResource(R.string.pharmacies_found, filteredAndSortedPharmacies.size),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }

                        // Boutons de tri
                        item {
                            SearchSortSelector(
                                currentSort = sortBy,
                                onSortChange = { sortBy = it }
                            )
                        }

                        if (filteredAndSortedPharmacies.isEmpty()) {
                            item {
                                NoResultsState(query = searchQuery)
                            }
                        } else {
                            items(
                                items = filteredAndSortedPharmacies,
                                key = { "search-${it.id}" }
                            ) { pharmacy ->
                                PharmacyCard(
                                    pharmacy = pharmacy,
                                    onClick = { onPharmacyClick(pharmacy) },
                                    modifier = Modifier.animateItem(),
                                    isPremium = isPremium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier,
        placeholder = {
            Text(stringResource(R.string.search_pharmacy))
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = { onQueryChange("") }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            disabledContainerColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = { onSearch() }),
        singleLine = true
    )
}

@Composable
fun SearchSortSelector(
    currentSort: String,
    onSortChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        FilterChip(
            selected = currentSort == "default",
            onClick = { onSortChange("default") },
            label = { Text(stringResource(R.string.sort_by_default)) },
            leadingIcon = if (currentSort == "default") {
                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
            } else null
        )
        FilterChip(
            selected = currentSort == "name",
            onClick = { onSortChange("name") },
            label = { Text(stringResource(R.string.sort_by_name)) },
            leadingIcon = if (currentSort == "name") {
                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
            } else null
        )
        FilterChip(
            selected = currentSort == "district",
            onClick = { onSortChange("district") },
            label = { Text(stringResource(R.string.sort_by_district)) },
            leadingIcon = if (currentSort == "district") {
                { Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(16.dp)) }
            } else null
        )
    }
}

@Composable
fun LoadingState() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun NoResultsState(query: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.SearchOff,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.no_results),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            if (query.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = stringResource(R.string.no_results_for, query),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)
                )
            }
        }
    }
}
