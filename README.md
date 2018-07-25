# UBC Course Viewer - Android Application

This simple android app takes a dataset on disk, parsers and stores the data locally, and allows the user to select courses from a series of dropdown menus. Once
a set of courses is chosen, the selected data can then be viewed in detail on the following screen.

## Setting up the Environment

You will need either:
- The latest version of Android Studio, found here: https://developer.android.com/studio/
- The latest version of your IDE of choice that supports android SDK development (I chose to use IntelliJ). You can download just the SDK from the same source as the Android Studio IDE

Mac users can choose to use Homebrew to setup the sdk instead if preferred:
---
brew install ant
brew install maven
brew install gradle
brew install android-sdk
brew install android-ndk
---

This application uses API version 25; this will need to be installed, as well as the ADB (for emulation) - can be done through either the IDE or lauching the sdkmanager.

Once this is all done, a new project can be created, and this repo can be cloned into it.

## Usage

Once the app starts, pressing the GET DATA! button will load the data for use. 
The data selection screen then appears, where you can choose a course subject, then course number, then section that is offered.
* Note that the subsequent selections will change based on the previous choice. So for example, if you choose CPSC as the course code, then only CPSC courses will appear in the second drop down, such as 110, 121, 320 etc. Same goes for the section of a given course.
Press ADD COURSE once you have chosen one to add. You can remove courses you have previously added, and then view your currently selected courses by pressing VIEW COURSES.

## Test

Unit tests can be run by selecting 'Run tests' on packages in both the java section of the module (model tests), as well as the androidTest section (parser activity tests).
