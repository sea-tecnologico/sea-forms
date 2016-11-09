package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
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
        Entity cli = addCliente(schema);
        Entity contrato = addContrato(schema);
        Entity formulario = addFormulario(schema);
        Property userId = contrato.addLongProperty("CliId").notNull().getProperty();
        cli.addToMany(contrato, userId, "cliContratos");
    }

    private static Entity addCliente(final Schema schema) {
        Entity cliente = schema.addEntity("Cliente");
        cliente.addIdProperty().primaryKey().autoincrement();
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
    }

    private static Entity addContrato(final Schema schema) {
        Entity contrato = schema.addEntity("Contrato");
        contrato.addIdProperty().primaryKey().autoincrement();
        contrato.addDateProperty("ConFecha");
        contrato.addByteArrayProperty("ConFoto1");
        contrato.addByteArrayProperty("ConFoto2");
        contrato.addByteArrayProperty("ConFoto3");
        contrato.addByteArrayProperty("ConFoto4");
        contrato.addStringProperty("ConGenerico1");
        contrato.addStringProperty("ConGenerico2");
        contrato.addStringProperty("ConGenerico3");
        contrato.addStringProperty("ConGenerico4");
        contrato.addStringProperty("ConGenerico5");
        contrato.addStringProperty("ConGenerico6");
        contrato.addStringProperty("ConGenerico7");
        contrato.addStringProperty("ConGenerico8");
        contrato.addStringProperty("ConGenerico9");
        contrato.addStringProperty("ConGenerico10");
        contrato.addStringProperty("ConGenerico11");
        contrato.addStringProperty("ConGenerico12");
        contrato.addStringProperty("ConGenerico13");
        contrato.addStringProperty("ConGenerico14");
        contrato.addStringProperty("ConGenerico15");
        contrato.addStringProperty("ConGenerico16");
        contrato.addStringProperty("ConGenerico17");
        contrato.addStringProperty("ConGenerico18");
        contrato.addStringProperty("ConGenerico19");
        contrato.addStringProperty("ConGenerico20");
        contrato.addStringProperty("ConGenerico21");
        contrato.addStringProperty("ConGenerico22");
        contrato.addStringProperty("ConGenerico23");
        contrato.addStringProperty("ConGenerico24");
        contrato.addStringProperty("ConGenerico25");
        contrato.addStringProperty("ConGenerico26");
        contrato.addStringProperty("ConGenerico27");
        contrato.addStringProperty("ConGenerico28");
        contrato.addStringProperty("ConGenerico29");
        contrato.addStringProperty("ConGenerico30");

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