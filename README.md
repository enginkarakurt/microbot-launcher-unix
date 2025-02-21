# microbot-launcher-unix

microbot-launcher-unix is an unofficial Windows, macOS and Linux Launcher for [Microbot](https://github.com/chsami/microbot)!

Although it can be used on all 3 platforms just fine, it is mainly intended for using Microbot on macOS or Linux (Hence why the -unix is in the name!). For Windows you can use the [Official Launcher](https://themicrobot.com/) too.

## Table of contents
- [Features](#features)
- [How to use](#how-to-use)
- [Using a Jagex Account](#using-a-jagex-account)
- [Contributions](#contributions)

## Features
- Automatically downloads the latest non-nightly .jar file from GitHub releases & puts it into a /jars directory which gets created in the same folder as the launcher

- Deletes old microbot versions and checks for new ones
  
- Launches the .jar file for you

- Portable (Writes to its own directory)

## How to use
NOTE: Requires Java 11 (Just like Microbot)

1. Put the Launcher in the folder where you want to have the files organized.
   
2. Launch using Terminal:
```
java -jar microbot-launcher-linux.jar
```

3. Enjoy!

## Using a Jagex Account
You can use the Launcher with a Jagex Account, however you currently need to do some manual steps:

Obtain a `credentials.properties` file from a RuneLite launcher. This can be from a Windows, macOS or Linux Launcher. 

For Windows and macOS, see [here](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts).

For Linux using the third-party:

1. Install [Bolt Launcher](https://flathub.org/apps/com.adamcake.Bolt) from Flathub. More information about Bolt can also be found on it's [Git Repository](https://github.com/adamcake/Bolt?tab=readme-ov-file#table-of-contents).

- For setting up Flathub for your Linux distro, see [here](https://flathub.org/setup).

![grafik](https://github.com/user-attachments/assets/4ff433fe-a889-4d31-907f-59448105c288)

2. After logging into Bolt Launcher, select RuneLite as the Game client.

3. Go to the Application Options and click on Configure RuneLite:

![grafik](https://github.com/user-attachments/assets/169546ca-a6e6-49db-99d0-8d7c0eaaa631)

![grafik](https://github.com/user-attachments/assets/b1922d08-05c4-426c-8180-a6b4b7819d0c)

4. In the window that pops up, paste the following argument for Client arguments:
```
--insecure-write-credentials
```

![grafik](https://github.com/user-attachments/assets/3c99760e-85dd-44a4-9782-2204a7b9ee7c)

5. Now if you start RuneLite, a `credentials.properties` file will be generated to the following path: `/home/YOUR-USERNAME/.var/app/com.adamcake.Bolt/data/bolt-launcher/.runelite/`

NOTE: Do NOT share this file with anyone!

6. Copy the `credentials.properties` file in to the `.runelite` folder at the following path (If you don't have a .runelite folder there, make sure to launch Microbot through the launcher once): `/home/YOUR-USERNAME/.runelite/`

7. Now when you start Microbot through the Launcher again, it should work with your Jagex Account!

NOTE: There are probably other methods aswell. Feel free to share them!

## Contributions
Feel free to submit a pull request to the dev branch if you have worked on something (Feature / Bug)! 

Also take a look at the Issues tab for things to solve and suggest features / report bugs if you encounter anything that could be improved!
