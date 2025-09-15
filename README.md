# Proverbial Espresso Sample

## Description

This repository is for demonstration of **Espresso test execution** on an Android application. The app itself is from the LambdaTest Proverbial Demo Android app, modified to showcase Android instrumentation testing capabilities using the Espresso framework.

## Features

- Demonstrates Espresso UI testing on a real Android application
- Includes multiple test scenarios covering UI interactions
- Shows best practices for Android instrumentation testing
- Provides examples of testing different app components (buttons, text fields, WebView, etc.)

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Android Studio** (latest version recommended)
- **Android SDK** with API level 31 or higher
- **Java Development Kit (JDK)** 8 or higher
- **Git** for cloning the repository
- An **Android device** or **emulator** for running the tests

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yogibaba2/Proverbial_Espresso_Sample.git
cd Proverbial_Espresso_Sample
```

### 2. Install Dependencies

Open the project in Android Studio and let it sync automatically, or use the command line:

```bash
# Make sure gradlew is executable
chmod +x gradlew

# Download dependencies
./gradlew build
```

### 3. Running the Android Instrumentation Tests

You can run the Espresso tests using any of the following methods:

#### Option A: Using Android Studio
1. Open the project in Android Studio
2. Connect an Android device or start an emulator
3. Navigate to the test files in the Project Explorer
4. Right-click on a test class or method and select "Run"

#### Option B: Using Command Line
```bash
# Run all instrumentation tests
./gradlew connectedAndroidTest

# Run specific test class
./gradlew connectedAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=com.lambdatest.proverbial.MainActivityTest

# Run tests with verbose output
./gradlew connectedAndroidTest --info
```

#### Option C: Using ADB (if device is connected)
```bash
# Install the app and test APK first
./gradlew assembleDebug assembleDebugAndroidTest

# Run tests using ADB
adb shell am instrument -w com.lambdatest.proverbial.test/androidx.test.runner.AndroidJUnitRunner
```

## Test Structure

The Android instrumentation tests are located in the following directory structure:

```
app/
├── src/
│   ├── androidTest/
│   │   └── java/
│   │       └── com/
│   │           └── lambdatest/
│   │               └── proverbial/
│   │                   ├── MainActivityTest.java    # Main UI interaction tests
│   │                   └── BrowserTest.java         # WebView and browser tests
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── lambdatest/
│   │               └── proverbial/
│   │                   ├── MainActivity.java        # Main application activity
│   │                   ├── ButtonFragment.java     # Button interaction fragment
│   │                   └── BrowserFragment.java    # WebView fragment
│   └── test/
│       └── java/
│           └── com/
│               └── lambdatest/
│                   └── proverbial/
│                       └── ExampleUnitTest.java     # Unit tests
```

### Test Coverage

#### MainActivityTest.java
- **checkTitleText()**: Validates the main title text and button interactions
- **isActivityInView()**: Checks if main UI components are visible
- **checkIfTextBtnIsClicked()**: Tests text button functionality
- **checkIfSpeedTestPageIsDisplayed()**: Validates navigation to speed test page

#### BrowserTest.java
- **checkBrowserPageIsOpened()**: Tests WebView page navigation
- **openURLInBrowser()**: Tests URL input and loading in WebView

## Project Configuration

- **Target SDK**: API 33
- **Minimum SDK**: API 19
- **Compile SDK**: API 31
- **Test Runner**: AndroidJUnitRunner
- **Testing Framework**: Espresso 3.3.0

## Troubleshooting

### Common Issues

1. **Gradle wrapper missing**: If you encounter issues with `./gradlew`, ensure the gradle wrapper jar is present or re-generate it:
   ```bash
   gradle wrapper
   ```

2. **Device not found**: Make sure an Android device is connected or an emulator is running:
   ```bash
   adb devices
   ```

3. **Test failures**: Ensure the device has enough time for UI rendering by checking the `Thread.sleep()` calls in tests.

## Contributing

When adding new tests:
1. Follow the existing test naming conventions
2. Add appropriate assertions for UI validation
3. Include proper wait mechanisms for UI elements
4. Update this README if new test categories are added

## License

This project is for demonstration purposes and follows the same license as the original LambdaTest Proverbial application. 