
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

data class FitnessTip(
    val day: Int,
    val title: String,
    val description: String,
    val image: String
)

val fitnessTips = listOf(
    FitnessTip(1, "Commence doucement", "Fais 10 minutes d'exercice pour commencer.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800"),
    FitnessTip(2, "Bois plus d'eau", "Bois régulièrement de l'eau pendant la journée.", "https://images.unsplash.com/photo-1523362628745-0c100150b504?w=800"),
    FitnessTip(3, "Renforce ton corps", "Essaie quelques pompes adaptées à ton niveau.", "https://images.unsplash.com/photo-1598971639058-fab3c3109a00?w=800"),
    FitnessTip(4, "Marche chaque jour", "Marche 15 à 20 minutes en plein air.", "https://images.unsplash.com/photo-1552674605-db6ffd4facb5?w=800"),
    FitnessTip(5, "Mange équilibré", "Ajoute des légumes, des fruits et des protéines à tes repas.", "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800"),
    FitnessTip(6, "Étire-toi", "Fais quelques étirements sans forcer.", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800"),
    FitnessTip(7, "Dors suffisamment", "Essaie de garder des horaires de sommeil réguliers.", "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?w=800"),
    FitnessTip(8, "Travaille tes jambes", "Fais quelques squats avec une bonne technique.", "https://images.unsplash.com/photo-1434596922112-19c563067271?w=800"),
    FitnessTip(9, "Améliore ton endurance", "Fais une petite séance de marche rapide.", "https://images.unsplash.com/photo-1538805060514-97d9cc17730c?w=800"),
    FitnessTip(10, "Garde une bonne posture", "Tiens-toi droit et évite de rester assis trop longtemps.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800"),
    FitnessTip(11, "Entraîne tes abdos", "Essaie une courte séance adaptée à ton niveau.", "https://images.unsplash.com/photo-1566241142559-40e1dab266c6?w=800"),
    FitnessTip(12, "Prends une pause", "Accorde-toi du repos si ton corps est fatigué.", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800"),
    FitnessTip(13, "Bouge davantage", "Prends les escaliers quand cela est possible.", "https://images.unsplash.com/photo-1552674605-db6ffd4facb5?w=800"),
    FitnessTip(14, "Découvre le yoga", "Essaie une posture simple et respire calmement.", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800"),
    FitnessTip(15, "Fixe un objectif", "Choisis un objectif réaliste pour cette semaine.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800"),
    FitnessTip(16, "Entraîne tes bras", "Utilise des exercices adaptés à tes capacités.", "https://images.unsplash.com/photo-1583454110551-21f2fa2afe61?w=800"),
    FitnessTip(17, "Respire calmement", "Prends cinq minutes pour respirer lentement.", "https://images.unsplash.com/photo-1506126613408-eca07ce68773?w=800"),
    FitnessTip(18, "Essaie le vélo", "Fais une sortie à vélo si tu en as la possibilité.", "https://images.unsplash.com/photo-1541625602330-2277e4c46182?w=800"),
    FitnessTip(19, "Échauffe-toi", "Prépare tes muscles avant une séance sportive.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800"),
    FitnessTip(20, "Améliore ta souplesse", "Fais quelques mouvements doux et contrôlés.", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800"),
    FitnessTip(21, "Choisis une activité", "Pratique un sport que tu aimes vraiment.", "https://images.unsplash.com/photo-1538805060514-97d9cc17730c?w=800"),
    FitnessTip(22, "Mange avant de bouger", "Choisis une collation adaptée si tu as faim.", "https://images.unsplash.com/photo-1490645935967-10de6ba17061?w=800"),
    FitnessTip(23, "Améliore ton équilibre", "Essaie de tenir sur un pied près d'un appui stable.", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800"),
    FitnessTip(24, "Fais une pause active", "Lève-toi et bouge quelques minutes régulièrement.", "https://images.unsplash.com/photo-1552674605-db6ffd4facb5?w=800"),
    FitnessTip(25, "Reste régulier", "Une petite séance régulière vaut mieux qu'un effort excessif.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800"),
    FitnessTip(26, "Écoute ton corps", "Arrête-toi si tu ressens une douleur inhabituelle.", "https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800"),
    FitnessTip(27, "Sors en plein air", "Profite d'une promenade dans un endroit agréable.", "https://images.unsplash.com/photo-1552674605-db6ffd4facb5?w=800"),
    FitnessTip(28, "Célèbre tes progrès", "Note les habitudes positives que tu as développées.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800"),
    FitnessTip(29, "Prépare ta semaine", "Planifie tes prochaines séances et tes moments de repos.", "https://images.unsplash.com/photo-1538805060514-97d9cc17730c?w=800"),
    FitnessTip(30, "Continue tes efforts", "Choisis les habitudes que tu veux garder après ces 30 jours.", "https://images.unsplash.com/photo-1517836357463-d25dfeac3438?w=800")
)

private val darkGreen = Color(0xFF174D38)
private val lightGreen = Color(0xFFE8F3EA)
private val accentGreen = Color(0xFF39845B)
private val pageBackground = Color(0xFFF5F8F3)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                FitnessApp()
            }
        }
    }
}

@Composable
fun FitnessApp() {
    Scaffold(
        containerColor = pageBackground,
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(darkGreen)
                    .padding(20.dp)
            ) {
                Text(
                    text = "30 DAYS OF FITNESS",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Petits efforts, grands résultats !",
                    fontSize = 14.sp,
                    color = Color(0xFFD8EBDD)
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Ton programme de 30 jours",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = darkGreen
                )
                Text(
                    text = "Découvre un nouveau conseil chaque jour.",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }

            items(fitnessTips, key = { it.day }) { tip ->
                FitnessCard(tip)
            }

            item {
                Text(
                    text = "Bravo ! Un petit pas chaque jour fait la différence.",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = darkGreen,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
        }
    }
}

@Composable
fun FitnessCard(tip: FitnessTip) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {
        Column {
            AsyncImage(
                model = tip.image,
                contentDescription = tip.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.Top
            ) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = accentGreen
                ) {
                    Text(
                        text = "Jour ${tip.day}",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        modifier = Modifier.padding(
                            horizontal = 12.dp,
                            vertical = 8.dp
                        )
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = tip.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = darkGreen
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = tip.description,
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        color = Color(0xFF444444)
                    )
                }
            }
        }
    }
}
