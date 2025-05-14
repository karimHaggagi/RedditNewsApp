package com.example.redditnews

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * created by Karim Haggagi Hassan Elsayed on 5/14/25
 **/
// src/androidTest/java/com/your/package/HiltTestRunner.kt
class HiltTestRunner : AndroidJUnitRunner() {
 override fun newApplication(cl: ClassLoader?, name: String?, context: Context?): Application {
  return super.newApplication(cl, HiltTestApplication::class.java.name, context)
 }
}
