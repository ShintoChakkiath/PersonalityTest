# PersonalityTest
An android app which allows to test your personality based on few questions

Introduction

This project is an Android Application Project which intents to implement the requirements mentioned in the Spark Network Exercise. I have implemented Personality test android application.

For this I have used https://raw.githubusercontent.com/sparknetworks/coding_exercises_options/master/personality_test/database/personality_test.json API which returns JSON response. To get the Json response, I have used Retrofit library.


Architecture Flow



Approach

Following key points have been considered –
•	Architecture – MVVM
•	Android Architecture Component – ViewModel, LiveData, Room
•	Networking – Retrofit2
•	Material Design

MVVM Architecture -  

The project is logically divided into three modules.  Model, View and ViewModel.  

Model - The classes in the “repository” package represents the model and its helper classes to retrieve the model.  Here data is the list of questions and options based on the category retrieved from the Server APIs.

View – All the classes in the “ui” package.  These are basically the Activities– SelectCategoryActivity, QuestionListActivity & SavedPersonalityDataActivity, Fragments  - QuestionListFragment and Adapters – SelectCategoryAdapter, QuestionPageAdapter and SavedPersonalityDataAdpater.  

These classes are meant for showing the Category, Questions List based on the category and also showing the options saved by the user in  UI. Personality questions are displayed through the View pagers and FragmentStatePagerAdpater. User has to keep swiping after answering each question. To check the options provided\saved by user, there is floating action button given in the SelectCategory screen which retrieves the answers\options from database.

ViewModel - The classes in the “viewmodel” package are those classes which deals with the logic of retrieving the data and handing over to the registered view.  It encapsulates the details of how to retrieve the data and helps the view to focus on showing the data.

With MVVM the code is structured, modularised and readable.


Environment – 

•	Android Studio 3.3.2

Libraries – 

Couple of well adapted libraries has been used in this project.  
•	Retrofit2 – ver 2.3.0
•	Android support – 27.1.1

TODOs

•	Testing – include as many tests as possible – UI, UT etc.
•	More Error handling.
•	Dependency Injection (Dagger).

Thank you for your time.

Shilpa Kathal
