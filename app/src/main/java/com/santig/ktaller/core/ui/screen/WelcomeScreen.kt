package com.santig.ktaller.core.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R

val DarkBackground = Color(0xFF0A0A0A)
val PrimaryPurple = Color(0xFF6B5DE8)
val TextGray = Color(0xFFA1A1AA)

@Composable
fun WelcomeScreen(
    onClick : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .background(DarkBackground)
            .padding(start = 24.dp, end = 24.dp, top = 40.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_microscope),
            contentDescription = "",
            modifier = Modifier
                .size(80.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Bienvenido a",
            color = Color(0xFF82B1FF),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "KTaller : Gestiona tu taller",
            color = Color.White,
            fontSize = 19.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(top = 4.dp, bottom = 48.dp)
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            FeatureItem(
                image = R.drawable.ic_tool,
                title = "Diseñado para talleres de reparación",
                description = "Diseñado en torno a flujos de trabajo \nreales de reparación: recepción, seguimiento \ny finalización de trabajos sin complicaciones."
            )

            FeatureItem(
                image = R.drawable.ic_person,
                title = "Hecho por un Tecnico de celulares",
                description = "Esta aplicación está desarrollada de forma independiente y recibe mantenimiento activo \ntu experiencia es importante."
            )

            FeatureItem(
                image = R.drawable.ic_mail,
                title = "Tus comentarios ayudan a mejorar la aplicación",
                description = "¿Tienes una idea o encontraste algún problema? Usa el buzón de comentarios en la lista de tickets: cada mensaje es leído."
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Comenzar",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun FeatureItem(
    title: String,
    description: String,
    image: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .padding(top = 2.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = description,
                color = TextGray,
                fontSize = 13.5.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 18.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(onClick = {})
}