package org.example;

import java.sql.*;
import java.util.Date;

public class BaseDeDatos {

        public static void main(String[] args) throws Exception {

            Paciente paciente1 = new Paciente("juan", "perez", "CABA", 123455L,new Date(10,10,10),"JuanP", "1234");
            try {

            Class.forName("org.h2.Driver");
            Connection con = DriverManager.getConnection("jdbc:h2:~/PACIENTES", "USUARIO", "CLAVE");
                Statement stmt = con.createStatement();
                String createSql = "DROP TABLE IF EXISTS TEST_PACIENTE; " +
                        "CREATE TABLE TEST_PACIENTE(DNI INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50), APELLIDO VARCHAR(50)," +
                        "                 DOMICILIO VARCHAR (50), FECHADEALTA DATE, USERNAME VARCHAR (50)," +
                        "                  PASSWORD VARCHAR (50) );";

                stmt.execute(createSql);
                String insertarRegistros="INSERT INTO TEST_PACIENTE(DNI, NOMBRE, APELLIDO, USERNAME, PASSWORD)" +
                        " VALUES(?,?,?,?,?);";
                PreparedStatement pstm = con.prepareStatement(insertarRegistros);
                pstm.setLong(1, paciente1.getDni());
                pstm.setString(2, paciente1.getNombre());
                pstm.setString(3, paciente1.getApellido());
               // pstm.setDate(4, paciente1.getFechaDeAlta());
                pstm.setString(4, paciente1.getUsername());
                pstm.setString(5, paciente1.getPassword());

                pstm.executeUpdate();

                try {con.setAutoCommit(false);
                    String updatePassword = "UPDATE TEST_PACIENTE SET PASSWORD = ? WHERE DNI = ?";
                    PreparedStatement pstm1 = con.prepareStatement(updatePassword);
                    pstm1.setString(1,"2345");
                   pstm1.setInt(1,1);
                   //int resultado = 4/0;
                    pstm1.setLong(2, paciente1.getDni());
                    //pstm1.setLong(2,45667); // Aca funciona la excepcion, solo muestra la excepcion de esta manera.
                    pstm1.executeUpdate();
                    int registrosModificados = pstm1.executeUpdate();
                    if (registrosModificados<1){
                        throw new RuntimeException("No se modificaron registros con ese DNI");
                    }
                    con.commit(); /*si sale todo bien lo comitea sino se anulan las operaciones anteriores*/
                    con.setAutoCommit(true);
                } catch (SQLException | RuntimeException e) {
                    con.rollback(); //Otras bases de datos necesitan esta linea.
                    System.err.println(e.getMessage());
                }

                String mostrarResultados = "SELECT * FROM TEST_PACIENTE;";
                Statement stm = con.createStatement();
                //stm.executeQuery(mostrarResultados);
                ResultSet resultado = stm.executeQuery(mostrarResultados);

                while (resultado.next()){
                    System.out.println("Paciente: " + resultado.getString("NOMBRE")
                    + "; APELLIDO: " +resultado.getString("APELLIDO")
                    ); // Faltarian los demas.

                }

            }
            catch (Exception e){
                System.err.println(e.getMessage());
            }

                /*Tenemos que crear una conexión a la base de datos e insertar una fila paciente.
                  Luego, abrir una transacción y asignar otro password con una sentencia
                update y, paso siguiente, generar una excepción (throw new Exception).
                Por último, corroborar con una consulta que el paciente existe y que el
                campo password mantuvo su valor inicial del punto 1.*/



        }
}
