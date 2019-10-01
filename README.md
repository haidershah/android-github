## Description
A Sample Android app built in the MVVM architecture, utilizing the following Android Jetpack 
Architecture components: 
[Data Binding](https://developer.android.com/topic/libraries/data-binding),
[LiveData](https://developer.android.com/topic/libraries/architecture/livedata),
[Navigation](https://developer.android.com/topic/libraries/architecture/navigation.html), 
[Paging](https://developer.android.com/topic/libraries/architecture/paging/),
[Room](https://developer.android.com/topic/libraries/architecture/room),
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), and 
[WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager).

## Structure
Network requests are cached on the device so that the users can right away view data when they
return to the app. While users see cached data, a synchronous network call is made. If it
succeeds, the cache is updated with fresh data. 

## Async
This app uses Kotlin Coroutines for its async background tasks.

## Service
This app uses [Github](https://developer.github.com/v3/) apis as a network service.
