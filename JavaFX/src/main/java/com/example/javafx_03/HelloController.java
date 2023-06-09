package com.example.javafx_03;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import model.entities.Person;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    @FXML
    private Label txtLabelId;

    @FXML
    private Label txtLabelEmail;

    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxPersonAction(){
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
        txtLabelId.setText(String.format("%d", person.getId()));
        txtLabelEmail.setText(person.getEmail());
                
        System.out.println(person);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Maria", "maria@gmail.com"));
        list.add(new Person(2, "Pedro", "pedro@gmail.com"));
        list.add(new Person(3, "Miguel", "miguel@gmail.com"));
        list.add(new Person(4, "Pedro", "pedro@gmail.com"));

        obsList = FXCollections.observableArrayList(list);
        comboBoxPerson.setItems(obsList);


        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>(){
            @Override
            protected void updateItem(Person item, boolean empty){
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };

        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));

    }
}