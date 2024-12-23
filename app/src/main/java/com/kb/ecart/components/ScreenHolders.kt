package com.kb.ecart.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHolder(
    topBar: @Composable () -> Unit,
    content: @Composable (PaddingValues) -> Unit,
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
    bottomView: @Composable () -> Unit = {},
    snackBarHost: @Composable () -> Unit = {},
    floatingAction: @Composable () -> Unit = {}
) {


    val isVisible = rememberSaveable { mutableStateOf(true) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                // Hide FAB
                if (available.y < -1) {
                    isVisible.value = false
                }

                // Show FAB
                if (available.y > 1) {
                    isVisible.value = true
                }

                return scrollBehavior.nestedScrollConnection.onPreScroll(available, source)

            }
        }
    }



    Surface(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .imePadding()
            .navigationBarsPadding()
            .statusBarsPadding()
    ) {
        Scaffold(
            topBar =   {
                Column(modifier = Modifier.fillMaxWidth()) {
                    topBar()
                }
            },
            content = content,
            bottomBar =
            {
                Column(modifier = Modifier.fillMaxWidth()) {
                    bottomView()
                }
            },
            snackbarHost = snackBarHost
        )
    }
}
