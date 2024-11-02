package com.example.homescreen


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ChildDestinationTopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    title: String
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = title)
        },
        navigationIcon =
        {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.cd_navigate_up)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue)
    )
}

@Preview(showBackground = true)
@Composable
fun ChildDestinationTopBarPreview() {
    ChildDestinationTopBar(
        onNavigateUp = {},
        title = stringResource(R.string.cd_navigate_up)
    )
}