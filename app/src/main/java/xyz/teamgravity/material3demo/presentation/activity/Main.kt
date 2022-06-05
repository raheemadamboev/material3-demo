package xyz.teamgravity.material3demo.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import xyz.teamgravity.material3demo.R
import xyz.teamgravity.material3demo.presentation.component.CardImage
import xyz.teamgravity.material3demo.presentation.theme.Material3DemoTheme
import xyz.teamgravity.material3demo.presentation.viewmodel.MainViewModel

class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = rememberTopAppBarScrollState()
                    val scroll = remember { TopAppBarDefaults.enterAlwaysScrollBehavior(state) }
                    val viewmodel = viewModel<MainViewModel>()

                    Scaffold(
                        topBar = {
                            SmallTopAppBar(
                                title = {
                                    Text(text = stringResource(id = R.string.images))
                                },
                                actions = {
                                    IconButton(onClick = viewmodel::onHeartCheckedChange) {
                                        Icon(
                                            imageVector = if (viewmodel.heartChecked) Icons.Filled.Favorite else Icons.Default.FavoriteBorder,
                                            contentDescription = stringResource(id = R.string.cd_favorite)
                                        )
                                    }
                                },
                                scrollBehavior = scroll,
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = stringResource(id = R.string.cd_add),
                                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                        },
                        modifier = Modifier.nestedScroll(scroll.nestedScrollConnection)
                    ) { padding ->
                        LazyColumn(contentPadding = padding) {
                            items(20) {
                                CardImage(
                                    title = stringResource(id = R.string.demo_title),
                                    description = stringResource(id = R.string.demo_description)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}