# FakeHH

## How to use

When running on a device or emulator, please use the Russian language in order to correctly follow
the instructions.

## Tech-Stack

* Tech-stack
    * [100% Kotlin](https://kotlinlang.org/)
        + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform
          background operations
        + [Kotlin Flow](https://kotlinlang.org/docs/flow.html) - data flow across all app layers,
          including views
    * [Retrofit/OkHttp](https://square.github.io/retrofit/) - networking
    * [Datastore](https://developer.android.com/topic/libraries/architecture/datastore) - data
      storage solution that allows you to store key-value pairs
    * [Serialization](https://kotlinlang.org/docs/serialization.html) -
      parse [JSON](https://www.json.org/json-en.html)
    * [Jetpack](https://developer.android.com/jetpack)
        * [Compose](https://developer.android.com/jetpack/compose) - modern, native UI kit
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) -
          in-app navigation
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) -
          perform an action when
          lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store
          and manage UI-related
          data in a lifecycle-aware way
* Modern Architecture
    * [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)
    * [Modularization](https://developer.android.com/topic/modularization) - practice of organizing
      a codebase into loosely coupled and self contained parts
    * Single activity architecture
      using [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)
    * MVVM + MVI (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
      ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
      , [Kotlin Flow](https://kotlinlang.org/docs/flow.html)
      , [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation))
* UI
    * [Jetpack Compose](https://developer.android.com/jetpack/compose) - modern, native UI kit (used
      for Fragments)
    * [Material Design 3](https://m3.material.io/) - application design system providing UI
      components
* Di
    * [Dagger/Hilt](https://developer.android.com/training/dependency-injection/hilt-android) -
      dependency injection library for Android that reduces the boilerplate of doing manual
      dependency injection in project