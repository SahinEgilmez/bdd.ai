[license]: http://www.apache.org/licenses/LICENSE-2.0 "Apache License 2.0"
[CONTRIBUTING.md]: .github/CONTRIBUTING.md
[CODE_OF_CONDUCT.md]: CODE_OF_CONDUCT.md

# BDD.AI

BDD.AI is a Gradle based, mobile test automation library written in Java, distributed by Maven distribution system. BDD (Behavior Driven Development) which is also used in the library name is one of the new generation software development approaches. BDD.AI uses a syntax that is close to human languages ​​in full compliance with the test language in this process.

One of the main features that distinguishes BDD.AI library from other test automation tools is that it uses AI technology actively. It does this by automatically recognizing and processing over 100 GUI elements used in mobile applications (without the need for additional definitions).

The library uses the Appium Framework when interacting with mobile devices. Other Appium-enabled automation tools such as xpath, resource-id etc. custom GUI elements can be introduced with definitions. With these features, Appium's Image Recoginition feature is used for use in areas where identification is difficult. With this feature, GUI elements can be recognized directly by processing images.

With BDD.AI, tests can be run in parallel. Test results can be viewed and analyzed in a modern interface. Allure Framework was used in preparing this reporting system.

## Installations

For the effective use of the library, the following software must be installed.

### appium

Appium installation is required for BDD.AI. You can access the installation document from the following link:

* http://appium.io/docs/en/about-appium/getting-started/#installation-via-npm

### opencv4nodejs

BDD.AI uses OpenCV for Image Processing. You can access the installation document from the following link:

* https://github.com/justadudewhohacks/opencv4nodejs#how-to-install

### test.ai appium classifier plugin

BDD.AI uses the test.ai plugin. You can access the installation document from the following link:

* https://github.com/testdotai/appium-classifier-plugin#system-setup

### allure framework

BDD.AI uses the Allure Framework to report test results. You can access the installation document from the following link:

* https://docs.qameta.io/allure/#_installing_a_commandline

## Documentation
To use BDD.AI, the latest version of the library must be added to the build.gradle file. You must also define a task called testRunner as follows: 

```groovy
  dependencies {
      implementation 'io.github.sahinegilmez:bdd.ai:0.2.0'
  }
  task testRunner(type: JavaExec) {
        classpath = sourceSets.main.runtimeClasspath
        main = "runner.BDDRunner"
  }
```

'bdd-config' 'bdd-config/images/' 'bdd-config/settings.json' must be added to the project correctly.

You can access to sample project from [here](https://github.com/SahinEgilmez/bdd.ai).

That's it! You are now ready to use BDD.AI.

## Contributing

You are completely free to contribute to the project. If you really want this, please contact me.

## License

BDD.AI is released under version 2.0 of the [Apache License][license].