package com.santig.ktaller.core.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.santig.ktaller.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    goToSetting: () -> Unit,
    goToAdd: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        ),
        title = {
            Image(
                painter = painterResource(id = R.drawable.ic_microscope),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
            )
        },
        navigationIcon = {},
        actions = {
            IconButton(onClick = goToSetting) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_setting),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
            IconButton(onClick = goToAdd) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_circle),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(32.dp)
                )
            }
        }
    )
}