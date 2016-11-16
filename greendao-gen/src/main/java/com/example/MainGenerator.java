package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        Schema schema = new Schema(1, "DAO");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "\\app\\src\\main\\java\\cr\\co\\sea\\seaforms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        //Entity cli = addCliente(schema);
        Entity contrato = addContrato(schema);
        Entity formulario = addFormulario(schema);
       // Property userId = contrato.addLongProperty("CliId").notNull().getProperty();
      //  cli.addToMany(contrato, userId, "cliContratos");
    }

   /* private static Entity addCliente(final Schema schema) {
        Entity cliente = schema.addEntity("Cliente");
        cliente.addIdProperty().primaryKey().autoincrement();
        cliente.addStringProperty("CliTipoIdentificacion");
        cliente.addStringProperty("CliIdentificacion");
        cliente.addStringProperty("CliPasaporte");
        cliente.addStringProperty("CliNombre").notNull();
        cliente.addStringProperty("CliApellido1").notNull();
        cliente.addStringProperty("CliApellido2");
        cliente.addStringProperty("CliEmail");
        cliente.addStringProperty("CliSexo").notNull();
        cliente.addDateProperty("CliFechaNacimiento").notNull();
        cliente.addStringProperty("CliTelCasa");
        cliente.addStringProperty("CliTelCel");
        cliente.addStringProperty("CliTelCel2");
        cliente.addStringProperty("CliFax");
        cliente.addStringProperty("CliDireccion").notNull();
        cliente.addStringProperty("CliOtrasSenas");
        cliente.addStringProperty("CliProvincia");
        cliente.addStringProperty("CliCanton");
        cliente.addStringProperty("CliDistrito");
        cliente.addStringProperty("CliTipoTarjeta");
        cliente.addStringProperty("CliNumeroTarjeta");
        cliente.addStringProperty("CliNumeroSeguridad");
        cliente.addStringProperty("CliVencimientoTarjeta");

        return cliente;
    }*/

    private static Entity addContrato(final Schema schema) {
        Entity contrato = schema.addEntity("Contrato");
        contrato.addIdProperty().primaryKey().autoincrement();
        contrato.addDateProperty("Fecha");
        contrato.addStringProperty("TipoIdentificacion");
        contrato.addStringProperty("Identificacion");
        contrato.addStringProperty("Pasaporte");
        contrato.addStringProperty("Nombre").notNull();
        contrato.addStringProperty("Apellido1").notNull();
        contrato.addStringProperty("Apellido2");
        contrato.addStringProperty("Email");
        contrato.addStringProperty("Sexo").notNull();
        contrato.addDateProperty("FechaNacimiento").notNull();
        contrato.addStringProperty("TelCasa");
        contrato.addStringProperty("TelCel");
        contrato.addStringProperty("TelCel2");
        contrato.addStringProperty("Fax");
        contrato.addStringProperty("Direccion").notNull();
        contrato.addStringProperty("OtrasSenas");
        contrato.addStringProperty("Provincia");
        contrato.addStringProperty("Canton");
        contrato.addStringProperty("Distrito");
        contrato.addStringProperty("TipoTarjeta");
        contrato.addStringProperty("NumeroTarjeta");
        contrato.addStringProperty("NumeroSeguridad");
        contrato.addStringProperty("VencimientoTarjeta");
        contrato.addFloatProperty("MontoTotal");
        contrato.addByteArrayProperty("Foto1");
        contrato.addByteArrayProperty("Foto2");
        contrato.addByteArrayProperty("Foto3");
        contrato.addByteArrayProperty("Foto4");
        contrato.addByteArrayProperty("FotoFirma");
        contrato.addStringProperty("Generico1");
        contrato.addStringProperty("Generico2");
        contrato.addStringProperty("Generico3");
        contrato.addStringProperty("Generico4");
        contrato.addStringProperty("Generico5");
        contrato.addStringProperty("Generico6");
        contrato.addStringProperty("Generico7");
        contrato.addStringProperty("Generico8");
        contrato.addStringProperty("Generico9");
        contrato.addStringProperty("Generico10");
        contrato.addStringProperty("Generico11");
        contrato.addStringProperty("Generico12");
        contrato.addStringProperty("Generico13");
        contrato.addStringProperty("Generico14");
        contrato.addStringProperty("Generico15");
        contrato.addStringProperty("Generico16");
        contrato.addStringProperty("Generico17");
        contrato.addStringProperty("Generico18");
        contrato.addStringProperty("Generico19");
        contrato.addStringProperty("Generico20");
        contrato.addStringProperty("Generico21");
        contrato.addStringProperty("Generico22");
        contrato.addStringProperty("Generico23");
        contrato.addStringProperty("Generico24");
        contrato.addStringProperty("Generico25");
        contrato.addStringProperty("Generico26");
        contrato.addStringProperty("Generico27");
        contrato.addStringProperty("Generico28");
        contrato.addStringProperty("Generico29");
        contrato.addStringProperty("Generico30");

        //contrato.addIntProperty("watchers_count");

        return contrato;
    }
    private static Entity addFormulario(final Schema schema) {
        Entity formulario = schema.addEntity("Formulario");
        formulario.addIdProperty().primaryKey().autoincrement();
        formulario.addStringProperty("Form_nombre");
        formulario.addStringProperty("Form_valor");

        return formulario;
    }
}