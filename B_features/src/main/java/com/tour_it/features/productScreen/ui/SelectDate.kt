package com.tour_it.features.productScreen.ui

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tour_it.features.productScreen.ProductViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectDate(modifier: Modifier = Modifier) {
    val viewModel = koinViewModel<ProductViewModel>()

    var startText by remember {
        mutableStateOf("Start date")
    }
    var endText by remember {
        mutableStateOf("End date")
    }
    var startDate by remember {
        mutableStateOf(LocalDate.now())
    }
    var endDate by remember {
        mutableStateOf(LocalDate.of(LocalDate.now().year, LocalDate.now().month, LocalDate.now().dayOfMonth + 1))
    }
    val formattedStartDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyy")
                .format(startDate)
        }
    }
    val formattedEndDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("MMM dd yyy")
                .format(endDate)
        }
    }
    val dateDialogStateStartDate = rememberMaterialDialogState()
    val dateDialogStateEndDate = rememberMaterialDialogState()

    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9000)),
                onClick = { dateDialogStateStartDate.show() }) {
                Row {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                    Spacer(modifier = modifier.width(8.dp))
                    androidx.compose.material3.Text(text = startText)
                    MaterialDialog(
                        dialogState = dateDialogStateStartDate,
                        buttons = {
                            positiveButton("Ok")
                            negativeButton("Cancel")
                        }
                    ) {
                        datepicker(
                            initialDate = LocalDate.now(),
                            title = "Start date",
                            allowedDateValidator = {
                                !it.isBefore(LocalDate.now())
                            }
                        ){
                            startDate = it
                            startText = it.toString()
                            viewModel.updateStartDate(it)
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF9000)),
                onClick = { dateDialogStateEndDate.show() }) {
                Row {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = null)
                    Spacer(modifier = modifier.width(8.dp))
                    androidx.compose.material3.Text(text = endText)
                    MaterialDialog(
                        dialogState = dateDialogStateEndDate,
                        buttons = {
                            positiveButton("Ok")
                            negativeButton("Cancel")
                        }
                    ) {
                        datepicker(
                            initialDate = LocalDate.now(),
                            title = "End date",
                            allowedDateValidator = {
                                !it.isBefore(startDate)
                            }
                        ){
                            endDate = it
                            endText =  it.toString()
                            viewModel.updateEndDate(it)
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun SelectDatePreview() {
    SelectDate()
}
