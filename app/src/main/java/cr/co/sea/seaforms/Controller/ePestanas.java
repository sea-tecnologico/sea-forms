package cr.co.sea.seaforms.Controller;

/**
 * Created by asanchezo on 14/11/2016.
 */

public enum ePestanas {
    DATOS_PERSONALES(0),
    DIRECCION(1),
    METODOS_PAGO(2),
    ANEXOS(3),
    DATOS_GENERICOS(4);
    private final int value;

    private ePestanas(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
