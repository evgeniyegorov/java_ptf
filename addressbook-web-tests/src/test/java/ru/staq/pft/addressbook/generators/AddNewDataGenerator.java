package ru.staq.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.staq.pft.addressbook.model.AddNewData;

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

  @Parameter(names = "-d", description = "Data format")
  public String format;

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
    if (format.equals("csv")) {
      saveAsCsv(addnews, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(addnews, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(addnews, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsJson(List<AddNewData> addnews, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(addnews);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
}

  private void saveAsXml(List<AddNewData> addnews, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(AddNewData.class);
    String xml = xstream.toXML(addnews);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsCsv(List<AddNewData> addnews, File file) throws IOException {
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


