package com.example.bookcatalog.repository;

import androidx.paging.DataSource;

import org.jetbrains.annotations.NotNull;


public class AllBooksDataSourceFactory extends DataSource.Factory {

    @NotNull
    @Override
    public DataSource create() {
        return new AllBooksDataSource();
    }

}
