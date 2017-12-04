package ru.staq.pft.addressbook.generators;

import ru.staq.pft.addressbook.model.AddNewData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AddNewDataGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<AddNewData> addnews = generateAddNews(count);
    save(addnews, file);
  }

  private static void save(List<AddNewData> addnews, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for(AddNewData addnew : addnews){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s\n"
              , addnew.getFirstname()
              , addnew.getMiddlename()
              , addnew.getLastname()
              , addnew.getNickname()
              , addnew.getCompany()
              , addnew.getAddress()
              , addnew.getMobilePhone()
              , addnew.getEmail()
              , addnew.getByear()
              , addnew.getGroup()));
    }
    writer.close();
  }

  private static List<AddNewData> generateAddNews(int count) {
    List<AddNewData> addnews = new ArrayList<AddNewData>();
    for (int i = 0; i < count; i ++){
      addnews.add(new AddNewData()
              .withFirstname(String.format("Evgeniy %s", i))
              .withMiddlename(String.format("Aleksandrovich %s", i))
              .withLastname(String.format("Egorov %s", i))
              .withNickname(String.format("egorzhekov %s", i))
              .withCompany(String.format("DPD %s", i))
              .withAddress(String.format("Mosqow %s", i))
              .withMobilePhone(String.format("8-968-982-38-07 %s", i))
              .withEmail(String.format("egorzhekov@gmail.com %s", i))
              .withByear(String.format("1989 %s", i))
              .withGroup(String.format("test1 %s", i)));
    }
    return addnews;
  }
}


