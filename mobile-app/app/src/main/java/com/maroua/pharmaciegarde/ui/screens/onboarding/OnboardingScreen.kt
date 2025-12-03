package com.maroua.pharmaciegarde.ui.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

data class OnboardingPage(
    val title: String,
    val description: String,
    val icon: ImageVector,
    val gradient: List<Color>
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onFinished: () -> Unit
) {
    val pages = remember {
        listOf(
            OnboardingPage(
                title = "Trouvez facilement",
                description = "Localisez rapidement les pharmacies de garde près de chez vous, 24h/24 et 7j/7",
                icon = Icons.Default.Search,
                gradient = listOf(
                    Color(0xFF667eea),
                    Color(0xFF764ba2)
                )
            ),
            OnboardingPage(
                title = "Carte interactive",
                description = "Visualisez toutes les pharmacies sur une carte interactive avec itinéraires en temps réel",
                icon = Icons.Default.Map,
                gradient = listOf(
                    Color(0xFFf093fb),
                    Color(0xFFF5576C)
                )
            ),
            OnboardingPage(
                title = "Calendrier de garde",
                description = "Consultez le calendrier complet des pharmacies de garde pour planifier à l'avance",
                icon = Icons.Default.CalendarToday,
                gradient = listOf(
                    Color(0xFF4facfe),
                    Color(0xFF00f2fe)
                )
            ),
            OnboardingPage(
                title = "Notifications intelligentes",
                description = "Recevez des alertes personnalisées sur les pharmacies de garde dans votre zone",
                icon = Icons.Default.Notifications,
                gradient = listOf(
                    Color(0xFF43e97b),
                    Color(0xFF38f9d7)
                )
            )
        )
    }

    val pagerState = rememberPagerState(pageCount = { pages.size })
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            OnboardingPageContent(
                page = pages[page],
                modifier = Modifier.fillMaxSize()
            )
        }

        // Bottom section avec indicateurs et boutons
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Indicateurs de page
            Row(
                modifier = Modifier.padding(bottom = 32.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(pages.size) { index ->
                    PageIndicator(
                        isSelected = pagerState.currentPage == index,
                        color = pages[pagerState.currentPage].gradient.first()
                    )
                }
            }

            // Boutons de navigation
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Bouton Passer
                AnimatedVisibility(
                    visible = pagerState.currentPage < pages.size - 1,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    TextButton(
                        onClick = onFinished
                    ) {
                        Text(
                            text = "Passer",
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                // Bouton Suivant/Commencer
                Button(
                    onClick = {
                        if (pagerState.currentPage < pages.size - 1) {
                            scope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        } else {
                            onFinished()
                        }
                    },
                    modifier = Modifier
                        .height(56.dp)
                        .widthIn(min = 140.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = pages[pagerState.currentPage].gradient.first()
                    )
                ) {
                    Text(
                        text = if (pagerState.currentPage < pages.size - 1) "Suivant" else "Commencer",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    if (pagerState.currentPage < pages.size - 1) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingPageContent(
    page: OnboardingPage,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icône avec gradient background
        Box(
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .background(
                    brush = Brush.linearGradient(
                        colors = page.gradient
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = page.icon,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = Color.White
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        // Titre
        Text(
            text = page.title,
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = page.description,
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
fun PageIndicator(
    isSelected: Boolean,
    color: Color
) {
    val width by animateDpAsState(
        targetValue = if (isSelected) 32.dp else 8.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "indicator width"
    )

    Box(
        modifier = Modifier
            .height(8.dp)
            .width(width)
            .clip(RoundedCornerShape(4.dp))
            .background(
                if (isSelected) color else color.copy(alpha = 0.3f)
            )
    )
}
