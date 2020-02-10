# Appium - Cucumber parallel tests executor
All tests are written in Cucumber + Appium and executed with TestNG to support execution for different devices in parallel.

##Pre-requisites
Install:

    - NodeJS & npm
    - Maven
    - Android Sdk tools
    - JDK 8
TO DO: MacOs prerequisites
### Set up environment variables
Export properly:

    - Android/Sdk/platform-tools to $PATH
    - Android/tools/bin to $PATH
    - $JAVA_HOME
    - $ANDROID_HOME
### Set up [appium-server.properties](src/test/resources/appium-server.properties)
Install appium-server using npm

    $ cd appium-server
    $ npm i

Then replace appium-server.properties props

Example:

    nodejs.executable.path=/home/user/.nvm/versions/node/v8.16.1/bin/node
    appiumjs.instalation.path=/home/user/jage/appiumTemplate/appium-server/node_modules/appium

### Add devices to test in [devices.json](src/test/resources/devices.json) 
Example with two emulated devices:

    [
      {
        "deviceName": "Pixel",
        "platformName": "Android",
        "platformVersion": "",
        "udid": "emulator-5554"
      },
      {
        "deviceName": "Pixel 2",
        "platformName": "Android",
        "platformVersion": "",
        "udid": "emulator-5556"
      }
    ]

## Running the tests

    $ mvn clean package exec:java -DskipTests=true
    
## Reporting
After the execution check target/testng-report folder