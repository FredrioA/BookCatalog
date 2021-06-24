package com.example.bookcatalog.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.bookcatalog.models.BookModel;
import com.example.bookcatalog.repository.BooksRepository;
import com.example.bookcatalog.repository.AllBooksDataSourceFactory;
import com.example.bookcatalog.room.BookTable;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.example.bookcatalog.utils.AppConstants.MAX_RESULTS_PER_CALL;

public class BooksViewModel extends AndroidViewModel {

    private BooksRepository booksRepository;

    public BooksViewModel(@NonNull @NotNull Application application) {
        super(application);
        booksRepository = new BooksRepository(application);
    }


    public LiveData<PagedList<BookModel>> getRetrofitBooks() {
        AllBooksDataSourceFactory allBooksDataSourceFactory = new AllBooksDataSourceFactory();
        PagedList.Config config =
                (new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setPageSize(MAX_RESULTS_PER_CALL))
                        .build();

        return new LivePagedListBuilder(allBooksDataSourceFactory, config).build();
    }

    public LiveData<List<BookTable>> getFavoriteBooksIDS() {
        return booksRepository.getFavoriteBooksIdsFromLocal();
    }

    public LiveData<List<BookModel>> getFavoriteBooks(List<BookTable> favBooksIDs) {
        return booksRepository.getAllFavoriteBooksFromAPI(favBooksIDs);
    }

    public void insertFavoriteBook(BookTable bookTable) {
        booksRepository.insertFavoriteBook(bookTable);
    }

    public LiveData<BookTable> getFavoriteBookByID(String bookID) {
        return booksRepository.checkIfFavoriteBookExistsLocally(bookID);
    }

    public void removeFavoriteBook(String bookID) {
        booksRepository.removeFavoriteBookByID(bookID);
    }
}
