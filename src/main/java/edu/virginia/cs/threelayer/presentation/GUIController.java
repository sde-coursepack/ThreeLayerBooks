package edu.virginia.cs.threelayer.presentation;

import edu.virginia.cs.threelayer.BestSellersList;
import edu.virginia.cs.threelayer.Book;
import edu.virginia.cs.threelayer.ListName;
import edu.virginia.cs.threelayer.business.BestSellersService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GUIController {

    private BestSellersService service;

    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> titleColumn, authorColumn;
    @FXML
    private TableColumn<Book, Integer> isbnColumn, weeksColumn;
    @FXML
    private ChoiceBox<ListName> listSelector;
    @FXML
    private DatePicker datePicker;

    public void initialize() {
        service = new BestSellersService();
        initDatePicker();
        initListSelector();
        initTableView();
    }

    private void initDatePicker() {
        LocalDate today = LocalDate.now();
        datePicker.setValue(today);
    }

    private void initTableView() {
        //initialize columns
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        weeksColumn.setCellValueFactory(new PropertyValueFactory<>("weeksOnList"));
        updateTable();
    }

    private void initListSelector() {
        listSelector.setValue(ListName.COMBINED_FICTION);
        List<ListName> listNameList = Arrays.asList(ListName.values());
        ObservableList<ListName> nameList = FXCollections.observableList(listNameList);
        listSelector.setItems(nameList);
    }

    private void updateTable() {
        BestSellersList bookList = service.getHistoricBestSellerList(listSelector.getValue(), Date.from(
                datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        ObservableList<Book> obsList = FXCollections.observableList(bookList.getAllBooksInOrderOfRank());
        tableView.getItems().clear();
        tableView.getItems().addAll(obsList);
    }

    @FXML
    public void updateList() {
        try {
            updateTable();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }

    @FXML
    public void updateDate() {
        try {
            updateTable();
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
}
