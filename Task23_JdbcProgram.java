import java.sql.*;


public class JdbcProgram {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try {

            //Create a connection using the static getConnection method
            String url = "jdbc:mysql://localhost/Demo";
            Connection connection = DriverManager.getConnection(url,"root","30071990");

            if(connection!=null) {
                System.out.println("Connected to database Successfully");
                //Create a statement class to execute the SQL statement
                Statement st = connection.createStatement();

                //Write the Queries
                //1. Create a table 'Employee' in Demo database
                String createTable="create table Employee(empcode int,empname varchar(255),empage int,esalary int)";
                st.executeUpdate(createTable);

                //2. Insert data into the table Employee
                st.executeUpdate("Insert into Employee " + "values (101,'Jenny',25,10000)");
                st.executeUpdate("Insert into Employee " + "values (102,'Jacky',30,20000)");
                st.executeUpdate("Insert into Employee " + "values (103,'Joe',20,40000)");
                st.executeUpdate("Insert into Employee " + "values (104,'John',40,80000)");
                st.executeUpdate("Insert into Employee " + "values (105,'Shameer',25,90000)");

                //3. Get the Result
                ResultSet rs= st.executeQuery("select * from Employee;");
                while(rs.next())
                {
                    System.out.println(rs.getInt("empcode")+"||"+rs.getString("empname")+"||"+rs.getInt("empage")+"||"+rs.getInt("esalary"));

                }
            }else {
                System.out.println("Failed to connect database");
            }
        }catch(SQLException e) {
            System.out.println("Database Connection Error");
            e.printStackTrace();
        }
    }
}
