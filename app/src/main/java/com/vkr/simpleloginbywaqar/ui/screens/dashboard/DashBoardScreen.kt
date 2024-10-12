package com.vkr.simpleloginbywaqar.ui.screens.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.vkr.simpleloginbywaqar.ui.data.AssociatedDrug
import com.vkr.simpleloginbywaqar.ui.data.Data
import com.vkr.simpleloginbywaqar.ui.data.Diabetes

@Composable
fun DashboardScreen(
    onNavigateToAuthenticatedRoute: () -> Unit
) {
    val context = LocalContext.current

    val dashboardVM by remember {
        mutableStateOf(Data())
    }

    if (dashboardVM.problems?.isEmpty() == true) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.white))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                )

                Text(
                    text = stringResource(R.string.fetching_data_please_wait),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(12.dp, 64.dp, 12.dp, 0.dp)
                )
            }
        }

    } else {
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
                                        onNavigateToAuthenticatedRoute.invoke()
                                    }) {
                                    Text(text = "Logout", color = Color.White, fontSize = 12.sp)
                                }
                            }
                        }
                        //For Diabetes Medications
                        dashboardVM.problems!![0].Diabetes?.forEach {
                            DisplayMedications(it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DisplayMedications(diabetes: Diabetes) {
    val medicationList = mutableListOf<AssociatedDrug>()

    diabetes.medications?.forEach { medication ->
        medication.medicationsClasses?.forEach { medClass ->
            medClass.className?.forEach { className ->
                medicationList.addAll(className.associatedDrug)
                medicationList.addAll(className.associatedDrug2)
            }
            medClass.className2?.forEach { className2 ->
                medicationList.addAll(className2.associatedDrug)
                medicationList.addAll(className2.associatedDrug2)
            }
        }
    }
    MedicationList(medications = medicationList)
}


@Composable
fun MedicationList(medications: List<AssociatedDrug>) {
    LazyColumn(modifier = Modifier
        .padding(0.dp, 20.dp, 0.dp, 0.dp)
        .fillMaxHeight()
        .fillMaxWidth(),
        content = {
            itemsIndexed(medications) { _, medication ->
                DashBoardItem(medication = medication)
            }
        })
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun Preview() {
    DashboardScreen(onNavigateToAuthenticatedRoute = {})
}