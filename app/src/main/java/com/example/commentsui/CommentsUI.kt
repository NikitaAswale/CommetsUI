package com.example.commentsui

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CommentsUI(viewModel: PostViewModel = viewModel())
{

    val post by viewModel.post.collectAsState()

    //top part

    Column(modifier = Modifier.fillMaxSize().padding(24.dp))
    {
        Row(modifier = Modifier.fillMaxWidth())
        {
            Icon(Icons.Default.ArrowBack, contentDescription = "")

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                "Comments",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End)
            {
                Icon(Icons.Default.MoreVert, contentDescription = "")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //Middle part
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {

            items(post) { postItem ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 14.dp,
                            bottom = 10.dp,
                            start = 10.dp,
                            end = 10.dp
                        ),
                    elevation = CardDefaults.cardElevation(2.dp),
                    shape = RoundedCornerShape(18.dp)
                )
                {
                    Column(modifier = Modifier.fillMaxWidth())
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(18.dp),
                            verticalAlignment = Alignment.Top
                        )
                        {
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "",
                                modifier = Modifier.size(70.dp).clip(CircleShape)
                                    .background(color = Color.Black)
                            )

                            Spacer(Modifier.width(16.dp))

                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = "${postItem.name}",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = "${postItem.email}",
                                    color = Color.Blue,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal
                                )

                                Spacer(modifier = Modifier.height(10.dp))

                                Text(
                                    "${postItem.body}",
                                    color = Color.Gray,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal
                                )

                            }
                        }

                    }
                }
            }
        }

        //bottom

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue))
        {
            Text("Post a comment",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White)
        }
    }
}