package es.ifp.proyectodamgrupo8;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class DataBase {

    protected String server;
    protected String port;
    protected String dbName;
    protected String user;
    protected String password;
    int i=0;

    protected Connection conexion=null;
    protected Statement peticion;
    protected ResultSet result;

    public DataBase() {

        this.server="192.168.1.55";
        this.port="3306";
        this.dbName="peluqueria";
        this.user="root";
        this.password="";
    }

    public DataBase(String server, String port, String dbName, String user, String password) {

        this.server=server;
        this.port=port;
        this.dbName=dbName;
        this.user=user;
        this.password=password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean conex() {


        try {

            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver).newInstance();

            conexion= (Connection) DriverManager.getConnection("jdbc:mysql://"+this.server+":"+this.port+"/"+ this.dbName,this.user,this.password );
            return true;
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    public boolean access (String u, String p) {

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                result= (ResultSet) peticion.executeQuery("SELECT * FROM usuarios");

                while(result.next())
                {
                    if (u.equalsIgnoreCase(result.getString("usuario")) && p.equals(result.getString("password")))
                    {
                        return true;
                    }
                }
                result.close();
                peticion.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return false;
    }

    public boolean userOrAdmin(String user) {

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                result= (ResultSet) peticion.executeQuery("SELECT * FROM usuarios WHERE usuario='"+user+"'");

                if (result.getString("rol").equals("admin")) {
                    return true;
                }
                /*while(result.next())
                {
                    Producto p= new Producto();
                    p.setId(result.getInt("id"));
                    p.setNombre( result.getString("nombre"));
                    p.setPrecio(result.getFloat("precio"));
                    p.setCantidad( result.getInt("cantidad"));

                    productos.add(p);
                }*/
                result.close();
                peticion.close();

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    public int crearUsuario (String user, String pass, String rol) {

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                return peticion.executeUpdate("INSERT INTO usuarios (usuario,password,rol) VALUES ('"+user+"',"+pass+","+rol+")");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int crearCita (Date date, Time time, int idUser) {

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                return peticion.executeUpdate("INSERT INTO citas (fecha,hora,id_usuario) VALUES ('"+date+"',"+time+","+idUser+")");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }

    /*public void showProducts() {

        ArrayList<Producto> productos= new ArrayList<Producto>();

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                result= (ResultSet) peticion.executeQuery("SELECT * FROM productos");

                while(result.next())
                {
                    Producto p= new Producto();
                    p.setId(result.getInt("id"));
                    p.setNombre( result.getString("nombre"));
                    p.setPrecio(result.getFloat("precio"));
                    p.setCantidad( result.getInt("cantidad"));

                    productos.add(p);
                }
                result.close();
                peticion.close();

                for (i=0; i<productos.size(); i++) {

                    System.out.println(productos.get(i).getId()+" "+productos.get(i).getNombre()+" "+productos.get(i).getPrecio()+"€ "+productos.get(i).getCantidad()+" unidades.");
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }*/

    public int update (int id, String name, float price, int qty) {

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                return peticion.executeUpdate("UPDATE productos SET nombre='"+name+"',precio="+price+",cantidad="+qty+" WHERE id="+id);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }

    public int delete (int id) {

        if (conexion!=null) {

            try {
                peticion = (Statement) conexion.createStatement();
                return peticion.executeUpdate("DELETE FROM productos WHERE id="+id);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return 0;
    }
}
