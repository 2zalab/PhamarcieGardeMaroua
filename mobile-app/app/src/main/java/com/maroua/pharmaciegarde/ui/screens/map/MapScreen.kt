package com.maroua.pharmaciegarde.ui.screens.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.*
import com.maroua.pharmaciegarde.data.model.Pharmacy
import com.maroua.pharmaciegarde.ui.viewmodel.PharmacyViewModel
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel
import com.maroua.pharmaciegarde.util.SubscriptionChecker
import kotlinx.coroutines.tasks.await
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.launch
import androidx.compose.foundation.background
import androidx.compose.ui.res.stringResource
import androidx.core.app.ActivityCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maroua.pharmaciegarde.R
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
    onPharmacyClick: (Pharmacy) -> Unit,
    onBackClick: () -> Unit,
    onUpgradeClick: () -> Unit = {},
    viewModel: PharmacyViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val currentUser by authViewModel.currentUser.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val canAccessMap = SubscriptionChecker.canAccessMap(currentUser)

    val locationPermissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    var userLocation by remember { mutableStateOf<LatLng?>(null) }
    var selectedPharmacy by remember { mutableStateOf<Pharmacy?>(null) }
    var showNearbyPharmacies by remember { mutableStateOf(false) }
    var isLoadingLocation by remember { mutableStateOf(false) }

    val marouaLocation = LatLng(10.5905, 14.3159)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(marouaLocation, 13f)
    }

    // Charger toutes les pharmacies au démarrage
    LaunchedEffect(Unit) {
        viewModel.loadAllPharmacies()
    }

    // Obtenir la localisation quand les permissions sont accordées
    /*
    LaunchedEffect(locationPermissionsState.allPermissionsGranted) {
        if (locationPermissionsState.allPermissionsGranted && userLocation == null) {
            try {
                val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
                val location = fusedLocationClient.lastLocation.await()
                userLocation = location?.let { LatLng(it.latitude, it.longitude) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
    */
    LaunchedEffect(locationPermissionsState.allPermissionsGranted) {
        if (locationPermissionsState.allPermissionsGranted) {
            val location = getUserLocation(context)
            userLocation = location
        }
    }



    // Fonction pour obtenir la localisation

    // Fonction pour localiser les pharmacies proches
    fun locateNearbyPharmacies() {
        if (locationPermissionsState.allPermissionsGranted) {
            isLoadingLocation = true

            scope.launch {
                try {
                    if (userLocation == null) {
                        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
                        if (locationPermissionsState.allPermissionsGranted) {
                            val location = getUserLocation(context)
                            userLocation = location
                        }
                    }

                    userLocation?.let { location ->
                        viewModel.loadNearbyPharmacies(location.latitude, location.longitude, 5.0)
                        cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 14f)
                        showNearbyPharmacies = true
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    isLoadingLocation = false
                }
            }
        } else {
            locationPermissionsState.launchMultiplePermissionRequest()
        }
    }

    // Fonction pour afficher toutes les pharmacies
    fun showAllPharmacies() {
        showNearbyPharmacies = false
        viewModel.loadAllPharmacies()
        userLocation?.let { location ->
            cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 12f)
        } ?: run {
            cameraPositionState.position = CameraPosition.fromLatLngZoom(marouaLocation, 13f)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (showNearbyPharmacies) stringResource(R.string.nearby_pharmacies)
                        else stringResource(R.string.all_pharmacies)
                    )
                },
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
        },
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Bouton pour centrer sur la position utilisateur
                if (locationPermissionsState.allPermissionsGranted && userLocation != null) {
                    FloatingActionButton(
                        onClick = {
                            userLocation?.let { location ->
                                cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 15f)
                            }
                        },
                        containerColor = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(56.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.MyLocation,
                            contentDescription = stringResource(R.string.my_location),
                            tint = Color.White
                        )
                    }
                }

                // Bouton principal pour basculer entre toutes les pharmacies et les pharmacies proches
                FloatingActionButton(
                    onClick = {
                        if (showNearbyPharmacies) {
                            showAllPharmacies()
                        } else {
                            locateNearbyPharmacies()
                        }
                    },
                    containerColor = if (showNearbyPharmacies) MaterialTheme.colorScheme.secondary
                    else MaterialTheme.colorScheme.primary
                ) {
                    if (isLoadingLocation) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            color = Color.White,
                            strokeWidth = 2.dp
                        )
                    } else {
                        Icon(
                            imageVector = if (showNearbyPharmacies) Icons.Default.Home
                            else Icons.Default.NearMe,
                            contentDescription = if (showNearbyPharmacies) stringResource(R.string.all_pharmacies)
                            else stringResource(R.string.nearby_pharmacies),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (!canAccessMap) {
                // Afficher l'écran verrouillé pour les utilisateurs gratuits
                PremiumLockedMapScreen(onUpgradeClick = onUpgradeClick)
            } else if (locationPermissionsState.allPermissionsGranted) {
                // Carte Google Maps
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState,
                    properties = MapProperties(
                        isMyLocationEnabled = true
                    ),
                    uiSettings = MapUiSettings(
                        zoomControlsEnabled = false,
                        myLocationButtonEnabled = false,
                        compassEnabled = true
                    )
                ) {
                    // Marqueur pour la position de l'utilisateur
                    userLocation?.let { location ->
                        Marker(
                            state = MarkerState(position = location),
                            title = stringResource(R.string.your_location),
                            snippet = stringResource(R.string.you_are_here),
                            icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
                        )
                    }

                    // Marqueurs pour les pharmacies
                    val pharmaciesToShow = if (showNearbyPharmacies) {
                        uiState.nearbyPharmacies
                    } else {
                        uiState.pharmacies
                    }

                    pharmaciesToShow.forEach { pharmacy ->
                        val markerColor = if (pharmacy.isOnDutyToday) {
                            BitmapDescriptorFactory.HUE_RED // Rouge pour les pharmacies de garde
                        } else {
                            BitmapDescriptorFactory.HUE_GREEN // Vert pour les pharmacies normales
                        }

                        Marker(
                            state = MarkerState(
                                position = LatLng(pharmacy.latitude, pharmacy.longitude)
                            ),
                            title = pharmacy.name + if (pharmacy.isOnDutyToday) " 🟢 " + stringResource(R.string.on_duty_badge) else "",
                            snippet = pharmacy.address,
                            icon = BitmapDescriptorFactory.defaultMarker(markerColor),
                            onClick = {
                                selectedPharmacy = pharmacy
                                true
                            }
                        )
                    }
                }

                // Badge indiquant le mode d'affichage
                if (showNearbyPharmacies) {
                    Card(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 16.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .wrapContentWidth()
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                imageVector = Icons.Default.NearMe,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = " " + stringResource(R.string.near_you),
                                color = Color.White,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }

                // Indicateur de compteur de pharmacies
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 16.dp, end = 16.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    ),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    val count = if (showNearbyPharmacies) {
                        uiState.nearbyPharmacies.size
                    } else {
                        uiState.pharmacies.size
                    }
                    Text(
                        text = stringResource(R.string.pharmacy_count, count),
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Medium
                    )
                }

                // Carte détaillée de la pharmacie sélectionnée
                if (selectedPharmacy != null) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        contentAlignment = Alignment.BottomCenter
                    ) {
                        PharmacyMapCard(
                            pharmacy = selectedPharmacy!!,
                            onCloseClick = { selectedPharmacy = null },
                            onDetailsClick = onPharmacyClick
                        )
                    }
                }
            } else {
                // Écran de demande de permission
                PermissionRequestCard(
                    onRequestPermission = {
                        locationPermissionsState.launchMultiplePermissionRequest()
                    }
                )
            }

            // Indicateur de chargement global
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(24.dp),
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = if (showNearbyPharmacies) stringResource(R.string.searching_nearby)
                                else stringResource(R.string.loading_pharmacies),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }

            // Gestion des erreurs
            uiState.error?.let { error ->
                Snackbar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    action = {
                        TextButton(onClick = { viewModel.retry() }) {
                            Text(stringResource(R.string.retry))
                        }
                    }
                ) {
                    Text(text = error)
                }
            }
        }
    }
}

