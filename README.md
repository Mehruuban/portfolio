# 📱 My Portfolio App

A simple, modern **Android Portfolio App** developed in **Kotlin**, where users can showcase their **Skills**, **Projects**, and **Certifications** using a clean and intuitive UI.

---

## ✨ Features

- ✅ Splash Screen
- ✅ Home Dashboard (with sections for Skills, Projects, and Certifications)
- ✅ Add & Delete Skills using RecyclerView
- ✅ Add & Delete Projects with Titles & Descriptions
- ✅ Add & Delete Certifications with Titles & Issuers
- ❌ Firebase Integration (optional - not included in current version)

---

## 📷 Screenshots

| Home Screen | Skills | Projects | Certifications |
|-------------|--------|----------|----------------|
| ![Home](assets/home.png) | ![Skills](assets/skills.png) | ![Projects](assets/projects.png) | ![Certifications](assets/certifications.png) |

> *Note: Replace image links above with actual screenshots from your app inside the `/assets` folder.*

---

## 🛠 Tech Stack

- **Language:** Kotlin  
- **UI:** XML Layouts  
- **Architecture:** Basic MVC  
- **Components:** RecyclerView, AlertDialog, Intent-based Navigation  
- **Design:** LinearLayout, Material Design FAB, Dark/Light backgrounds  

---

## 📁 Project Structure

```
com.mehru.myportfolio/
│
├── activities/
│   ├── MainActivity.kt
│   ├── SkillsActivity.kt
│   ├── ProjectsActivity.kt
│   ├── CertificationsActivity.kt
│   ├── AddSkillActivity.kt
│   ├── AddProjectActivity.kt
│   └── AddCertificationActivity.kt
│
├── adapters/
│   ├── SkillAdapter.kt
│   ├── ProjectAdapter.kt
│   └── CertificationAdapter.kt
│
├── models/
│   ├── SkillModel.kt
│   ├── ProjectModel.kt
│   └── CertificationModel.kt
│
├── res/
│   ├── layout/
│   ├── drawable/
│   ├── values/
│
└── AndroidManifest.xml
```

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Dolphin or higher
- Gradle 8+
- Kotlin Plugin installed

### How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/portfolio-app.git
   ```

2. Open in Android Studio  
3. Click **Run > Run 'app'**

---

## 🧠 Future Improvements

- 🔄 Store data using Firebase Realtime Database or Firestore  
- ☁️ Backup user data to the cloud  
- 🌐 Add social/profile links and resume download  
- ✨ Add animations or use Lottie for a more engaging UI  

---

## 📩 Connect With Me

Created with ❤️ by **Meharban Alam**  
📧 Email: developermehru@gmail.com 
🌐 GitHub: [@Mehruuban](https://github.com/Mehruuban)

---# portfolio
