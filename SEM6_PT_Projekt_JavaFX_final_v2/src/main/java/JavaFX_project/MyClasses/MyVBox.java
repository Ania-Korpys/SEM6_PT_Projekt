package JavaFX_project.MyClasses;

import JavaFX_project.Database.TableCodecs;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class MyVBox {

    public final Label labelParameterDescription = new Label("Opis parametrów");
    public Text paramDescription = new Text();

    public final Label labelCodecsTable = new Label("Kodeki");

    public MenuItem menuItemCodecs = new MenuItem("Kodeki");
    public MenuItem menuItemParameter = new MenuItem("Opis parametrów");
    public MenuButton menuButton;

    public ChoiceBox choiceBox_Frequency = new ChoiceBox(FXCollections.observableArrayList("-", "Wąski", "Szeroki"));
    public TextField fieldFromMax_kbps_bitrate = new TextField();
    public TextField fieldToMax_kbps_bitrate = new TextField();
    public TextField fieldFromFrame_ms = new TextField();
    public TextField fieldToFrame_ms = new TextField();
    public TextField fieldFromMax_bits_per_frame = new TextField();
    public TextField fieldToMax_bits_per_frame = new TextField();
    public TextField fieldFromAlgorithmic_delay_ms = new TextField();
    public TextField fieldToAlgorithmic_delay_ms = new TextField();
    public ChoiceBox choiceBox_CompressionTypes = new ChoiceBox(FXCollections.observableArrayList("-", "PCM", "MP-MLQ", "ACELP", "ADPCM", "LD-CELP", "CS-ACELP", "CS-ACELP LPC", "RPE-LTP", "VSELP", "LPC", "CELP", "TSNFC", "SB-ADPCM", "MLT"));
    public TextField fieldFromMips = new TextField();
    public TextField fieldToMips = new TextField();
    public TextField fieldFromMos = new TextField();
    public TextField fieldToMos = new TextField();

    public Button searchButton = new Button("Szukaj");
    public Button saveButton = new Button("Zapisz");
    public Button resetButton = new Button("Reset");
    private ToolBar toolBarButtons = new ToolBar();

    private HBox hBox1, hBox2, hBox3;

    public MyVBox() {
        labelParameterDescription.setFont(new Font("Arial", 20));
        labelCodecsTable.setFont(new Font("Arial", 20));
        menuButton = new MenuButton("opcje wyświetlania", null, menuItemCodecs, menuItemParameter); //

        /* do szukania */
            // zakres_czestotliwosci
        String[] frequency_ranges = {"-", "Wąski", "Szeroki"};
        Label labelFrequency = new Label("Zakres częstotliwości: ");
        choiceBox_Frequency.setTooltip(new Tooltip("Wybierz zakres częstotliwości"));
        choiceBox_Frequency.setValue(frequency_ranges[0]);

            // maks_przeplywnosc_kbps
        Label labelMax_kbps_bitrate = new Label("Maksymalna przepływność (kb/s) (od - do): ");
        fieldFromMax_kbps_bitrate.setMaxWidth(50);
        fieldToMax_kbps_bitrate.setMaxWidth(50);

            // ramka_ms
        Label labelFrame_ms = new Label("Ramka (ms) (od - do): ");
        fieldFromFrame_ms.setMaxWidth(50);
        fieldToFrame_ms.setMaxWidth(50);

        hBox1 = new HBox(labelFrequency, choiceBox_Frequency, new Separator(), labelMax_kbps_bitrate, fieldFromMax_kbps_bitrate, fieldToMax_kbps_bitrate, new Separator(), labelFrame_ms, fieldFromFrame_ms, fieldToFrame_ms);
        hBox1.setSpacing(20);

            // maks_ilosc_bitow_na_ramke
        Label labelMax_bits_per_frame = new Label("Maksymalna ilość bitów na ramkę (od - do): ");
        fieldFromMax_bits_per_frame.setMaxWidth(50);
        fieldToMax_bits_per_frame.setMaxWidth(50);

            // opoznienie_algorytmiczne_ms
        Label labelAlgorithmic_delay_ms = new Label("Opóźnienie algorytmiczne (ms) (od - do): ");

        fieldFromAlgorithmic_delay_ms.setMaxWidth(50);
        fieldToAlgorithmic_delay_ms.setMaxWidth(50);

        hBox2 = new HBox(labelMax_bits_per_frame, fieldFromMax_bits_per_frame, fieldToMax_bits_per_frame, new Separator(), labelAlgorithmic_delay_ms, fieldFromAlgorithmic_delay_ms, fieldToAlgorithmic_delay_ms);
        hBox2.setSpacing(20);

            // typ_kompresji
        Label labelCompression = new Label("Typ kompresji: ");
        String[] compression_types = {"-", "PCM", "MP-MLQ", "ACELP", "ADPCM", "LD-CELP", "CS-ACELP", "CS-ACELP LPC", "RPE-LTP", "VSELP", "LPC", "CELP", "TSNFC", "SB-ADPCM", "MLT"};
        choiceBox_CompressionTypes.setTooltip(new Tooltip("Wybierz typ kompresji"));
        choiceBox_CompressionTypes.setValue(compression_types[0]);

            // maks_mips
        Label labelMips = new Label("Maksymalna wartość MIPS (od - do): ");
        fieldFromMips.setMaxWidth(50);
        fieldToMips.setMaxWidth(50);

            // mos
        Label labelMos = new Label("MOS (od - do): ");
        fieldFromMos.setMaxWidth(50);
        fieldToMos.setMaxWidth(50);

        hBox3 = new HBox(labelCompression, choiceBox_CompressionTypes, new Separator(), labelMips, fieldFromMips, fieldToMips, new Separator(), labelMos, fieldFromMos, fieldToMos);
        hBox3.setSpacing(20);

        /* przyciski */
            // przycisk do szukania
        Tooltip tooltipSearch = new Tooltip("Pokaż tabele z wynikami według powyższych ustawień.");
        tooltipSearch.setTextAlignment(TextAlignment.CENTER);
        searchButton.setTooltip(tooltipSearch);
        searchButton.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

            // przycisk do zapisania wyników do pliku tekstowego
        Tooltip tooltipSave = new Tooltip("Stwórz nowy plik w domyślnym folderze o nazwie new.txt z wynikiem wyszukiwań.");
        tooltipSave.setTextAlignment(TextAlignment.CENTER);
        saveButton.setTooltip(tooltipSave);
        saveButton.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

            // przycisk do zresetowania wyszukiwań
        Tooltip tooltipReset = new Tooltip("Zresetuj wyszukiwania. Wyświetl całą tabelę.");
        tooltipReset.setTextAlignment(TextAlignment.CENTER);
        resetButton.setTooltip(tooltipReset);
        resetButton.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

            // ToolBar Buttons
        toolBarButtons.getItems().add(searchButton);
        toolBarButtons.getItems().add(new Separator());
        toolBarButtons.getItems().add(saveButton);
        toolBarButtons.getItems().add(new Separator());
        toolBarButtons.getItems().add(resetButton);
        toolBarButtons.setMaxWidth(295);
    }

    public VBox getMyCodecsVBox(TableView<TableCodecs> codecsTableView) {
        VBox myVBox = new VBox();
        myVBox.setSpacing(5);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(menuButton, labelCodecsTable, codecsTableView, hBox1, hBox2, hBox3, toolBarButtons);
        return myVBox;
    }

    public VBox getMyParameterVBox(String strParamDesc) {
        VBox myVBox = new VBox();
        paramDescription = new Text(strParamDesc);
        paramDescription.setFont(new Font("Arial", 15));
        paramDescription.wrappingWidthProperty().set(1200);
        myVBox.setSpacing(5);
        myVBox.setPadding(new Insets(10, 0, 0, 10));
        myVBox.getChildren().addAll(menuButton, labelParameterDescription, paramDescription);
        return myVBox;
    }
}
