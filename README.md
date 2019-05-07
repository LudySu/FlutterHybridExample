An example demostrates how to add a new Flutter sub-module into existing native Android and iOS project, to make the drastic transition smoother.

A detailed step-by-step guide on how to setup a Flutter hybrid project is available here:

1.
2.

Below is a quick-start guide to get things running.

# Import Flutter project

[Install Flutter SDK](https://flutter.dev/docs/get-started/install) if you haven't already.

1. Go to folder `FlutterHybridExample`, type command line to generate common binary files:

```bash
flutter create -t module flutter_common_module
```

2. Open Android Studio, import this project by clicking *File -> Open*, open folder `FlutterHybridExample/flutter_common_module`.

3. During gradle sync it will fail because dependencies are not imported yet, Android Studio will prompt to do *Get dependencies*. Click it.

4. The project is using `AndroidX` packages, so you will see another error. Open `flutter_common_module/.android/Flutter/build.gradle`, replace the dependencies at the bottom from:

```plain
dependencies {
    testImplementation 'junit:junit:4.12'
    implementation 'com.android.support:support-v13:27.1.1'
    implementation 'com.android.support:support-annotations:27.1.1'
}
```

to this:

```plain
dependencies {
    testImplementation 'junit:junit:4.12'
    implementation 'androidx.legacy:legacy-support-v13:1.0.0'
    implementation 'androidx.annotation:annotation:1.0.0'
}
```

5. Errors should go away after a Gradle sync. Then open `FlutterFragment.java` and `Flutter.java `, remove all imports that the compiler marks red saying can't find the packages, Android Studio will then replace them with the correct ones.

Then you should be able to build and run a demo pure Flutter app on your Android or iOS devices.

# Import iOS project

[Install cocoapods](https://guides.cocoapods.org/using/getting-started.html) if you haven't already.

1. Go to folder `FlutterHybridExample/ios_native_app`, type command line to install cocoapods dependencies:

```bash
pod install
```

2. Open the project by command line:

```bash
open ios_native_app.xcworkspace
```

Then you should be able to run the app with Flutter module embedded.

# Import Android project

1. Open Android Studio, import this project by clicking *File -> Open*, open folder `FlutterHybridExample/android_native_app`.

After a minute of gradle sync, you should be able to run the app with Flutter module embedded.
