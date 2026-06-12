package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R

@Composable
fun SearchBar(
    onTextChange: (String) -> Unit,
) {
    var query by remember { mutableStateOf("") }
    TextField(
        value = query,
        onValueChange = {
            if (it.length <= 35) query = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 8.dp),
        placeholder = {
            Text(
                text = "Buscar cliente, dispositivo",
                color = Color(0xFF7F8489),
                fontSize = 16.sp
            )
        },
        trailingIcon = {
            IconButton(onClick = { onTextChange(query) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "Search Icon",
                    tint = Color(0xFF7F8489),
                    modifier = Modifier
                        .size(32.dp)
                )
            }
        },
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        ),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF1E1F22),
            unfocusedContainerColor = Color(0xFF1E1F22),
            disabledContainerColor = Color(0xFF1E1F22),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.White
        ),
        singleLine = true
    )
}