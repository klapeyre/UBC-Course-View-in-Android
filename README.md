# UBC-Course-View-in-Android
Takes data pulled from UBC Course Website, and allows you to choose courses and then display their info.

Current work flow:
- Start application
- Pressing 'GET DATA!' button triggers the parser to load data from disk, parse into Courses and save into local memory
- From here you can choose courses by Code, which show relevant course numbers and sections available
- Pressing 'Add Course' will add a course with the selected values to a list of courses
- Once courses are selected, pressing 'View Courses' will show a list of courses with their relevant info (title, days of the week the courses is offered, and times for lecture)

Work to do still:
- Be able to remove courses from a list of previously chosen courses
- Be able to manage multiple lists of courses
- User authentication and persisted data
- Addresses for buildings courses are offered in, which can then be used to pull lat/lon information through HTTP/GET
- Build in google map usage with application, so you can find where on campus a course lecture can be found

To get started:
- Download either Android Studio or the Android SDK (can find either on the Android development website here: https://developer.android.com/studio/
- If using IntelliJ or Eclipse, follow instructions on developer website to install SDK onto computer
- Install API version 25 (version used in the application currently)
- Clone project into directory used, boot up in IDE
- Run app

** Currently uses Java 7. There have been some issues with getting Java 8 to work with Android, they've recently been addressed in Android Studio, but their recommended fixes are currently not working in IntelliJ. Once this is fixed, I can move from using loops on collections of data to streams.
