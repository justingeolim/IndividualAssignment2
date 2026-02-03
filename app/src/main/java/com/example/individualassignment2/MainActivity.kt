package com.example.individualassignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.individualassignment2.ui.theme.IndividualAssignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualAssignment2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AssignmentOutput(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun AssignmentOutput(modifier: Modifier = Modifier) {

    //1.Variables & Types
    val name: String = "Justin"
    var age = 25
    val height: Double = 170.0
    val isBUStudent: Boolean = true
    val grade: Char = 'A'
    val course = "CS 501"

    //2.String Interpolation
    var CourseAndGrade = "Course: $course, Grade: $grade"
    val NextYearAge = "Next year, age will be ${age + 1}"

    //3.Null Safety
    var nickname: String? = null
    val length = nickname?.length
    val displayNickName = nickname ?: "JustinTime"
    // This is safe because ?. provides null as length if the string is null – rather than crashing //
    // ?: uses nickname if it exists, but if it's null, it uses what comes after – "JustinTime"
    // In both cases, they both allows us to handle null values safely – without any crashes.

    //4.Operators
    val sum = 8 + 3
    val comparison = age > 18
    val logical = isBUStudent && age > 18

    age++
    age += 2
    //increment

    val output = """
        1. Variables & Types
        Name: $name
        Age: ${age-3}
        Height: $height
        Student: $isBUStudent
        Grade: $grade

        2. String Interpolation
        $CourseAndGrade
        $NextYearAge

        3. Null Safety
        Nickname length: $length
        Display Nickname: $displayNickName

        4. Operators 
        5 + 3 = $sum
        Age > 18: $comparison
        Student and adult: $logical
        Age in 3 years: $age
    """

    Text(text = output, modifier = modifier)
}




@Preview(showBackground = true)
@Composable
fun PreviewOutput() {
    IndividualAssignment2Theme {
        AssignmentOutput()
    }
}