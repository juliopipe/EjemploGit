package edu.cecar.controladores;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class GestionTestExtraerDatosCVLAC extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description description) {
        super.failed(e, description);
        System.out.println("la prueba del metodo "+ description.getMethodName()+" ha fallado ");
        System.out.println(" el error presentado es " +e.getLocalizedMessage());

    }

    @Override
    protected void succeeded(Description description) {
        super.succeeded(description);
        System.out.println(" la prueba del metodo " + description.getMethodName()+ " ha sido exitosa " );
    }
}
