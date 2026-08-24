# 📖 Overview

Universal Language Translator is a lightweight and powerful Android application that enables users to translate text between 59 different languages using Google's ML Kit Translation API.

The application downloads language models directly to the device, allowing translations to work even without an internet connection after the initial model download.

Designed with a modern Material Design interface, the app provides a smooth, responsive, and user-friendly translation experience.

---

# ✨ Features

✅ Translate between 59 languages

✅ Dynamic source language selection

✅ Dynamic target language selection

✅ On-device translation using ML Kit

✅ Offline translation support

✅ Automatic language model download

✅ Fast and accurate translations

✅ Material Design 3 UI

✅ Dark Mode Support

✅ Responsive layout for different screen sizes

✅ Keyboard dismissal on Back Press

---

# 📱 Screenshots

## Home Screen

<img width="600" height="1335" alt="WhatsApp Image 2026-08-24 at 10 02 34 PM" src="https://github.com/user-attachments/assets/3d27913b-a074-4208-b6bc-d1f3849226c5" />

The default application screen where users can select languages and enter text.

---

## Language Selection

<img width="600" height="1335" alt="WhatsApp Image 2026-08-24 at 10 02 34 PM (1)" src="https://github.com/user-attachments/assets/b86c8ab3-bb91-413a-8885-fc0a3307cb65" />


Choose from 59 supported languages using intuitive dropdown menus.

---

## Extended Language List

<img width="600" height="1335" alt="WhatsApp Image 2026-08-24 at 10 02 34 PM (2)" src="https://github.com/user-attachments/assets/8c733388-d5a3-4b70-b3c9-0805ed1b7918" />


Browse the complete collection of supported languages.

---

## Translation Result

<img width="600" height="1335" alt="WhatsApp Image 2026-08-24 at 10 02 35 PM" src="https://github.com/user-attachments/assets/e08796d2-f2fc-4b0a-9811-73cef337f678" />


Instantly view translated text in the selected target language.

---

# 🌐 Supported Languages

The application supports 59 languages including:

- English
- Bengali
- Hindi
- Arabic
- Chinese
- Japanese
- Korean
- French
- German
- Spanish
- Portuguese
- Russian
- Turkish
- Urdu
- Vietnamese
- Tamil
- Telugu
- Gujarati
- Marathi
- Swahili

and many more.

---

# 🛠 Tech Stack

| Technology | Usage |
|------------|--------|
| Kotlin | Android Development |
| XML | UI Design |
| Material Design 3 | Modern UI Components |
| Google ML Kit | Translation Engine |
| Android SDK | Core Application Framework |

---

# 📂 Project Structure

```text
Universal-Language-Translator/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   ├── values/
│   │   │   │   └── mipmap/
│   │   │   └── AndroidManifest.xml
│
├── screenshots/
│   ├── banner.png
│   ├── home_screen.png
│   ├── language_selection_1.png
│   ├── language_selection_2.png
│   └── translation_result.png
│
└── README.md
```

---

# 🚀 Getting Started

## Clone the Repository

```bash
git clone https://github.com/yourusername/Universal-Language-Translator.git
```

## Open in Android Studio

Open Android Studio and select:

```text
File → Open → Universal-Language-Translator
```

---

## Sync Gradle

Allow Gradle to download all required dependencies.

---

## Run the Application

1. Connect an Android device
2. Or start an Android Emulator
3. Click Run ▶️

---

# 📦 Dependencies

Add ML Kit Translation Dependency:

```kotlin
implementation("com.google.mlkit:translate:17.0.3")
```

---

# ⚙️ How It Works

### Step 1

Select the source language.

### Step 2

Select the target language.

### Step 3

Enter text into the input field.

### Step 4

Press the Translate button.

### Step 5

The app downloads the required translation model (only the first time).

### Step 6

The translated text is displayed instantly.

### Step 7

Previously downloaded models can be used offline.

---

# 📈 Future Enhancements

- 🔄 Language Swap Button
- 🎤 Speech-to-Text
- 🔊 Text-to-Speech
- 🕘 Translation History
- 📋 Copy Translation
- 📤 Share Translation
- 🌍 Auto Language Detection
- ⭐ Favorite Translations

---

# 💡 Why ML Kit?

Google ML Kit provides:

- Fast translations
- Offline capability
- On-device processing
- Improved privacy
- Reduced latency
- No external server dependency

---

# 👨‍💻 Developer

### Sayan Sarkar

BCA Student • Android Developer

**Skills**

- Kotlin
- Android SDK
- Firebase
- Room Database
- Jetpack Compose
- XML UI
- Google ML Kit

---

# 🤝 Contributing

Contributions, issues, and feature requests are welcome.

Feel free to fork the repository and submit pull requests.

---

# ⭐ Support

If you found this project helpful, consider giving it a star on GitHub.

It helps the project reach more developers.

---

# 📄 License

This project is licensed under the MIT License.
