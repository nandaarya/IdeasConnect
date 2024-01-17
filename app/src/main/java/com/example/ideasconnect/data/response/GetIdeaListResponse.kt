package com.example.ideasconnect.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class GetIdeaListResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("ideaList")
    val ideaList: List<IdeaListItem>

) : Parcelable

@Parcelize
data class IdeaListItem(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("idea_title")
    val ideaTitle: String,

    @field:SerializedName("idea_description")
    val ideaDescription: String,

    @field:SerializedName("additional_details")
    val additionalDetails: String,

    @field:SerializedName("developer_name")
    val developerName: String,

    @field:SerializedName("submission_date")
    val submissionDate: String,

) : Parcelable

object DataDummy {
    val ideaListDummy = listOf(
        IdeaListItem(
            id = 1,
            ideaTitle = "Smart Home Automation",
            ideaDescription = "Develop an application to automate home devices, such as lights, thermostats, and security systems.",
            additionalDetails = "Integration with voice assistants and energy-efficient solutions.",
            developerName = "Alice Johnson",
            submissionDate = "2023-03-15"
        ),
        IdeaListItem(
            id = 2,
            ideaTitle = "Health and Fitness Tracker",
            ideaDescription = "Create a comprehensive health and fitness app to track daily activities, workouts, and provide health tips.",
            additionalDetails = "Include features for diet planning and personalized fitness routines.",
            developerName = "Bob Smith",
            submissionDate = "2023-03-20"
        ),
        IdeaListItem(
            id = 3,
            ideaTitle = "E-Learning Platform",
            ideaDescription = "Build an online learning platform with courses, quizzes, and interactive content for various subjects.",
            additionalDetails = "Support for user profiles, progress tracking, and discussion forums.",
            developerName = "Charlie Brown",
            submissionDate = "2023-03-25"
        ),
        IdeaListItem(
            id = 4,
            ideaTitle = "Travel Companion App",
            ideaDescription = "Develop an app that assists travelers with itinerary planning, local recommendations, and navigation.",
            additionalDetails = "Offline maps, currency converters, and language translation features.",
            developerName = "David Miller",
            submissionDate = "2023-03-30"
        ),
        IdeaListItem(
            id = 5,
            ideaTitle = "Virtual Reality Gaming",
            ideaDescription = "Create immersive virtual reality games with realistic graphics and interactive gameplay.",
            additionalDetails = "Multiplayer support, dynamic environments, and motion sensor integration.",
            developerName = "Eva Davis",
            submissionDate = "2023-04-05"
        ),
        IdeaListItem(
            id = 6,
            ideaTitle = "Social Media Analytics",
            ideaDescription = "Build a tool for analyzing social media trends, engagement, and user behavior on various platforms.",
            additionalDetails = "Graphical representations, sentiment analysis, and data export features.",
            developerName = "Frank Wilson",
            submissionDate = "2023-04-10"
        ),
        IdeaListItem(
            id = 7,
            ideaTitle = "Food Delivery Service",
            ideaDescription = "Develop a food delivery app with a wide range of restaurant choices, real-time tracking, and reviews.",
            additionalDetails = "Secure payment options, order customization, and loyalty programs.",
            developerName = "Grace Turner",
            submissionDate = "2023-04-15"
        ),
        IdeaListItem(
            id = 8,
            ideaTitle = "Language Learning Game",
            ideaDescription = "Create an interactive game for language learning with challenges, quizzes, and vocabulary building.",
            additionalDetails = "Support for multiple languages, progress tracking, and user-friendly interface.",
            developerName = "Harry Brown",
            submissionDate = "2023-04-20"
        ),
        IdeaListItem(
            id = 9,
            ideaTitle = "Weather Forecast App",
            ideaDescription = "Build a weather app with accurate forecasts, real-time updates, and severe weather alerts.",
            additionalDetails = "Map overlays, customizable widgets, and integration with weather stations.",
            developerName = "Ivy Garcia",
            submissionDate = "2023-04-25"
        ),
        IdeaListItem(
            id = 10,
            ideaTitle = "Task Management Tool",
            ideaDescription = "Develop a task management application with features for creating, organizing, and tracking tasks.",
            additionalDetails = "Collaboration tools, reminders, and progress visualization.",
            developerName = "Jack Robinson",
            submissionDate = "2023-04-30"
        )
    )
}
