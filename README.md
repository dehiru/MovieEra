Android приложение для просмотра списка фильмов.
В приложении используется DI - Hilt.
Данные фильмов загружаются через сторонний Api (Movie Reviews API - https://developer.nytimes.com/docs/movie-reviews-api/1/overview)
с помощью Retrofit и конвертируются в объекты Kotlin конвертером Moshi.
Для работы с изображениями применяется Glide.
Список фильмов отображается в RecyclerView.
В RecyclerView реализована пагинация при скролле с использованием Paging 3.
___
An Android app for viewing a list of movies.
The application uses DI - Hilt.
Movie data is uploaded via a third-party Api (Movie Reviews API - https://developer.nytimes.com/docs/movie-reviews-api/1/overview)
using Retrofit and converted to Kotlin objects by Moshi converter.
Glide is used to work with images.
The list of movies is displayed in RecyclerView.
RecyclerView implements pagination when scrolling using Paging 3.

<img src="https://user-images.githubusercontent.com/89028460/191205879-a4adaf75-b1e5-4f18-ba57-74d3c9abca57.jpg" width="300"/> <img src="https://user-images.githubusercontent.com/89028460/191205917-616c68d2-d05f-4e2f-a4f7-de0337c13a9d.jpg" width="300"/> <img src="https://user-images.githubusercontent.com/89028460/191205950-813113c2-aba0-45af-bbdc-dc66628958aa.jpg" width="300"/>
