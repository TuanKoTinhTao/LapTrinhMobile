package com.example.flowlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.firebase.auth.FirebaseAuth




@Composable
fun ProfileScreen(onBackClick: () -> Unit = {}) {
    val user = FirebaseAuth.getInstance().currentUser

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Nút back + Tiêu đề
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF4C9EFF) // Xanh giống mockup
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Profile",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF4C9EFF)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Ảnh đại diện
        Box(contentAlignment = Alignment.BottomEnd) {
            AsyncImage(
                model = user?.photoUrl,
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.LightGray, CircleShape)
            )
            Icon(
                imageVector = Icons.Default.PhotoCamera,
                contentDescription = "Change Photo",
                tint = Color(0xFF6C63FF),
                modifier = Modifier
                    .size(28.dp)
                    .background(Color.White, CircleShape)
                    .padding(4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Các trường thông tin
        ProfileField(label = "Name", value = user?.displayName ?: "")
        Spacer(modifier = Modifier.height(12.dp))
        ProfileField(label = "Email", value = user?.email ?: "")
        Spacer(modifier = Modifier.height(12.dp))
        ProfileField(label = "Date of Birth", value = "23/05/1995", showArrow = true)

        Spacer(modifier = Modifier.weight(1f))

        // Nút Back
        Button(
            onClick = onBackClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C9EFF))
        ) {
            Text("Back", color = Color.White)
        }
    }
}

@Composable
fun ProfileField(label: String, value: String, showArrow: Boolean = false) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = {},
            enabled = false,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                if (showArrow) {
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                }
            }
        )
    }
}
