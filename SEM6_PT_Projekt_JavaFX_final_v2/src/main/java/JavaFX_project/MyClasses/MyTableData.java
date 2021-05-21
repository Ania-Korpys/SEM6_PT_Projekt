package JavaFX_project.MyClasses;

import JavaFX_project.Database.TableCodecs;
import JavaFX_project.Database.TableDaoCodecs;
import JavaFX_project.Database.TableDaoParameterDescription;
import JavaFX_project.Database.TableParameterDescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class MyTableData {

    private TableDaoParameterDescription parameterDescriptionDao = new TableDaoParameterDescription();
    private List<TableParameterDescription> parameterDescriptionList = parameterDescriptionDao.getAll();
    private ObservableList<TableParameterDescription> parameterDescriptionData = FXCollections.observableArrayList(parameterDescriptionList);
    private String strParamDesc = "\n";

    private TableView<TableCodecs> codecsTableView;
    private TableDaoCodecs codecsTableDao = new TableDaoCodecs();
    private List<TableCodecs> codecsTableList = codecsTableDao.getAll();
    private ObservableList<TableCodecs> codecsTableData = FXCollections.observableArrayList(codecsTableList);

    private TableColumn codec_idColl = new TableColumn("id_kodeka");
    private TableColumn codec_nameColl = new TableColumn("Nazwa kodeka");
    private TableColumn frequency_rangeColl = new TableColumn("Zakres częstotliwości");
    private TableColumn max_kbps_bitrateColl = new TableColumn("Maksymalna przepływność (kb/s)");
    private TableColumn frame_msColl = new TableColumn("Ramka (ms)");
    private TableColumn max_bits_per_frameColl = new TableColumn("Maksymalna ilość bitów na ramkę");
    private TableColumn algorithmic_delay_msColl = new TableColumn("Opóźnienie algorytmiczne (ms)");
    private TableColumn compression_typeColl = new TableColumn("Typ kompresji");
    private TableColumn mipsColl = new TableColumn("Maksymalna wartość MIPS");
    private TableColumn mosColl = new TableColumn("MOS");

    public MyTableData() {
        codec_idColl.setMinWidth(50);
        codec_idColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("codec_id"));
        codec_nameColl.setMinWidth(150);
        codec_nameColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("codec_name"));
        frequency_rangeColl.setMinWidth(125);
        frequency_rangeColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("frequency_range"));
        max_kbps_bitrateColl.setMinWidth(125);
        max_kbps_bitrateColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("max_kbps_bitrate"));
        frame_msColl.setMinWidth(125);
        frame_msColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("frame_ms"));
        max_bits_per_frameColl.setMinWidth(125);
        max_bits_per_frameColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("max_bits_per_frame"));
        algorithmic_delay_msColl.setMinWidth(150);
        algorithmic_delay_msColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("algorithmic_delay_ms"));
        compression_typeColl.setMinWidth(150);
        compression_typeColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("compression_type"));
        mipsColl.setMinWidth(75);
        mipsColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("mips"));
        mosColl.setMinWidth(75);
        mosColl.setCellValueFactory(new PropertyValueFactory<TableCodecs, String>("mos"));
    }

    public TableView<TableCodecs> getCodecsTableView() {
        codecsTableView = new TableView<TableCodecs>();
        codecsTableData = FXCollections.observableArrayList(codecsTableList);
        codecsTableView.setItems(codecsTableData);
        codecsTableView.getColumns().addAll(codec_idColl, codec_nameColl, frequency_rangeColl, max_kbps_bitrateColl, frame_msColl,
                max_bits_per_frameColl, algorithmic_delay_msColl, compression_typeColl, mipsColl, mosColl);
        return codecsTableView;
    }

    public TableView<TableCodecs> getCodecsTableView(ObservableList<TableCodecs> codecsTableData2) {
        codecsTableData = codecsTableData2;
        codecsTableView = new TableView<TableCodecs>();
        codecsTableView.setItems(codecsTableData2);
        codecsTableView.getColumns().addAll(codec_idColl, codec_nameColl, frequency_rangeColl, max_kbps_bitrateColl, frame_msColl,
                max_bits_per_frameColl, algorithmic_delay_msColl, compression_typeColl, mipsColl, mosColl);
        return codecsTableView;
    }

    public String getParametersDescription() {
        if (strParamDesc == "\n") {
            for (int i = 0; i < parameterDescriptionData.size(); i++) {
                strParamDesc = strParamDesc + parameterDescriptionData.get(i) + "\n\n";
            }
        }
        return strParamDesc;
    }

    public String getStringWriteToFile() {
        String strWriteToFile = "";
        for (int i = 0; i < codecsTableData.size(); i++) {
            strWriteToFile = strWriteToFile + codecsTableData.get(i) + "\n";
        }
        return strWriteToFile;
    }
}
