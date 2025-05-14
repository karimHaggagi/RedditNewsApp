# Reddit Kotlin News App

This is a sample Android application that displays news posts from (https://www.reddit.com/r/kotlin/.json). The app is built using **Jetpack Compose**, follows the **Clean Architecture** pattern, and is structured using a **multi-module setup**.

---

## 🧱 Architecture

The project uses **Clean Architecture** with the following module structure:

### Modules

- **app**: Entry point of the application, contains navigation and app-wide setup.
- **core**: Shared components like networking (Retrofit), database (Room), models, utilities, and error handling.
- **home**: Feature module for displaying a list of Kotlin news from Reddit.
- **details**: Feature module for displaying detailed information about a news item.

---

## 🔧 Tech Stack

| Layer             | Library / Approach                |
|------------------|------------------------------------|
| UI               | Jetpack Compose                    |
| Architecture     | MVVM + Clean Architecture          |
| Networking       | Retrofit + Kotlin Coroutines       |
| Local Storage    | Room                               |
| Dependency Injection | Hilt                         |
| Async / Flow     | Kotlin Coroutines + StateFlow      |
| Testing          | JUnit, Mockito, Mockk, Compose UI Test, Coroutine Test |

---

## 🌐 API

The app fetches data from:
https://www.reddit.com/r/kotlin/.json


Each Reddit post is mapped into a local model and displayed in a scrollable list (LazyColumn). Clicking on a post can navigate to a detailed view (from the `details` module).

---

## ✅ Unit Testing

- **ViewModels** and **UseCases** are tested using `JUnit` and `Mockk`/`Mockito`.
- Coroutine `Flow` and `StateFlow` are tested using `kotlinx-coroutines-test`.
- Local DB and Repository logic are mocked using interfaces and tested in isolation.

---

## 🎯 UI Testing

- UI tests written using **Jetpack Compose Testing APIs**.
- Fake ViewModels are used to simulate `StateFlow` emissions and validate UI behavior.
- LazyColumn interactions and item clicks are verified with `ComposeTestRule`.

---

## 🧪 Example Test Coverage

- ✅ Test remote data fetch success/failure.
- ✅ Test Room insertion and query logic.
- ✅ Test ViewModel state transformations.
- ✅ UI test: validate item shown after API result.
- ✅ UI test: click item from LazyColumn.

---

## 🚀 Getting Started

1. Clone the repository:

git clone https://github.com/karimHaggagi/RedditNewsApp.git