suspend fun getUserLocation(context: Context): LatLng? = suspendCancellableCoroutine { cont ->
    val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
        ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        cont.resume(null)
        return@suspendCancellableCoroutine
    }
    fusedLocationClient.lastLocation.addOnSuccessListener { location ->
        if (location != null) cont.resume(LatLng(location.latitude, location.longitude))
        else cont.resume(null)
    }.addOnFailureListener { cont.resume(null) }
}

@Composable
fun PharmacyMapCard(
    pharmacy: Pharmacy,
    onCloseClick: () -> Unit,
    onDetailsClick: (Pharmacy) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    // Indicateur "DE GARDE"
                    if (pharmacy.isOnDutyToday) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 6.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(8.dp)
                                    .background(Color.Red, shape = RoundedCornerShape(4.dp))
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = stringResource(R.string.on_duty_badge),
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.Red,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Text(
                        text = pharmacy.name,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        text = pharmacy.address,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    // Informations supplémentaires
                    pharmacy.phone?.let { phone ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 6.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Phone,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = phone,
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                IconButton(onClick = onCloseClick) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = stringResource(R.string.close)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onDetailsClick(pharmacy) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(stringResource(R.string.view_details))
            }
        }
    }
}

@Composable
fun PremiumLockedMapScreen(onUpgradeClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    modifier = Modifier.size(72.dp),
                    tint = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = stringResource(R.string.interactive_map),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.map_description),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = stringResource(R.string.premium_feature),
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(
                    onClick = onUpgradeClick,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Icon(imageVector = Icons.Default.Upgrade, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(stringResource(R.string.upgrade_to_premium))
                }

                TextButton(onClick = {}) {
                    Text(
                        text = stringResource(R.string.learn_more_premium),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

@Composable
fun PermissionRequestCard(onRequestPermission: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(64.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = stringResource(R.string.location_permission_required),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.location_permission_message),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = onRequestPermission,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationSearching,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(stringResource(R.string.grant_permission))
                }
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = { /* L'utilisateur peut ignorer */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.skip))
                }
            }
        }
    }
}
