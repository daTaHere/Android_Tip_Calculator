package com.example.tiptime.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tiptime.R
import com.example.tiptime.calculateTip

// toggle switch to round tip total on and off
@Composable
fun RoundUpSwitchComponent(
    roundUp: Boolean,
    onRoundUpChange: (Boolean)-> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            textAlign = TextAlign.Left,
            text = stringResource(id = R.string.round_up_tip)
        )
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .testTag("RoundUpSwitch"),
            checked = roundUp,
            onCheckedChange = onRoundUpChange)
    }
}

// input field component
@Composable
fun FieldComponent(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    value: String,
    onValueChange: (String)-> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = { Icon(painter = painterResource(leadingIcon), null) },
        label = {Text(stringResource(label))},
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = modifier,
    )
}

// calculate and render tip total and render
@Composable
fun TipAmountTextComponent( amount: Double, tipPercent: Double, roundUp: Boolean ) {
    val tip = calculateTip(amount = amount, tipPercent = tipPercent, roundup = roundUp)
    Text(
        text = stringResource(R.string.tip_amount, tip),
        style = MaterialTheme.typography.displaySmall
    )
}