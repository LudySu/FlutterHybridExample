An example demostrates how to add a new Flutter sub-module into existing native Android and iOS project, to make the drastic transition smoother.

A detailed step-by-step guide on how to setup a Flutter hybrid project is available here:

1. [Power of hybrid (I): add flutter to existing apps](http://tsuinte.ru/2019/make-a-flutter-hybrid-app-1/)
2. [Power of hybrid (II): communicate with native code](http://tsuinte.ru/2019/make-a-flutter-hybrid-app-2/)

Below is a quick-start guide to get things running.

# Import Flutter project

[Install Flutter SDK](https://flutter.dev/docs/get-started/install) if you haven't already. This example uses `v1.9.1`.

1. Go to folder `FlutterHybridExample/flutter_common_module`, type command line to generate common binary files:

```bash
flutter pub get
```

2. Open Android Studio, import this project by clicking *File -> Open*, open folder `FlutterHybridExample/flutter_common_module`.

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
