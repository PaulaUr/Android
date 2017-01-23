package edu.upc.eetac.dsa.etakemon_projecte.estructura;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by ivanm on 15/12/2016.
 */
public abstract class DAO {


    public static Connection getConnection() {
        Connection con = null;
        try {
            String host = "localhost";
            int port = 3306;
            String database = "juego2";
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "25098866");
            info.setProperty("useSSL", "false");
            info.setProperty("serverTimezone", "UTC");
            con = DriverManager.getConnection(url, info);
            System.out.println("CONEXIÓN CREADA");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /*INSERT FUNCIONA*/
    public void insert() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ").append(this.getClass().getSimpleName()).append(" (");

        Field[] fields = this.getClass().getDeclaredFields();

        int i = 0;
        //rellenar campos con los parametros de Usuario
        for (Field f : fields) {
            if (i == fields.length - 1) { //para quitar la ultima coma
                sb.append(f.getName());
            } else {
                sb.append(f.getName()).append(",");
            }
            i++;
        }

        sb.append(") VALUES (");

        int j = 0;
        for (Field f : fields) {
            if (j == fields.length - 1) {
                sb.append("?");
            } else {
                sb.append("?,");
            }
            j++;
        }

        sb.append(") ");


        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
            insertarElementos(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
        }
    }

    private void insertarElementos(PreparedStatement preparedStatement) {
        int i = 1;
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field f : fields) {
            String res = getValors(f);//obtienes el valor de esa posición
            try {
                preparedStatement.setObject(i, res); //asigna valor al interrrogante de esa posicion
            } catch (SQLException e) {
            }
            i++;
        }
    }

    //función que coge los valores de las variables
    private String getValors(Field f) {
        String res = null;
        try {
            Method m = this.getClass().getMethod(getUpper(f.getName()), null);
            res = m.invoke(this, null).toString();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return res;
    }

    private String getUpper(String m) {
        String result = Character.toUpperCase(m.charAt(0)) + m.substring(1);
        return "get".concat(result);
    }

    /*
    * HAY QUE ARREGLARLO Q NO VA AUN
    *
    * */
    public void update(int iu) {

        Connection con = getConnection();  //obtener conexión de la base de datos
        StringBuffer consulta = new StringBuffer();
        consulta.append("UPDATE ").append(this.getClass().getSimpleName()).append(" SET ");

        Field[] fields = this.getClass().getDeclaredFields(); //campos--> obtener campos declarados en esta clase:nombre, address, id

        int numfields = 0;
        for (Field f : fields) {
            if (f.getGenericType().toString().equals("INT")) {
                consulta.append(f.getName()).append("=?,");
            } else {
                if (numfields == fields.length - 1) {
                    consulta.append(f.getName()).append("=?");
                } else {
                    consulta.append(f.getName()).append("=?,");
                }
            }
            numfields++;
        }
        consulta.append(" WHERE idUsuario =" + iu);

        String query = consulta.toString();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            insertarElementos(preparedStatement); //asignar valor correspondiente
            preparedStatement.execute();
        } catch (SQLException e) {
        }
    }


    /*DELETE FUNCIONA*/
    //Eliminar de la BBDD
    public void delete(int iu) {
        Connection con = getConnection();
        StringBuffer consulta = new StringBuffer();
        consulta.append("DELETE FROM ").append(this.getClass().getSimpleName()).append(" WHERE idusuarios =" + iu);
        Statement stmt = null;
        //EJECUTO CONSULTA
        try {
            stmt = con.createStatement();
            stmt.execute(consulta.toString());
        } catch (SQLException e) {
        }
    }

    public List<Integer> select(int pk) {

        Connection con = getConnection();

        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT * FROM ").append(this.getClass().getSimpleName()).append(" WHERE idUsuario = " + pk);

        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta.toString()); //Y RECOJO LOS DATOS EN rs
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) { //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {//para la columna i,si es del tipo int
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getInt(i)); //obtengo la etiqueta de la columna y el entero (id=1...)
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) { //si es del tipovarchar, obtengo lo que es tambien
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                } catch (Exception e) {
                   // logger.error("SELECT: " +e);
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }


    /*SELECCIONA DATOS USUARIO Y LOS GUARDAS */
    public Usuario select2(int pk) {

        Connection con = getConnection();
        Usuario u = new Usuario();

        StringBuffer consulta = new StringBuffer();
        consulta.append("SELECT * FROM ").append(this.getClass().getSimpleName()).append(" WHERE idUsuario = " + pk);

        Statement stmt = null;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(consulta.toString()); //Y RECOJO LOS DATOS EN rs
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) { //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    if (rsmd.getColumnLabel(i).equals("idUsuario")){
                        u.setIdUsuario(rs.getInt(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("nombre")){
                        u.setNombre(rs.getString(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("nick")){
                        u.setNick(rs.getString(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("email")){
                        u.setEmail(rs.getString(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("password")){
                        u.setContraseña(rs.getString(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("batganadas")){
                        u.setBatganadas(rs.getInt(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("batjugadas")){
                        u.setBatjugadas(rs.getInt(i));
                    }
                    if (rsmd.getColumnLabel(i).equals("experiencia")){
                        u.setExperiencia(rs.getInt(i));
                    }



                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
        }
        return u;
    }


    /* SELECT PARA DATOS OLVIDADOS*/
    /*public StringBuffer selectDatos(int correo){
        StringBuffer sbdatos = new StringBuffer();
        sbdatos.append("SELECT * FROM Usuario WHERE email = " +correo);
        logger.info("Query selectDatos: " +sbdatos.toString());

        Connection con = getConnection();
        Statement stmt = null;

        StringBuffer res = new StringBuffer("datos:");
        try{
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sbdatos.toString());
            ResultSetMetaData rsmd = rs.getMetaData();
            for (int i=1; i < rsmd.getColumnCount() + 1; i++){
                try{
                    if (rsmd.getColumnTypeName(i).equals("INT"))
                        res.append(rsmd.getColumnLabel(i) + "=" +rs.getInt(i));
                        logger.info(rsmd.getColumnLabel(i) + "=" +rs.getInt(i) );
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR"))
                        logger.info(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                        res.append(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                }
                catch (Exception e){
                    logger.error("selectDatos: "+e.getMessage());
                }
            }

        }
        catch (SQLException e){
            logger.error("Query selectDatos: "+e.getMessage());
        }
        return res;
    }*/


}

