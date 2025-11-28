package com.maroua.pharmaciegarde.ui.screens.subscription

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maroua.pharmaciegarde.data.model.SubscriptionPlan
import com.maroua.pharmaciegarde.data.model.SubscriptionPlans
import com.maroua.pharmaciegarde.data.model.SubscriptionType
import com.maroua.pharmaciegarde.ui.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionScreen(
    onNavigateBack: () -> Unit,
    authViewModel: AuthViewModel = hiltViewModel(),
    subscriptionViewModel: SubscriptionViewModel = hiltViewModel()
) {
    val currentUser by authViewModel.currentUser.collectAsStateWithLifecycle()
    val uiState by subscriptionViewModel.uiState.collectAsStateWithLifecycle()

    // Afficher un dialogue de succès
    LaunchedEffect(uiState.isPaymentSuccessful) {
        if (uiState.isPaymentSuccessful) {
            // L'utilisateur peut revenir en arrière après succès
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Choisir un abonnement") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Statut actuel
                item {
                    CurrentSubscriptionCard(
                        currentType = currentUser?.subscriptionType ?: SubscriptionType.FREE,
                        expiryDate = currentUser?.subscriptionExpiryDate
                    )
                }

                // Plans d'abonnement
                items(SubscriptionPlans.getAll()) { plan ->
                    SubscriptionPlanCard(
                        plan = plan,
                        isCurrentPlan = currentUser?.subscriptionType == plan.type,
                        onSelectPlan = {
                            if (plan.type != SubscriptionType.FREE) {
                                subscriptionViewModel.initiatePayment(plan.type)
                            }
                        }
                    )
                }
            }

            // Dialogue de paiement
            if (uiState.showPaymentDialog) {
                PaymentDialog(
                    paymentResponse = uiState.paymentResponse,
                    onDismiss = { subscriptionViewModel.dismissPaymentDialog() },
                    onCheckStatus = { subscriptionViewModel.checkPaymentStatus() }
                )
            }

            // Dialogue de succès
            if (uiState.isPaymentSuccessful) {
                SuccessDialog(
                    onDismiss = {
                        subscriptionViewModel.resetPaymentStatus()
                        onNavigateBack()
                    }
                )
            }

            // Snackbar pour les erreurs
            uiState.error?.let { error ->
                LaunchedEffect(error) {
                    // Afficher un snackbar ou une alerte
                }
                Snackbar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp),
                    action = {
                        TextButton(onClick = { subscriptionViewModel.clearError() }) {
                            Text("OK")
                        }
                    }
                ) {
                    Text(error)
                }
            }

            // Indicateur de chargement
            if (uiState.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = Color.White)
                }
            }
        }
    }
}

@Composable
fun CurrentSubscriptionCard(
    currentType: SubscriptionType,
    expiryDate: Long?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Abonnement actuel",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = when (currentType) {
                        SubscriptionType.FREE -> Icons.Default.Person
                        SubscriptionType.MONTHLY -> Icons.Default.Star
                        SubscriptionType.ANNUAL -> Icons.Default.Stars
                    },
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = when (currentType) {
                        SubscriptionType.FREE -> "Gratuit"
                        SubscriptionType.MONTHLY -> "Mensuel Premium"
                        SubscriptionType.ANNUAL -> "Annuel Premium"
                    },
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            expiryDate?.let { expiry ->
                Text(
                    text = "Expire le: ${java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale.FRANCE).format(java.util.Date(expiry))}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
fun SubscriptionPlanCard(
    plan: SubscriptionPlan,
    isCurrentPlan: Boolean,
    onSelectPlan: () -> Unit
) {
    val isPremium = plan.type != SubscriptionType.FREE
    val gradientColors = if (isPremium) {
        listOf(
            MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
            MaterialTheme.colorScheme.secondary.copy(alpha = 0.1f)
        )
    } else {
        listOf(Color.Transparent, Color.Transparent)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (isPremium) {
                    Modifier.border(
                        width = 2.dp,
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                } else Modifier
            ),
        onClick = { if (!isCurrentPlan) onSelectPlan() },
        enabled = !isCurrentPlan
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(gradientColors)
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // En-tête du plan
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = plan.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = if (isPremium) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                )
                if (isCurrentPlan) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colorScheme.primary
                    ) {
                        Text(
                            text = "Actuel",
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }

            // Prix
            if (plan.price > 0) {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "${plan.price}",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "FCFA / ${plan.duration}",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                    )
                }
            } else {
                Text(
                    text = "0 FCFA",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Divider()

            // Fonctionnalités
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                plan.features.forEach { feature ->
                    FeatureItem(feature)
                }
            }

            // Bouton d'action
            if (!isCurrentPlan) {
                Button(
                    onClick = onSelectPlan,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isPremium) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(
                        text = if (plan.type == SubscriptionType.FREE) "Rester gratuit" else "Choisir ce plan",
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun FeatureItem(feature: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = feature,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun PaymentDialog(
    paymentResponse: com.maroua.pharmaciegarde.data.model.CamPayPaymentResponse?,
    onDismiss: () -> Unit,
    onCheckStatus: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Paiement en cours") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                paymentResponse?.ussdCode?.let { ussdCode ->
                    Text("Composez ce code USSD pour payer:")
                    Text(
                        text = ussdCode,
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .background(MaterialTheme.colorScheme.primaryContainer)
                            .padding(16.dp)
                    )
                }
                paymentResponse?.message?.let { message ->
                    Text(message)
                }
                Text(
                    text = "Référence: ${paymentResponse?.reference}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        },
        confirmButton = {
            Button(onClick = onCheckStatus) {
                Text("Vérifier le paiement")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Annuler")
            }
        }
    )
}

@Composable
fun SuccessDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Color(0xFF4CAF50),
                modifier = Modifier.size(64.dp)
            )
        },
        title = {
            Text(
                text = "Paiement réussi !",
                textAlign = TextAlign.Center
            )
        },
        text = {
            Text(
                text = "Votre abonnement a été activé avec succès. Vous pouvez maintenant profiter de toutes les fonctionnalités premium !",
                textAlign = TextAlign.Center
            )
        },
        confirmButton = {
            Button(
                onClick = onDismiss,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Continuer")
            }
        }
    )
}
