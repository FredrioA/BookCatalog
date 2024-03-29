package com.example.bookcatalog.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.bookcatalog.models.BookModel;
import com.example.bookcatalog.R;
import com.example.bookcatalog.databinding.BookRvItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FavoriteBooksAdapter extends RecyclerView.Adapter<FavoriteBooksAdapter.FavoritesViewHolder> {

    private List<BookModel> bookList;
    private IBookClicked listener;
    private ProgressBar progressBar;

    //Constructor
    public FavoriteBooksAdapter(IBookClicked listener, ProgressBar progressBar) {
        bookList = new ArrayList<>();
        this.listener = listener;
        this.progressBar = progressBar;

        this.progressBar.setVisibility(View.VISIBLE);
    }

    //Get book in a certain position
    public BookModel getBook(int position) {
        return bookList.get(position);
    }

    public void clearAndAddItems(List<BookModel> books) {
        bookList.clear();
        bookList.addAll(books);
    }

    public void clear() {
        bookList.clear();
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoritesViewHolder(BookRvItemBinding
                .inflate(LayoutInflater
                        .from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(FavoritesViewHolder holder, int position) {

        //Cover Thumbnail imageview
        if (bookList.get(position).getBookInfo().getBookCover().getCoverImage() != null) {
            Glide.with(holder.binding.bookCoverIvListItem.getContext())
                    .load(bookList.get(position).getBookInfo().getBookCover().getCoverImage())
                    .placeholder(R.drawable.book_icon)
                    .into(holder.binding.bookCoverIvListItem);
        }


        //Title Textview
        if (bookList.get(position).getBookInfo().getTitle() != null) {
            holder.binding.titleTvListItem.setText(bookList.get(position).getBookInfo().getTitle());
        }


        //Authors Textview
        if (bookList.get(position).getBookInfo().getAuthors() != null) {
            holder.binding.authorsTvListItem.setText("by " + bookList.get(position).getBookInfo().getAuthors()[0]);
        }

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    //View Holder Class
    public class FavoritesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private BookRvItemBinding binding;


        //List Item
        public FavoritesViewHolder(BookRvItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.cardview.setOnClickListener(this);
        }

        //OnRecyclerViewItemClick
        @Override
        public void onClick(View v) {
            listener.onClick(getAdapterPosition());
        }
    }

    public interface IBookClicked {
        void onClick(int position);
    }
}

