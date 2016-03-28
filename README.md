Synopsis

ProjectName: Electri-C-oin
Purpose: To gamify electricity consumption, to make the user more conscious of his energy usage, and to use the 'CrownIt' concept in electricity.
What is it?: There are 2 android applications is the project. One app is an ocr(optical character recognition) app and another is the main 'game' app. The OCR app, taking inspiration from the app 'CrownIt' is made for the purpose of directly reading the date and power consumed from a photo of an electricity bill. The Game app is to get the user to compete with himself, his friends and his neighbours for reducing power consumption.


About:
The Game app has 5 different features. 
1. It intruduces a pre-paid option to pay for electricity. The benifit of this feature is that the user has the freedom to pay whenever he wants. The company also has a constant cash inflow.
2. The 'Vs-Friends' Feature, where the user gets to compete with his friends (electricity consumed is converted to certain points. The points are stored online on a free hosted sql database.) he user an see his and his friends' points.
3. The 'LeaderBoard', where the user can see the comparison of points of all his Friends/Neighbouors.
4. The 'Goals', where the user sets a monthly goal for himself for electricity consumption. The app checks the value from his bills using the OCR app at the end of the month.
5. The 'News' and 'Notification' section, where the user is constantly updated with news on electricity consumption and generation.


What is Used:

For OCR App: Tessaract, Tess-Two library 
For Game App: Materian Design Library(front end), SQL database (back end) 


Motivation:

Rapidly increasing electricity demand and growing concern about economic and environmental consequences call for effective and thorough energy governance. The challenge is to actively involve the people to solve power distribution problems in our country and also improve their consumer experience.


Installation

STEP1: Download the complete folder from git-hub and extract it on your pc
STEP2: Be sure to have the latest version of android studio installed, the jdk and android ndk-v10. [I used AndroidStudio 1.3.2, jdk-1.8.0, android-ndk-r10e]
STEP3: Open the Game_App project in android studio and run a build. [Refer screenshot 1 for project structure]
STEP4: After a successful build, run it on eiher a virtual device or a connected device. [!! make sure to have internet connectivity on your mobile !!]
STEP5: Login with credentials 'Username: Rohit   Password: abcd'. This is because that entry already exists in my SQL database (free hosting by 2freehosting.com). You will have to redirect the database when you make your own database.
STEP6: Check out screenshots 2 to 6 to compare the front end of the app.
STEP7: Go to the vs-friends section and type in 'Tanay' in the  1st text box on the right and click 'GO'. You will see the app fetch the corresponding value from the SQL database.

STEP8: Open the 2nd app (OCR) named 'ECoin' and build it.
STEP9: Run the app on your phone. Look at screenshot 6 to compare.
STEP10: Click the button OCR and take a photo of easily legible text.


Important Links
Take a look at http://androidadvance.com/blog/tutorial-getting-started-with-tessaract-ocr-in-android-android-studio/  for understanding the OCR app
For java files  http://www.oracle.com/technetwork/java/javase/downloads/index.html
For Android Studio  http://developer.android.com/sdk/index.html
[Refer developer.android.com for tutorials as well]
For refrence OCR app  https://github.com/GautamGupta/Simple-Android-OCR
For Tess-Two library  https://github.com/rmtheis/tess-two


Contributors

You can contribute to the project directly. Download the project and change it and use if for your own purposes.