package com.example.myappbar.ui.theme

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappbar.BottomMenuContent
import com.example.myappbar.R

@Composable
fun HomeScreen() {
    Box(modifier= Modifier
        .background(NewBackGround)
        .fillMaxSize()

    )
    {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            GreetingSection()
            ChipSection(chips =listOf("  Nice Body  "," Clean Mind "," Fresh Soul "))
            FamilyBar()
            WorkOut()
            Diet()
            Books()
            Community()
          //  Spirituality()




         }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)


        ) {
            BottomMenu(items= listOf(
                BottomMenuContent("Home", R.drawable.homeicon),
                BottomMenuContent("Date", R.drawable.newcalendar),
                BottomMenuContent("Profile", R.drawable.female),
                BottomMenuContent("Explore", R.drawable.explore),
                BottomMenuContent("Save", R.drawable.bookmark)

            ))
        }


     }
 }


@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor:Color = EndBlue,
    activeTextColor: Color = LightOrange,
    inactiveTextColor : Color = Color.White,
    initialSelectedItemIndex: Int = 0

){
    var selectedItemIndex by remember{
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(EndBlue)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item->
            BottomMenuItem(
                item= item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor

                )
            {
                selectedItemIndex = index
            }

        }
    }

}
@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
            activeHighlightColor:Color = NewBackGround,
    activeTextColor: Color = LightBlue,
    inactiveTextColor : Color = LightBlue,
    onItemClick: () -> Unit
){
    Column (
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.
        clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment =Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)

        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
            tint = if(isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)

                )
        }
        Text(
            text= item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
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
            .padding(15.dp),

        ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier. weight (.5f)
        ) {

            Text(text = "Good Morning, $name",
                style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)

            )
            Text(text = "Welcome To Your Day!",
                style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )

            )

        }
        Icon(imageVector = Icons.Default.Menu, contentDescription =null,modifier=Modifier.padding(horizontal = 25.dp) )


        Icon(imageVector = Icons.Default.Notifications, contentDescription = null,)


    }
}
@Composable
fun ChipSection(
    chips: List<String>
){
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow(){
        items(chips.size){
            Box(
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp, end = 0.dp)

                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) (LightOrange)
                        else (EndBlue)
                    )
                    .padding(15.dp)
            ){
                Text( text= chips[it], color = Color.White)
            }
        }

    }

}
@Composable
fun FamilyBar(
    color: Color= RockPink
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 17.dp)
            .fillMaxWidth()
    ){
        Column(
        )
        {
            Text(text = "Family,",
                style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)


            )
            Text(text = "Check Up On Mum",
                style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )
            )

        }


    }



}
@Composable
fun WorkOut(
    color: Color= RockPink
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 17.dp)
            .fillMaxWidth()
    ){
        Column()
        {
            Text(text = "Work Out,",
                style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)


            )
            Text(text = "Run 10 Kilometres",
                style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )
            )

        }


    }



}

@Composable
fun Diet(
    color: Color= LightOrange
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 17.dp)
            .fillMaxWidth()
    ){
        Column()
        {
            Text(text = "Diet,",
                style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)


            )
            Text(text = "Drink 5 litres Of water",
                style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )
            )

        }


    }



}
@Composable
fun Books(
    color: Color= LightOrange
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,

        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 17.dp)
            .fillMaxWidth()
    ){
        Column()
        {
            Text(text = "Books,",
                style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)


            )
            Text(text = "Shoe Dog,Phil Knight",
                style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )
            )

        }


    }



}
@Composable
fun Community(
    color: Color= LightBlue
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 17.dp,)
            .fillMaxWidth()
    ){
        Column(

        )
        {
            Text(text = "Community,",
                style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)


            )
            Text(text = "Friends hang out At Karura",
                style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )
            )

        }


    }



}
//@Composable
//fun Spirituality(
    //color: Color= LightBlue
//){
    //Row(
      //  verticalAlignment = Alignment.CenterVertically,
     //   horizontalArrangement = Arrangement.SpaceBetween,
      //  modifier = Modifier
        //    .padding(15.dp)
           // .clip(RoundedCornerShape(15.dp))
           // .background(color)
           // .padding(horizontal = 15.dp, vertical = 20.dp)
            //.fillMaxWidth()
    //){
      //  Column()
  //      {
           // Text(text = "Spirituality,",
           //     style = TextStyle(EndBlue,  fontSize = 20.sp, fontWeight = FontWeight.Bold)//


       //     )
       //     Text(text = "Meditate At 8:30 PM",
       //         style = TextStyle(EndBlue, fontSize = 16.sp, fontWeight = FontWeight.Bold )
      //      )

   //     }


  //  }



//}







