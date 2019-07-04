package javafxmvc.model.database;

public class DatabaseFactory {
    public static Database getDatabase(String nome){
        if(nome.equals("javafxmvc")){
            return new DatabasePostgreSQL();
        }else if(nome.equals("mysql")){
            return new DatabaseMySQL();
        }
        return null;
    }
}
