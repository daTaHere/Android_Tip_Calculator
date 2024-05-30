package com.example.tiptime.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.tiptime.R
import com.example.tiptime.components.FieldComponent
import com.example.tiptime.components.RoundUpSwitchComponent
import com.example.tiptime.components.TipAmountTextComponent

@Composable
fun TipCalculatorScreen() {
    // bill amount state
    var amountInput by rememberSaveable {
        mutableStateOf("")
    }

    // tip percentage state
    var tipInput by rememberSaveable {
        mutableStateOf("")
    }

    // round up state
    var roundUp by rememberSaveable {
        mutableStateOf(false)
    }

    // convert input state String type to Double or return 0.0 as default
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        FieldComponent(
            label = R.string.bill_amount,
            value = amountInput,
            leadingIcon = R.drawable.money,
            onValueChange = { newState -> amountInput = newState },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
            ,
        )
        FieldComponent(
            label = R.string.how_was_the_service,
            value = tipInput,
            leadingIcon = R.drawable.percent,
            onValueChange = { tipInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
            ,
        )
        RoundUpSwitchComponent(
            roundUp = roundUp,
            onRoundUpChange = { roundUp = it; Log.d("switch","$roundUp") },
            modifier = Modifier.padding(bottom = 32.dp),
        )
        TipAmountTextComponent(amount = amount, tipPercent = tipPercent, roundUp = roundUp)

        Spacer(modifier = Modifier.height(150.dp))
    }
}