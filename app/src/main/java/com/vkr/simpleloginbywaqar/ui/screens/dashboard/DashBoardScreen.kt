package com.vkr.simpleloginbywaqar.ui.screens.dashboard

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vkr.simpleloginbywaqar.R

@Composable
fun DashboardScreen(
    onNavigateBack: () -> Unit,
    onNavigateToHomeRoute: (String) -> Unit
) {
    val context = LocalContext.current
    Box(modifier = Modifier.background(colorResource(id = R.color.white))) {
        ElevatedCard(
            modifier = Modifier.padding(24.dp, 54.dp, 24.dp, 54.dp)
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                Column(
                    Modifier.padding(12.dp, 18.dp, 12.dp, 0.dp)

                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            modifier = Modifier.weight(0.7f),
                            text = stringResource(R.string.app_name),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Box(modifier = Modifier.weight(0.3f)) {
                            Button(colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(
                                    id = R.color.black
                                )
                            ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                                onClick = {
//                                    setLanguageAndSave(
//                                        context, selectedLanguage.countryCode!!,
//                                        selectedPosition, onNavigateToHomeRoute
//                                    )
                                }) {
                                Text(text = "Select", color = Color.White, fontSize = 12.sp)
                            }
                        }
                    }

                    LazyColumn(modifier = Modifier
                        .padding(0.dp, 20.dp, 0.dp, 0.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                        content = {
                            val list = mutableListOf<String>()
                            itemsIndexed(list) { index, country ->
//                                LanguageItem(
//                                    context = LocalContext.current,
//                                    language = country, position = index
//                                ) { language, position ->
//                                    list.forEach { it.isChecked.value = false }
//                                    list[position].isChecked.value = !list[position].isChecked.value
//                                    selectedPosition = position
//                                    selectedLanguage = list[position]
//                                }
                            }
                        })
                }
            }

        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun Preview() {
    DashboardScreen(onNavigateBack = {}, onNavigateToHomeRoute = {})
}