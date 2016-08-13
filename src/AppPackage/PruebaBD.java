/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppPackage;

import java.sql.SQLException;
/**
 * Fecha de Inicio del proyecto 
 * Fecha de Finalización del proyecto
 * @author Eisner Lopez y Diego Murillo
 */
public class PruebaBD {    
    /**
     * Metodo que permite la conexion crear la conección a la base de datos
     * @param ses
     * @throws SQLException
     */
    public static void main(String[] ses) throws SQLException
    {
        Conectar.Coneccion c = new Conectar.Coneccion();
    }
}
