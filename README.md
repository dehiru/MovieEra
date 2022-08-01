Android приложение для просмотра списка фильмов.
Данные фильмов загружаются через сторонний Api (Movie Reviews API - https://developer.nytimes.com/docs/movie-reviews-api/1/overview)
с помощью Retrofit и конвертируются в объекты Kotlin конвертером Moshi.
Список фильмов отображается в RecyclerView.
В RecyclerView реализована пагинация при скролле с использованием Paging 3.
___
An Android app for viewing a list of movies.
Movie data is uploaded via a third-party Api (Movie Reviews API - https://developer.nytimes.com/docs/movie-reviews-api/1/overview)
using Retrofit and converted to Kotlin objects by Moshi converter.
The list of movies is displayed in RecyclerView.
RecyclerView implements pagination when scrolling using Paging 3.
