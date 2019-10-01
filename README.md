# android-github
A Sample Android app built in the MVVM architecture, utilizing the following Android Jetpack 
Architecture components: 
[Data Binding](https://developer.android.com/topic/libraries/data-binding),
[LiveData](https://developer.android.com/topic/libraries/architecture/livedata),
[Navigation](https://developer.android.com/topic/libraries/architecture/navigation.html), 
[Paging](https://developer.android.com/topic/libraries/architecture/paging/),
[Room](https://developer.android.com/topic/libraries/architecture/room),
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), and 
[WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager).

This app uses [Github](https://developer.github.com/v3/) apis as a network service. The structure is
such that network requests are cached on the device so that the users can view data when they
return to the app. While users see cached data, when they open the app after the firs time, a
synchronous network call is made, which when returns updates the cache with fresh data. 
 