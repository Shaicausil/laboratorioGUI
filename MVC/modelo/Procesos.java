package MVC.modelo;

import MVC.controlador.Coordinador;

public class Procesos {
    //En caso de que se requiera usar el coordinador desde aquí
    private Coordinador coordinador;

    // Establecer el coordinador
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public String obtenerDatos(String nombre) {
        //Aquí van los procesos que se delegan a la clase
        return "Bienvenido "+nombre.toUpperCase();
    }

    public String obtenerMensajeEjemplo() {

        return "Este es un mensaje de ejemplo";
    }

    public String calcularOperaciones(String seleccion, String numero1, String numero2) {

        double num1=Double.parseDouble(numero1);
        double num2=Double.parseDouble(numero2);

        String resp="";
        switch (seleccion) {
            case "suma":
                resp=num1+" + "+num2+"= "+(num1+num2);
                break;
            case "resta":
                resp=num1+" - "+num2+"= "+(num1-num2);
                break;
            case "multiplicacion":
                resp=num1+" * "+num2+"= "+(num1*num2);
                break;
            case "division":

                if (num2==0) {
                    resp="No se puede dividir por 0";
                }else {
                    resp=num1+" / "+num2+"= "+(num1/num2);
                }

                break;
            default:resp="Debe seleccionar una operación";
                break;
        }

        return resp;
    }


    /*
     * Metodo de ejemplo para validar que no se permita datos
     * numericos
     */
    public boolean validarNombre(String valor) {

        try {
            //si transforma el dato a numero y no lanza la excepcion es
            //porque es un dato numerico, por lo tanto no deberia permitir
            //el ingreso por esa razon retorna false
            int val=Integer.parseInt(valor.trim());

            return false;

        } catch (Exception e) {

            //si entra al catch es porque es un texto que no pudo convertir a numero por lo tanto
            //es correcto que sea un nombre, pero ahora valida que no sea vacio, si es vacio es porque
            //no ingresaron nada y no se debe permitir, en caso contrario retorna true
            if (valor.trim().equals("")) {
                return false;
            }else {
                return true;
            }

        }
    }

    /*
     * Valida que los numeros del formulario no sean negativos ni vacios
     */
    public boolean validarNumero(String valor) {
        boolean retorno=false;
        try {
            double num=Double.parseDouble(valor);

            if (num>=0) {
                retorno= true;
            }else {
                retorno = false;
            }

        } catch (Exception e) {
            retorno = false;
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return retorno;
    }
}