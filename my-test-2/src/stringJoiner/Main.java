package stringJoiner;

import java.util.StringJoiner;

public class Main {
    public static void main(String[] args){
        String[] s= new String[]{"name","sno","grade"};
        String table = "student";
        String sql = buildSelectSql(table,s);
        System.out.println(sql);
    }

    static String buildSelectSql(String table,String[] fields){
        StringJoiner js= new StringJoiner(",","SELECT "," FROM "+table);
        for(String field:fields){
            js.add(field);
        }
        return js.toString();
    }
}


