package com.example.onecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onecard.ui.theme.OnecardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OnecardTheme {
                val player1 = Player(
                    listOf(
                        Card(CardType.Club, 2),
                        Card(CardType.Heart, 3),
                        Card(CardType.Spade, 4),
                        Card(CardType.Heart, 5),
                        Card(CardType.Spade, 6),
                        Card(CardType.Club, 7),
                        Card(CardType.Heart, 8),
                    )
                )

                val player2 = Player(
                    listOf(
                        Card(CardType.Club, 2),
                        Card(CardType.Heart, 3),
                        Card(CardType.Spade, 4),
                        Card(CardType.Heart, 5),
                        Card(CardType.Spade, 6),
                        Card(CardType.Club, 7),
                        Card(CardType.Heart, 8),
                    )
                )
                Column() {
                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        player1.cards.forEach { card: Card ->
                                Card(resId = card.getDrawable())
                        }
                    }

                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(modifier = Modifier.weight(1f))
                        Card(R.drawable.card_back)
                        Box(modifier = Modifier.weight(1f))
                        Card(R.drawable.diamonds_11)
                        Box(modifier = Modifier.weight(1f))
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                        player1.cards.forEach { card: Card ->
                            Card(resId = card.getDrawable())
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun RowScope.Card(@DrawableRes resId: Int) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = null,
        modifier = Modifier
            .weight(1f)
            .height(90.dp),
        contentScale = ContentScale.Fit
    )
}