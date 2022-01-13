package stringBuilder;

public class Main {
    public static void main(String[] args){
        String[] fields = {"name","position","salary"};
        String table = "employee";
        String insert = buildInsertSql(table,fields);
        System.out.println(insert);
    }
    static String buildInsertSql(String table,String[] fields){
        StringBuilder x = new StringBuilder(1024);
        for (int field = 0;field<fields.length;field++){
            if(field == 0){
                x.insert(0," (");

            }else {
                x.append(", ");
            }
            x.append(fields[field]);
            if(field == (fields.length-1)){
                x.append(") VALUES (?, ?, ?)");
            }
        }
        x.insert(0,table).insert(0,"INSERT INTO ");
        return  x.toString();

    }
}


