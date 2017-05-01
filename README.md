# Phone Number Encoder
Using below mapping, encode phone numbers to words, so it becomes easier to remember the numbers:
```
E | J N Q | R W X | D S Y | F T | A M | C I V | B K U | L O P | G H Z
e | j n q | r w x | d s y | f t | a m | c i v | b k u | l o p | g h z
0 |   1   |   2   |   3   |  4  |  5  |   6   |   7   |   8   |   9
```

For example:
- 5624-82: mir Tor
- 5624-82: Mix Tor
- 4824: Torf
- 4824: fort
- 4824: Tor 4
- 10/783--5: neu o"d 5

## Pre-requisites
- Java 8 (JDK 1.8.0_121)
- Gradle 3.5
- Maven

### Step 1: Install and build
Go to project directory and build the project
```
cd C:\Users\User\IdeaProjects\PhoneNumberEncoder
gradle clean build
or
mvn clean package
```

### Step 2: Usage
Pass below files to the application for encoding:
1. Dictionary
2. Phone Numbers to be encoded
Results would be displayed on the console
```
cd C:\Users\User\IdeaProjects\PhoneNumberEncoder\
java -jar build\libs\PhoneNumberEncoder-all-1.0-SNAPSHOT.jar src\main\resources\dictionary.txt src\main\resources\input.txt
or
java -jar target\PhoneNumberEncoder-1.0-SNAPSHOT.jar src\main\resources\dictionary.txt src\main\resources\input.txt
```

Results would be displayed on the console
```

Output snippet:
48746879300588803: Flut 6 Lug See Moll es
5-61189/-4-685: 5 in 1 oh Film
5-61189/-4-685: 5 in 1 oh Tip 5
6-81/: Ion
6-81/: von
/93-8-: 9 so
2//58: Wal
-5/39/1/-8656-38: As 9 Nova 6 so
8576: lau 6
-810873502888/74-556227/1: 8 je ob da er Po ob 4 Mai 2 Run
```

## Test
For more details, see com.ts.service.EncoderTest for detailed test cases