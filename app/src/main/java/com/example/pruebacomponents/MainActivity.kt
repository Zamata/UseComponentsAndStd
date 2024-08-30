package com.example.pruebacomponents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.GridCells
import com.example.pruebacomponents.ui.theme.PruebaComponentsTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp



@Composable
fun LazyColumnExample() {
    LazyColumn {
        items(50) { index ->
            Text("Item #$index", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow {
        items(50) { index ->
            Text("Item #$index", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        content = {
            items(9) { index ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Text("Item #$index", modifier = Modifier.padding(16.dp))
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") }
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                Text("Content goes here")
            }
        }
    )
}

@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier.size(100.dp),
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium
    ) {
        Text("Surface content", modifier = Modifier.padding(16.dp))
    }
}


@Composable
fun ChipExample() {
    ElevatedFilterChip(
        selected = false,
        onClick = { /* Handle click */ },
        label = { Text("Chip") }
    )
}

@Composable
fun AlertDialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Show Dialog")
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Alert") },
            text = { Text("This is an alert dialog.") },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun CardExample() {
    Card(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text("Card content", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun CheckboxExample() {
    var checked by remember { mutableStateOf(false) }
    Checkbox(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@Composable
fun FloatingActionButtonExample() {
    FloatingActionButton(
        onClick = { /* Handle click */ }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

@Composable
fun IconExample() {
    Icon(Icons.Default.Favorite, contentDescription = "Favorite")
}

@Composable
fun ImageExample() {
    Image(
        painter = painterResource(id = R.drawable.kirby8b),
        contentDescription = "Sample Image"
    )
}

@Composable
fun ProgressBarExample() {
    CircularProgressIndicator()
}

@Composable
fun RadioButtonExample() {
    var selected by remember { mutableStateOf(false) }
    RadioButton(
        selected = selected,
        onClick = { selected = !selected }
    )
}

@Composable
fun SliderExample() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it }
    )
}

@Composable
fun SpacerExample() {
    Column {
        Text("Text before spacer")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Text after spacer")
    }
}

@Composable
fun SwitchExample() {
    var checked by remember { mutableStateOf(false) }
    Switch(
        checked = checked,
        onCheckedChange = { checked = it }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarExample() {
    TopAppBar(
        title = { Text("My App") },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon press */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        }
    )
}

@Composable
fun BottomNavigationExample() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* Handle click */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
            label = { Text("Favorites") },
            selected = false,
            onClick = { /* Handle click */ }
        )
    }
}

@Composable
fun DialogExample() {
    var showDialog by remember { mutableStateOf(false) }

    Button(onClick = { showDialog = true }) {
        Text("Show Dialog")
    }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 4.dp
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("This is a custom dialog.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { showDialog = false }
                    ) {
                        Text("Close")
                    }
                }
            }
        }
    }
}

@Composable
fun DividerExample() {
    Column {
        Text("Above divider")
        Text("Below divider")
    }
}

@Composable
fun DropDownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    val items = listOf("Item 1", "Item 2", "Item 3")

    Box(modifier = Modifier.wrapContentSize()) {
        Text(
            items[selectedIndex],
            modifier = Modifier.clickable { expanded = true }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        content = {
            items(9) { index ->
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Text("Item #$index", modifier = Modifier.padding(16.dp))
                }
            }
        }
    )
}

@Composable
fun NavigationRailExample() {
    NavigationRail {
        NavigationRailItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = true,
            onClick = { /* Handle click */ }
        )
        NavigationRailItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favorites") },
            label = { Text("Favorites") },
            selected = false,
            onClick = { /* Handle click */ }
        )
    }
}

@Composable
fun OutlinedTextFieldExample() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Enter text") }
    )
}



@Composable
fun SnackbarExample() {
    Snackbar {
        Text("This is a snackbar")
    }
}

@Composable
fun TabRowExample() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")

    TabRow(selectedTabIndex = selectedTabIndex) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = selectedTabIndex == index,
                onClick = { selectedTabIndex = index }
            )
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaComponentsTheme {
                //LazyColumnExample()
                //LazyRowExample()
                //GridExample()
                //ScaffoldExample()
                //SurfaceExample()
                //ChipExample()
                //AlertDialogExample()
                //CardExample()
                //CheckboxExample()
                //FloatingActionButtonExample()
                //IconExample()
                //ImageExample()
                //ProgressBarExample()
                //RadioButtonExample()
                //SliderExample()
                //SpacerExample()
                //SwitchExample()
                //TopAppBarExample()
                //BottomNavigationExample()
                //DialogExample()
                //DividerExample()
                //DropDownMenuExample()
                //LazyVerticalGridExample()
                //NavigationRailExample()
                //OutlinedTextFieldExample()
                //SnackbarExample()
                TabRowExample()
            }
        }
    }
}

