package com.anucodes.d4capplication

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anucodes.d4capplication.model.ProductInfo
import com.anucodes.d4capplication.ui.theme.montserratFamily
import com.anucodes.d4capplication.ui.theme.poppinsFamily


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopFlowScreen(
    modifier: Modifier = Modifier
) {

    var productList: List<ProductInfo> = emptyList()

    for(i in 0..20){
        productList += ProductInfo(
            productImage = R.drawable.categorysample,
            title = "Clencera",
            summary = "French clay and algae-powered cleanser",
            features = "Skin Tightness * Dry & Dehydrated Skin",
            price = 444.00,
            revisedPrice = 355.20,
            ratingStar = 5.0,
            ratedBy = 294,
            isBestSeller = true,
            isInStock = true,
            isFavorite = true
        )

        productList += ProductInfo(
            productImage = R.drawable.productimage,
            title = "Glow",
            summary = "French clay and algae-powered cleanser",
            features = "Skin Tightness * Dry & Dehydrated Skin",
            price = 444.00,
            revisedPrice = 355.20,
            ratingStar = 5.0,
            ratedBy = 249,
            isBestSeller = false,
            isInStock = true,
            isFavorite = false
        )
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .background(color = Color.DarkGray)
    ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )

            Text(
                text = "Shop",
                fontSize = 30.sp,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.White
            )

            Row {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )

                Spacer(modifier = modifier.width(15.dp))

                Box {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorites",
                        tint = Color.White
                    )

                    Badge(count = 5)
                }

                Spacer(modifier = modifier.width(15.dp))

                Box {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Cart",
                        tint = Color.White
                    )

                    Badge(count = 3)
                }
            }
        }

        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {

            Image(
                modifier = modifier
                    .fillMaxWidth()
                    .matchParentSize(),
                painter = painterResource(id = R.drawable.shopflowcard1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )

            Column(
                modifier = modifier
                    .padding(vertical = 50.dp, horizontal = 30.dp)
            ){
                Text(
                    text = "GET 20% OFF",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Get 20% off",
                    color = Color.White.copy(alpha = 0.6f)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .background(Color(0xFFB2FF59), RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        "12-16 October",
                        color = Color.Black,
                        fontSize = 12.sp)
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "New products",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontFamily = montserratFamily
            )

            Text(
                text = "See all",
                fontSize = 14.sp,
                fontFamily = montserratFamily,
                color = Color.White.copy(alpha = 0.6f)
            )

        }

        LazyColumn {
            items(productList){product->
                ProductTile(
                    productInfo = product
                )
            }
        }
    }
}

@Composable
fun ProductTile(
    modifier: Modifier = Modifier,
    productInfo: ProductInfo
) {
        Box(
            modifier = modifier
                .padding(15.dp)
        ){

            Image(
                modifier = modifier
                    .matchParentSize(),
                painter = painterResource(id = R.drawable.cardgreybgpng),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row (
                    modifier = modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column (
                        modifier = modifier
                            .padding(end = 10.dp, bottom = 10.dp)
                            .size(45.dp)
                            .background(color = Color.Black, shape = CircleShape),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        if (productInfo.isFavorite){
                            Icon(
                                modifier = modifier
                                    .background(color = Color.Transparent),
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorite",
                                tint = Color(0xFFB7A7F2)
                            )
                        }else{
                            Icon(
                                modifier = modifier
                                    .background(color = Color.Transparent),
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = Color(0xFFB7A7F2)
                            )
                        }
                    }
                    if (productInfo.isBestSeller) {
                        Text(
                            text = "Best seller",
                            color = Color.White,
                            fontSize = 14.sp,
                            modifier = Modifier
                                .background(Color.Black, RoundedCornerShape(15.dp))
                                .padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }
                }
                Image(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    contentScale = ContentScale.FillWidth,
                    painter = painterResource(productInfo.productImage),
                    contentDescription = "product image"
                )
                Box(
                    modifier = modifier
                        .padding(10.dp)
                ){
                    Image(
                        modifier = modifier
                            .matchParentSize(),
                        contentScale = ContentScale.FillBounds,
                        painter = painterResource(R.drawable.cardblackshape),
                        contentDescription = "black bg"
                    )

                    Column(
                        modifier = modifier
                            .padding(15.dp)
                    ){
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = productInfo.title,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB7EC43),
                                fontSize = 16.sp,
                                fontFamily = montserratFamily
                            )
                            Text(
                                text = if (productInfo.isInStock) "• In stock" else "• Out of stock",
                                color = if (productInfo.isInStock) Color(0xFFB7EC43) else Color.Red,
                                fontSize = 12.sp
                            )
                        }
                        Spacer(modifier.height(5.dp))
                        Text(
                            text = productInfo.summary,
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier.height(5.dp))
                        Text(
                            modifier = modifier.padding(bottom = 10.dp),
                            text = productInfo.features,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppinsFamily,
                            color = Color.White
                        )
                        Spacer(modifier.height(5.dp))

                        Row {
                            Text(
                                text = "RS. ${productInfo.revisedPrice}",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFB7A2F1)
                            )

                            Spacer(modifier.width(5.dp))

                            Text(
                                text = "RS. ${productInfo.price}",
                                fontSize = 18.sp,
                                textDecoration = TextDecoration.LineThrough,
                                color = Color.Gray
                            )
                        }
                        Spacer(modifier.height(5.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            repeat(5) { index ->
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = if (index < productInfo.ratingStar) Color.Yellow else Color.Gray,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${productInfo.ratedBy} reviews",
                                fontSize = 12.sp,
                                color = Color.White
                            )
                        }
                    }
                    Icon(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(bottom = 16.dp)
                            .size(60.dp)
                            .border(width =  1.dp, color = Color(0xFFB7EC43) , shape = CircleShape)
                            .padding(10.dp),
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = null,
                        tint = Color(0xFFB7EC43)
                    )
                }
            }

        }

}

@Composable
fun Badge(count: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .offset(x = (-8).dp, y = 0.dp)
            .size(16.dp)
            .background(Color(0xFFB2FF59), CircleShape)
    ) {
        Text(text = "$count", fontSize = 10.sp, color = Color.Black)
    }
}

