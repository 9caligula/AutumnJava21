package com.netcracker.lesson;

import java.sql.*;
import java.util.List;

public class SolutionMain {
    public static void main(String[] args) throws SQLException {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        List<Verb> verbs = VerbsService.getInstance.getList();


        try(Connection connection = DriverManager.getConnection("jdbc:h2:mem:testa")){
            connection.setAutoCommit(false);
            PreparedStatement create = connection.prepareStatement(CREATE_TABLE_SQL);
            create.execute();
            PreparedStatement insert = connection.prepareStatement(INSERT_ROW_SQL);

            connection.commit();
        }
    }

    public static final String CREATE_TABLE_SQL = "CREATE TABLE \"VERBS\" (\n" +
            "\tid int IDENTITY(1,1), \n" +
            "\tINFINITIVE varchar (250) NOT NULL, \n" +
            "\tPAST_PARTICIPLE varchar (250), \n" +
            "\tRUS_NAME varchar(250), \n" +
            "\tPRIMARY KEY (id), \n" +
            "\tunique (INFINITIVE) \n" +
                    ")";

    public static final String INSERT_ROW_SQL = "insert into VERBS " +
            "(\"INFINITIVE\", \"PAST_PARTICIPLE\", \"RUS_NAME\") values ('?', '?', '?')";

    public static final String SELECT_ROW_BY_RUSNAME = "select * from VERBS where RUS_NAME = ?";
}