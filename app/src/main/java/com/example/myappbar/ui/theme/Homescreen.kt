package com.example.myappbar.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
 fun HomeScreen() {
     Box(modifier= Modifier
         .background(Color.Transparent)
         .fillMaxSize()

     )
     {
         Column {
        GreetingSection()


         }
     }
 }
@Composable
fun GreetingSection(
    name: String = "Noah"
){
  Row(
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
          .fillMaxWidth()
          .padding(15.dp)
  ) {
      Column(
          verticalArrangement = Arrangement.Center
      ) {
          Text(text = "Good Morning, $name",
              style = TextStyle(Color.Black,  fontSize = 20.sp, fontWeight = FontWeight.Bold)


          )
          Text(text = "Have a fabulous day",
              style = TextStyle(Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold )

          )

      }

  }
}