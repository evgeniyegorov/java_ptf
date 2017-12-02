package ru.staq.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class AddNews extends ForwardingSet<AddNewData> {

  private Set<AddNewData> delegate;

  public AddNews(AddNews addnews) {
    this.delegate = new HashSet<AddNewData>(addnews.delegate);
  }

  public AddNews() {
    this.delegate = new HashSet<AddNewData>();
  }

  @Override
  protected Set<AddNewData> delegate() {
    return delegate;
  }

  public AddNews withAdded(AddNewData addnew) {
    AddNews addnews = new AddNews(this);
    addnews.add(addnew);
    return addnews;
  }

  public AddNews without(AddNewData addnew) {
    AddNews addnews = new AddNews(this);
    addnews.remove(addnew);
    return addnews;
  }
}
