package com.santig.ktaller.features.home.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    title: String,
    holder : String,
    isNumeric: Boolean = false,
    onTextChange: (String) -> Unit
) {
    var query by remember { mutableStateOf("") }
    Text(
        text = title,
        color = Color.White,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    )
    Spacer(modifier = Modifier.height(10.dp))
    OutlinedTextField(
        value = query,
        onValueChange = {
            if (it.length <= 35){
                query = it
                onTextChange(it)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 8.dp),
        placeholder = {
            Text(
                text = holder,
                color = Color(0xFF7F8489),
                fontSize = 16.sp
            )
        },
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.W400
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isNumeric) {
                KeyboardType.Number
            } else {
                KeyboardType.Text
            }
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