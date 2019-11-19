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

## Build error

With Flutter 1.9.1 you might run into this build error in the final phase `[CP] Embed Pods Frameworks`, saying permission denied when signing file `Flutter.framework`:

```
PhaseScriptExecution [CP] Embed Pods Frameworks

/Users/myuser/Library/Developer/Xcode/DerivedData/ios_native_app/Build/Products/Debug-iphonesimulator/ios_native_app.app/Frameworks/Flutter.framework: replacing existing signature
/Users/myuser/Library/Developer/Xcode/DerivedData/ios_native_app/Build/Products/Debug-iphonesimulator/ios_native_app.app/Frameworks/Flutter.framework: Permission denied
Command PhaseScriptExecution failed with a nonzero exit code
```

According to [a user replied in Flutter issue tracker](https://github.com/flutter/flutter/issues/39507#issuecomment-555715584), it can be fixed by adding a line `chmod -R +w $1` to script `ios_native_app/Pods/Target Support Files/Pods-ios_native_app/Pods-ios_native_app-frameworks.sh`. 

```
code_sign_if_enabled() {
  if [ -n "${EXPANDED_CODE_SIGN_IDENTITY:-}" -a "${CODE_SIGNING_REQUIRED:-}" != "NO" -a "${CODE_SIGNING_ALLOWED}" != "NO" ]; then
    # Use the current code_sign_identity
    echo "Code Signing $1 with Identity ${EXPANDED_CODE_SIGN_IDENTITY_NAME}"
    chmod -R +w $1 # ADD THIS NEW LINE
    local code_sign_cmd="/usr/bin/codesign --force --sign ${EXPANDED_CODE_SIGN_IDENTITY} ${OTHER_CODE_SIGN_FLAGS:-} --preserve-metadata=identifier,entitlements '$1'"

    if [ "${COCOAPODS_PARALLEL_CODE_SIGN}" == "true" ]; then
      code_sign_cmd="$code_sign_cmd &"
    fi
    echo "$code_sign_cmd"
    eval "$code_sign_cmd"
  fi
}
```

# Import Android project

1. Open Android Studio, import this project by clicking *File -> Open*, open folder `FlutterHybridExample/android_native_app`.

After a minute of gradle sync, you should be able to run the app with Flutter module embedded.
