package com.example.bookcatalog.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookTableDAO {

    @Insert
    void insertFavorite(BookTable favoriteBook);

    @Query("SELECT * FROM FavoritesTable")
    LiveData<List<BookTable>> getAllFavoriteBooks();

    @Query("SELECT * FROM FavoritesTable WHERE bookID = :bookID")
    LiveData<BookTable> getFavoriteBookByID(String bookID);

    @Query("DELETE FROM FavoritesTable WHERE bookID = :bookID")
    void removeFavoriteBookByID(String bookID);

}
