package JavaFX_project.Database;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDaoCodecs {

    private final NamedParameterJdbcTemplate jdbc;

    public TableDaoCodecs() {
        String url = "jdbc:sqlite:SQLite_voip2.db";
        DataSource dataSource = new DriverManagerDataSource(url);
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<TableCodecs> getAll() {
        String sql = "SELECT c.id_kodeka, c.nazwa_kodeka, c.zakres_czestotliwosci, c.maks_przeplywnosc_kbps, c.ramka_ms, " +
                "c.maks_ilosc_bitow_na_ramke, c.opoznienie_algorytmiczne_ms, c.typ_kompresji, c.maks_mips, c.mos FROM Kodeki c ";
        try {
            return jdbc.query(sql, new RowMapper<TableCodecs>() {
                @Override
                public TableCodecs mapRow(ResultSet rs, int rownumber) throws SQLException {
                    TableCodecs tableCodecs = new TableCodecs();
                    tableCodecs.setCodec_id(rs.getInt(1));
                    tableCodecs.setCodec_name(rs.getString(2));
                    tableCodecs.setFrequency_range(rs.getString(3));
                    tableCodecs.setMax_kbps_bitrate(rs.getFloat(4));
                    tableCodecs.setFrame_ms(rs.getFloat(5));
                    tableCodecs.setMax_bits_per_frame(rs.getInt(6));
                    tableCodecs.setAlgorithmic_delay_ms(rs.getFloat(7));
                    tableCodecs.setCompression_type(rs.getString(8));
                    tableCodecs.setMips(rs.getFloat(9));
                    tableCodecs.setMos(rs.getFloat(10));
                    return tableCodecs;
                }
            });
        } catch (EmptyResultDataAccessException ex) {
            return new ArrayList<>();
        }
    }

    public List<TableCodecs> getSpecified(String frequency_range, String max_kbps_bitrateFrom, String max_kbps_bitrateTo, String frame_msFrom, String frame_msTo, String max_bits_per_frameFrom, String max_bits_per_frameTo, String algorithmic_delay_msFrom, String algorithmic_delay_msTo, String compression_type, String mipsFrom, String mipsTo, String mosFrom, String mosTo) {
        String sql = "SELECT c.id_kodeka, c.nazwa_kodeka, c.zakres_czestotliwosci, c.maks_przeplywnosc_kbps, c.ramka_ms, " +
                "c.maks_ilosc_bitow_na_ramke, c.opoznienie_algorytmiczne_ms, c.typ_kompresji, c.maks_mips, c.mos FROM Kodeki c ";

        if (frequency_range != "-" || max_kbps_bitrateFrom != "" || max_kbps_bitrateTo != "" || frame_msFrom != "" || frame_msTo != "" || max_bits_per_frameFrom != "" || max_bits_per_frameTo != "" || algorithmic_delay_msFrom != "" || algorithmic_delay_msTo != "" || compression_type != "-" || mipsFrom != "" || mipsTo != "" || mosFrom != "" || mosTo != "") {
            boolean first = true;
            if (frequency_range != "-") {
                sql = sql + "WHERE c.zakres_czestotliwosci = :frequency_range ";
                first = false;
            }
            if (!max_kbps_bitrateFrom.isEmpty() || !max_kbps_bitrateTo.isEmpty()) {
                if (max_kbps_bitrateFrom.isEmpty()) {
                    max_kbps_bitrateFrom = "0";
                }
                if (max_kbps_bitrateTo.isEmpty()) {
                    max_kbps_bitrateTo = "64";
                }
                if (first) {
                    sql = sql + "WHERE c.maks_przeplywnosc_kbps BETWEEN :max_kbps_bitrateFrom AND :max_kbps_bitrateTo ";
                    first = false;
                } else {
                    sql = sql + "AND c.maks_przeplywnosc_kbps BETWEEN :max_kbps_bitrateFrom AND :max_kbps_bitrateTo ";
                }
            }
            if (!frame_msFrom.isEmpty() || !frame_msTo.isEmpty()) {
                if (frame_msFrom.isEmpty()) {
                    frame_msFrom = "0";
                }
                if (frame_msTo.isEmpty()) {
                    frame_msTo = "30";
                }
                if (first) {
                    sql = sql + "WHERE c.ramka_ms BETWEEN :frame_msFrom AND :frame_msTo ";
                    first = false;
                } else {
                    sql = sql + "AND c.ramka_ms BETWEEN :frame_msFrom AND :frame_msTo ";
                }
            }
            if (!max_bits_per_frameFrom.isEmpty() || !max_bits_per_frameTo.isEmpty()) {
                if (max_bits_per_frameFrom.isEmpty()) {
                    max_bits_per_frameFrom = "0";
                }
                if (max_bits_per_frameTo.isEmpty()) {
                    max_bits_per_frameTo = "884";
                }
                if (first) {
                    sql = sql + "WHERE c.maks_ilosc_bitow_na_ramke BETWEEN :max_bits_per_frameFrom AND :max_bits_per_frameTo ";
                    first = false;
                } else {
                    sql = sql + "AND c.maks_ilosc_bitow_na_ramke BETWEEN :max_bits_per_frameFrom AND :max_bits_per_frameTo ";
                }
            }
            if (!algorithmic_delay_msFrom.isEmpty() || !algorithmic_delay_msTo.isEmpty()) {
                if (algorithmic_delay_msFrom.isEmpty()) {
                    algorithmic_delay_msFrom = "0";
                }
                if (algorithmic_delay_msTo.isEmpty()) {
                    algorithmic_delay_msTo = "40";
                }
                if (first) {
                    sql = sql + "WHERE c.opoznienie_algorytmiczne_ms BETWEEN :algorithmic_delay_msFrom AND :algorithmic_delay_msTo ";
                    first = false;
                } else {
                    sql = sql + "AND c.opoznienie_algorytmiczne_ms BETWEEN :algorithmic_delay_msFrom AND :algorithmic_delay_msTo ";
                }
            }
            if (compression_type != "-") {
                if (first) {
                    sql = sql + "WHERE c.typ_kompresji = :compression_type ";
                    first = false;
                } else {
                    sql = sql + "AND c.typ_kompresji = :compression_type ";
                }
            }
            if (!mipsFrom.isEmpty() || !mipsTo.isEmpty()) {
                if (mipsFrom.isEmpty()) {
                    mipsFrom = "0";
                }
                if (mipsTo.isEmpty()) {
                    mipsTo = "38";
                }
                if (first) {
                    sql = sql + "WHERE c.maks_mips BETWEEN :mipsFrom AND :mipsTo ";
                    first = false;
                } else {
                    sql = sql + "AND c.maks_mips BETWEEN :mipsFrom AND :mipsTo ";
                }
            }
            if (!mosFrom.isEmpty() || !mosTo.isEmpty()) {
                if (mosFrom.isEmpty()) {
                    mosFrom = "0";
                }
                if (mosTo.isEmpty()) {
                    mosTo = "5";
                }
                if (first) {
                    sql = sql + "WHERE c.mos BETWEEN :mosFrom AND :mosTo ";
                    first = false;
                } else {
                    sql = sql + "AND c.mos BETWEEN :mosFrom AND :mosTo ";
                }
            }
        }
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("frequency_range", frequency_range);
        paramSource.addValue("max_kbps_bitrateFrom", max_kbps_bitrateFrom);
        paramSource.addValue("max_kbps_bitrateTo", max_kbps_bitrateTo);
        paramSource.addValue("frame_msFrom", frame_msFrom);
        paramSource.addValue("frame_msTo", frame_msTo);
        paramSource.addValue("max_bits_per_frameFrom", max_bits_per_frameFrom);
        paramSource.addValue("max_bits_per_frameTo", max_bits_per_frameTo);
        paramSource.addValue("algorithmic_delay_msFrom", algorithmic_delay_msFrom);
        paramSource.addValue("algorithmic_delay_msTo", algorithmic_delay_msTo);
        paramSource.addValue("compression_type", compression_type);
        paramSource.addValue("mipsFrom", mipsFrom);
        paramSource.addValue("mipsTo", mipsTo);
        paramSource.addValue("mosFrom", mosFrom);
        paramSource.addValue("mosTo", mosTo);
        try {
            return jdbc.query(sql, paramSource, new RowMapper<TableCodecs>() {
                @Override
                public TableCodecs mapRow(ResultSet rs, int rownumber) throws SQLException {
                    TableCodecs tableCodecs = new TableCodecs();
                    tableCodecs.setCodec_id(rs.getInt(1));
                    tableCodecs.setCodec_name(rs.getString(2));
                    tableCodecs.setFrequency_range(rs.getString(3));
                    tableCodecs.setMax_kbps_bitrate(rs.getFloat(4));
                    tableCodecs.setFrame_ms(rs.getFloat(5));
                    tableCodecs.setMax_bits_per_frame(rs.getInt(6));
                    tableCodecs.setAlgorithmic_delay_ms(rs.getFloat(7));
                    tableCodecs.setCompression_type(rs.getString(8));
                    tableCodecs.setMips(rs.getFloat(9));
                    tableCodecs.setMos(rs.getFloat(10));
                    return tableCodecs;
                }
            });
        } catch (EmptyResultDataAccessException ex) {
            return new ArrayList<>();
        }
    }
}
