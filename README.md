🇺🇸 [English](#english) | 🇲🇽 [Español](#español)

---

## English

### Kotlin Multiplatform Movie App Example

This repository contains an example of a Kotlin Multiplatform (KMP) application based on the [DevExpert tutorial](https://youtu.be/F0AWKPSDbHo?si=uQLUOVcRGgdM5Ox8), with additional improvements and ongoing development.

This app supports both **Android** and **iOS** platforms, demonstrating how to share code across mobile environments with Kotlin.

---

### 📁 Code structure

This is a Kotlin Multiplatform project for Android and iOS:
```
/composeApp -> Shared code for both platforms
├── commonMain -> Shared logic across Android and iOS
└── iosMain, androidMain -> Platform-specific code
/iosApp -> Entry point for the iOS app (SwiftUI integration possible)
```

---

### 🛠️ Technologies Used

- Kotlin 2.0 (PR: `Home implementation`)
- Gradle using Kotlin DSL and Versions Catalog (PR: `Home implementation`)
- Compose Multiplatform for UI (PR: `Home implementation`)
- Coil for image loading (PRs: `Coil implementation`, `Added a default behavior for image loader`)
- Navigation Compose for navigation (PRs: `Added the navigation function between screens`, `Refactor API requests and improve Navigation structure`)
- ViewModels from Architecture Components (PR: `Refactor HomeScreen to use HomeViewModel for state management and added loading indicator`)
- Ktor Client for networking (PR: `Implement Ktor client setup for TMDb API requests and create MoviesService for fetching popular movies`)
- Room for local persistence (PR: `Implement Room for data persistence and configure database`)
- Koin for dependency injection (PR: `Set up Koin for dependency injection`)
- Moko Permissions for handling permissions (PR: `Use Moko for location permission and get region from native APIs`)

---

### ▶️ Running the Project

To run the project, you will need an API key from [TheMovieDb](https://www.themoviedb.org).  
Create a `local.properties` file in the root of your project and add the following line:

```
API_KEY=your_api_key_here
```

Replace `your_api_key_here` with your actual API key.

---

## Español

### Ejemplo de Aplicación Multiplataforma con Kotlin

Este repositorio contiene un ejemplo de una aplicación Kotlin Multiplataforma (KMP), basada en el [tutorial de DevExpert](https://youtu.be/F0AWKPSDbHo?si=uQLUOVcRGgdM5Ox8), con mejoras adicionales y desarrollo en curso.

La aplicación es compatible con plataformas **Android** e **iOS**, demostrando cómo compartir código en entornos móviles usando Kotlin.

---

### 📁 Estructura del código

Este es un proyecto Multiplataforma con Kotlin para Android e iOS:
```
/composeApp -> Código compartido entre ambas plataformas
├── commonMain -> Lógica común para Android e iOS
└── iosMain, androidMain -> Código específico para cada plataforma
/iosApp -> Punto de entrada de la app iOS (se puede integrar SwiftUI)
```

---

### 🛠️ Tecnologías Usadas

- Kotlin 2.0 (PR: `Home implementation`)
- Gradle con Kotlin DSL y Versions Catalog (PR: `Home implementation`)
- Compose Multiplatform para la interfaz (PR: `Home implementation`)
- Coil para carga de imágenes (PRs: `Coil implementation`, `Added a default behavior for image loader`)
- Navigation Compose para navegación (PRs: `Added the navigation function between screens`, `Refactor API requests and improve Navigation structure`)
- ViewModels de Android Architecture Components (PR: `Refactor HomeScreen to use HomeViewModel for state management and added loading indicator`)
- Ktor Client para conexión con APIs (PR: `Implement Ktor client setup for TMDb API requests and create MoviesService for fetching popular movies`)
- Room para persistencia local (PR: `Implement Room for data persistence and configure database`)
- Koin para inyección de dependencias (PR: `Set up Koin for dependency injection`)
- Moko Permissions para manejo de permisos (PR: `Use Moko for location permission and get region from native APIs`)

---

### ▶️ Cómo ejecutar el proyecto

Para ejecutar el proyecto, necesitas una API key de [TheMovieDb](https://www.themoviedb.org).  
Crea un archivo `local.properties` en la raíz del proyecto y agrega la siguiente línea:

```
API_KEY=tu_api_key_aquí
```

Reemplaza `tu_api_key_aquí` con tu clave real de API.
