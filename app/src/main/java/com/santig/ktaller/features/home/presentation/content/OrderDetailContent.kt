package com.santig.ktaller.features.home.presentation.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.santig.ktaller.R
import com.santig.ktaller.features.home.domain.model.RepairOrder
import com.santig.ktaller.features.home.presentation.components.IconBackWithText
import com.santig.ktaller.features.home.presentation.components.StepsProgress
import com.santig.ktaller.features.home.presentation.viewmodel.event.OrderDetailEvent
import com.santig.ktaller.features.home.presentation.viewmodel.state.OrderDetailUiState

@Composable
fun OrderDetailContent(
    onBack: () -> Unit,
    order: RepairOrder,
    uiState: OrderDetailUiState,
    onEvent: (OrderDetailEvent) -> Unit,
    onClickBookmark: (Boolean) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
            .navigationBarsPadding()
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconBackWithText(
            title = "Detalle de la orden",
            onBackClick = onBack
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp, vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "#${order.id}",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                        maxLines = 1
                    )
                    Text(
                        text = order.createdAt,
                        color = Color(0xFF7F8489),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W400,
                        maxLines = 1
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            color = Color.Green.copy(0.7f),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "Pagado",
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W400
                    )
                }
            }
        }
        StepsProgress(order = order)
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Cliente",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Start,
                maxLines = 1,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(
                    if (order.save) {
                        R.drawable.ic_bookmark_fill
                    } else R.drawable.ic_bookmark
                ),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable(onClick = { onClickBookmark(!order.save) })
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Nombre : ${order.clientName}",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Start,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Dispositivo : ${order.device}",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Start,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Costo de reparacion : $${order.price}",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Start,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "Descripcion : ${order.description}",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400,
            textAlign = TextAlign.Start,
            maxLines = 5,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 50.dp)
                .background(color = Color.White, shape = RoundedCornerShape(0.dp)),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            shape = RoundedCornerShape(0.dp)
        ) {
            Text(
                text = "Guardar",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = {
                onEvent(OrderDetailEvent.OnAdvanceStatus(order))
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 50.dp)
                .border(width = 1.dp, color = Color.White),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            border = BorderStroke(width = 1.dp, color = Color.White),
            shape = RoundedCornerShape(0.dp)
        ) {
            if (uiState.loadingUpdate) {
                CircularProgressIndicator(
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize()
                )
            } else {
                Text(
                    text = "Cambiar progreso",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                )
            }
        }
        Spacer(modifier = Modifier.height(25.dp))
    }
}