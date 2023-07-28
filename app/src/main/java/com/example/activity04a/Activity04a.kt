package com.example.activity04a

import java.util.*

data class Student(
    val firstName: String,
    val lastName: String,
    val nickName: String,
    val id: String,
    val yearEnrolled: Int
)

class StudentManager(private val students: ArrayList<Student>) {

    fun searchStudentWildSearch(searchString: String, searchField: String): ArrayList<Student> {
        val matchingStudents = ArrayList<Student>()
        val searchStringLowerCase = searchString.toLowerCase()

        for (student in students) {
            val lastNameLowerCase = student.lastName.toLowerCase()
            val firstNameLowerCase = student.firstName.toLowerCase()
            val nickNameLowerCase = student.nickName.toLowerCase()

            when (searchField) {
                "lastname" -> if (lastNameLowerCase.contains(searchStringLowerCase)) matchingStudents.add(student)
                "middlename" -> if (firstNameLowerCase.contains(searchStringLowerCase)) matchingStudents.add(student)
                "nickname" -> if (nickNameLowerCase.contains(searchStringLowerCase)) matchingStudents.add(student)
            }
        }

        return matchingStudents
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val students = arrayListOf(
        Student("Rizwan", "Caser", "Riz", "ID863", 2020),
        Student("Kurt ", "Verzo", "KC", "ID375", 2021),
        Student("Nicole", "Razo", "Nic", "ID036", 2019)
    )

    val studentManager = StudentManager(students)

    print("Enter search field (lastname, middlename, or nickname): ")
    val searchField = scanner.nextLine().toLowerCase()

    print("Enter search string: ")
    val searchString = scanner.nextLine()

    val matchingStudents = studentManager.searchStudentWildSearch(searchString, searchField)

    if (matchingStudents.isNotEmpty()) {
        println("Matching students:")
        for (student in matchingStudents) {
            println("Name: ${student.firstName} ${student.lastName}, Nickname: ${student.nickName}, ID: ${student.id}, Year Enrolled: ${student.yearEnrolled}")
        }
    } else {
        println("No students found.")
    }
}

