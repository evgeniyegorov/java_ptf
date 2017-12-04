package ru.staq.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.staq.pft.addressbook.model.AddNewData;
import ru.staq.pft.addressbook.model.GroupDate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AddNewDataGenerator {

  @Parameter(names = "-c", description = "Group count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {

    AddNewDataGenerator generator = new AddNewDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
      generator.run();
  }

  private void run() throws IOException {
    List<AddNewData> addnews = generateAddNews(count);
    save(addnews, new File(file));
  }

  private void save(List<AddNewData> addnews, File file) throws IOException {
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

  private List<AddNewData> generateAddNews(int count) {
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


