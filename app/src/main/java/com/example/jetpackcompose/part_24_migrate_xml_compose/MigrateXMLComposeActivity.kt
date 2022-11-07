package com.example.jetpackcompose.part_24_migrate_xml_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpackcompose.databinding.ActivityMigrateXmlComposeBinding
import com.example.jetpackcompose.ui.theme.MigrateXMLComposeTheme

class MigrateXMLComposeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMigrateXmlComposeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMigrateXmlComposeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContent {
//            MigrateXMLComposeTheme {
//
//            }
//        }
    }
}