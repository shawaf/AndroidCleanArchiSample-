## MVVM CLean Architecure Sample 
This project is a try of implementing the best clean architecture and Solid Principles using the latest APIs/Libraries nowadays . 
I have to defined a set of tools to use to start this project with but i will keep update with what i could find better for reaching the goal . 

### Tech Stack 
- MVVM
- Kotlin
- Dagger Hilt 
- Retrofit 
- Room 
- NetworkDataBouncer 
- Coroutines wiht Flow 
- Components ( Viewmodel , Live Data , Navigation)  
- XML with Data Binding 
- Glide 

### Coming : 
- Jetpack Compose 
- State/Shared Flow 
- Unit / UI Tests


### RX vs Coroutines : 
I have used coroutines for this as it's 
- Easier to implement with much simpler operators , 
- Handling Back-presurre very well by suspent the producer if consumer are not able to handle , 
- Better Performance 
- Better handling for memory leaks as Coroutines is using structured concurrency and that makes it better in manage the lifecycle of concurrent tasks.

### Modularity : 
you can't say i implemented modularity here as it's just shared libraries for core and networking but it's making it easier for building it in the future with project getting bigger . 


