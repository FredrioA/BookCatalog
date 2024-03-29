// Generated by view binder compiler. Do not edit!
package com.example.bookcatalog.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.example.bookcatalog.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class BookRvItemBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  @NonNull
  public final TextView authorsTvListItem;

  @NonNull
  public final ImageView bookCoverIvListItem;

  @NonNull
  public final CardView cardview;

  @NonNull
  public final TextView titleTvListItem;

  private BookRvItemBinding(@NonNull LinearLayoutCompat rootView,
      @NonNull TextView authorsTvListItem, @NonNull ImageView bookCoverIvListItem,
      @NonNull CardView cardview, @NonNull TextView titleTvListItem) {
    this.rootView = rootView;
    this.authorsTvListItem = authorsTvListItem;
    this.bookCoverIvListItem = bookCoverIvListItem;
    this.cardview = cardview;
    this.titleTvListItem = titleTvListItem;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static BookRvItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static BookRvItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.book_rv_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static BookRvItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.authors_tv_listItem;
      TextView authorsTvListItem = rootView.findViewById(id);
      if (authorsTvListItem == null) {
        break missingId;
      }

      id = R.id.bookCover_iv_listItem;
      ImageView bookCoverIvListItem = rootView.findViewById(id);
      if (bookCoverIvListItem == null) {
        break missingId;
      }

      id = R.id.cardview;
      CardView cardview = rootView.findViewById(id);
      if (cardview == null) {
        break missingId;
      }

      id = R.id.title_tv_listItem;
      TextView titleTvListItem = rootView.findViewById(id);
      if (titleTvListItem == null) {
        break missingId;
      }

      return new BookRvItemBinding((LinearLayoutCompat) rootView, authorsTvListItem,
          bookCoverIvListItem, cardview, titleTvListItem);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
