package DateBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DBHandler db = new DBHandler();

        String query = "select * from table_name";
        String query2 = "insert into table_name (name) values('huy')";
        try {
            Statement statement = db.getConnection().createStatement();

            statement.execute(query2);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString("name");
                System.out.println(id);
                System.out.println(name);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }




    }
}
