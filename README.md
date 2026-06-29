# Tas - অফলাইন নোট টেকিং অ্যাপ

একটি সম্পূর্ণ অফলাইন নোট টেকিং অ্যাপ্লিকেশন যা আপনার সমস্ত ডেটা স্থানীয়ভাবে এনক্রিপ্ট করে সংরক্ষণ করে।

## বৈশিষ্ট্য

### ১. অফলাইন ডেটা ম্যানেজমেন্ট ও সিকিউরিটি
- **Room Database**: স্থানীয় ডেটা হ্যান্ডেলিংয়ের জন্য
- **SQLCipher**: ডাটাবেস এনক্রিপশনের জন্য
- **Auto-Save**: ডেবাউন্স মেকানিজম সহ স্বয়ংক্রিয় সংরক্ষণ
- **Database Transactions**: ডেটা সততা নিশ্চিত করতে

### ২. ইউজার সেটিংস ও কাস্টমাইজেশন
- **Material 3 Dynamic Theming**: ডিভাইসের ওয়ালপেপার রঙের সাথে সামঞ্জস্য
- **Color Customization**: প্রাথমিক এবং মাধ্যমিক রঙ কাস্টমাইজ করুন
- **DataStore Preferences**: সেটিংস স্থায়ীভাবে সংরক্ষণ করুন
- **Adaptive Layout**: মোবাইল এবং বড় স্ক্রিনের জন্য অপ্টিমাইজড

### ৩. অফলাইন এরর হ্যান্ডেলিং
- **Database Transactions**: আংশিক ডেটা সেভ প্রতিরোধ করুন
- **Backup & Restore**: JSON এবং CSV ফরম্যাটে এক্সপোর্ট/ইমপোর্ট
- **User Feedback**: স্পষ্ট বাংলা ত্রুটি বার্তা

### ৪. আর্কিটেকচার
- **Modular Design**: `:app`, `:core`, এবং `:features` মডিউল
- **Kotlin & Compose**: আধুনিক Android ডেভেলপমেন্ট স্ট্যাক
- **Dependency Injection (Hilt)**: পরিচ্ছন্ন এবং টেস্টেবল কোড

## প্রজেক্ট স্ট্রাকচার

```
Tas/
├── app/                          # Main application module
│   └── src/main/kotlin/
│       └── com/deepanjan/tas/
│           ├── MainActivity.kt
│           ├── TasApplication.kt
│           └── ui/theme/
│               └── Theme.kt
│
├── core/                         # Core module (database, utilities)
│   └── src/main/kotlin/
│       └── com/deepanjan/tas/core/
│           ├── data/
│           │   ├── database/
│           │   │   ├── TasDatabase.kt
│           │   │   ├── dao/NoteDao.kt
│           │   │   ├── entity/NoteEntity.kt
│           │   │   └── converter/LocalDateTimeConverter.kt
│           │   ├── preferences/SettingsPreferences.kt
│           │   └── repository/NoteRepository.kt
│           ├── di/DatabaseModule.kt
│           └── util/
│               ├── ErrorHandler.kt
│               └── FileExportImport.kt
│
├── features/                     # Features module (UI components)
│   └── src/main/kotlin/
│       └── com/deepanjan/tas/features/
│           └── (Feature screens will be added here)
│
├── build.gradle.kts              # Root build configuration
└── settings.gradle.kts           # Project structure definition
```

## ডিপেন্ডেন্সি

### Core Dependencies
- **Kotlin**: 1.9.21
- **Jetpack Compose**: 1.10.4
- **Material 3**: 1.1.2
- **Room**: 2.6.1
- **SQLCipher**: 4.5.4
- **DataStore**: 1.0.0
- **Hilt**: 2.48

## শুরু করা

### প্রয়োজনীয়তা
- Android Studio Jellyfish বা নতুন
- Android SDK 34+
- Kotlin 1.9.21+

### বিল্ড করা
```bash
./gradlew build
```

### চালানো
```bash
./gradlew installDebug
```

## ভবিষ্যত ফিচার

- [ ] ক্লাউড সিঙ্ক (অপ্শনাল)
- [ ] উন্নত সার্চ ফাংশনালিটি
- [ ] নোট কোলাবোরেশন
- [ ] ভয়েস নোট সাপোর্ট
- [ ] উইজেট সাপোর্ট

## লাইসেন্স

এই প্রজেক্ট MIT লাইসেন্সের অধীন।

## অবদান

অবদান স্বাগত জানাই! অনুগ্রহ করে একটি Pull Request খুলুন।
