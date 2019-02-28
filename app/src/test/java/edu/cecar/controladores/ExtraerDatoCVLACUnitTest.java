package edu.cecar.controladores;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExtraerDatoCVLACUnitTest {
    @Test
    public void testDatosCVLAC() {

        Investigador investigador = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0001376707");
        Investigador investigador1 = ExtraerDatoCVLAC.getDatos("http://scienti.colciencias.gov.co:8081/cvlac/visualizador/generarCurriculoCv.do?cod_rh=0000733180");

        String resultadoEsperadoInvestigador = "Guillermo Carlos Hernández Hernández";
        String resultadoEsperadoInvestigador1 = "Jhon Jaime Mendez Alandete";

        assertEquals(resultadoEsperadoInvestigador, investigador.getNombres());
        assertEquals(resultadoEsperadoInvestigador1, investigador1.getNombres());

    }
}