# PlantiT Repository Structure

This document describes the main structure of the PlantiT Android project.

## Project Layout

```
PlantiT/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/pasindu/plantit/      # Java source code
│   │   │   ├── res/                           # Resources (layouts, drawables, values)
│   │   │   ├── AndroidManifest.xml            # App manifest
│   │   └── test/                              # Unit tests
│   ├── build.gradle                           # App module Gradle config
├── build.gradle                               # Project-level Gradle config
├── README.md                                  # Project documentation
```

## Key Directories and Files

- **app/src/main/java/com/pasindu/plantit/**  
  Contains all Java source files for activities, fragments, and logic.

- **app/src/main/res/**  
  Contains resources such as layouts (`layout/`), images (`drawable/`), and values (`values/`).

- **app/src/main/AndroidManifest.xml**  
  The manifest file declaring app components and permissions.

- **build.gradle**  
  Gradle build configuration files for the project and app module.

## Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest stable version recommended)
- Android SDK (API level 21 or higher)
- Internet connection for downloading dependencies
- A valid Google Maps API key (already included in the manifest)

## Getting Started

1. Clone the repository.
2. Open in Android Studio.
3. Sync Gradle and build the project.

## Setup Instructions

1. **Clone the repository**
   ```sh
   git clone <your-repo-url>
   ```

2. **Open the project in Android Studio**
   - Select `Open an existing project` and choose the `PlantiT` directory.

3. **Configure Google Maps API Key**
   - The API key is already set in `AndroidManifest.xml`. If you need to use a different key, update the value of `com.google.android.geo.API_KEY`.

4. **Sync Gradle**
   - Android Studio will prompt you to sync Gradle. Accept and wait for dependencies to download.

5. **Build and Run**
   - Connect an Android device or start an emulator.
   - Click the Run button in Android Studio.

6. **Troubleshooting**
   - Ensure you have the latest version of Android Studio and the required SDKs installed.
   - If you encounter issues with Google Play Services, update them on your device or emulator.

---
